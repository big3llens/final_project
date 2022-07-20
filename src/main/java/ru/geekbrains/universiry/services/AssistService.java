package ru.geekbrains.universiry.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.universiry.models.*;
import ru.geekbrains.universiry.repositories.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssistService {
    private final DepartmentRepositories departmentRepositories;
    private final OfficeAddressRepositories officeAdressRepositories;
    private final OrganizationRepositories organizationRepositories;
    private final RoomNamberRepositories roomNamberRepositories;
    private final StructuralSubdivisionRepositories structuralSubdivisionRepositories;

    public List<Department> getAllDepartmens(){
        return departmentRepositories.findAll();
    }

    public List<OfficeAddress> getAllOfficeAddresses(){
        return officeAdressRepositories.findAll();
    }

    public List<Organization> getAllOrganizations(){
        return organizationRepositories.findAll();
    }

    public List<RoomNumber> getAllRoomNumbers(){
        return roomNamberRepositories.findAll();
    }

    public List<StructuralSubdivision> getAllStructuralSubdivisions(){
        return structuralSubdivisionRepositories.findAll();
    }
}
