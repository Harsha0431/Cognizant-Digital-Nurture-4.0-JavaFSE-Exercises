--* Exercise-3: Stored Procedures
-- For this we are going to use tables that we had created in Exercise-1

--* Scenario-1
-- creating procedure that process monthly interest for all savings accounts.
BEGIN
    EXECUTE IMMEDIATE '
        ALTER TABLE users
        ADD account_type VARCHAR2(36)
        CHECK (account_type IN (''SAVINGS'', ''CURRENT''))
    ';
END;

BEGIN
    FOR rec IN (SELECT id FROM users) LOOP
        UPDATE users
        SET account_type = CASE
            WHEN DBMS_RANDOM.VALUE < 0.5 THEN 'SAVINGS'
            ELSE 'CURRENT'
        END
        WHERE id = rec.id;
    END LOOP;

    COMMIT;
END;

-- Procedure to update user balance by adding interest
create or replace procedure ProcessMonthlyInterest(interest IN NUMBER) AS  -- interest in percentage
    updated_balance Users.BALANCE%TYPE;
    records_updated NUMBER;
BEGIN
    records_updated := 0;
    SAVEPOINT before_updating_monthly_interests;

    FOR rec IN (SELECT id, balance FROM users WHERE account_type = 'SAVINGS')
    LOOP
        updated_balance := ROUND(rec.balance + (interest * rec.balance / 100), 2);

        UPDATE users
        SET balance = updated_balance
        WHERE id = rec.id;

        records_updated := records_updated+1;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Number of records updated are ' || records_updated);

    COMMIT;

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK TO SAVEPOINT before_updating_monthly_interests;
        DBMS_OUTPUT.PUT_LINE('Error occurred while updating monthly interest: ' || SQLERRM);
END;


BEGIN
    DBMS_OUTPUT.PUT_LINE('User data before applying 1% interest on SAVINGS account');

    for rec in (
        select id, balance, account_type
        from users
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'ID: ' || rec.id ||
            ' | Balance: ' || rec.balance ||
            ' | Account Type: ' || rec.account_type
        );
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('');

    ProcessMonthlyInterest(1);

    DBMS_OUTPUT.PUT_LINE('User data after applying 1% interest on SAVINGS account');

    for rec in (
        select id, balance, account_type
        from users
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'ID: ' || rec.id ||
            ' | Balance: ' || rec.balance ||
            ' | Account Type: ' || rec.account_type
        );
    END LOOP;
END;

----------------------------------------------------

--* Scenario-2
BEGIN
    EXECUTE IMMEDIATE '
        CREATE TABLE employee (
            id NUMBER,
            name VARCHAR2(255) NOT NULL,
            dept VARCHAR2(36) NOT NULL CHECK (dept IN (''Dept-1'', ''Dept-2'')),
            salary number(10, 2) not null,
            CONSTRAINT pk_employee PRIMARY KEY (id)
        )
    ';
END;

-- Fill employee table with some random data
BEGIN
    FOR i IN 1..10 LOOP
        INSERT INTO employee (id, name, dept, salary)
        VALUES (
            i,
            'Emp-' || i,
            CASE
                WHEN MOD(i, 2) = 0 THEN 'Dept-1'
                ELSE 'Dept-2'
            END,
            ROUND(DBMS_RANDOM.VALUE(10000, 50000), 2)
        );
    END LOOP;

    COMMIT;
END;

-- Procedure to get add bonus to employees
create or replace PROCEDURE UpdateEmployeeBonus(
    bonus IN NUMBER, -- Bonus in percentage
    dept IN varchar2
) AS
    updated_salary NUMBER(10, 2);
BEGIN
    SAVEPOINT before_adding_bonus;

    for rec in (
        select id, salary from employee e where e.dept = UpdateEmployeeBonus.dept
    ) LOOP
        updated_salary := ROUND(rec.salary + (rec.salary * bonus / 100), 2);

        update EMPLOYEE
        set salary = updated_salary
        where id = rec.id and dept = dept;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Bonus applied successfully to department: ' || dept);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK TO SAVEPOINT before_adding_bonus;
        DBMS_OUTPUT.PUT_LINE('Error while adding bonus to employees: ' || SQLERRM);
END;


DECLARE
    p_dept VARCHAR2(36);
BEGIN
    p_dept := 'Dept-1';

    DBMS_OUTPUT.PUT_LINE('Employees data before adding to bonus');
    for rec in (select id, salary, dept from employee where dept = p_dept)
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'ID: ' || rec.id ||
            ' | Dept: ' || rec.dept ||
            ' | Salary: ' || rec.salary
        );
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('');

    UpdateEmployeeBonus(10, p_dept);

    DBMS_OUTPUT.PUT_LINE('Employees data after adding to bonus');
    for rec in (select id, salary, dept from employee where dept = p_dept)
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'ID: ' || rec.id ||
            ' | Dept: ' || rec.dept ||
            ' | Salary: ' || rec.salary
        );
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('');
END;


--------------------------------------------------

--* Scenario-3: Transfer funds from one customer to another
create or replace procedure TransferFunds(
    from_id IN NUMBER,
    to_id IN NUMBER,
    amount IN NUMBER
) AS
    from_balance USERS.BALANCE%TYPE;
    to_user_count NUMBER;
BEGIN

    SAVEPOINT before_transfer;
    
    SELECT balance INTO from_balance FROM users WHERE id = from_id FOR UPDATE;

    SELECT count(*) INTO to_user_count from users WHERE id = to_id;
    IF to_user_count = 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Recipient or receiver not found.');
    END IF;

    IF from_balance < amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance in source account.');
    END IF;

    -- 4. Perform the transfer
    UPDATE users
    SET balance = balance - amount
    WHERE id = from_id;

    UPDATE users
    SET balance = balance + amount
    WHERE id = to_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Transfer of ' || amount ||
        ' from user ' || from_id ||
        ' to user ' || to_id ||
        ' successful.'
    );

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK TO before_transfer;
        DBMS_OUTPUT.PUT_LINE('User not found.');
    WHEN OTHERS THEN
        ROLLBACK TO before_transfer;
        DBMS_OUTPUT.PUT_LINE('Failed to make transaction: ' || SQLERRM);
END;


DECLARE
    from_id NUMBER;
    to_id NUMBER;
    amount NUMBER(10, 2);
BEGIN
    from_id := 1;
    to_id := 2;
    amount := 1000.00;
    
    DBMS_OUTPUT.PUT_LINE('Balance before transaction');
    FOR rec in (
        select id, balance from users where id = from_id
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Sender -> ID: ' || rec.id || ' | Balance: ' || rec.balance);
    END LOOP;

    FOR rec in (
        select id, balance from users where id = to_id
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Receiver -> ID: ' || rec.id || ' | Balance: ' || rec.balance);
    END LOOP;

    TransferFunds(from_id, to_id, amount);

    DBMS_OUTPUT.PUT_LINE('Balance after transaction');
    FOR rec in (
        select id, balance from users where id = from_id
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Sender -> ID: ' || rec.id || ' | Balance: ' || rec.balance);
    END LOOP;

    FOR rec in (
        select id, balance from users where id = to_id
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Receiver -> ID: ' || rec.id || ' | Balance: ' || rec.balance);
    END LOOP;
END;