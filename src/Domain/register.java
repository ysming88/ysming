package Domain;

public class register {
    private  String username=" ";
    private  String email=" ";
    private  String passworld=" ";
    private  String head=" ";

    public register() {
    }

    public register(String username, String email, String passworld,String head) //有参构造方法
    {
        this.username = username;
        this.email = email;
        this.passworld = passworld;
        this.head = head;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassworld(String passworld) {
        this.passworld = passworld;
    }

    public String getPassworld() {
        return passworld;
    }


    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
}
