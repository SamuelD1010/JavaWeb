package uts.edu.java.corte3.Servicios;

import java.util.List;

import uts.edu.java.corte3.modelos.Sucursal;

public interface ISucursalServicio {

	//Cabecera de los metodos
	
	//Listar proveedor
	public List<Sucursal> listar();
	
	//Buscar proveedor
	public Sucursal listarId(int nit);
	
	//Crear o salvar proveedor
	public void save(Sucursal p);
	
	//Eliminar un proveedor
	public void delete(int nit);
	
	Sucursal buscarPorId(int id);
}
