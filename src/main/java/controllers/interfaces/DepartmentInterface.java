package controllers.interfaces;

import models.Department;

public interface DepartmentInterface {
    void findHead(String department_name);

    void showStatistic(String department_name);

    void avgSalary(String department_name);

    void countEmployee(String department_name);
}
