package iuh.fit.se.tranhuuphuc.Bai1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private List<Address> addresses;
    private List<String> email;
}
