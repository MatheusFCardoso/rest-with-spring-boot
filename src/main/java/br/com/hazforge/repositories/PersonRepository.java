package br.com.hazforge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hazforge.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
