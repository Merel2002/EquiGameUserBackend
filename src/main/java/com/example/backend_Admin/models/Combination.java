package com.example.backend_Admin.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Combination {
    @Id
    @GeneratedValue
    private int id;

    private int userID;
    @OneToOne
    private Rider rider;
    @ManyToOne
    private Horse horse;
}
