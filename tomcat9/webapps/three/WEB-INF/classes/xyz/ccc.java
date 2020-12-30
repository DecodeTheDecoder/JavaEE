package xyz ;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ccc extends HttpServlet{

public void doGet(HttpServletRequest rq, HttpServletResponse rs){
try{
String name= rq.getParameter("name");
String city= rq.getParameter("city");
System.out.println("Name :"+name);
System.out.println("City :"+city);
PrintWriter pw;
pw= rs.getWriter();
rs.setContentType("text/html");
pw.println("<!DOCTYPE html>");
pw.println("<html>");
pw.println("<body>");
pw.println("<form action='/three/index.html' >");
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