package web.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyFirstServlet")
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try (
	            // 抓取response通道(IO)，準備傳送資料
	            // PrintWriter 以列為單位寫出
	            PrintWriter pw = response.getWriter();
	    ) {
	        
	        // SimpleDateFormat(String pattern) 時間格式化 <- new java.util.Date.Date()
	        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        String dateTime = sdf.format(new Date());
	        
	        pw.append(dateTime + " - 01 - Bowen"); // 加入訊息
	        
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
