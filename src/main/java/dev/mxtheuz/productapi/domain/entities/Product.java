package dev.mxtheuz.productapi.domain.entities;


import dev.mxtheuz.productapi.domain.dto.CreateBodyDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "products")
@Table(name = "products")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;

    public Product(String name, String description, double price, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Product(CreateBodyDTO dto) {
        this.name = dto.name();
        this.description = dto.description();
        this.price = dto.price();
        this.imageUrl = dto.imageUrl();
    }
}
