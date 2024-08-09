package com.mkyong.employee;

import java.time.LocalDate;

//搜尋條件
public class EmployeeSearchCriteria {
    private String name; //員工姓名（模糊搜索）
    private String department; //部門名稱
    private Double minSalary; //最低薪資
    private Double maxSalary; //最高薪資
    private LocalDate hireeDateFrom; //入職日期起始（格式：YYYY-MM-DD）
    private LocalDate hireeDateTo; //入職日期結束（格式：YYYY-MM-DD）
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}
	public Double getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}
	public LocalDate getHireeDateFrom() {
		return hireeDateFrom;
	}
	public void setHireeDateFrom(LocalDate hireeDateFrom) {
		this.hireeDateFrom = hireeDateFrom;
	}
	public LocalDate getHireeDateTo() {
		return hireeDateTo;
	}
	public void setHireeDateTo(LocalDate hireeDateTo) {
		this.hireeDateTo = hireeDateTo;
	}
}
