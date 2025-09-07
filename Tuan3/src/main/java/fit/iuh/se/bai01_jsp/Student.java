package fit.iuh.se.bai01_jsp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String gender;
    private String address;
    private String city;
    private String pin_code;
    private String state;
    private String country;
    private String dob;

    private List<String> hobbies;

    private String board10;
    private String percent10;
    private String year10;

    private String board12;
    private String percent12;
    private String year12;

    private String boardGrad;
    private String percentGrad;
    private String yearGrad;

    private String boardMas;
    private String percentMas;
    private String yearMas;

    private List<String> courses;
}
