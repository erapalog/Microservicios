package com.microservicioDatos.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.microservicioDatos.model.Contacto;

@Repository
public interface AgendaRepository extends JpaRepository<Contacto,Long>{
	
	Contacto findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query(value = "Delete from Contacto where email=?1", nativeQuery = true)
	void eliminarPorEmail(String email);

}
