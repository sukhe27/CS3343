package Users;

import java.util.ArrayList;

import javax.security.auth.login.AppConfigurationEntry;

import Data.Appointment;
import Data.Hospital;

public abstract class User {
    private String name;
    private String HKID;
    private String password;
    private ArrayList<Appointment> appointments;

    public User(String name, String HKID, String password)
    {
        this.name=name;
        this.HKID=HKID;
        this.password=password;
        appointments=new ArrayList<>();
        Hospital hospital=Hospital.getinstance();
        hospital.addUser(this);
    }

    public void checkAppointments(){
        
    }

    
}
