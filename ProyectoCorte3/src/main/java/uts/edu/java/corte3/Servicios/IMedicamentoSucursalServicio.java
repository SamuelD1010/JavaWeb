package uts.edu.java.corte3.Servicios;

import java.util.List;

import uts.edu.java.corte3.modelos.MedicamentoSucursal;

public interface IMedicamentoSucursalServicio {

	//Cabecera de los metodos
	
	//Listar proveedor
	public List<MedicamentoSucursal> listar();
	
	//Buscar proveedor
	public MedicamentoSucursal listarId(int nit);
	
	//Crear o salvar proveedor
	public void save(MedicamentoSucursal p);
	
	//Eliminar un proveedor
	public void delete(int nit);
}
