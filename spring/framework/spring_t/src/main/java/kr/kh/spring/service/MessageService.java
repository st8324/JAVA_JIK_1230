package kr.kh.spring.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	public void sendMessage(HttpServletResponse response, 
			HttpServletRequest request,
			String message, 
			String url) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+ message +"');");
			out.println("location.href='"+ request.getContextPath() + url + "'");
			out.println("</script>");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
