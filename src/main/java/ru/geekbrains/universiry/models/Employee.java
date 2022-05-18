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
    private int locaPhoneNumber;

    @Column(name = "phone_number_city")
    private int phoneNumberCity;

    @Column(name = "mobile_phone_number")
    private long mobilePhoneNumber;

//    @Column(name = "fax")
//    private int fax;

    @Column(name = "email")
    private String email;

    @Column(name = "print")
    private boolean print;

    @Column(name = "priorities")
    private byte priorities;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

}
