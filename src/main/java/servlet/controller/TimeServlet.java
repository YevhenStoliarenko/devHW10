package servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;

@WebServlet(value = "/time/*")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String timezone = req.getParameter("timezone");
            if (timezone.equals("")) {
                resp.getWriter().write(TimeZone.getLocalTime("GMT+2") + " " + "GMT+2");
            } else {
                String replace = timezone.replace(" ", "+");
                resp.getWriter().write(TimeZone.getLocalTime(replace) + " " + replace);
            }

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        resp.getWriter().close();
    }
}
