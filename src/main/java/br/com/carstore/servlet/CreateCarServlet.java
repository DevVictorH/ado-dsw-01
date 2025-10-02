package br.com.carstore.servlet;

import br.com.carstore.dao.CarDAO;
import br.com.carstore.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String carName = req.getParameter("car-name");

        Car car = new Car(carName);

        new CarDAO().createCar(car);

        req.getRequestDispatcher("index.html").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        HttpSession s = req.getSession(false);
        String carName = (s != null && s.getAttribute("carName") != null)
                ? s.getAttribute("carName").toString()
                : "";

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().write("{\"carName\":\"" + jsonEscape(carName) + "\"}");
    }

    private String jsonEscape(String s) {
        if (s == null) return "";
        return s.replace("\\","\\\\").replace("\"","\\\"")
                .replace("\b","\\b").replace("\f","\\f")
                .replace("\n","\\n").replace("\r","\\r")
                .replace("\t","\\t");
    }
}
