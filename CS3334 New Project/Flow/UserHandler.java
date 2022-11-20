package Flow;

import java.util.Scanner;

import Data.Hospital;
import Users.Admin;
import Users.Patient;
import Users.User;

public class UserHandler {

    public static boolean adminLogin(Scanner sc) {
        String adminRetry;
        boolean loginSuccess = true;
        do {
            adminRetry = "n";
            System.out.println("Please enter the username:");
            String userName = sc.next();
            System.out.println("Please enter the password:");
            String password = sc.next();
            Admin admin = Admin.getInstance();
            if (!admin.credentialCheck(userName, password)) {
                System.out.println("Invalid credential. Want to retry? enter y/n");
                adminRetry = sc.next();
                loginSuccess = false;
            }
        } while (adminRetry.equals("y"));
        return loginSuccess;

    }

    public static User patientLogin(Hospital hospital, Scanner sc) {
        System.out.println("Are you an existing user, enter y/n");
        String existingUser = sc.next();
        Boolean userRetry;
        String HKID;
        User user;
        do {
            userRetry = false;
            if (existingUser.equals("y")) {
                System.out.println("Please enter your HKID");
                HKID = sc.next();
                System.out.println("Please enter your password");
                String password = sc.next();
                if (hospital.checkUserCredentials(HKID, password)) // checkUserCredentials definition needed
                {
                    user = hospital.getUserByHKID(HKID); // define the functionn
                    return user;
                } else {
                    System.out.println(
                            "Invalid credential. Enter 'create' to create a new account or enter 'retry' to enter credentials again.");
                    String userChoice = sc.next();
                    if (userChoice.equals("create")) {
                        userRetry = false;
                        existingUser = "n";
                    } else if (userChoice.equals("retry")) {
                        userRetry = true;
                    }
                }

            }

        } while (userRetry == true);
        if (existingUser.equals("n")) {
            System.out.println("Please enter your name");
            String name = sc.next();
            System.out.println("Please enter your HKID");
            HKID = sc.next();
            System.out.println("Please enter the password");
            String password = sc.next();
            user = new Patient(name, HKID, password);
            return user;
        }
        return null;
    }

    public static User Doctorlogin(Hospital hospital, Scanner sc) {
        boolean doctorRetry;
        do
        {
            doctorRetry=false;
            User user;
            System.out.println("Please enter your HKID");
            String HKID = sc.next();
            System.out.println("Please enter your password");
            String password = sc.next();
            if (hospital.checkUserCredentials(HKID, password)) // checkUserCredentials definition needed
            {
                user = hospital.getUserByHKID(HKID); // define the functionn
                return user;
            }
            else
            {
                System.out.println("Invalid credential. Want to retry enter y/n");
                String userChoice=sc.next();
                if(userChoice.equals("y"))
                {
                    doctorRetry=true;
                }
                else
                {
                    System.out.println("Please contact admin for support");
                }
            }
        }while(doctorRetry==true);
        return null;
    }

}
