package com.cegefos.tp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cegefos.tp1.entity.Matiere;

import java.util.Collection;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Integer> , QuerydslPredicateExecutor<Matiere> {

    Collection<Matiere> findByCoefficientGreaterThan(int coefficient);

    /********************************  -------------------------Query methods------------------***************/

    @Query(value = "SELECT * FROM matiere m WHERE m.coefficient > :coefficient", nativeQuery = true)
    Collection<Matiere> findByCoefficient(@Param("coefficient") int coefficient);



}
