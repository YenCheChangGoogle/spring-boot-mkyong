package com.mkyong.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.Predicate;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	//搜尋條件 改寫
	public Page<Employee> searchEmployees(EmployeeSearchCriteria searchCriteria, Pageable pageable) {
		Specification<Employee> spec = (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (searchCriteria.getName() != null && !searchCriteria.getName().isEmpty()) {
				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + searchCriteria.getName().toLowerCase() + "%"));
			}

			if (searchCriteria.getDepartment() != null && !searchCriteria.getDepartment().isEmpty()) {
				predicates.add(criteriaBuilder.equal(root.get("department"), searchCriteria.getDepartment()));
			}

			if (searchCriteria.getMinSalary() != null) {
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), searchCriteria.getMinSalary()));
			}

			if (searchCriteria.getMaxSalary() != null) {
				predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("salary"), searchCriteria.getMaxSalary()));
			}

			if (searchCriteria.getHireeDateFrom() != null) {
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("hireDate"), searchCriteria.getHireeDateFrom()));
			}

			if (searchCriteria.getHireeDateTo() != null) {
				predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("hireDate"), searchCriteria.getHireeDateTo()));
			}

			//添加排序
			query.orderBy(criteriaBuilder.asc(root.get("name")));

			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};

		return employeeRepository.findAll(spec, pageable);
	}

	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}

	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}
}
