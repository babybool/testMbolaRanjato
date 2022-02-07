package com.example.entrevueSpringBoot.repository;

import com.example.entrevueSpringBoot.entity.Acteur;
import com.example.entrevueSpringBoot.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActeurRepository extends JpaRepository<Acteur, Long> {

}
