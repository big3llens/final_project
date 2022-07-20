package ru.geekbrains.universiry.controllers;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.universiry.dto.EmployeeDto;
import ru.geekbrains.universiry.dto.EditEmployeeDto;
import ru.geekbrains.universiry.models.Employee;
import ru.geekbrains.universiry.services.EmployeeService;

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

    @GetMapping("/findAllEmployees")
    @ResponseBody
    private List<EmployeeDto> findAllEmployee (){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/findAllByOrganization")
    @ResponseBody
    private List<EmployeeDto> findAllByOrganization (@RequestParam(name="orgId") Integer orgId){
        return employeeService.findAllByOrganization(orgId);
    }

    @GetMapping("/findEmployeeByName")
    @ResponseBody
    private EditEmployeeDto findEmployeeByName(@RequestParam(name = "name") String name){
        return employeeService.findEditEmployeeByLastName(name);
    }

    @GetMapping("/findEditEmployeeByName")
    @ResponseBody
    private EmployeeDto findEditEmployeeByName(@RequestParam(name = "name") String name){
        return employeeService.findEmployeeByLastName(name);
    }

    @GetMapping("/findEmployeeById")
    @ResponseBody
    private EmployeeDto findEmployeeById(@RequestParam(name = "id") Long id){
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/hideEmployee")
    @ResponseBody
    private void hideEmployee(@RequestParam(name = "id") Long id){
        System.out.println(id);
        employeeService.hideEmployee(id);
    }

    @PostMapping("/editEmployee")
    @ResponseBody
    private void editEmployee(@RequestBody EditEmployeeDto employeeDto){
        employeeService.updateEmployee(employeeDto);
        System.out.println(employeeDto.toString());
        System.out.println(employeeDto.getId());
    }

    @PostMapping("/saveEmployee")
    @ResponseBody
    private void saveEmployee(@RequestBody EditEmployeeDto employeeDto){
        employeeService.saveEmployee(employeeDto);
        System.out.println(employeeDto.toString());
    }

//    @GetMapping("/login")
//    @ResponseBody
//    private String login(@RequestParam(name = "login") String login){
//        System.out.println(login);
//        return employeeService.findByLogin(login).get().getLogin();
//    }

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
