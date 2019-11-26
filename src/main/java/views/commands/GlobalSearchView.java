package views.commands;

import controllers.DepartmentImpl;
import controllers.EmployeeImpl;
import models.Employee;
import org.hibernate.Session;
import views.MenuView;

import java.util.Scanner;

public class GlobalSearchView {
    private Session session;

    public GlobalSearchView(Session session) {
        this.session = session;
    }

    public void show() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter employee name");

        String name = myObj.nextLine();

        EmployeeImpl controller = new EmployeeImpl(session);
        controller.findEmployee(name);

        //back to main menu
        MenuView generalMenu = new MenuView(session);
        generalMenu.show();

    }
}
