package cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n03.S05T01N03FernandezVidalAlejandro.model.dto;

import java.io.Serializable;

public class FlorDTO implements  Serializable {
	private static final long serialVersionUID = 1L;
	private int pk_FlorID;
	private String nomFlor;
	private String paisFlor;
	private String tipusFlor;
	/*private List<String> paisosEuropa = Stream.of("Alemania", "Belgica", "Croacia", "España", "Francia", "Irlanda",
			"Letonia", "Luxemburgo", "Paises Bajos", "Suecia", "Bulgaria", "Eslovaquia", "Estonia", "Grecia", "Malta",
			"Polonia", "Republica Checa", "Austria", "Chipre", "Eslovenia", "Finlandia", "Hungria", "Italia",
			"Lituania", "Portugal", "Rumania").collect(Collectors.toList());*/
	public FlorDTO() {
		
	}
	/*public FlorDTO(int pk_FlorID, String nomFlor, String paisFlor) {
		
		this.pk_FlorID = pk_FlorID;
		this.nomFlor = nomFlor;
		this.paisFlor = paisFlor;
		this.tipusFlor = tipusFlor(paisFlor);
	}*/
public FlorDTO(int pk_FlorID, String nomFlor, String paisFlor, String tipusFlor) {
		
		this.pk_FlorID = pk_FlorID;
		this.nomFlor = nomFlor;
		this.paisFlor = paisFlor;
		this.tipusFlor = tipusFlor;
	}
	public int getPk_FlorID() {
		return pk_FlorID;
	}
	public void setPk_FlorID(int pk_FlorID) {
		this.pk_FlorID = pk_FlorID;
	}
	public String getNomFlor() {
		return nomFlor;
	}
	public void setNomFlor(String nomFlor) {
		this.nomFlor = nomFlor;
	}
	public String getPaisFlor() {
		return paisFlor;
	}
	public void setPaisFlor(String paisFlor) {
		this.paisFlor = paisFlor;
	}
	public String getTipusFlor() {
		return tipusFlor;
	}
	public void setTipusFlor(String tipusFlor) {
		this.tipusFlor = tipusFlor;
	}
	
	
	
	@Override
		public String toString() {
			return "FlorDTO [pk_FlorID=" + pk_FlorID + ", nomFlor=" + nomFlor + ", paisFlor=" + paisFlor + ", tipusFlor="
				+ tipusFlor + "]";
		}
	/*public String tipusFlor(String paisFlor) {
		
		int i = 0;
		boolean condicion = false;

		while (i < paisosEuropa.size() && condicion == false) {
			if (paisFlor.equalsIgnoreCase(paisosEuropa.get(i))) {
				tipusFlor = "UE";
				condicion = true;
			}
			i++;
		}
		if (!condicion) {
			tipusFlor = "Fora UE";
		}
		return tipusFlor;
	}*/

}
