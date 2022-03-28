package BussinessLayer.Utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
public static Cookie addCookie(String name,String values,int hour,HttpServletResponse response) {
	Cookie cookie=new Cookie(name, values);
	cookie.setPath("/");
	cookie.setMaxAge(hour*60*60);
	response.addCookie(cookie);
	return cookie;
}
public static String getCookieValue(String name,HttpServletRequest request) {
    Cookie[] cookie=request.getCookies();
     if (cookie!=null) {
    	 for(Cookie x:cookie) {
    		 if(x.getName().equals(name)) {
    			 return x.getValue();
    		 }
    	 }
		
	}
     return null;
	
}
}
