package kr.teamfive.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ExecTimeFilter implements Filter{

	@Override
	public void init(FilterConfig Config) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest hReq = (HttpServletRequest)request;
		String uri = hReq.getRequestURI();
		
		long s = System.currentTimeMillis(); // 시작시간 (밀리세컨즈 - 1/1000 초) 
		chain.doFilter(request, response);
		double time = (System.currentTimeMillis() - s) / 1000d ;
		// 	/projectname/board.list.do - 실행시간: 1.0021초 걸림 
		System.out.printf("%s - 실행시간: %.4f초 걸림..\n", uri, time);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
