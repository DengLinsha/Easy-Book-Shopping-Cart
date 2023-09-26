package loginSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginSessionServlet", value = "/LoginSessionServlet")
public class LoginSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String freeOption = request.getParameter("free");
        // 验证用户名和密码，这里使用简单的模拟验证
        if ("denglinsha".equals(username) && "123456".equals(password)) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setFreeStatus(freeOption);
            // 存入Session域进行数据共享
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/CookieSession/indexServlet");
        } else {
            // 登录失败
            response.getWriter().write("用户名密码错误，登录失败<br>");
            response.getWriter().write("请点击<a href='/CookieSession/loginServlet'>重新登录</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
