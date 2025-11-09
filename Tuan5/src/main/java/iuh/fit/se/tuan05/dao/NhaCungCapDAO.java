package iuh.fit.se.tuan05.dao;

import iuh.fit.se.tuan05.entities.NhaCungCap;

import java.sql.SQLException;
import java.util.List;

public interface NhaCungCapDAO {
    List<NhaCungCap> getAll() throws Exception;
    List<NhaCungCap> search(String keyword) throws Exception;
    NhaCungCap findById(String maNCC) throws Exception;
}
