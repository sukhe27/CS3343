package Users;

import java.util.ArrayList;

import javax.security.auth.login.AppConfigurationEntry;

import Data.Appointment;
import Data.Hospital;

public abstract class User {
    protected String name;
    protected String HKID;
    protected String password;
    protected ArrayList<Appointment> appointments;

    public User(String name, String HKID, String password)
    {
        this.name=name;
        this.HKID=HKID;
        this.password=password;
        appointments=new ArrayList<>();
        Hospital hospital=Hospital.getinstance();
        hospital.addUser(this);
    }
    @Override
    public String toString() {
        return this.name;
    }
    public void checkAppointments(){
        
        for(Appointment appointment: appointments)
        {
            System.out.println(appointment);
        }
        
    }


    
}
