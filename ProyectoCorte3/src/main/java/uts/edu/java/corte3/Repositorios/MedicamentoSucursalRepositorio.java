package uts.edu.java.corte3.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uts.edu.java.corte3.modelos.MedicamentoSucursal;

public interface MedicamentoSucursalRepositorio extends JpaRepository<MedicamentoSucursal, Integer> {

    @Query("SELECT m FROM MedicamentoSucursal m WHERE m.sucursal_id.id = :id")
    List<MedicamentoSucursal> buscarPorSucursalId(@Param("id") int id);

}
