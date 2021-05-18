package web.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("MyListener: contextDestroyed");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("MyListener: contextInitialized");
    }
	
}
