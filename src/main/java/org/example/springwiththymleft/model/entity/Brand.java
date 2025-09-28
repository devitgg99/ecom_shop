package org.example.springwiththymleft.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "brand_tb")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;
    private String name;
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Product> product;
}
