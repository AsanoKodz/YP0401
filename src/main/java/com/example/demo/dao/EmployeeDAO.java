package com.example.demo.dao;

import com.example.demo.model.EmployeeModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    private static int Employee_COUNT;
    private List<EmployeeModel> employees;
    {
        employees = new ArrayList<>();

        employees.add(new EmployeeModel(++Employee_COUNT,"Шершуков", "Виктор", "Кузьмич", "Охраник"));
        employees.add(new EmployeeModel(++Employee_COUNT, "Левин", "Данила", "Глебович", "Менеджер"));
        employees.add(new EmployeeModel(++Employee_COUNT,"Козлов", "Степан", "Тимурович","Программист"));
    }

    public List<EmployeeModel> index(){

        return employees;
    }

    public EmployeeModel show(int id){
        return employees.stream().filter(employeeModel -> employeeModel.getId() == id).findAny().orElse(null);
    }

    public void save(EmployeeModel employee){
        employee.setId(++Employee_COUNT);
        employees.add(employee);
    }

    public void update(int id, EmployeeModel employeeModel){
        EmployeeModel updateEmployee = show(id);
        updateEmployee.setSurname(employeeModel.getSurname());
        updateEmployee.setPatronymic(employeeModel.getPatronymic());
        updateEmployee.setPost(employeeModel.getPost());
        updateEmployee.setName(employeeModel.getName());
    }


    public void delete(int id){
        employees.removeIf(p-> p.getId() == id);
    }

}
