package Servlet;

import Dao.selectDao;
import Domain.Information;
import Domain.register;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/percenterServlet")
public class PercenterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );

        String email = req.getParameter("email");
        System.out.println("email:" + email);

        ArrayList<register> user=new selectDao().findRegister(email);
        for(register id:user)
        {
            System.out.println(id.getEmail()+id.getUsername()+id.getPassworld()+id.getHead());
            req.setAttribute("email", email);
            req.setAttribute("username", id.getUsername());
            req.setAttribute("password", id.getPassworld());
            req.setAttribute("head", id.getHead());
        }

        ArrayList<Information> information=new selectDao().findInformation(email);
        for (Information id:information)
        {
            System.out.println(id.getName()+id.getSex()+id.getBirthday()+id.getJob()+id.getPhone()+id.getEmail());
            req.setAttribute("name", id.getName());
            req.setAttribute("sex", id.getSex());

            req.setAttribute("birthday", id.getBirthday());
            String year=id.getBirthday().substring(0,4);
            String month=id.getBirthday().substring(4,6);
            String day=id.getBirthday().substring(6,8);
            req.setAttribute("year", year);
            req.setAttribute("month", month);
            req.setAttribute("day", day);

            req.setAttribute("job", id.getJob());
            req.setAttribute("phone", id.getPhone());
        }
        req.getRequestDispatcher("/perCenter.jsp").forward(req, resp);
    }

}
