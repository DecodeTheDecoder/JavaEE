package com.thinking.machines.hr.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.thinking.machines.hr.dl.*;
import java.util.*;
import java.text.*;
public class EmployeesView extends HttpServlet {
 public void doGet(HttpServletRequest request,HttpServletResponse response){
try{
List<EmployeeDTO> employees= new EmployeeDAO().getAll();
response.setContentType("text/html");
PrintWriter pw= response.getWriter();
pw.println("");
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<script>");
pw.println("function Employee(){");
pw.println("this.employeeId='';");
pw.println("this.name='';");
pw.println("this.designationCode=0;");
pw.println("this.designation='';");
pw.println("this.dateOfBirth='';");
pw.println("this.gender='';");
pw.println("this.isIndian=true;");
pw.println("this.basicSalary=0;");
pw.println("this.panNumber='';");
pw.println("this.aadharCardNumber='';");
pw.println("}");
pw.println("");
pw.println("var selectedRow=null;");
pw.println("var employees=[];");
int i =0;
SimpleDateFormat simpleDateFormat;
simpleDateFormat= new SimpleDateFormat("dd/MM/yyyy");
for(EmployeeDTO employee:employees){
pw.println("var employee= new Employee();");
pw.println("employee.employeeId='"+employee.getEmployeeId()+"';");
pw.println("employee.name='"+employee.getName()+"';");
pw.println("employee.designationCode="+employee.getDesignationCode()+";");
pw.println("employee.designation='"+employee.getDesignation()+"'");
pw.println("employee.dateOfBirth='"+simpleDateFormat.format(employee.getDateOfBirth())+"';");
pw.println("employee.gender='"+employee.getGender()+"';");
pw.println("employee.basicSalary="+employee.getBasicSalary().toPlainString()+";");
pw.println("employee.isIndian='"+employee.getIsIndian()+"';");
pw.println("employee.panNumber='"+employee.getPanNumber()+"';");
pw.println("employee.aadharCardNumber='"+employee.getAadharCardNumber()+"';");
pw.println("employees["+i+"]=employee;");
i++;
}


pw.println("function selectEmployee(row,employeeId){");
pw.println("if(selectedRow==row)return;");
pw.println("if(selectedRow!=null){");
pw.println("selectedRow.style.background='white';");
pw.println("selectedRow.style.color='black';");
pw.println("}");
pw.println("row.style.background='#7C7B7B';");
pw.println("row.style.color='white';");
pw.println("selectedRow=row;");
pw.println(" var i;");
pw.println("for (i=0;i<employees.length;i++){");
pw.println("if(employees[i].employeeId==employeeId)");
pw.println("{");
pw.println("break;");
pw.println("}");
pw.println("}");
pw.println("var emp=employees[i];");
pw.println("document.getElementById('detailPanel_employeeId').innerHTML=emp.employeeId;");
pw.println("document.getElementById('detailPanel_name').innerHTML=emp.name;");
pw.println("document.getElementById('detailPanel_designation').innerHTML=emp.designation;");
pw.println("document.getElementById('detailPanel_dateOfBirth').innerHTML=emp.dateOfBirth;");
pw.println("document.getElementById('detailPanel_gender').innerHTML=emp.gender;");
pw.println("document.getElementById('detailPanel_isIndian').innerHTML=emp.isIndian;");
pw.println("document.getElementById('detailPanel_basicSalary').innerHTML=emp.basicSalary;");
pw.println("document.getElementById('detailPanel_panNumber').innerHTML=emp.panNumber;");
pw.println("document.getElementById('detailPanel_aadharCardNumber').innerHTML=emp.aadharCardNumber;");
pw.println("");
pw.println("}");
pw.println("</script>");
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
pw.println("<a href='/styleone/designationsView'>Designations</a><br >");
pw.println("<b>Employees</b><br><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");
pw.println("</div>");
pw.println("<!-- Left Panel ends here-->");
pw.println("<!-- Right Panel starts here-->");
pw.println("<div style='height:65vh;margin-left:105px;margin-right:5px;margin-bottom:px;margin-top:5px; border:1px solid black'>");
pw.println("<h2>Employees</h2>");
pw.println("<div style='height:30vh;margin-left:5px;margin-right:5px;margin-bottom:px;margin-top:5px; border:1px solid black';overflow:scroll>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='6' style='text-align:right;padding:5px'>");
pw.println("<a href='/styleone/getEmployeeAddForm'>Add Employee</a>");
pw.println("</th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:60px;text-align:center'>S.No</th>");
pw.println("<th style='width:60px;text-align:center'>Id.</th>");
pw.println("<th style='width:60px;text-align:center'>Name</th>");
pw.println("<th style='width:200px;text-align:center'>Designation</th>");
pw.println("<th style='width:100px;textalign:center'>Edit</th>");
pw.println("<th style='width:100px;textalign:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");
for(EmployeeDTO employee:employees)
{ 
pw.println("<tr style='cursor:pointer' onClick='selectEmployee(this,\""+employee.getEmployeeId()+"\")'>");
pw.println("<td style='text-align:right'>1</td>");
pw.println("<td>"+employee.getEmployeeId()+"</td>");
pw.println("<td>"+employee.getName()+"</td>");
pw.println("<td>"+employee.getDesignation()+"</td>");
pw.println("<td style='text-align:center'><a href='/styleone/editEmployee?code="+employee.getEmployeeId()+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/styleone/confirmDeleteEmployee?code="+employee.getEmployeeId()+"'>Delete</a></td>");
pw.println("</tr>");
}
pw.println("</tbody>");
pw.println("</table>");
pw.println("</div>");
pw.println("<div style='height:19vh;margin-left:5px;margin-right:5px;margin-bottom:px;margin-top:5px; border:1px solid black'>");
pw.println("<label style='background:gray;color:white;padding-left:5px;padding-right:5px'>Details</label>");
pw.println("<table border='1' width='100%'>");
pw.println("<tr>");
pw.println("<td>Employee Id: <span id='detailPanel_employeeId'></span></td>");
pw.println("<td>Name: <span id='detailPanel_name'></span></td>");
pw.println("<td>Designation: <span id='detailPanel_designation'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Date Of Birth: <span id='detailPanel_dateOfBirth'></span></td>");
pw.println("<td>Gender: <span id='detailPanel_gender'></span></td>");
pw.println("<td>Is Indian: <span id='detailPanel_isIndian'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Basic salary: <span id='detailPanel_basicSalary'></span></td>");
pw.println("<td>Pan Number: <span id='detailPanel_panNumber'></span></td>");
pw.println("<td>Aadhar Card Number: <span id='detailPanel_aadharCardNumber'></span></td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</div>");
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
}catch(Exception exception){
exception.printStackTrace(System.out);
}

}
public void doPost(HttpServletRequest request,HttpServletResponse response){
doGet(request,response);

}
}