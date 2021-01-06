package Domain;

public class Information {
    private  String name=" ";
    private  String sex=" ";
    private  String birthday=" ";
    private  String job=" ";
    private  String phone=" ";
    private  String email=" ";

    public Information() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Information(String name, String sex, String birthday, String job, String phone, String email) //有参构造方法
    {

        this.name = name;
        this. sex =  sex;
        this.birthday = birthday;
        this.job = job;
        this.phone = phone;
        this.email = email;
    }


}
