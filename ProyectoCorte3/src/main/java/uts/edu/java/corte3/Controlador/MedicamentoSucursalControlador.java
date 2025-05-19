package uts.edu.java.corte3.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import uts.edu.java.corte3.modelos.MedicamentoSucursal;
import uts.edu.java.corte3.modelos.Medicamentos;
import uts.edu.java.corte3.modelos.Sucursal;
import uts.edu.java.corte3.Servicios.MedicamentosSucursalServicio;
import uts.edu.java.corte3.Servicios.MedicamentosServicio;
import uts.edu.java.corte3.Servicios.SucursalServicio;

@Controller
@RequestMapping("/medicamentosucursal")
public class MedicamentoSucursalControlador {

	@Autowired
	private MedicamentosSucursalServicio medicamentosucursalServicio;
	@Autowired
	private MedicamentosServicio medicamentosServicio;
	@Autowired
	private SucursalServicio sucursalServicio;

	
	@RequestMapping("/")
	public String verIndex(Model model) {
		List<MedicamentoSucursal> listaMedicamentoSucursal = medicamentosucursalServicio.listar();
		model.addAttribute("listaMedicamentoSucursal",listaMedicamentoSucursal);
		return "views/medicamentosucursal/medsuc";
	}
	
	//Direccionar a la pagina de crear un proveedor
	@GetMapping("/new")
	public String mostrarPaginaNuevoMedicamentoSucursal(Model model) {
		MedicamentoSucursal medicamentosucursal = new MedicamentoSucursal();
		List<Medicamentos> listaMedicamentos = medicamentosServicio.listar();
		model.addAttribute("listaMedicamentos",listaMedicamentos);
		List<Sucursal> listaSucursal = sucursalServicio.listar();
		model.addAttribute("listaSucursal",listaSucursal);
		model.addAttribute("medicamentosucursal", medicamentosucursal);
		return "/views/medsucursales/nuevo_ms";
	}
	
	@GetMapping("/{id}")
	public String verMedicamentosPorSucursal(@PathVariable("id") int id, Model model) {
	    List<MedicamentoSucursal> lista = medicamentosucursalServicio.listarPorSucursal(id);
	    model.addAttribute("listaMedSucursal", lista);
	    return "views/medicamentosucursal/medsuc";
	}
	

	@GetMapping("/nuevo/{idSucursal}")
	public String nuevoMedicamentoSucursal(@PathVariable("idSucursal") int idSucursal, Model model) {
	    MedicamentoSucursal medSucursal = new MedicamentoSucursal();
	    medSucursal.setSucursal_id(new Sucursal()); // para evitar nulls en el formulario
	    medSucursal.getSucursal_id().setId(idSucursal);

	    model.addAttribute("medicamentoSucursal", medSucursal);
	    model.addAttribute("listaMedicamentos", medicamentosServicio.listar()); 

	    return "views/medicamentosucursal/nuevo";
	}


	@PostMapping("/guardar")
	public String guardarMedicamentoSucursal(@ModelAttribute MedicamentoSucursal medicamentoSucursal) {

	   
	    Sucursal sucursal = sucursalServicio.buscarPorId(medicamentoSucursal.getSucursal_id().getId());
	    Medicamentos medicamento = medicamentosServicio.buscarPorId(medicamentoSucursal.getMedicamento_id().getId());

	   
	    medicamentoSucursal.setSucursal_id(sucursal);
	    medicamentoSucursal.setMedicamento_id(medicamento);

	   
	    medicamentosucursalServicio.save(medicamentoSucursal);

	   
	    return "redirect:/medicamentosucursal/" + sucursal.getId();
	}

		//Editar
		@GetMapping("/listar/{id}")
		public String listarId(@PathVariable int id, Model model) {
			model.addAttribute("medicamentosucursal", medicamentosucursalServicio.listarId(id));
			List<Medicamentos> listaMedicamentos = medicamentosServicio.listar();
			model.addAttribute("listaMedicamentos",listaMedicamentos);
			List<Sucursal> listaSucursal = sucursalServicio.listar();
			model.addAttribute("listaSucursal",listaSucursal);
			return "/views/medsucursales/editar_ms";
				
		}
		
		@GetMapping("/editar/{id}")
		public String editarMedicamentoSucursal(@PathVariable("id") int id, Model model) {
		    MedicamentoSucursal medSuc = medicamentosucursalServicio.listarId(id);
		    List<Medicamentos> listaMedicamentos = medicamentosServicio.listar(); 
		    model.addAttribute("medicamentoSucursal", medSuc);
		    model.addAttribute("listaMedicamentos", listaMedicamentos);
		    return "views/medicamentosucursal/editar_medsuc";
		}
		
		@PostMapping("/editar/{id}")
		public String guardarEdicionMedicamentoSucursal(@PathVariable("id") int id, 
		                                                @ModelAttribute MedicamentoSucursal medicamentoSucursal) {
		   
		    MedicamentoSucursal original = medicamentosucursalServicio.listarId(id);
		    medicamentoSucursal.setSucursal_id(original.getSucursal_id());
		    medicamentosucursalServicio.save(medicamentoSucursal);
		    return "redirect:/medicamentosucursal/" + original.getSucursal_id().getId();
		}
		
		
		@GetMapping("/eliminar/{id}")
		public String eliminarMedicamentoSucursal(@PathVariable int id) {
		    MedicamentoSucursal medSuc = medicamentosucursalServicio.listarId(id);
		    int idSucursal = medSuc.getSucursal_id().getId();

		    medicamentosucursalServicio.delete(id);

		    return "redirect:/medicamentosucursal/" + idSucursal;
		}


}
