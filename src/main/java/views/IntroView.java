package views;

import org.hibernate.Session;

import java.util.Scanner;

public class IntroView {

        private Session session;

        public IntroView(Session session) {
            this.session = session;
        }

        public void show() {
            System.out.println("==================================================");
            System.out.println("=                                                =");
            System.out.println("=             BOTSCREW's TEST TASK               =");
            System.out.println("=                                                =");
            System.out.println("==================================================");


            System.out.println("[ 1 ] open menu");
            System.out.println("[ 2 ] out");

            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter 1/2");

            String number = myObj.nextLine();

            if (number.equals("1")) {
                MenuView generalMenu = new MenuView(session);
                generalMenu.show();
            }

            if (number.equals("2")) {
                OutView outer = new OutView();
                outer.show();
            }

            else {
                System.out.println("Pl, enter 1 or 2");
            }
        }

}
