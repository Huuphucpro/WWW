package iuh.fit.se.tuan05.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhaCungCap {
    private String maNCC;
    private String tenNCC;
    private String diaChi;
    private String soDienThoai;
}
