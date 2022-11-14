package cat.itacademy.barcelonactiva.fernandezvidal.alejandro.s05.t01.n01.S05T01N01FernandezVidalAlejandro.model.dto;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SucursalDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;

	private List<String> paisosEuropa = Stream.of("Alemania", "Belgica", "Croacia", "España", "Francia", "Irlanda",
			"Letonia", "Luxemburgo", "Paises Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta",
			"Polonia", "Republica Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungria", "Italia",
			"Lituania", "Portugal", "Rumania").collect(Collectors.toList());

	public SucursalDTO() {

	}

	public SucursalDTO(int pk_SucursalID, String nomSucursal, String paisSucursal) {
		this.pk_SucursalID = pk_SucursalID;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		this.tipusSucursal = tipusSucursal(paisSucursal);
	}

	public int getPk_SucursalID() {
		return pk_SucursalID;
	}

	public void setPk_SucursalID(int pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	public String getTipusSucursal() {
		return tipusSucursal;
	}

	public void setTipusSucursal(String paisSucursal) {
		this.tipusSucursal = tipusSucursal(paisSucursal);
	}

	/*
	 * public List<String>[] getPaisosEuropa() { return paisosEuropa; }
	 */

	/*
	 * public void setPaisosEuropa(List<String>[] paisosEuropa) { this.paisosEuropa
	 * = paisosEuropa; }
	 */

	@Override
	public String toString() {
		return "SucursalDTO [pk_SucursalID=" + pk_SucursalID + ", nomSucursal=" + nomSucursal + ", paisSucursal="
				+ paisSucursal + ", tipusSucursal=" + tipusSucursal + "]";
	}

	public String tipusSucursal(String paisSucursal) {
		int i = 0;
		boolean condicion = false;

		while (i < paisosEuropa.size() && condicion == false) {
			if (paisSucursal.equalsIgnoreCase(paisosEuropa.get(i))) {
				tipusSucursal = "UE";
				condicion = true;

			}
			i++;
		}
		if (!condicion) {
			tipusSucursal = "Fora UE";
		}
		return tipusSucursal;
	}

}
