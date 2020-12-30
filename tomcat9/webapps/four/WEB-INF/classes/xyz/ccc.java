package xyz ;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class ccc extends HttpServlet{

public void doGet(HttpServletRequest rq, HttpServletResponse rs){
try{
Cookie cookies[]=rq.getCookies();
String name="";
String city="";
if(cookies!=null){
int x;
Cookie c;
for (x=0;x<cookies.length;x++){
c=cookies[x];
	if(c.getName().equals("Name")){

	name=URLDecoder.decode(c.getValue());
	}
	if(c.getName().equals("City")){

	city=URLDecoder.decode(c.getValue());
	}
}


}

System.out.println("Name :"+name);
System.out.println("City :"+city);
PrintWriter pw;
pw= rs.getWriter();
rs.setContentType("text/html");
pw.println("<!DOCTYPE html>");
pw.println("<html>");
pw.println("<body>");
pw.println("<form action='/four/index.html' >");
pw.println("Name : "+name+"</br>");
pw.println("City :"+city+"</br>");
pw.println("<button type='submit'>Ok</button>");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");
}catch(Exception e){
System.out.println(e);
}
}

}