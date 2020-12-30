package com.thinking.machines.hr.dl;
import java.sql.*;
import java.util.*;
import java.math.*;
public class EmployeeDAO{

public void delete(DesignationDTO designation) throws DAOException{
try{
int code= designation.getCode();
Connection connection = DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from designation where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet;
resultSet= preparedStatement.executeQuery();
if(resultSet.next()==false){
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid code :"+code);
}
preparedStatement=connection.prepareStatement("delete from designation where code=?");
preparedStatement.setInt(1,code);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();

}catch(Exception exception){
throw new DAOException(exception.getMessage());
}

}


public void update(DesignationDTO designation) throws DAOException{
try{
int code= designation.getCode();
String title= designation.getTitle();
Connection connection= DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement= connection.prepareStatement("select * from designation where code =?");
preparedStatement.setInt(1,code);
ResultSet resultSet;
resultSet= preparedStatement.executeQuery();
if(resultSet.next()==false){
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Designation code :"+code);
}
preparedStatement=connection.prepareStatement("select * from designation where title=? and code!=?");
preparedStatement.setString(1,title);
preparedStatement.setInt(2,code);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==true){
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException(title+" exists.");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("update designation set title=? where code=?");
preparedStatement.setString(1,title);
preparedStatement.setInt(2,code);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();

}
catch(Exception exception)
{
throw new DAOException(exception.getMessage());
}

}

public DesignationDTO getByCode(int code) throws DAOException{
try{
Connection connection= DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement = connection.prepareStatement("Select * from designation where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet;
resultSet= preparedStatement.executeQuery();
if(resultSet.next()==false){
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid designation code : "+code);
	}
DesignationDTO designationDTO= new DesignationDTO();
designationDTO.setCode(resultSet.getInt("code"));
designationDTO.setTitle(resultSet.getString("title"));
resultSet.close();
preparedStatement.close();
connection.close();
return designationDTO;
	}
	catch(Exception exception){
	throw new DAOException(exception.getMessage());
	}	

}

public void add(DesignationDTO designation) throws DAOException{
try{
Connection connection= DAOConnection.getConnection();
PreparedStatement preparedStatement=  connection.prepareStatement("select * from designation where title=?");
preparedStatement.setString(1,designation.getTitle());
ResultSet resultset= preparedStatement.executeQuery();
if(resultset.next()){
resultset.close();
preparedStatement.close();
connection.close();
throw new DAOException("Designation  "+designation.getTitle()+" exists.");
}
resultset.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into designation(title) values(?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1, designation.getTitle());
preparedStatement.executeUpdate();
resultset= preparedStatement.getGeneratedKeys();
resultset.next();
int code= resultset.getInt(1);
resultset.close();
preparedStatement.close();
connection.close();
designation.setCode(code);
}catch(SQLException sqlException){
throw new DAOException(sqlException.getMessage()); //remove after testing.
}


}

public List<EmployeeDTO> getAll() throws DAOException{

List<EmployeeDTO> employees;
employees=new LinkedList<>();
try{
Connection connection= DAOConnection.getConnection();
Statement statement;
statement=connection.createStatement();
ResultSet resultSet;
resultSet=statement.executeQuery("select employee.id,employee.name,employee.designation_code,designation.title,employee.date_of_birth,employee.gender,employee.is_indian,employee.basic_salary,employee.pan_number,employee.aadhar_card_number from employee inner join designation on employee.designation_code=designation.code order by employee.name");
EmployeeDTO employeeDTO;
int id;
String name;
int designationCode;
String title;
java.sql.Date dateOfBirth;
String gender;
boolean isIndian;
BigDecimal basicSalary;
String panNumber;
String aadharCardNumber;
while(resultSet.next()){
id=resultSet.getInt("id");
name=resultSet.getString("name");
designationCode=resultSet.getInt("designation_code");
title=resultSet.getString("title").trim();
dateOfBirth=resultSet.getDate("date_of_birth");
gender=resultSet.getString("gender");
isIndian=resultSet.getBoolean("is_indian");
basicSalary=resultSet.getBigDecimal("basic_salary");
panNumber=resultSet.getString("pan_number").trim();
aadharCardNumber=resultSet.getString("aadhar_card_number").trim();
employeeDTO= new EmployeeDTO();
employeeDTO.setEmployeeId("A"+id);
employeeDTO.setName(name);
employeeDTO.setDesignationCode(designationCode);
employeeDTO.setDesignation(title);
employeeDTO.setDateOfBirth(dateOfBirth);
employeeDTO.setGender(gender);
employeeDTO.setIsIndian(isIndian);
employeeDTO.setBasicSalary(basicSalary);
employeeDTO.setPanNumber(panNumber);
employeeDTO.setAadharCardNumber(aadharCardNumber);
employees.add(employeeDTO);

}
resultSet.close();
statement.close();
connection.close();


}catch(Exception exception)
{
throw new DAOException("DAO Exception"+exception.getMessage());
}
return employees;
}
public void add(EmployeeDTO employee) throws DAOException{
try{
Connection connection = DAOConnection.getConnection();
String panNumber= employee.getPanNumber();
String aadharCardNumber= employee.getAadharCardNumber();
java.util.Date dateOfBirth = employee.getDateOfBirth();
PreparedStatement preparedStatement= connection.prepareStatement("select id from employee where pan_number=?");
preparedStatement.setString(1,panNumber);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()){
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Pan Number"+panNumber+"already exists.");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select id from employee where aadhar_card_number=?");
preparedStatement.setString(1,aadharCardNumber);
resultSet=preparedStatement.executeQuery();
if(resultSet.next()){
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Aadhar Card Number "+aadharCardNumber+"already exists.");
}
resultSet.close();
preparedStatement.close();

preparedStatement= connection.prepareStatement("insert into employee (name,designation_code,date_of_birth,gender,is_indian,basic_salary,pan_number,aadhar_card_number) values (?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1,employee.getName());
preparedStatement.setInt(2,employee.getDesignationCode());
java.sql.Date sqlDateOfBirth = new java.sql.Date(dateOfBirth.getYear(),dateOfBirth.getMonth(),dateOfBirth.getDate());
preparedStatement.setDate(3,sqlDateOfBirth);
preparedStatement.setString(4,employee.getGender());
preparedStatement.setBoolean(5,employee.getIsIndian());
preparedStatement.setBigDecimal(6,employee.getBasicSalary());
preparedStatement.setString(7,employee.getPanNumber());
preparedStatement.setString(8,employee.getAadharCardNumber());
preparedStatement.executeUpdate();
resultSet= preparedStatement.getGeneratedKeys();
resultSet.next();
int id = resultSet.getInt(1);
employee.setEmployeeId("A"+id);
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException){
throw new DAOException(sqlException.getMessage());
}
}

}