package iuh.fit.se.tuan05.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DienThoai {
    private String maDT;
    private String tenDT;
    private int namSX;
    private String cauHinh;
    private NhaCungCap maNCC;
    private String hinhAnh;
}
