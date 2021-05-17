package web.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

@WebServlet("/ReceiveParameterServlet")
public class ReceiveParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // request & response 的編碼方式
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=utf-8");
	    try (
		        PrintWriter printWriter = response.getWriter();
		) {
		    // 接收來自sendParameter.html的請求參數，並將所有請求參數的名稱和值印出至Console
		    String name = request.getParameter("name");
		    String[] hobbies = request.getParameterValues("hobbies");
		    System.out.println("name: " + name);
		    System.out.println("hobbies: " + Arrays.toString(hobbies));
		    
		    // 回應狀態碼(Status Code)204
		    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
