package dev.mxtheuz.productapi.domain.repositories;

import dev.mxtheuz.productapi.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, String> { }
