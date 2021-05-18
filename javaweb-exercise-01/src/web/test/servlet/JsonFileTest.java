package web.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


/**
 * 
 * 使用步驟
 * 1. 讀入檔案byte[]
 * 2. 用Base64編碼器將檔案byte[]編碼成Base64字串
 * 3. 將Base64字串放入JavaBean
 * 4. 用Gson將 JavaBean 轉成 JSON字串
 * 5. 用resp取得的PrintWriter將 JSON字串 寫出至前端
 *
 */
@WebServlet("/JsonFileTest")
public class JsonFileTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // request & response 的編碼方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        
        // 1. 讀入檔案byte[]
        // 取得測試路徑檔名 (file資料夾是自創的)
        String uri = System.getProperty("catalina.home") + "/file/" + "watame002.png";
        Path path = Paths.get(uri);
        byte[] bytes = Files.readAllBytes(path);
        
        // 2. 用Base64編碼器將檔案byte[]編碼成Base64字串
        String base64Str = Base64.getEncoder().encodeToString(bytes);
        
        // 3. 將Base64字串放入JavaBean
        Member member = new Member();
        member.setId(1);
        member.setAccount("watameAccount");
        member.setPassword("watamePassword");
        member.setPass(true);
        member.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
        member.setImage(base64Str);
        
        // 4. 用Gson將 JavaBean 轉成 JSON字串
        Gson gson = new Gson();
        String json = gson.toJson(member);
        
        // 5. 用resp取得的PrintWriter將 JSON字串 寫出至前端
        try (
                PrintWriter pw = response.getWriter();
        ) {
            pw.print(json);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
