package Servlet;

import Dao.deleteDao;
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

@WebServlet("/delelabelServlet")
public class DelelabelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("delelabelServlet-post");

        HttpSession session=req.getSession();
        String email=(String) session.getAttribute("email");
        String label = req.getParameter("delelabel");
        System.out.println("label:" + label);

        new deleteDao().delelabel(label,email);

        ArrayList<Label> allLabel = new selectDao().label(email);

        session.setAttribute("allLabel",allLabel);
        req.getRequestDispatcher("/mylabel.jsp").forward(req, resp);
    }
}
