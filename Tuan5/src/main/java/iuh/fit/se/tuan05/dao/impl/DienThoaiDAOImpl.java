package iuh.fit.se.tuan05.dao.impl;

import iuh.fit.se.tuan05.dao.DienThoaiDAO;
import iuh.fit.se.tuan05.entities.DienThoai;
import iuh.fit.se.tuan05.entities.NhaCungCap;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAOImpl implements DienThoaiDAO {
    private final DataSource dataSource;

    public DienThoaiDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public boolean insert(DienThoai dt) throws Exception {
        String sql = "INSERT INTO DienThoai(tenDT, namSX, cauHinh, maNCC, hinhAnh) VALUES (?,?,?,?,?)";
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, dt.getTenDT());
            ps.setInt(2, dt.getNamSX());
            ps.setString(3, dt.getCauHinh());
            ps.setString(4, dt.getMaNCC().getMaNCC());
            ps.setString(5, dt.getHinhAnh());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(String maDT) throws Exception {
        String sql = "DELETE FROM DienThoai WHERE maDT=?";
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maDT);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public List<DienThoai> search(String keyword) throws Exception {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT * FROM DienThoai d JOIN NhaCungCap n ON d.maNCC=n.maNCC " +
                "WHERE d.maNCC LIKE ? OR tenDT LIKE ? OR cauHinh LIKE ?";
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            String key = "%" + keyword + "%";
            ps.setString(1, key);
            ps.setString(2, key);
            ps.setString(3, key);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    NhaCungCap ncc = new NhaCungCap(
                            rs.getString("maNCC"),
                            rs.getString("tenNCC"),
                            rs.getString("diaChi"),
                            rs.getString("soDienThoai")
                    );
                    list.add(new DienThoai(
                            rs.getString("maDT"),
                            rs.getString("tenDT"),
                            rs.getInt("namSX"),
                            rs.getString("cauHinh"),
                            ncc,
                            rs.getString("hinhAnh")
                    ));
                }
            }
        }
        return list;
    }

    @Override
    public List<DienThoai> getByNCC(String maNCC) throws Exception {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT * FROM DienThoai d JOIN NhaCungCap n ON d.maNCC=n.maNCC WHERE d.maNCC=?";
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maNCC);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    NhaCungCap ncc = new NhaCungCap(
                            rs.getString("maNCC"),
                            rs.getString("tenNCC"),
                            rs.getString("diaChi"),
                            rs.getString("soDienThoai")
                    );
                    list.add(new DienThoai(
                            rs.getString("maDT"),
                            rs.getString("tenDT"),
                            rs.getInt("namSX"),
                            rs.getString("cauHinh"),
                            ncc,
                            rs.getString("hinhAnh")
                    ));
                }
            }
        }
        return list;
    }

    @Override
    public DienThoai getById(String maDT) throws Exception {
        String sql = "SELECT * FROM DienThoai d JOIN NhaCungCap n ON d.maNCC=n.maNCC WHERE maDT=?";
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maDT);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    NhaCungCap ncc = new NhaCungCap(
                            rs.getString("maNCC"),
                            rs.getString("tenNCC"),
                            rs.getString("diaChi"),
                            rs.getString("soDienThoai")
                    );
                    return new DienThoai(
                            rs.getString("maDT"),
                            rs.getString("tenDT"),
                            rs.getInt("namSX"),
                            rs.getString("cauHinh"),
                            ncc,
                            rs.getString("hinhAnh")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<DienThoai> getAll() throws Exception {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT * FROM DienThoai d JOIN NhaCungCap n ON d.maNCC=n.maNCC";
        try (Connection con = this.dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                NhaCungCap ncc = new NhaCungCap(
                        rs.getString("maNCC"),
                        rs.getString("tenNCC"),
                        rs.getString("diaChi"),
                        rs.getString("soDienThoai")
                );
                list.add(new DienThoai(
                        rs.getString("maDT"),
                        rs.getString("tenDT"),
                        rs.getInt("namSX"),
                        rs.getString("cauHinh"),
                        ncc,
                        rs.getString("hinhAnh")
                ));
            }
        }
        return list;
    }
}
