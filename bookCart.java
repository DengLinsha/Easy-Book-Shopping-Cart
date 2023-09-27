package cartSession;

import java.util.HashMap;
import java.util.Map;

public class bookCart {

    // 存放书名和数量
    private static Map<String, Integer> books = new HashMap<String, Integer>();
    private  int number;
    public void addBook(String bookName) {
        if (books.containsKey(bookName)) {
            // 购物车有当前要购买的书
            int quantity = books.get(bookName);
            books.put(bookName, quantity + 1);
        } else {
            // 购物车没有当前要购买的书
            books.put(bookName, 1);
        }
        number++;
    }
    // 获得所购买书的数量
    public int getNumber() {
        return number;
    }
    // 获得所购买的书
    public Map<String, Integer> getBooks() {
        return books;
    }
    // 清除购物车内容
    public void clear() {
        books.clear();
    }
}
