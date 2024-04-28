package com.shahid.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shahid.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>  {

}
