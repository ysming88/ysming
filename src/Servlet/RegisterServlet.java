package Servlet;

import Dao.insertDao;
import Dao.selectDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/registerServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        String email = req.getParameter("email");
        String verity= req.getParameter("verity");

        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("email:" + email);
        System.out.println("verity:"+verity);

        if(new selectDao().register(email)){
            req.setAttribute("username", email);
            req.setAttribute("password", password);
            req.setAttribute("repassword", repassword);
            req.setAttribute("email", email);
            req.setAttribute("error", "此号码已被注册！");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
        else {
            HttpSession session=req.getSession();
            String value=(String)session.getAttribute("value");
            System.out.println("get验证码:  "+value);
            if(verity.equals(value)) {
                new insertDao().register(username, email, password,"pic/灰太狼.jpg");
//                req.setAttribute("registersucceed", "注册成功，请登录！");
                resp.setContentType("text/html;charset=gb2312");//防止弹窗无法发中文

                resp.setContentType("text/html;charset=gb2312");//防止弹窗无法发中文
                resp.getWriter().print("<script language='javascript'>alert('注册成功');window.location.href='/java_web_war_exploded/login.jsp';</script>");
            }
            else {
                req.setAttribute("username", username);
                req.setAttribute("password", password);
                req.setAttribute("repassword", repassword);
                req.setAttribute("email", email);
                req.setAttribute("error", "验证码错误！");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        }
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        System.out.println("get");
//        req.setCharacterEncoding( "UTF-8" );
//        resp.setContentType( "textml;charset=UTF-8" );
//
//        String email = req.getParameter("email");
//        System.out.println("email:" + email);
//
//        String  x=new RandomNum().getRandomNumCode(4);//生成4位数验证码给x
//        try {
//            SendMail.Mail( String.valueOf(x),email);//给邮箱发送验证码
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
}
