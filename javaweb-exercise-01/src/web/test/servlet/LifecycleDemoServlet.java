package web.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LifecycleDemoServlet")
public class LifecycleDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifecycleDemoServlet() {
        super();
        
        // Lifecycle
        System.out.println("constructor()");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try (
	            // 抓取response通道(IO)，準備傳送資料
                // PrintWriter 以列為單位寫出
	            PrintWriter writer = response.getWriter();
	    ) {
	        // SimpleDateFormat(String pattern) 時間格式化 <- new java.util.Date.Date()
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        String dateTime = sdf.format(new Date());
	        
	        // 取得當下 時 分 秒
	        String dateTime2 = new Time(System.currentTimeMillis()).toString();
	        
	        writer.append(dateTime);
	        writer.append("\n");
	        writer.append(dateTime2);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        
        // Lifecycle
        System.out.println("service()");
    }

    @Override
    public void destroy() {
        super.destroy();
        
        // Lifecycle
        System.out.println("destroy()");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        
        // Lifecycle
        System.out.println("init()");
    }

}
