package Data;
import java.util.ArrayList;

import Users.Doctor;
import Users.Patient;
public class Department {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;
    private ArrayList<Appointment> appointments;
    private int consulattionFee;

    public Department(String name)
    {
        this.name=name;
        this.doctors=new ArrayList<>();
        this.patients=new ArrayList<>();
        this.appointments=new ArrayList<>();
    }
}
