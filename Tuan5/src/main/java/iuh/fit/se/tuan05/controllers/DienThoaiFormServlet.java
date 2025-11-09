package iuh.fit.se.tuan05.controllers;

import iuh.fit.se.tuan05.dao.DienThoaiDAO;
import iuh.fit.se.tuan05.dao.impl.DienThoaiDAOImpl;
import iuh.fit.se.tuan05.entities.DienThoai;
import iuh.fit.se.tuan05.entities.NhaCungCap;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/form")
public class DienThoaiFormServlet extends HttpServlet {
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
        req.getRequestDispatcher("/views/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String maDT = req.getParameter("maDT");
            String tenDT = req.getParameter("tenDT");
            int namSX = Integer.parseInt(req.getParameter("namSX"));
            String cauHinh = req.getParameter("cauHinh");
            String maNCC = req.getParameter("maNCC");
            String hinhAnh = req.getParameter("hinhAnh");

            DienThoai dt = new DienThoai(maDT, tenDT, namSX, cauHinh, 
                    new NhaCungCap(maNCC, null, null, null), hinhAnh);

            dtdao.insert(dt);
            resp.sendRedirect("/listdt?maNCC=" + maNCC);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
