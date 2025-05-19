package uts.edu.java.corte3.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uts.edu.java.corte3.modelos.Medicamentos;
import uts.edu.java.corte3.Repositorios.MedicamentosRepositorio;

@Service
@Transactional
public class MedicamentosServicio implements IMedicamentoServicio{
	
	@Autowired
	private MedicamentosRepositorio repo;
	
	@Override
	public List<Medicamentos> listar() {
		return repo.findAll();
	}

	@Override
	public Medicamentos listarId(int nit) {
		return repo.findById(nit).get();
	}

	@Override
	public void save(Medicamentos p) {
		repo.save(p);
	}

	@Override
	public void delete(int nit) {
		repo.deleteById(nit);;
	}

	@Override
	public Medicamentos buscarPorId(int id) {
	    return repo.findById(id).orElse(null);
	}
	
}
