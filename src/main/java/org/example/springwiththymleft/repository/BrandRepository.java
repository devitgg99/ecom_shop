package org.example.springwiththymleft.repository;

import org.example.springwiththymleft.model.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
