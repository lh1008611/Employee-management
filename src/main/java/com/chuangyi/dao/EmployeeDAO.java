package com.chuangyi.dao;

import com.chuangyi.pojo.Department;
import com.chuangyi.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

//员工DAO
@Repository
public class EmployeeDAO {
    //模拟数据库中数据
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDAO departmentDAO;    //员工所属的部门

    static {
        employees = new HashMap<>();    //创建员工表
        employees.put(1001, new Employee(1001, "Lihua", "129866@qq.com", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "cyy", "129866@qq.com", 1, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "lsx", "129866@qq.com", 1, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "wz", "129866@qq.com", 1, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "lzt", "129866@qq.com", 1, new Department(105, "后勤部")));
    }

    //业务
    //主键自增
    private static Integer initId = 1006;

    //增加一个员工
    public void add(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDAO.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询全部员工
    public Collection<Employee> getAll() {
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    //删除员工
    public void removeEmployeeById(Integer id) {
        employees.remove(id);
    }

}
