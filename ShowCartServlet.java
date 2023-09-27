package cartSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "ShowCartServlet", value = "/ShowCartServlet")
public class ShowCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应对象的字符编码，确保服务器以正确的字符编码向客户端发送响应内容
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取session对象
        HttpSession session = request.getSession();
        // 获取购物车对象
        bookCart cart = (bookCart) session.getAttribute("cart");
        if (cart != null) {
            // 显示购物车内容
            PrintWriter out = response.getWriter();
            out.println("<html lang='en'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>购物车</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>您的购物车有" + cart.getNumber() + "个商品：" + "</h1>");
            out.println("<p>您已选购以下书籍：</p>");
            Map<String, Integer> books = cart.getBooks();
            for (Map.Entry<String, Integer> book : books.entrySet()) {
                String bookName = book.getKey();
                int quantity = book.getValue();
                out.println(bookName + ": " + quantity + "本 <br>");
            }
            out.println("<br>");
            out.println("<a href='shopping.html'>继续购物</a><br>");
            out.println("<a href='/CookieSession/logoutCartServlet'>退出系统</a><br>");
            out.println("</body>");
            out.println("</html>");
        } else {
            response.sendRedirect("/CookieSession/loginServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
