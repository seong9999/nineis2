package team.travel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.map")
public class CalendarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		boolean isLoginCheck = false;
		// 요청 URL에서 서블릿 이름을 추출한다.
		String url = request.getRequestURI();
		// /을 기준으로 잘라낸다.
		String [] sub = url.split("/");
		url = sub[sub.length -1];
		// ;JSESSIONID값이 있다면 제거한다.
		sub = url.split(";");
		url = sub[0];
		// 이동할 페이지
		String site = null;
		// 서블릿 이름으로 분기한다.
		switch(url){
		case "calendar_result.map" :
			site = "CalendarResultServlet";
			break;
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(site);
		dis.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
