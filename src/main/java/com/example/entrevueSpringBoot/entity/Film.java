package com.example.entrevueSpringBoot.entity;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="tbl_film")
@Setter
@Getter
@ToString
public class Film {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String titre;

    private String description;

     @ElementCollection
     private List<Acteur> acteurs;

}
