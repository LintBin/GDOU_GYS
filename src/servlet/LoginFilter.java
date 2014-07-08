package servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	public void destroy() {

	}

	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain chain) throws IOException, ServletException {
		//获得账号密码
		HttpServletRequest req = (HttpServletRequest) srequest;
		HttpServletResponse res = (HttpServletResponse) sresponse;
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		//账号为空的时候做出处理
		if(username == null){
			res.sendRedirect("../login.jsp");
		}else{
			chain.doFilter(srequest,sresponse);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
