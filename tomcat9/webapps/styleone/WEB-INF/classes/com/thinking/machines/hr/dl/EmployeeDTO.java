package com.thinking.machines.hr.dl;
import java.math.BigDecimal;
import java.util.Date;

public class EmployeeDTO  implements java.io.Serializable,Comparable<EmployeeDTO>{
	

	public EmployeeDTO() {
		this.employeeId = "";
		this.name = "";
		this.designationCode = 0;
		this.title = "";
		this.dateOfBirth = null;
		this.gender = "";
		this.isIndian = false;
		this.basicSalary = null;
		this.panNumber = "";
		this.aadharCardNumber = "";
	}
	private String employeeId;
	private  String name;
	private int designationCode;
private String designation;
	private String title;
	private java.util.Date dateOfBirth;
	private String gender;
	private boolean isIndian;
	private BigDecimal basicSalary;


	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDesignationCode() {
		return designationCode;
	}
	public void setDesignationCode(int designationCode) {
		this.designationCode = designationCode;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean getIsIndian() {
		return isIndian;
	}
	public void setIsIndian(boolean isIndian) {
		this.isIndian = isIndian;
	}
	public BigDecimal getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(BigDecimal basicSalary) {
		this.basicSalary = basicSalary;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAadharCardNumber() {
		return aadharCardNumber;
	}
	public void setAadharCardNumber(String aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}
	private String panNumber;
	private String aadharCardNumber;
public int hashCode(){
return employeeId.hashCode();
}

public boolean equals(Object object){
if(!(object instanceof EmployeeDTO)) return false;
EmployeeDTO employee=(EmployeeDTO)object;
return this.employeeId.equalsIgnoreCase(employee.employeeId);
}
public int compareTo(EmployeeDTO employee){
return this.employeeId.compareTo(employee.employeeId);
}
}