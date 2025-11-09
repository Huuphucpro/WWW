package iuh.fit.se.tranhuuphuc;


import iuh.fit.se.tranhuuphuc.Bai1.Person;
import iuh.fit.se.tranhuuphuc.Bai1.Student;
import org.springframework.context.ApplicationContext;
import iuh.fit.se.tranhuuphuc.Bai1.Class;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private static ApplicationContext context;
    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("beans.xml");
//
//        Student student1 = context.getBean("student2", Student.class);
//        System.out.println(student1);

//        Student student2 = context.getBean("student2", Student.class);
//        System.out.println("Student 2 (Setter): " + student2);
//
//        Student student3 = context.getBean("student3", Student.class);
//        System.out.println("Student 3 (Constructor): " + student3);

//        Person person = context.getBean("person", Person.class);
//
//        System.out.println("--- Kết quả Collection Injection cho Person ---");
//        System.out.println(person);
//        System.out.println("Tổng số địa chỉ: " + person.getAddresses().size());
//        System.out.println("Địa chỉ đầu tiên: " + person.getAddresses().get(0));
//        System.out.println("Email đầu tiên: " + person.getEmail().get(0));

        Class class2 = context.getBean("class2", Class.class);
        System.out.println(class2);

        ((ClassPathXmlApplicationContext) context).close();
    }
}