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
import uts.edu.java.corte3.modelos.Medicamentos;
import uts.edu.java.corte3.Servicios.MedicamentosServicio;

@Controller
@RequestMapping("/views/medicamentos")
public class MedicamentosControlador {

	@Autowired
	private MedicamentosServicio medicamentosServicio;
	
	@GetMapping("/")
	public String verIndex(Model model) {
	    List<Medicamentos> listaMedicamentos = medicamentosServicio.listar();
	    model.addAttribute("listaMedicamentos", listaMedicamentos);
	    return "views/medicamentos/medicamentos"; // 
	}
	
	//Direccionar a la pagina de crear un proveedor
	@GetMapping("/new")
	public String mostrarPaginaNuevoMedicamento(Model model) {
		Medicamentos medicamento = new Medicamentos();
		model.addAttribute("medicamento",medicamento);
		return "/views/medicamentos/nuevo_med";
	}
	
	//Metodo de crear 
		@PostMapping("/save")
		public String saveMedicamento(@Valid @ModelAttribute("medicamento") Medicamentos medicamento, BindingResult bindingResult) {
			if (bindingResult.hasErrors()) {
				return "/views/medicamentos/nuevo_med";
			}
			medicamentosServicio.save(medicamento);
			return "redirect:/views/medicamentos/";
		}
	
		//Editar
		@GetMapping("/listar/{id}")
		public String listarId(@PathVariable int id, Model model) {
			model.addAttribute("medicamento", medicamentosServicio.listarId(id));
			return "/views/medicamentos/editar_med";
				
		}
		
		@RequestMapping("/delete/{id}")
		public String deleteMedicamento(@PathVariable(name = "id") int id) {
			medicamentosServicio.delete(id);
			return "redirect:/views/medicamentos/";
		}
}
