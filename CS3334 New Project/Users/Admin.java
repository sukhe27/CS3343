package Users;

public class Admin {
    private static Admin inst = new Admin();
    private String adminId;
    private String password;

    private Admin()
    {
        this.adminId="admin123";
        this.password="1234";
    }
    public static Admin getInstance()
    {
        return inst;
    }

    public boolean credentialCheck(String userName,String password)
    {
        if(this.adminId.equals(userName) && this.password.equals(password))
        {
            return true;
        }
        return false;
    }
}
