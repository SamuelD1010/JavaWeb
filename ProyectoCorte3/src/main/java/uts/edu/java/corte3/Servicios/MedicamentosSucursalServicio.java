package uts.edu.java.corte3.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uts.edu.java.corte3.modelos.MedicamentoSucursal;
import uts.edu.java.corte3.Repositorios.MedicamentoSucursalRepositorio;

@Service
@Transactional
public class MedicamentosSucursalServicio implements IMedicamentoSucursalServicio{
	
	//Atributo
	@Autowired
	private MedicamentoSucursalRepositorio repo;
	
	@Override
	public List<MedicamentoSucursal> listar() {
		return repo.findAll();
	}

	@Override
	public MedicamentoSucursal listarId(int nit) {
		return repo.findById(nit).get();
	}

	@Override
	public void save(MedicamentoSucursal p) {
		repo.save(p);
	}

	public void delete(int id) {
	    repo.deleteById(id);
	}

	public List<MedicamentoSucursal> listarPorSucursal(int idSucursal) {
	    return repo.buscarPorSucursalId(idSucursal);
	}
}
