package ru.geekbrains.universiry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.universiry.models.Organization;

public interface OrganizationRepositories extends JpaRepository<Organization, Integer> {
}
