package cat.itacademy.barcelonactiva.fernandezvidal.alejandro.s05.t01.n01.S05T01N01FernandezVidalAlejandro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cat.itacademy.barcelonactiva.fernandezvidal.alejandro.s05.t01.n01.S05T01N01FernandezVidalAlejandro.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.fernandezvidal.alejandro.s05.t01.n01.S05T01N01FernandezVidalAlejandro.model.services.SucursalServiceImpl;

@Controller
@RequestMapping("/sucursal")
public class SucursalController {

	@Autowired
	private SucursalServiceImpl sucursalServiceImpl;

	@GetMapping("/")
	public String home() {
		return "/sucursal/home";
	}

	@GetMapping("/getAll")
	public String listarSucursales(Model model) {

		List<SucursalDTO> listadoSucursalesDTO = sucursalServiceImpl.getAllSucursal();

		model.addAttribute("titulo", "Lista de Sucursales");
		model.addAttribute("sucursales", listadoSucursalesDTO);
		return "/sucursal/listar";
	}

	@GetMapping("/create")
	public String crearSucursal(Model model) {
		SucursalDTO sucursalDTO = new SucursalDTO();

		model.addAttribute("titulo", "Formulario: Nueva Sucursal");
		model.addAttribute("sucursal", sucursalDTO);
		return "/sucursal/frmCrear";
	}

	@PostMapping("/add")
	public String guardar(@Validated @ModelAttribute SucursalDTO sucursalDTO, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {

			model.addAttribute("titulo", "Formulario: Nueva Sucursal");
			model.addAttribute("sucursal", sucursalDTO);
			System.out.println("Error en el formulario.");
			return "/sucursal/frmCrear";
		}
		sucursalServiceImpl.addSucursal(sucursalDTO);
		System.out.println("Sucursal registrada correctamente.");
		redirectAttributes.addFlashAttribute("success", "Sucursal registrada correctamente.");
		return "redirect:/sucursal/getAll/";
	}

	@GetMapping("/update")
	public String actualizarSucursal(Model model) {

		SucursalDTO sucursalDTO = new SucursalDTO();

		model.addAttribute("titulo", "Formulario: Actualizar Sucursal");
		model.addAttribute("sucursal", sucursalDTO);
		return "/sucursal/frmActualizar";

	}

	@PostMapping("/actualizar")
	public String actualizar(@Validated @ModelAttribute SucursalDTO sucursalDTO,
			RedirectAttributes redirectAttributes) {
		try {
			sucursalServiceImpl.getOneSucursal(sucursalDTO.getPk_SucursalID());
			sucursalServiceImpl.updateSucursal(sucursalDTO);
			System.out.println("Sucursal actualizada correctamente.");
			redirectAttributes.addFlashAttribute("success", "Sucursal actualizada correctamente.");
			return "redirect:/sucursal/getAll/";
		} catch (Exception e) {
			System.out.println("La sucursal con ID " + sucursalDTO.getPk_SucursalID() + " no existe.");
			redirectAttributes.addFlashAttribute("error",
					"La sucursal con ID " + sucursalDTO.getPk_SucursalID() + " no existe.");
			return "redirect:/sucursal/getAll/";

		}
	}

	@GetMapping("/update/{id}")
	public String editarSucursal(@PathVariable("id") int pk_SucursalID, Model model,
			RedirectAttributes redirectAttributes) {
		try {
			SucursalDTO sucursalActualizarDTO = sucursalServiceImpl.getOneSucursal(pk_SucursalID);
			model.addAttribute("titulo", "Formulario: Editar Sucursal");
			model.addAttribute("sucursal", sucursalActualizarDTO);
			return "/sucursal/frmActualizar";
		} catch (Exception e) {
			System.out.println("La sucursal con ID " + pk_SucursalID + " no existe.");
			redirectAttributes.addFlashAttribute("error", "La sucursal con ID " + pk_SucursalID + " no existe.");
			return "redirect:/sucursal/getAll/";
		}
	}

	@GetMapping("/delete/{id}")
	public String eliminarSucursal(@PathVariable("id") int pk_SucursalID, RedirectAttributes redirectAttributes) {
		try {
			sucursalServiceImpl.deleteSucursal(pk_SucursalID);
			System.out.println("Sucursal eliminada correctamente.");
			redirectAttributes.addFlashAttribute("warning", "Sucursal eliminada correctamente.");
			return "redirect:/sucursal/getAll/";
		} catch (Exception e) {
			System.out.println("La sucursal con ID " + pk_SucursalID + " no existe.");
			redirectAttributes.addFlashAttribute("error", "La sucursal con ID " + pk_SucursalID + " no existe.");
			return "redirect:/sucursal/getAll/";
		}
	}

	@GetMapping("/getOne/{id}")
	public String obtenerSucursal(@PathVariable("id") int pk_SucursalID, RedirectAttributes redirectAttributes,
			Model model) {
		try {
			SucursalDTO sucursalDTO = sucursalServiceImpl.getOneSucursal(pk_SucursalID);
			model.addAttribute("titulo", "Sucursal");
			model.addAttribute("sucursales", sucursalDTO);
			return "/sucursal/listar";
		} catch (Exception e) {
			System.out.println("La sucursal con ID " + pk_SucursalID + " no existe.");
			redirectAttributes.addFlashAttribute("error", "La sucursal con ID " + pk_SucursalID + " no existe.");
			return "redirect:/sucursal/getAll/";
		}
	}
}