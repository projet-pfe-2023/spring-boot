package com.example.manifest.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;



@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Merch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marque;
    private Integer mass;
    private Integer volume;
    private String designation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


}
