package xyz ;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.*;

public class bbb extends HttpServlet{

public void doGet(HttpServletRequest rq, HttpServletResponse rs){
try{
String name= rq.getParameter("nm");
String city= rq.getParameter("ct");
Cookie c1=new Cookie("Name",URLEncoder.encode(name));
rs.addCookie(c1);
Cookie c2= new Cookie("City",URLEncoder.encode(city));
rs.addCookie(c2);
System.out.println("Name :"+name);
System.out.println("City :"+city);
PrintWriter pw;
pw= rs.getWriter();
rs.setContentType("text/html");
pw.println("<!DOCTYPE html>");
pw.println("<html>");
pw.println("<body>");

pw.println("Name : "+name+"</br>");
pw.println("City :"+city+"</br>");
pw.println("<a href='/four/ccc'>Save</a>");
pw.println("</body>");
pw.println("</html>");
}catch(Exception e){
System.out.println(e);
}
}

}