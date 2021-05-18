package web.test.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// "/*"表示攔截所有網址
@WebFilter("/*") 
public class MyFilter extends HttpFilter {
    
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        
        System.out.println("前置處理");
        
        chain.doFilter(req, res);
        
        System.out.println("後置處理");
    }
}
