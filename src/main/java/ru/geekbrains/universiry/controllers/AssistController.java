package ru.geekbrains.universiry.controllers;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.universiry.models.*;
import ru.geekbrains.universiry.services.AssistService;

import java.util.List;

@RestController
@Data
@RequestMapping("/assist")
public class AssistController {
    private final AssistService assistService;

    @GetMapping("/getAllDepartments")
    public List<Department> getAllDepartments(){
        return assistService.getAllDepartmens();
    }

    @GetMapping("/getAllOrganizations")
    public List<Organization> getAllOrganizations(){
        return assistService.getAllOrganizations();
    }

    @GetMapping("/getAllRoomNumbers")
    public List<RoomNumber> getAllRoomNumbers(){
        return assistService.getAllRoomNumbers();
    }

    @GetMapping("/getAllStructuralSubdivisions")
    public List<StructuralSubdivision> getAllStructuralSubdivisions(){
        return assistService.getAllStructuralSubdivisions();
    }

    @GetMapping("/getAllOfficeAddresses")
    public List<OfficeAddress> getAllOfficeAddresses(){
        return assistService.getAllOfficeAddresses();
    }
}
