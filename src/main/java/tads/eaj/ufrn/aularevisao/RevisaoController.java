package tads.eaj.ufrn.aularevisao;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Controller
public class RevisaoController {


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public void doGetUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var writer = response.getWriter();
        response.setContentType("text/html");
        writer.println("Hello User");
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public void doGetAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var writer = response.getWriter();
        response.setContentType("text/html");
        writer.println("Hello Admin");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void doProcessLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var login = request.getParameter("login");
        var password = request.getParameter("password");

        if (login.equals("user") && password.equals("123")) {
            HttpSession session = request.getSession();
            session.setAttribute("tipo", "user");

            response.sendRedirect("/user");
        }else if (login.equals("admin") && password.equals("456")){
            HttpSession session = request.getSession();
            session.setAttribute("tipo", "admin");

            response.sendRedirect("/admin");
        }else{
            response.sendRedirect("index.html");
        }
    }
}
