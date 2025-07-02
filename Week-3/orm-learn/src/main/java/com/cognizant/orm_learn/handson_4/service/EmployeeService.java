package com.cognizant.orm_learn.handson_4.service;

import com.cognizant.orm_learn.handson_4.model.Employee;
import com.cognizant.orm_learn.handson_4.repository.EmployeeRepository;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private SessionFactory factory;
    @Autowired
    private EmployeeRepository employeeRepository;

    public Long addEmployeeHibernate(Employee emp){
        Long empId = null;
        Session session = factory.openSession();
        Transaction txn = null;
        try{
            txn = session.beginTransaction();
            empId = (Long) session.save(emp);
            txn.commit();
        }
        catch (Exception e){
            if(txn != null) txn.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return empId;
    }

    @Transactional
    public Long addEmployeeJpa(Employee emp){
        Long id = null;
        try{
            id = employeeRepository.save(emp).getId();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }
}
