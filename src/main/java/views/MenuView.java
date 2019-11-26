package views;

import org.hibernate.Session;
import views.commands.*;

import java.util.Scanner;

public class MenuView {
    private Session session;

    public MenuView(Session session) {
        this.session = session;
    }

    public void show() {
        System.out.println("\n\n");
        System.out.println("[ 1 ] find head of department");
        System.out.println("[ 2 ] show statistic of department ");
        System.out.println("[ 3 ] show average salary for department");
        System.out.println("[ 4 ] show amount of employees");
        System.out.println("[ 5 ] find employee in all departments");
        System.out.println("[ 0 ] << back");

        Scanner myObj = new Scanner(System.in);
        System.out.println("Please, enter number [0-5]");

        String number = myObj.nextLine();

        if (number.equals("1")){
            DepartmentHeadView oneTable = new DepartmentHeadView(session);
            oneTable.show();
        }

        if (number.equals("2")){
            DepartmentStatisticView addView = new DepartmentStatisticView(session);
            addView.show();
        }

        if (number.equals("3")){
            AverageSalaryView updateView = new AverageSalaryView(session);
            updateView.show();
        }

        if (number.equals("4")){
            AmoutEmployeesView deleteView = new AmoutEmployeesView(session);
            deleteView.show();
        }

        if (number.equals("5")){
            GlobalSearchView deleteView = new GlobalSearchView(session);
            deleteView.show();
        }

        if (number.equals("0")){
            IntroView introView = new IntroView(session);
            introView.show();
        }

        else {
            System.out.println("Pl, enter any numbers from [0-5]");
            MenuView menuView = new MenuView(session);
            menuView.show();
        }
    }
}
