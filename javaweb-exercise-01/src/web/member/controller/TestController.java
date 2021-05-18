package web.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.member.bean.Member;
import web.member.service.MemberService;

@WebServlet("/member/test")
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 下一層是 Service層
	private MemberService memberService;
	
    // init() 實例化    
	@Override
    public void init() throws ServletException {
        super.init();
        
        memberService = new MemberService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // request & response 的編碼方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        
        // 1.利用MemberService取得會員資料
        List<Member> mambers = memberService.test();
        
        // 2.將找到的資料，以JSON格式寫出
        try (
                // 
                PrintWriter pw = response.getWriter();
        ) {
            // JSON格式寫出激活後的會員
            String string = new Gson().toJson(mambers);
            pw.print(string);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
