package ru.geekbrains.universiry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.universiry.models.StructuralSubdivision;

public interface StructuralSubdivisionRepositories extends JpaRepository<StructuralSubdivision, Integer> {
}
