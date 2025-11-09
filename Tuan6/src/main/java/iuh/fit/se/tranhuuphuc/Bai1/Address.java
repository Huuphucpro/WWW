package iuh.fit.se.tranhuuphuc.Bai1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String city;
    private String country;
    private String street;
}
