package uts.edu.java.corte3.Servicios;

import java.util.List;

import uts.edu.java.corte3.modelos.Medicamentos;

public interface IMedicamentoServicio {

	//Cabecera de los metodos
	
	//Listar proveedor
	public List<Medicamentos> listar();
	
	//Buscar proveedor
	public Medicamentos listarId(int nit);
	
	//Crear o salvar proveedor
	public void save(Medicamentos p);
	
	//Eliminar un proveedor
	public void delete(int nit);
	
	Medicamentos buscarPorId(int id);
}
