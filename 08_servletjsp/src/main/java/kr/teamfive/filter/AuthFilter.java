package kr.teamfive.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.teamfive.repository.domain.Member;

public class AuthFilter implements Filter{
	// 로그인 없이 접근할 수 있는 페이지 url 페이지 리스트 
	private List<String> list = new ArrayList<>();
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		String pages = config.getInitParameter("pages");
//		System.out.println(pages);
		String[] arr = pages.split(";");
		for(String page: arr) {
			System.out.println(page.trim());
			list.add(page.trim());
		}
	}
	
	@Override
	   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	         throws IOException, ServletException {
		HttpServletRequest hReq = (HttpServletRequest)request;
		HttpServletResponse hRes = (HttpServletResponse)response;

		// 사용자가 요청한 페이지 URI 가져오기 
		String uri = hReq.getRequestURI();
		System.out.println("uri: "+uri);
		
		String contextPath = hReq.getContextPath(); // 프로젝트 경로
		System.out.println("contextPath: "+contextPath);
		
		uri = uri.substring(contextPath.length());
		System.out.println("변경후 contextPath: "+uri);
		
	    //로그인이 필요한 페이지에 대해서 로그인이 되어 있는지 체크하고 
		// list 안에 uri 가 포함되어 있는지 확인한다.
		// 포함되어 있다면 호출한 페이지로 이동시킨다.
		// 포함되어 있지 않다면 반드시 로그인 해야 하는 페이지 이다.
		// -1 이라면 리스트에 포함되어 있지 않다. 
		int index = list.indexOf(uri);
		if(index==-1) {
			HttpSession session = hReq.getSession();
			Member id= (Member)session.getAttribute("id");
			if(id==null) {
				 // 로그인 폼으로 메이지를 이동 
				hRes.sendRedirect(contextPath+"/jsp/main/main.do");
				return;
			}
		}
		
		// 만약 로그인이 안되어 있다면 로그인폼("/login/login-form.do")으로 이동시키고
		// session 객체에 "user"의 이름으로 객체가 등록되어 있는지 확인한다. 	    
			
	      
	      //로그인 되어있다면 호출한 페이지로 이동시킨다.
	      chain.doFilter(request, response);
	   }


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
