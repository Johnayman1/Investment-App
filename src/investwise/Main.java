
package investwise;

import investwise.controller.Dashboard;
import investwise.user.Register;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n**************************** WELCOME TO OUR INVESTMENT APP ****************************\n");

        Register register = new Register();
        while (true){
            if(register.start()) break;
        }

        Dashboard dashboard = new Dashboard();
        dashboard.dashboard();

    } 
}
