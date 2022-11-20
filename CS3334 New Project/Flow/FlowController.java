package Flow;

import java.util.Scanner;

import Data.Hospital;
import Users.Patient;
import Users.User;

public class FlowController{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hospital hospital = Hospital.getinstance();
        boolean portalAccess=false;

        do
        {
            System.out.println("Select the type of user you are:\n1. Admin \n2. Patient\n3. Doctor");
            int userType = sc.nextInt();
            switch(userType)
            {
                case 1: 
                    boolean loginSuccess = UserHandler.adminLogin(sc);
                    if(loginSuccess)
                    {
                        System.out.println("Login successful!");
                        //add more options

                        System.out.println("Please select what you would like to do:");
                        System.out.println("1. Add Doctor\n2. Remove Doctor");

                        int userChoice = sc.nextInt();
                        switch(userChoice){
                            case 1: DoctorHandler.addDoctor(sc);
                            break;
                            case 2: DoctorHandler.removeDoctor(sc, hospital);
                            default:
                        }
                        break;

                    }
                    else
                    {
                        System.out.println("Enter 'exit to close the portal, 'reload' to acces the potral again" );
                        String userInput=sc.next();
                        if(userInput.equals("exit"))
                        {
                            portalAccess=false;
                        }
                        else
                        {
                            portalAccess=true;
                        }
                    }
                    break;

                case 2: 
                    User user = UserHandler.patientLogin(hospital, sc);
                    //patient functions 

                    System.out.println("Please select what you would like to do:");
                    System.out.println("1. Make new appointment\n2. Cancel Appointment \n3. View Appointments");
                    int userChoice = sc.nextInt();
                    switch(userChoice){
                        case 1: NewAppointment.initiate();
                        break;
                        case 2: user.checkAppointments();
                        break;
                        case 3: DeleteAppointment.initiate();
                        default:
                    }
                    break;
                case 3:
                    user = UserHandler.Doctorlogin(hospital,sc);
                    System.out.println("Please select what you would like to do:");
            }

        }while(portalAccess);
    
        
        
    }
}