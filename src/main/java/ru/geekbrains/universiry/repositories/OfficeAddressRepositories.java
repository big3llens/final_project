package ru.geekbrains.universiry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.universiry.models.OfficeAddress;

public interface OfficeAddressRepositories extends JpaRepository<OfficeAddress, Integer> {
}
