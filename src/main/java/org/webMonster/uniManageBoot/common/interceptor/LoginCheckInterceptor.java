package org.webMonster.uniManageBoot.common.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.webMonster.uniManageBoot.member.entity.MemberEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		MemberEntity loginMember = (MemberEntity) session.getAttribute("loginMember");

		//임시
		String requestURI = request.getRequestURI();
		if (requestURI.equals("/") || requestURI.equals("/favicon.ico")) {
			return true;
		}

		if (loginMember == null) {
			response.setStatus(401); // Unauthorized status code
			response.setContentType("application/json");
			response.getWriter().write("{\"message\": \"Please log in.\"}");
			response.getWriter().flush();
			return false;
		}

		return true;
	}
}