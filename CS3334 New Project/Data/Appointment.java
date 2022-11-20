package Data;

import java.sql.Date;

import Users.Doctor;
import Users.Patient;

public class Appointment {
    private Doctor doctor;
    private Patient patient;
    Date date;
    Time time;

    public Appointment(Doctor doctor, Patient patient,Date date, Time time)
    {
        this.doctor = doctor;
        this.patient=patient;
        this.date=date;
        this.time=time;
    }
}

