package PresentationsLayer.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BussinessLayer.ServiceBUS.ServiceAdmin;


@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceAdmin admin;
  
    public AdminServlet() {
        super();
        admin=new ServiceAdmin();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.getRequestDispatcher("/admins/login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.getCharacterEncoding();
			String username=request.getParameter("username");
			String passwd=request.getParameter("passwd");
			if(admin.checkError(username, passwd).isEmpty()) {
				request.getRequestDispatcher("/admins/index.jsp").forward(request, response);
				
			}else {
				HashMap<String, String>error=admin.checkError(username, passwd);
				for(Map.Entry<String, String> x:error.entrySet()) {
					request.setAttribute(x.getKey(), x.getValue());
				}
				request.getRequestDispatcher("/admins/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
