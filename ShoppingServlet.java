package cartSession;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "ShoppingServlet", value = "/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求对象的字符编码，正确地解析和获取请求参数的值
        request.setCharacterEncoding("UTF-8");
        // 设置响应对象的字符编码，确保服务器以正确的字符编码向客户端发送响应内容
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        // 获取session对象
        HttpSession session = request.getSession();
        // 获取购物车对象
        bookCart cart = (bookCart) session.getAttribute("cart");
        if (cart == null) {
            // 如果购物车对象不存在，则创建新的购物车对象
            cart = new bookCart();
            session.setAttribute("cart", cart);
        }
        // 获取复选框的数据
        String[] selectedBooks = request.getParameterValues("book");
        if (selectedBooks != null) {
            for (String bookName : selectedBooks) {
                // 将选中的图书加入购物车
                cart.addBook(bookName);
            }
        }
        response.sendRedirect("/CookieSession/showCartServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
