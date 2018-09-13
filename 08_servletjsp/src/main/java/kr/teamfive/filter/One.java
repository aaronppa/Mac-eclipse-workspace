/*
 *		Filter 기능
 *		1. Filter Interface 상속
 *		2. init: 메모리에 초딩시 최초 한번만 수행함. (웹서버가 구동될 때)
 *		3. doFilter: 호출시마다 실행
 *		4. 어떤 URL에 필터가 호출될 지 설정 
 *		5.  
 */
package kr.teamfive.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class One implements Filter{
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("One 필터 클래스 메모리 로딩시 최초 한번만 수행");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 다음 필터 또는 서블릿을 호출한다.
		System.out.println("One 다음 필터 또는 서블릿 호출 전...");
		chain.doFilter(request, response);
		System.out.println("One 다음 필터 또는 서블릿 호출 후...");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	

	
} // end class
