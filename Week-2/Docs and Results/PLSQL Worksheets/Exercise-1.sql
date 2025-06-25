--*Exercise-1: Control Structures

-- Create users table
BEGIN
    EXECUTE IMMEDIATE '
        CREATE TABLE users (
            id NUMBER,
            name VARCHAR2(255) NOT NULL,
            created_at DATE,
            age NUMBER,
            is_vip boolean not null,
            CONSTRAINT pk_user PRIMARY KEY (id)
        )
    ';

    EXECUTE IMMEDIATE '
        ALTER TABLE users MODIFY (created_at DEFAULT SYSDATE)
    ';

    EXECUTE IMMEDIATE '
        ALTER TABLE users MODIFY (is_vip DEFAULT FALSE)
    ';


    DBMS_OUTPUT.PUT_LINE('User table created successfully');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error creating table: ' || SQLERRM);
END;


-- Create loan table
BEGIN
    EXECUTE IMMEDIATE '
        CREATE TABLE loan(
            id NUMBER,
            user_id NUMBER,
            amount NUMBER(10, 2) not null,
            due_date DATE DEFAULT SYSDATE,
            interest_rate number(4, 2) not null,
            CONSTRAINT pk_loan PRIMARY KEY(id),
            CONSTRAINT fk_loan_user FOREIGN KEY (user_id) REFERENCES users(id)
        )
    ';

    DBMS_OUTPUT.PUT_LINE('Loan table created successfully');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error creating table: ' || SQLERRM);
END;


-- Insert data
BEGIN
    FOR i IN 1..10 LOOP
        INSERT INTO users (id, name, age, is_vip)
        VALUES (
            i,
            'User_' || i,
            TRUNC(DBMS_RANDOM.VALUE(30, 80)),
            FALSE
        );
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Inserted 10 users');
END;

BEGIN
    FOR i IN 1..10 LOOP
        INSERT INTO loan (id, user_id, amount, due_date, interest_rate)
        VALUES (
            i,
            MOD(i, 10) + 1,
            TRUNC(DBMS_RANDOM.VALUE(10000, 50000), 2),
            SYSDATE + MOD(i, 35),
            ROUND(DBMS_RANDOM.VALUE(6, 12), 2)
        );
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Inserted 10 loans');
END;


--* Scenario-1:
-- Apply 1% loan discount on interest rates for users whose age is > 60
BEGIN
    -- Begin Transaction
    SAVEPOINT before_discount;

    DBMS_OUTPUT.PUT_LINE('Customer data whose age is greater than 60 before applying 1% discount on interest rate');

    FOR rec IN (
        SELECT u.id AS user_id, u.age, l.id AS loan_id, l.interest_rate AS lr
        FROM users u
        JOIN loan l ON u.id = l.user_id
        WHERE u.age > 60
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'User_ID: ' || rec.user_id ||
            ' | Age: ' || rec.age ||
            ' | Loan_ID: ' || rec.loan_id ||
            ' | Interest: ' || rec.lr
        );
    END LOOP;

    -- Apply Discount
    UPDATE loan l
    SET interest_rate = CASE
        WHEN interest_rate >= 1 THEN interest_rate - 1
        ELSE 0
    END
    WHERE EXISTS (
        SELECT 1 FROM users u
        WHERE u.id = l.user_id AND u.age > 60
    );

    DBMS_OUTPUT.PUT_LINE('Customer data after applying 1% discount on interest rate');

    FOR rec IN (
        SELECT u.id AS user_id, u.age, l.id AS loan_id, l.interest_rate AS lr
        FROM users u
        JOIN loan l ON u.id = l.user_id
        WHERE u.age > 60
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'User_ID: ' || rec.user_id ||
            ' | Age: ' || rec.age ||
            ' | Loan_ID: ' || rec.loan_id ||
            ' | Interest: ' || rec.lr
        );
    END LOOP;

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK TO before_discount;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
        DBMS_OUTPUT.PUT_LINE('Rolled back to before applying discount.');
END;


--* Scenario-2
-- Update customer status as VIP if their balance is over 10,000
BEGIN
    -- Add column
    BEGIN
        EXECUTE IMMEDIATE '
            ALTER TABLE users ADD balance NUMBER(10, 2)
        ';
        DBMS_OUTPUT.PUT_LINE('"balance" column added to users');
    EXCEPTION
        WHEN OTHERS THEN
            DBMS_OUTPUT.PUT_LINE('ℹ"balance" column already exists');
    END;

    -- Assign random balances to each user
    FOR rec IN (SELECT id FROM users) LOOP
        UPDATE users
        SET balance = TRUNC(DBMS_RANDOM.VALUE(5000, 20000), 2)
        WHERE id = rec.id;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Random balances assigned to each user');
END;


CREATE or replace procedure print_customers_vip_data AS
BEGIN
    for rec in(
        SELECT id as user_id, balance, IS_VIP
        from users
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'ID: ' || rec.user_id ||
            '| Balance: ' || rec.balance ||
            '| Is VIP: ' || CASE
                WHEN rec.is_vip THEN 'TRUE'
                ELSE 'FALSE'
            END
        );
    END LOOP;
END;

-- Now start our query to update customer VIP status
BEGIN
    SAVEPOINT before_update_status;

    DBMS_OUTPUT.PUT_LINE('Customer data before updating their VIP status');
    print_customers_vip_data;

    update users
    set IS_VIP = TRUE
    where balance >= 10000;

    DBMS_OUTPUT.PUT_LINE('Customer data after updating their VIP status');
    print_customers_vip_data;

    commit;

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error occurred while updating customer VIP status: ' || SQLERRM);
        ROLLBACK TO SAVEPOINT before_update_status;
END;


--* Scenario-3
-- Get data of users whose loan due date is less than next 30 days
create or replace PROCEDURE get_loan_data_with_due_date_message AS
    days_left NUMBER;
BEGIN
    FOR rec IN (
        select u.id as user_id, l.id as loan_id, l.due_date
        from users u
        join LOAN l on l.USER_ID = u.ID
        order by l.DUE_DATE
    ) LOOP
        days_left := TRUNC(rec.due_date) - TRUNC(SYSDATE);

        DBMS_OUTPUT.PUT_LINE(
            'ID: ' || rec.user_id ||
            ' | Loan ID: ' || rec.loan_id ||
            ' | Due Date: ' || TO_CHAR(rec.due_date, 'YYYY-MM-DD') ||
            ' | Message: Loan is due in ' || days_left || ' day(s).'
        );
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('');
END;

BEGIN
    DBMS_OUTPUT.PUT_LINE('Loan data with due date message:');
    get_loan_data_with_due_date_message;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error while getting users data whose loan due is in next 30 days: ' || SQLERRM);
END;
