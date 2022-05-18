package ru.geekbrains.universiry.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(schema = "project_schema", name = "organization")
@Data
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "organization_name")
    private String organizationName;
}
