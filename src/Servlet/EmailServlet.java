package Servlet;

import Demo.RandomNum;
import Demo.SendMail;

import javax.mail.MessagingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/emailServlet")
public class EmailServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setContentType( "textml;charset=UTF-8" );
        System.out.println("get" );

        String email = req.getParameter("email");
        System.out.println("email:" + email);

        String  x=new RandomNum().getRandomNumCode(4);//生成4位数验证码给x
        String  message=("验证码："+x);
        System.out.println(message);

        //传验证码给RegisterServlet
        HttpSession session=req.getSession();
        session.setAttribute("value",x);

        try {
            SendMail.Email(email,message);//给邮箱发送验证码
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
