package com.DemoCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DemoCrud.domain.Arbre;


@Repository
public interface ArbreRepository extends JpaRepository<Arbre, Long>{

}
