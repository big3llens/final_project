package ru.geekbrains.universiry.controllers;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.universiry.dto.EmployeeDto;
import ru.geekbrains.universiry.models.Employee;
import ru.geekbrains.universiry.models.EmployeeName;
import ru.geekbrains.universiry.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
@Data
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/main")
    private String showMainPage (){
        return "Главная.html";
    }

    @GetMapping("/findAllByOrganization")
    @ResponseBody
    private List<EmployeeDto> findAllByOrganization (@RequestParam(name="orgId") Integer orgId){
        return employeeService.findAllByOrganization(orgId);
    }

    @GetMapping("/searchEmployeeByName")
    @ResponseBody
    private EmployeeDto findEmployeeByLastName(@RequestParam(name = "name") String name){
        return employeeService.findEmployeeByLastName(name);
    }

    @GetMapping("/hideEmployee")
//    @ResponseBody
    private void hideEmployee(@RequestParam(name = "id") Integer id){
        System.out.println(id);
        employeeService.hideEmployee(id);
    }

//    @GetMapping("/hideEmployee/{id}")
//    private void hideEmployee(@PathVariable Integer id){
//        System.out.println(id);
////        Integer idd = Integer.parseInt(id);
////        System.out.println(idd);
//        employeeService.hideEmployee(false, id);
//    }

    @PostMapping("/saveOrUpdateEmployee")
    @ResponseBody
    private void saveOrUpdateEmployee(@RequestBody Employee employee){
        employeeService.saveOrUpdateEmployee(employee);
    }
}
