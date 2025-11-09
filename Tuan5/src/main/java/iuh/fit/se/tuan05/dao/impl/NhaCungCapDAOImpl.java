package iuh.fit.se.tuan05.dao.impl;

import iuh.fit.se.tuan05.dao.NhaCungCapDAO;
import iuh.fit.se.tuan05.entities.NhaCungCap;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAOImpl implements NhaCungCapDAO {
    private final DataSource dataSource;

    public NhaCungCapDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<NhaCungCap> getAll() throws Exception {
        List<NhaCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM NHACUNGCAP";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new NhaCungCap(
                        rs.getString("MANCC"),
                        rs.getString("tenNCC"),
                        rs.getString("DIACHI"),
                        rs.getString("SODIENTHOAI")
                ));
            }
        }
        return list;
    }

    @Override
    public List<NhaCungCap> search(String keyword) throws Exception {
        List<NhaCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM NHACUNGCAP " +
                "WHERE MANCC LIKE ? OR tenNCC LIKE ? OR DIACHI LIKE ? OR SODIENTHOAI LIKE ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            String kw = "%" + keyword + "%";
            ps.setString(1, kw);
            ps.setString(2, kw);
            ps.setString(3, kw);
            ps.setString(4, kw);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new NhaCungCap(
                            rs.getString("MANCC"),
                            rs.getString("tenNCC"),
                            rs.getString("DIACHI"),
                            rs.getString("SODIENTHOAI")
                    ));
                }
            }
        }
        return list;
    }

    @Override
    public NhaCungCap findById(String maNCC) throws Exception {
        String sql = "SELECT * FROM NHACUNGCAP WHERE MANCC = ?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maNCC);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new NhaCungCap(
                            rs.getString("MANCC"),
                            rs.getString("tenNCC"),
                            rs.getString("DIACHI"),
                            rs.getString("SODIENTHOAI")
                    );
                }
            }
        }
        return null;
    }
}
