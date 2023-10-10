package com.facebook.minifacebookback.repositories;

import com.facebook.minifacebookback.entities.Poste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosteRepository extends JpaRepository<Poste, Long> {
}
