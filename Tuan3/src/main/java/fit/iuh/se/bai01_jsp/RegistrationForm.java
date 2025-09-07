package fit.iuh.se.bai01_jsp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student sv = new Student();

        sv.setFirstName(req.getParameter("firstName"));
        sv.setLastName(req.getParameter("lastName"));
        sv.setEmail(req.getParameter("email"));
        sv.setPhoneNumber(req.getParameter("phoneNumber"));
        sv.setGender(req.getParameter("gender"));
        sv.setAddress(req.getParameter("address"));
        sv.setCity(req.getParameter("city"));
        sv.setPin_code(req.getParameter("pin_code"));
        sv.setState(req.getParameter("state"));
        sv.setCountry(req.getParameter("country"));

        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        sv.setDob(day + " " + month + " " + year);

        String[] hobbies = req.getParameterValues("hobbies");
        if (hobbies != null) sv.setHobbies(Arrays.asList(hobbies));

        sv.setBoard10(req.getParameter("board10"));
        sv.setPercent10(req.getParameter("percent10"));
        sv.setYear10(req.getParameter("year10"));

        sv.setBoard12(req.getParameter("board12"));
        sv.setPercent12(req.getParameter("percent12"));
        sv.setYear12(req.getParameter("year12"));

        sv.setBoardGrad(req.getParameter("boardGrad"));
        sv.setPercentGrad(req.getParameter("percentGrad"));
        sv.setYearGrad(req.getParameter("yearGrad"));

        sv.setBoardMas(req.getParameter("boardMas"));
        sv.setPercentMas(req.getParameter("percentMas"));
        sv.setYearMas(req.getParameter("yearMas"));

        String[] courses = req.getParameterValues("courses");
        if (courses != null) sv.setCourses(Arrays.asList(courses));

        req.setAttribute("student", sv);

        RequestDispatcher rd = req.getRequestDispatcher("result-form.jsp");
        rd.forward(req, resp);
    }
}
