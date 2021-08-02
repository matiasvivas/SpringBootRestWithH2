package com.superheroes.springboot.SpringBootRestWithH2.service;

import com.superheroes.springboot.SpringBootRestWithH2.model.Superheroe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface SuperheroeService extends JpaRepository<Superheroe, Integer>{

    @Query("SELECT s FROM Superheroe s where s.name like %?1%")
    List<Superheroe> findByName(String name);
}
