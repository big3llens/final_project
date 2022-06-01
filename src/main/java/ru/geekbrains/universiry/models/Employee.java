package ru.geekbrains.universiry.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(schema = "project_schema", name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "position")
    private String position;

    @Column(name = "local_phone_number")
    private Integer localPhoneNumber;

    @Column(name = "phone_number_city")
    private Integer phoneNumberCity;

    @Column(name = "mobile_phone_number")
    private Long mobilePhoneNumber;

    @Column(name = "fax")
    private Integer fax;

    @Column(name = "email")
    private String email;

    @Column(name = "print")
    private boolean print;

    @Column(name = "priorities")
    private Byte priorities;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "structural_subdivision_id")
    private StructuralSubdivision structuralSubdivision;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "office_adress_id")
    private OfficeAdress officeAdress;

    @ManyToOne
    @JoinColumn(name = "room_number_id")
    private RoomNumber roomNumber;
}
