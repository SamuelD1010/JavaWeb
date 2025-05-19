package uts.edu.java.corte3.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uts.edu.java.corte3.modelos.Sucursal;
import uts.edu.java.corte3.Repositorios.SucursalRepositorio;

@Service
@Transactional
public class SucursalServicio implements ISucursalServicio{
	
	//Atributo
	@Autowired
	private SucursalRepositorio repo;
	
	@Override
	public List<Sucursal> listar() {
		return repo.findAll();
	}

	@Override
	public Sucursal listarId(int nit) {
		return repo.findById(nit).get();
	}

	public void save(Sucursal sucursal) {
	    repo.save(sucursal);
	}

	@Override
	public void delete(int nit) {
		repo.deleteById(nit);;
	}

	@Override
	public Sucursal buscarPorId(int id) {
	    return repo.findById(id).orElse(null);
	}
}
