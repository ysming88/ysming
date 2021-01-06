package Servlet;

import Dao.selectDao;
import Domain.register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/updateuserServlet")
public class UpdateuserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("updateuserServlet-get");

        String email = req.getParameter("email");
        System.out.println("email:" + email);

        ArrayList<register> user=new selectDao().findRegister(email);
        for(register id:user)
        {
            System.out.println(id.getEmail()+id.getUsername()+id.getPassworld()+id.getHead());
            req.setAttribute("email", email);
            req.setAttribute("username", id.getUsername());
            req.setAttribute("password", id.getPassworld());
        }

        req.getRequestDispatcher("/updateuser.jsp").forward(req, resp);
    }
}
