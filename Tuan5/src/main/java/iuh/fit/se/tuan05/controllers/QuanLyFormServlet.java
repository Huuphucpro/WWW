package iuh.fit.se.tuan05.controllers;

import iuh.fit.se.tuan05.dao.DienThoaiDAO;
import iuh.fit.se.tuan05.dao.impl.DienThoaiDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;

@WebServlet("/QuanLyFormServlet")
public class QuanLyFormServlet extends HttpServlet {
    private DienThoaiDAO dienThoaiDAO;

    @Override
    public void init() {
        DataSource ds = (DataSource) getServletContext().getAttribute("dataSource");
        dienThoaiDAO = new DienThoaiDAOImpl(ds);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maDT = req.getParameter("maDT");
        String maNCC = req.getParameter("maNCC");
        try {
            dienThoaiDAO.delete(maDT);
            resp.sendRedirect("DanhSachDienThoaiNCCServlet?maNCC=" + maNCC);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
