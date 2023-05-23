package com.example.backend_Admin.models.DTOs;

import com.example.backend_Admin.models.Horse;
import com.example.backend_Admin.models.Rider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CombinationDTO {
    @Id
    @GeneratedValue
    private int id;

    private int userID;
    @OneToOne
    private Rider rider;
    @ManyToOne
    private Horse horse;
}
