package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import entity.Dados;

@WebServlet("/Controle")
public class Controle extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if (cmd.equalsIgnoreCase("logar")) {
			logar(request, response);}
		
	}
	
	
	protected String logar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = new String(request.getParameter("login"));
		String senha = new String(request.getParameter("senha"));
		
//		Consumo c = new Consumo();
//		
//		try {
//			c.retorna_token(login, senha);
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		request.getRequestDispatcher("medicao.jsp").forward(request, response);

		
		return "";
	}	
			
			
			
	
	

}
