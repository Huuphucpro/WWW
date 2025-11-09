package iuh.fit.se.tuan05.controllers;

import iuh.fit.se.tuan05.dao.DienThoaiDAO;
import iuh.fit.se.tuan05.dao.impl.DienThoaiDAOImpl;
import iuh.fit.se.tuan05.entities.DienThoai;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/listdt")
public class ListDTServlet extends HttpServlet {
    @Resource(name = "jdbc/qlsp")
    private DataSource dataSource;
    private DienThoaiDAO dtdao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.dtdao = new DienThoaiDAOImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maNCC = req.getParameter("maNCC");
        try {
            List<DienThoai> list = dtdao.getByNCC(maNCC);
            req.setAttribute("list", list);
            req.getRequestDispatcher("/views/DanhSachDienThoai.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
