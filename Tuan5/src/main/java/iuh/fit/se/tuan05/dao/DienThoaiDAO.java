package iuh.fit.se.tuan05.dao;

import iuh.fit.se.tuan05.entities.DienThoai;
import iuh.fit.se.tuan05.entities.NhaCungCap;

import java.sql.SQLException;
import java.util.List;


public interface DienThoaiDAO {
    boolean insert(DienThoai dt) throws Exception;
    boolean delete(String maDT) throws Exception;
    List<DienThoai> search(String keyword) throws Exception;
    List<DienThoai> getByNCC(String maNCC) throws Exception;
    DienThoai getById(String maDT) throws Exception;
    public List<DienThoai> getAll() throws Exception;
}
