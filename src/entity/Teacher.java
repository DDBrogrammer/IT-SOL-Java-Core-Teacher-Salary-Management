package entity;

public class Teacher  extends Staff{
    private int id;
    private String degree;


    public Teacher(String name, String address, String phone, int id, String degree) {
        super(name, address, phone);
        this.id = id;
        this.degree = degree;
    }

    public Teacher() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", degree='" + degree + '\'' +
                "} " + super.toString();
    }
}
