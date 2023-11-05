package com.microservicioDatos.Service;

import java.util.List;

import com.microservicioDatos.model.Contacto;

public interface AgendaService {
   
	void agregarContacto(Contacto contacto);
	Contacto recupearContacto(String email);
	void eliminarContacto(String email);
	List<Contacto> devolverContactos();
	void eliminarContacto(int id);
	void actualizarContacto(Contacto contacto);
}
