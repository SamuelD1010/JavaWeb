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
import uts.edu.java.corte3.modelos.Sucursal;
import uts.edu.java.corte3.Servicios.SucursalServicio;

@Controller
@RequestMapping("/views/sucursales")
public class SucursalControlador {

	@Autowired
	private SucursalServicio sucursalServicio;
	
	@RequestMapping("/")
	public String verIndex(Model model) {
		List<Sucursal> listaSucursal = sucursalServicio.listar();
		model.addAttribute("listaSucursal",listaSucursal);
		return "/views/sucursales/sucursales";
	}
	
	@GetMapping("/new")
    public String nuevaSucursal(Model model) {
		Sucursal Sucursal = new Sucursal();
        model.addAttribute("sucursal", Sucursal);
        return "views/sucursales/nuevo_suc";
    }

    @PostMapping("/guardar")
    public String guardarSucursal(@ModelAttribute Sucursal sucursal) {
        sucursalServicio.save(sucursal);
        return "redirect:/views/sucursales/";
    }
		
		@RequestMapping("/delete/{id}")
		public String deleteSucursal(@PathVariable(name = "id") int id) {
			sucursalServicio.delete(id);
			return "redirect:/views/sucursales/";
		}
}
