package com.mkyong.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/*
//創建 employees 表格的 SQL 語句
CREATE TABLE employees (
	    id BIGINT PRIMARY KEY AUTO_INCREMENT,
	    name VARCHAR(100) NOT NULL,
	    department VARCHAR(50), --部門名稱
	    salary DECIMAL(10, 2), --薪資
	    hire_date DATE, --入職日
	    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
	);

//添加一些索引以提高查詢效率
CREATE INDEX idx_department ON employees(department);
CREATE INDEX idx_hire_date ON employees(hire_date);
*/

//基本呼叫（使用默認分頁） GET /api/employees
//搜索條件的呼叫 GET /api/employees?name=John&department=IT&minSalary=50000&maxSalary=100000&hireeDateFrom=2022-01-01&hireeDateTo=2023-12-31
//帶有分頁資訊的呼叫 GET /api/employees?page=0&size=20&sort=name,asc
//結合搜索條件和分頁的完整呼叫 GET /api/employees?name=John&department=IT&minSalary=50000&maxSalary=100000&hireeDateFrom=2022-01-01&hireeDateTo=2023-12-31&page=0&size=20&sort=name,asc
//
//分頁和排序：
//  page: 頁碼（從 0 開始）
//  size: 每頁記錄數
//  sort: 排序欄位和方向（例如：name,asc 或 salary,desc）

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
    @Autowired
    private EmployeeService employeeService;
    
    //條件搜尋
    //範例 GET http://localhost:8080/api/employees?name=&department&minSalary=50000&maxSalary&hireeDateFrom&hireeDateTo
    //範例 GET http://localhost:8080/api/employees?name=&department&minSalary=50000&page=0&size=5&sort=name,asc
    //page: 頁碼（從 0 開始）
    //size: 每頁記錄數
    //sort: 排序欄位和方向（例如：name,asc 或 salary,desc）
    @GetMapping
    public ResponseEntity<Page<Employee>> searchEmployees(EmployeeSearchCriteria searchCriteria, 
                                                          @PageableDefault(size = 20) Pageable pageable) { //一頁20筆
    	System.out.println("條件搜尋");
    	
    	Page<Employee> employees = employeeService.searchEmployees(searchCriteria, pageable);
        
        for(Employee e:employees) {
        	System.out.println("條件搜尋後 "+e.getName());
        }
        
        return ResponseEntity.ok(employees);
    }
    
    //新增
    //使用POSTMAN測試 POST
    //BODY內使用JSON傳出內容
    //{
    //  "name": "John",
    //  "department": "IT",
    //  "salary": 80000,
    //  "hire_date": "2023-12-31"
    //}
    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
    	System.out.println("新增");
        return employeeService.save(employee);
    }
    
    //刪除
    //範例 DELETE http://localhost:8080/api/employees/1
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
    	System.out.println("刪除");
    	employeeService.deleteById(id);
    }
    
    //修改
    //範例 PUT http://localhost:8080/api/employees
    //使用POSTMAN測試 PUT
    //BODY內使用JSON傳出內容
    //{
    //  "name": "John",
    //  "department": "IT",
    //  "salary": 80000,
    //  "hire_date": "2023-12-31"
    //}
    //update a employee
    @PutMapping
    public Employee update(@RequestBody Employee employee) {
    	System.out.println("修改");
        return employeeService.save(employee);
    }
}
