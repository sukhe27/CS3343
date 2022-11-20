package Flow;

import java.util.Scanner;

import Data.Department;
import Data.Hospital;
import Users.Doctor;
import Users.User;

public class DoctorHandler {

    public static void addDoctor(Scanner sc){
        System.out.println("Please enter name of Doctor");
        String name= sc.next();
        System.out.println("Please enter HKID of the Doctor");
        String HKID = sc.next();
        System.out.println("Please enter the temporary passwoord");
        String password = sc.next();
        // System.out.println("Please select the department");
        Department department = null; // work on this not completed
        Doctor doctor=new Doctor(name, HKID, password,department);
        department.addDoctor(doctor);

    }

    public static void removeDoctor(Scanner sc, Hospital hospital) {
        do
        {
            System.out.println("Please enter HKID of the doctor");
            String HKID=sc.next();
            User doctor=hospital.getUserByHKID(HKID);
            Department department=((Doctor) doctor).getDepartment();
            hospital.removeUser(doctor);
            department.removeDoctor(doctor);
        }while(false);
        

        
    }
    
}
