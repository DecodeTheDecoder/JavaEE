package xyz;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class aaa extends HttpServlet{


public void doGet(HttpServletRequest rq,HttpServletResponse rs){
try{
String name=rq.getParameter("nm");
System.out.println("Data arrived");
System.out.println("Name :"+name);
PrintWriter pw;
pw= rs.getWriter();
rs.setContentType("text/html");
pw.println("<!DOCTYPE html>");
pw.println("<html>");
pw.println("<head>");
pw.println("<script>");
pw.println("function validate(frm){");
pw.println("var cc= frm.ct.value.trim();");
pw.println("if(cc.length==0){");
pw.println("alert('city required');");
pw.println("return false;");
pw.println("}");
pw.println("return true;");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<form action='/two/bbb' onsubmit='return validate(this)'>");
pw.println("<input type='hidden' name='nm' id='nm' value='"+name+"'>");
pw.println("City <input type='text' name='ct' id='ct'>");
pw.println("</input>");
pw.println("<button type='submit'>Save</button>");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");
}
catch(Exception e){
System.out.println(e);
}
}



}