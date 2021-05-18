package web.test.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

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
	    // request & response 的編碼方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("charset=UTF-8");
	    
		// 將.pdf檔寫出至客戶端
		String file = "/WEB-INF/pdf/test.pdf";
		// 一定要在處理訊息本體前設定
//		response.setContentType("application/pdf");
		
		// 如果想要強制下載，要改變MIME Type設定
		response.setContentType("application/octet-stream"); // MIME Type設定
		String filename = URLEncoder.encode("測試.pdf", "UTF-8"); // 設定中文檔名
		response.setHeader("Content-Disposition", "attachment;filename=" + filename); // 設定檔名
		try (
		        // 位元組讀入(2種方式)
		        InputStream is = getServletContext().getResourceAsStream(file);
		        FileInputStream fis = (FileInputStream)getServletContext().getResourceAsStream(file);
		        // 位元組寫出
		        ServletOutputStream sos = response.getOutputStream();
		        
		        
		) {
		    // available() -> 預估的byte數
		    byte[] buf = new byte[is.available()];
		    // 寫法一：以buf大小為單位讀取資料至buf中(傳參考呼叫)，回傳讀到的byte數。無資料時回傳-1
            while (is.read(buf) != -1) {
                sos.write(buf);
            }
            // 寫法二：FileInputStream，讀入一byte的資料，並轉換成0~255的整數傳回。無資料時回傳-1
//            int i;
//            while ((i = fis.read()) != -1) {
//                sos.write(i);
//            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
