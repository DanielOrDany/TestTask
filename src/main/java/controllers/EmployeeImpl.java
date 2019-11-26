package controllers;

import controllers.interfaces.EmployeeInterface;
import models.Department;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import persistant.SessionManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EmployeeImpl implements EmployeeInterface {
    private Session session;

    public EmployeeImpl(Session session){
        this.session = session;
    }

    @Override
    public void findEmployee(String template) {
        String str = template;
        String[] splitStr = str.split("\\s+");
        ArrayList<String> employees = new ArrayList<String>();

        session = SessionManager.getSession();
        try {
            Query query = session.createQuery("from " + "Employee ");
            for (Object obj : query.list()) {
                Employee employee = (Employee) obj;
                employees.add(employee.getFullName());
            }

        } finally {
            ArrayList<String> founded = new ArrayList<String>();
            for (String employee: employees){
                for (String name: splitStr){
                    if(employee.contains(name)){
                        founded.add(employee);
                    }
                }
            }
            String result = String.join(", ", founded);
            System.out.println("Answer: " + result);

            session.close();
        }
    }
}
