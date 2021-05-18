package web.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 練習跳轉 TestServlet -> ReceiveParameterServlet
// 練習檔案路徑 catalina.home
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    String name = request.getParameter("name");
//	    System.out.println(name);
	    
	    Map<String, String[]> paramMap = request.getParameterMap();
	    for (String name : paramMap.keySet()) {
	        System.out.println(name + ": " + Arrays.toString(paramMap.get(name)));
	    }
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 方式一 Forward
//        System.out.println("Forward start");
//        request.setAttribute("name", "Forward-Bowen");
//        request.getRequestDispatcher("ReceiveParameterServlet").forward(request, response);
//        System.out.println("Forward end");
        
        // 方式二 Redirect
//        System.out.println("Redirect start");
//        // 使用Session範圍物件
//        HttpSession session = request.getSession();
//        session.setAttribute("name", "Redirect-Bowen");
//        response.sendRedirect("ReceiveParameterServlet");
//        System.out.println("Redirect end");
        
        // 練習 catalina.home
//        String tomcatRoot = System.getProperty("catalina.home");
//        System.out.println("tomcatRoot: " + tomcatRoot);
//        try (
//                PrintWriter pw = response.getWriter();
//        ) {
//            pw
//            .append("tomcatRoot: ")
//            .append(tomcatRoot);
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
