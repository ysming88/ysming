package Domain;

public class Label {
    private  String label=" ";
    private  String id=" ";
    private  String email=" ";

    public Label(String label, String id,String email) {
        this.label = label;
        this.id = id;
        this.email=email;
    }

    public Label(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Label(String label) {
        this.label = label;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
