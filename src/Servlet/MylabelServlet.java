package Servlet;

import Dao.selectDao;
import Domain.Label;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/mylabelServlet")
public class MylabelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("mylabelServlet-post");

        HttpSession session=req.getSession();
        String email = req.getParameter("email");
        System.out.println("email:"+email);
        session.setAttribute("email",email);

        ArrayList<Label> allLabel = new selectDao().label(email);
        for (Label label:allLabel){
            System.out.println("label:"+label.getLabel());
        }
        session.setAttribute("allLabel",allLabel);

        req.getRequestDispatcher("/mylabel.jsp").forward(req, resp);
    }
}
