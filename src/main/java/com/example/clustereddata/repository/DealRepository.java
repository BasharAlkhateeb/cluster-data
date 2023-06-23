package com.example.clustereddata.repository;

import com.example.clustereddata.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {
    Deal findByDealUniqueId(String dealUniqueId);
}
