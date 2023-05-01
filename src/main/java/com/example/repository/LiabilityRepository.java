package com.example.repository;

import com.example.entity.Liability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiabilityRepository extends JpaRepository<Liability, Long> {
    Liability findByUserId(Long userId);
}
