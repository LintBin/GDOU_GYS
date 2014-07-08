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

public class EncodingFilter implements Filter{
	String encoding = null;

	public void destroy() {
		encoding = null;
	}

	public void doFilter(ServletRequest srequest, ServletResponse sresponse,
			FilterChain chain) throws IOException, ServletException {
		  HttpServletRequest request = (HttpServletRequest)srequest;
		  HttpServletResponse response = (HttpServletResponse)sresponse;
		
		  if(this.encoding != null && !this.encoding.equals("")){
			
		  }else{
			  
		  }
		chain.doFilter(srequest, sresponse);
	}

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		System.out.println("encoding="+encoding);
		System.out.println("编码拦启动");
	}

}
