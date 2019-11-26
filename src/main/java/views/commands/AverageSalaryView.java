package views.commands;

import controllers.DepartmentImpl;
import org.hibernate.Session;
import views.MenuView;

import java.util.Scanner;

public class AverageSalaryView {
    private Session session;

    public AverageSalaryView(Session session) {
        this.session = session;
    }

    public void show() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter department name:");

        String name = myObj.nextLine();

        DepartmentImpl controller = new DepartmentImpl(session);
        controller.avgSalary(name);

        //back to main menu
        MenuView generalMenu = new MenuView(session);
        generalMenu.show();

    }
}
