package com.eventofix.eventoback.repository;

import com.eventofix.eventoback.entitys.Locacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacionRepository extends JpaRepository<Locacion, Long> {
}
