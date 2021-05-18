package web.test.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@WebServlet("/UseJsonFormatServlet")
public class UseJsonFormatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 
	private Gson gson = new Gson();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // request & response 的編碼方式
        request.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json; charset=UTF-8");
	    
	    // 讀入JSON格式的會員資料，將帳號激活(pass = true)，以 JSON格式寫出激活後的會員
	    try (
	            // 取得用來從前端讀入純文字資料的Reader
	            BufferedReader br = request.getReader();
	            // 
	            PrintWriter pw = response.getWriter();
	    ) {
	        // 讀入JSON格式的會員資料
            Member member = gson.fromJson(br, Member.class);
            // 帳號激活
            member.setPass(true);
            // JSON格式寫出激活後的會員
            pw.print(gson.toJson(member));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
}
