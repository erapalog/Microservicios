package com.microservicioDatos.ServicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservicioDatos.Repository.AgendaRepository;
import com.microservicioDatos.Service.AgendaService;
import com.microservicioDatos.model.Contacto;

@Service
public class AgendaServiceImp implements AgendaService{

	@Autowired
	AgendaRepository agendaRepository;
	
	@Override
	public void agregarContacto(Contacto contacto) {
		agendaRepository.save(contacto);
		
	}

	@Override
	public Contacto recupearContacto(String email) {
		
		return agendaRepository.findByEmail(email);
	}

	@Override
	public void eliminarContacto(String email) {
		agendaRepository.eliminarPorEmail(email);
		
	}

	@Override
	public List<Contacto> devolverContactos() {
		return agendaRepository.findAll();
	}

	@Override
	public void eliminarContacto(int id) {
		agendaRepository.deleteById(new Long(id));
		
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		agendaRepository.save(contacto);
	}

}
