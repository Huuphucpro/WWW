package iuh.fit.se.tranhuuphuc.Bai1;

public class Student {
    private Long id;
    private String name;
    private iuh.fit.se.tranhuuphuc.Bai1.Class myclass;
    public Student(Long id, String name, iuh.fit.se.tranhuuphuc.Bai1.Class myclass) {
        this.id = id;
        this.name = name;
    }

    public Class getMyclass() {
        return myclass;
    }

    public void setMyclass(iuh.fit.se.tranhuuphuc.Bai1.Class myclass) {
        this.myclass = myclass;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", myClass=" + myclass +
                '}';
    }
}
