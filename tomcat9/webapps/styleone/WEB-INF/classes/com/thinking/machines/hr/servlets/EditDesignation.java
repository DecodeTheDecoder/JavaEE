package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class EditDesignation extends HttpServlet{

public void doGet(HttpServletRequest request,HttpServletResponse response){

try{	
int code=0;
		try{
code=Integer.parseInt(request.getParameter("code"));
		}catch(NumberFormatException numberFormatException){
	sendBackView(response);
	return;
	}

DesignationDAO designationDAO= new DesignationDAO();

try{
DesignationDTO designation=designationDAO.getByCode(code);
PrintWriter pw = response.getWriter();
response.setContentType("text/html");
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR application</title>");
pw.println("<script>");
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
pw.println("function cancelEditing(){");
pw.println("document.getElementById('cancelEditingForm').submit();");
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
pw.println("<h1>Designation(Edit Module)</h1>");

pw.println("<form method='post' action='/styleone/updateDesignation' onsubmit='return validateForm(this)'>");
pw.println("<input type='hidden' id='code' name='code' value='"+code+"' >");
pw.println("Designation <input type='text' name='title' id='title' maxlength='35' size='36' value='"+designation.getTitle()+"'>");
pw.println("<span id='titleErrorSection' style='color:red'></span><br>");

pw.println("<button type='submit'> Update </button>");


pw.println("<button type='button' onclick='cancelEditing()'> Cancel </button>");
pw.println("</form>");

pw.println("</div>");
pw.println("<!-- Right Panel ends here-->");
pw.println("</div><!- Contents Section  ends here-->");


pw.println("<!- Footer starts here-->");
pw.println("<div style='width:90hw;height:auto; margin:5px;text-align:center; border:1px solid white'> ");
pw.println("&copy;Thinking Machines 2020");
pw.println("</div><!- Footer  ends here-->");


pw.println("</div><!-- Main container ends here-->");
pw.println("<form id='cancelEditingForm' action='/styleone/designationsView'>");
pw.println("</form>");
pw.println("</body>");
pw.println("<html>");



}catch(DAOException daoException){
sendBackView(response);
}

}catch(Exception exception){

System.out.println(exception.getMessage()); // remove after testing
}

}

private void sendBackView(HttpServletResponse response){
try{
DesignationDAO designationDAO;
designationDAO= new DesignationDAO();
List<DesignationDTO> designations;
designations= designationDAO.getAll();
PrintWriter pw= response.getWriter();
response.setContentType("text/html");

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here-->");
pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");

pw.println("<!-- Header starts here-->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<a href='/styleone/index.html'>");
pw.println("<img src='/styleone/images/logo.png' style='float:left' ></a>");
pw.println("<div style='margin-top:9px;margin-bottom:9px;font-size:20pt'>Thinking Machines</div>");
pw.println("</div><!-- Header ends here-->");

pw.println("<!-- Contents Section starts here-->");
pw.println("<div style='width:90hw; height:70vh; margin:5px; border:1px solid white'>");

pw.println("<!-- Left Panel starts here-->");
pw.println("<div style='height:65vh;margin:5px;float:left;padding:5px;border:1px solid black ' >");
pw.println("<b>Designations<b><br >");
pw.println("<a href='/styleone/employeesView'>Employees</a><br><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");
pw.println("</div>");
pw.println("<!-- Left Panel ends here-->");


pw.println("<!-- Right Panel starts here-->");
pw.println("<div style='height:65vh;margin-left:105px;margin-right:5px;margin-bottom:px;margin-top:5px;overflow:scroll; border:1px solid black'>");
pw.println("<h2>Designations</h2>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='4' style='text-align:right;padding:5px'>");
pw.println("<a href='/styleone/AddDesignation.html'>Add new designation</a>");
pw.println("</th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:60px;text-align:center'>S.No</th>");
pw.println("<th style='width:200px;text-align:center'>Designation</th>");
pw.println("<th style='width:100px;textalign:center'>Edit</th>");
pw.println("<th style='width:100px;textalign:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");

int x;
DesignationDTO designationDTO;
int code;
String title;
int sno=0;
for (x=0;x<designations.size();x++)
{
sno++;
designationDTO= designations.get(x);
code=designationDTO.getCode();
title=designationDTO.getTitle();
pw.println("<tr>");
pw.println("<td style='text-align:right'>"+sno+"</td>");
pw.println("<td>"+title+"</td>");
pw.println("<td style='text-align:center'><a href='/styleone/editDesignation?code="+code+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/styleone/confirmDeleteDesignation?code="+code+"'>Delete</a></td>");
pw.println("</tr>");
}

pw.println("</tbody>");
pw.println("</table>");
pw.println("</div>");
pw.println("<!-- Right Panel ends here-->");
pw.println("</div><!-- Contents Section  ends here-->");


pw.println("<!-- Footer starts here-->");
pw.println("<div style='width:90hw;height:auto; margin:5px;text-align:center; border:1px solid white'>");
pw.println("&copy;Thinking Machines 2020");
pw.println("</div><!-- Footer  ends here-->");


pw.println("</div><!-- Main container ends here-->");
pw.println("</body>");
pw.println("<html>");





}catch(DAOException daoException){
System.out.println("DAO exception");
System.out.println(daoException.getMessage()); //remove after testing and set up 500 (internal error page)
}
catch(Exception exception){
System.out.println(exception.getMessage()); //remove after testing and setup 500 (internal error page)
}


}

public void doPost(HttpServletRequest request, HttpServletResponse response){

doGet(request,response);
}



}