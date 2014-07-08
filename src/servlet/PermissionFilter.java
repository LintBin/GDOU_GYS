package servlet;

import java.io.IOException;



import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PermissionFilter implements Filter {

	public void destroy() {
		
	}

	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) srequest;
		HttpServletResponse res = (HttpServletResponse) sresponse;
		HttpSession session = req.getSession();
		String permission = (String) session.getAttribute("permission");
		
		if(permission.equals("COMMON_USER")){
			RequestDispatcher dispatcher = req.getRequestDispatcher("../jsp/right.jsp");
		}else{
			chain.doFilter(srequest,sresponse);
		}
		
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	
	
}
