package com.sky.service;

import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    void save(EmployeeDTO employeeDTO);

    /**
     * Pagination and query
     * @param employeePageQueryDTO
     * @return
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * activation and deactivation of employee's account
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * retrieve employee's info
     * @param id
     * @return
     */
    Employee getById(Long id);

    /**
     * edit employees
     * @param employeeDTO
     */
    void update(EmployeeDTO employeeDTO);
}
