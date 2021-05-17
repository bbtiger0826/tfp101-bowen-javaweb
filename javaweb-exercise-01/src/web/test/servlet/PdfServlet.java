package web.test.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PdfServlet")
public class PdfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 將.pdf檔寫出至客戶端
		String file = "/WEB-INF/pdf/test.pdf";
		response.setContentType("application/pdf"); // 一定要在處理訊息本體前設定
		try (
		        InputStream is = getServletContext().getResourceAsStream(file);
		        ServletOutputStream sos = response.getOutputStream();
		) {
		    byte[] buf = new byte[is.available()];
            while (is.read(buf) != -1) {
                sos.write(buf);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
