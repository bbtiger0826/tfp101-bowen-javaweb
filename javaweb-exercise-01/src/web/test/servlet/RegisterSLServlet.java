package web.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        // 設定映射的網址
        urlPatterns = {"/RegisterSLServlet", "/registerSL", "/REGISTER_SL"},
        // 設定Servlet的名稱
        name = "registerSLServlet",
        // 設定啟動順序
        loadOnStartup = 1,
        // 設定初始化參數
        initParams = {
                @WebInitParam(name = "name", value = "Bowen"),
                @WebInitParam(name = "hight", value = "180")
        }
)
public class RegisterSLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String name, hight, value;
	
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        super.init();
//        
////        this.name = config.getInitParameter("name");
////        this.hight = config.getInitParameter("hight");
//    }

    public RegisterSLServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try (
	            // 抓取response通道(IO)，準備傳送資料
                // PrintWriter 以列為單位寫出
	            PrintWriter writer = response.getWriter();
	    ) {
	        // 取得Servlet初始化用的參數
	        ServletConfig config = getServletConfig();
	        // 取得Servlet所有config(初始化)參數的名稱
	        Enumeration<String> initParams = config.getInitParameterNames();
	        // 遞迴抓取name(可以不用知道有哪些name)，在一個個取得value
	        while (initParams.hasMoreElements()) {
	            name = initParams.nextElement();
	            value = config.getInitParameter(name);
	            
	            writer
	            .append(name)
	            .append("\t")
	            .append(value)
	            .append("\n");
	        }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
