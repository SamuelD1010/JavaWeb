package uts.edu.java.corte3.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = MedicamentoSucursal.TABLE_NAME)
public class MedicamentoSucursal {

	private static final String TABLE_NAME = "medicamentos_sucursal";
	
	@Id
	private int id;

	@ManyToOne
	@JoinColumn(name = "medicamento_id")
	private Medicamentos medicamento_id;
	
	@ManyToOne
	@JoinColumn(name = "sucursal_id")
	private Sucursal sucursal_id;
	
	private int cantidad; 
	
	public MedicamentoSucursal() {
		super();
	}

	public MedicamentoSucursal(int id, Medicamentos medicamento_id, Sucursal sucursal_id, int cantidad) {
		super();
		this.id = id;
		this.medicamento_id = medicamento_id;
		this.sucursal_id = sucursal_id;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Medicamentos getMedicamento_id() {
		return medicamento_id;
	}

	public void setMedicamento_id(Medicamentos medicamento_id) {
		this.medicamento_id = medicamento_id;
	}

	public Sucursal getSucursal_id() {
		return sucursal_id;
	}

	public void setSucursal_id(Sucursal sucursal_id) {
		this.sucursal_id = sucursal_id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "MedicamentoSucursal [id=" + id + ", medicamento_id=" + medicamento_id + ", sucursal_id=" + sucursal_id
				+ ", cantidad=" + cantidad + "]";
	}

	
	
	
}
