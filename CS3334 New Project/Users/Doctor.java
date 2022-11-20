package Users;

import java.util.ArrayList;

import Data.Appointment;
import Data.Department;
import Data.Hospital;

public class Doctor extends User{
    private Department department;

    public Doctor(String name, String HKID, String password, Department department) {
        super(name, HKID, password);
        this.department=department;
        Hospital hospital = Hospital.getinstance();
        hospital.addUser(this);
        //TODO Auto-generated constructor stub
    }
    public Department getDepartment() {
        return null;
    }
        
}
