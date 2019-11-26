package controllers;

import controllers.interfaces.DepartmentInterface;
import models.Department;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import persistant.SessionManager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DepartmentImpl implements DepartmentInterface {

    private Session session;

    public DepartmentImpl(Session session){
        this.session = session;
    }

    @Override
    public void findHead(String department_name) {
        System.out.println("You search " + department_name);

        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Department where name = " + ":department_name");
            query.setParameter("department_name", department_name);
            for (Object obj : query.list()) {
                Department item = (Department) obj;
                System.out.format( "Head of " + item.getName() + " is " + item.getHead());

            }
        } finally {
            session.close();
        }
    }


    @Override
    public void showStatistic(String department_name) {
        ArrayList<String> degrees = new ArrayList<String>();

        // Add Strings to list
        // each string represents student name
        degrees.add("professor");
        degrees.add("assistant");
        degrees.add("associate_professor");

        degrees.forEach((a)-> {
            String url = "select count(*) from Employee where degree = :degree and department = :department";
            Query q = session.createQuery(url)
                    .setParameter("degree",a)
                    .setParameter("department", department_name);
            System.out.println(a + ": " + q.list().get(0).toString());
        });

    }

    @Override
    public void avgSalary(String department_name) {
        String url = "select avg(salary) from Employee where department = :department";
        Query q = session.createQuery(url)
                .setParameter("department", department_name);
        System.out.println("Average salary in " + department_name + ": " + q.list().get(0).toString());
    }

    @Override
    public void countEmployee(String department_name) {
        String url = "select count (*) from Employee where department = :department";
        Query q = session.createQuery(url)
                .setParameter("department", department_name);
        System.out.println("Number " + department_name + " employees: " + q.list().get(0).toString());
    }
}
