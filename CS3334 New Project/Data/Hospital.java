package Data;

import java.util.ArrayList;
import Users.User;
//Singleton Pattern
public class Hospital {
    private String name;
    private static Hospital inst = new Hospital();
    private ArrayList<User> userList;
    private ArrayList<Department> departments;

    public static Hospital getinstance() {
		return inst;
	}

    private Hospital() {
        this.name="Prime A1 Health";
        userList=new ArrayList<>();
        departments=new ArrayList<>();
    }

    public boolean checkUserCredentials(String hKID, String password) {
        return false;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUserByHKID(String HKID) {
        for(User user:userList)
        {
            if (user.getHKID().equals(HKID))
            {
                return user;
            }
        }
        return null;
    }

    public void removeUser(User doctor) {
        userList.remove(doctor);
    }
}
