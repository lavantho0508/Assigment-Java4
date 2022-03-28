package PresentationsLayer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import BussinessLayer.ServiceBUS.ServiceAdmin;
import BussinessLayer.ServiceBUS.ServiceStaff;
import BussinessLayer.Utils.CookieUtil;
import BussinessLayer.Utils.HashUtil;
import BussinessLayer.entities.Admin;
import BussinessLayer.entities.Staff;
import java.util.BitSet;



@WebServlet({"/admin/login",
		     "/admin/index"
})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServiceAdmin admin;
	ServiceStaff staff;
	List<Admin> listAdmin;
	List<Staff>listStaff;

  
    public AdminServlet() {
        super();
        admin=new ServiceAdmin();
        staff=new ServiceStaff();
        listAdmin=new ArrayList<Admin>();
        listStaff=new ArrayList<Staff>();   
    } 
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.getCharacterEncoding();
		String btn_login=request.getParameter("login");
		String btn_add=request.getParameter("btn_add");
    	try {
			if(btn_login!=null) {
				String username=request.getParameter("username");
				String passwd=request.getParameter("passwd");
				String passwdHash=HashUtil.MD5(passwd);
				String remember=request.getParameter("remember");
				if(admin.checkError(username, passwdHash).isEmpty()) {
					listAdmin=admin.selectAll();
					listStaff=staff.selectAll();
					if(remember!=null) {
						CookieUtil.addCookie("username", username, 10, response);
						CookieUtil.addCookie("password", passwd, 10, response);		
					}
					HttpSession session=request.getSession();
					session.setAttribute("admin", username);	
					request.setAttribute("admin", listAdmin);
					request.setAttribute("staff", listStaff);			
				    request.getRequestDispatcher("/admin/index").forward(request, response);
					
				}else {
					HashMap<String,String>error=admin.checkError(username, passwd);
					for(Map.Entry<String, String> x:error.entrySet()) {
						request.setAttribute(x.getKey(), x.getValue());
					}
					request.getRequestDispatcher("/admin/login").forward(request, response);
				}
			}
			if(btn_add!=null) {
				Admin a=new Admin();
				BeanUtils.populate(a, request.getParameterMap());
				if(admin.add(a)!=null) {
					System.out.println("demo");
					listAdmin=new ArrayList<Admin>();
					listAdmin=admin.selectAll();
					request.removeAttribute("admin");
					request.setAttribute("admin", listAdmin);
				   request.setAttribute("active", "active");
					request.getRequestDispatcher("/admin/index").forward(request, response);
					System.out.println(listAdmin.size());
				}
				
				///
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/admins/index.jsp").forward(request, response);
    }
    //do get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username=CookieUtil.getCookieValue("username", request);
	    String passwd=CookieUtil.getCookieValue("password", request);
	String uri=request.getRequestURI();
	if(uri.contains("login")) {
		request.setAttribute("username",username);
		request.setAttribute("password",passwd);
		request.getRequestDispatcher("/admins/login.jsp").forward(request, response);
	}else if(uri.contains("index")) {
		index(request, response);	
	}else {
		
	}
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		if(uri.contains("login")) {
			login(request, response);
		}else if(uri.contains("index")) {
			index(request, response);	
		}else {
			
		}
	}


}
