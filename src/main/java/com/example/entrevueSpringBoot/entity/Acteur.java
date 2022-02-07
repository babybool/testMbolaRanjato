package com.example.entrevueSpringBoot.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="tbl_acteur")
@Setter
@Getter
@ToString
public class Acteur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String nom;

    private String prenom;

}
