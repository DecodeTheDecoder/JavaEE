package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class AddDesignation extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response){
PrintWriter pw=null;
String title="";
try{
pw= response.getWriter(); 
title= request.getParameter("title");
DesignationDTO designation= new DesignationDTO();
designation.setTitle(title);
DesignationDAO designationDAO;
designationDAO= new DesignationDAO();
designationDAO.add(designation);
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here-->");
pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");

pw.println("<!- Header starts here-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<a href='/styleone/index.html'><img src='/styleone/images/logo.png' style='float:left' ></a>");
pw.println("<div style='margin-top:9px;margin-bottom:9px;font-size:20pt'>Thinking Machines</div>");
pw.println("</div><!-- Header ends here-->");

pw.println(" <!-- Contents Section starts here-->");
pw.println("<div style='width:90hw; height:70vh; margin:5px; border:1px solid white'>");
pw.println("<!-- Left Panel starts here-->");
pw.println("<div style='height:65vh;margin:5px;float:left;padding:5px;border:1px solid black ' >");
pw.println("<a href='/styleone/designationsView'>Designations</a><br >");
pw.println("<a href='/styleone/emplyeesView'>Employees</a>");
pw.println("</div>");

pw.println("<!-- Left Panel ends here-->");
pw.println("<!-- Right Panel starts here-->");
pw.println("<div style='height=65vh;margin-left:105px;margin-right:5px;margin-top:5px;margin-bottom:px; border:1px solid black'>");
pw.println("<h3>Notification</h3>");
pw.println("Designation Added<br><br>");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>");
pw.println("<form action='/styleone/AddDesignation.html'>");
pw.println("Add more Designations?");
pw.println("<button type='submit'>Yes</button>");
pw.println("</form>");
pw.println("</td>");
pw.println("<td>");
pw.println("<form action='/styleone/designationsView'>");
pw.println("<button type='submit'>No</button>");
pw.println("</form>");
pw.println("</td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</div>");
pw.println("<!-- Right Panel ends here-->");
pw.println("</div><!- Contents Section  ends here-->");


pw.println("<!- Footer starts here-->");
pw.println("<div style='width:90hw;height:auto; margin:5px;text-align:center; border:1px solid white'>");
pw.println("&copy;Thinking Machines 2020");
pw.println("</div><!- Footer  ends here-->");


pw.println("</div><!-- Main container ends here-->");
pw.println("</body>");
pw.println("<html>");
}
catch(DAOException daoException)
{
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR application</title>");
pw.println("<script>");
pw.println("function cancelAddition(){");
pw.println("document.getElementById('cancelAdditionForm').submit();");
pw.println("}");
pw.println("function validateForm(frm){");

pw.println("var title= frm.title.value.trim();");
pw.println("var titleErrorSection=document.getElementById('titleErrorSection');");
pw.println("titleErrorSection.innerHTML='';");
pw.println("if(title.length==0){");
pw.println("titleErrorSection.innerHTML='Required';");
pw.println("frm.title.focus();");
pw.println("return false;");
pw.println("}");

pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here-->");
pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");

pw.println("<!- Header starts here-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<a href='/styleone/index.html'><img src='/styleone/images/logo.png' style='float:left' ></a>");
pw.println("<div style='margin-top:9px;margin-bottom:9px;font-size:20pt'>Thinking Machines</div>");
pw.println("</div><!-- Header ends here-->");

pw.println(" <!-- Contents Section starts here-->");
pw.println("<div style='width:90hw; height:70vh; margin:5px; border:1px solid white'>");
pw.println("<!-- Left Panel starts here-->");
pw.println("<div style='height:65vh;margin:5px;float:left;padding:5px;border:1px solid black ' >");
pw.println("<b>Designations</b><br >");
pw.println("<a href='/styleone/emplyeesView'>Employees</a>");
pw.println("</div>");

pw.println("<!-- Left Panel ends here-->");
pw.println("<!-- Right Panel starts here-->");
pw.println("<div style='height=65vh;margin-left:105px;margin-right:5px;margin-top:5px;margin-bottom:px; border:1px solid black'>");
pw.println("<h1>Designation(Add Module)</h1>");
pw.println("<div style='color:red'>"+daoException.getMessage()+"</div>");
pw.println("<form action='/styleone/addDesignation' onsubmit='return validateForm(this)'>");
pw.println("Designation <input type='text' name='title' id='title' maxlength='35' size='36' value='"+title+"'>");
pw.println("<span id='titleErrorSection' style='color:red'></span><br>");
pw.println("<button type='submit'> Add </button>");
pw.println("<button type='button' onclick=cancelAddition()>Cancel</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("<!-- Right Panel ends here-->");
pw.println("</div><!- Contents Section  ends here-->");


pw.println("<!- Footer starts here-->");
pw.println("<div style='width:90hw;height:auto; margin:5px;text-align:center; border:1px solid white'>");
pw.println("&copy;Thinking Machines 2020");
pw.println("</div><!- Footer  ends here-->");


pw.println("</div><!-- Main container ends here-->");
pw.println("<form id='cancelAdditionForm' action='/styleone/designationsView'>");
pw.println("</form>");
pw.println("</body>");
pw.println("<html>");

}
catch(Exception exception)
  {
  } 
 }


}