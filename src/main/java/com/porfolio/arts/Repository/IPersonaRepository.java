package com.porfolio.arts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porfolio.arts.Entity.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

}
