package web.test.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestJNDI")
public class TestJNDI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
//	    try (
//	            // JNDI寫法 HikariDataSource 要強制轉型
//	            // HikariCP -> Java的連線池實作(第三方)
//	            HikariDataSource dataSource = (HikariDataSource)new InitialContext().lookup("java:/comp/env/jdbc/example");
//	    ) {
//	        try (
//	                // dataSource -> 由資料源產生的連線物件，在web環境下較常使用
//	                Connection connection = dataSource.getConnection();
//	                // sql: 欲對資料庫執行的SQL敘述. 可帶有多個問號，表示佔位符(placeholder)
//	                PreparedStatement pstm = connection.prepareStatement("select * from EMP");
//	                // ResuleSet rs -> 結果集
//	                ResultSet rs = pstm.executeQuery();
//	               
//	        ) {
//	            while (rs.next()) {
//	                // rs.get型態(“欄名”);
//                    System.out.println(rs.getString("ENAME"));
//                }
//                
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
