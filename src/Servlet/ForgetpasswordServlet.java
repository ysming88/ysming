package Servlet;

import Dao.insertDao;
import Dao.updateDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/forgetpasswordServlet")
public class ForgetpasswordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );

        String email = req.getParameter("email");
        String verity = req.getParameter("verity");
        String password = req.getParameter("password");
        System.out.println("email:" + email);
        System.out.println("password:" + password);
        System.out.println("verity:"+verity);

        HttpSession session=req.getSession();
        String value=(String)session.getAttribute("value");
        System.out.println("get验证码:  "+value);
        if(verity.equals(value)) {
            new updateDao().updatepassword( email, password);
            req.setAttribute("registersucceed", "修改成功，请登录！");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("email", email);
            req.setAttribute("error", "验证码错误！");
            req.getRequestDispatcher("/forgetpassword.jsp").forward(req, resp);
        }
    }
}
