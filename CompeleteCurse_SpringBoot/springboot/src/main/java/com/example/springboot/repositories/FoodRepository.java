package com.example.springboot.repositories;

import com.example.springboot.models.FoodModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoodRepository extends JpaRepository<FoodModel, UUID>{
}
