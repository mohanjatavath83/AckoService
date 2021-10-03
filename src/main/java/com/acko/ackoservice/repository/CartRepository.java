package com.acko.ackoservice.repository;

import com.acko.ackoservice.model.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartModel, String> {
}
