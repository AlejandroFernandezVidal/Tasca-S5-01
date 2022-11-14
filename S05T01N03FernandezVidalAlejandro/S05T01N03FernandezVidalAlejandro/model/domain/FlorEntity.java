package cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n03.S05T01N03FernandezVidalAlejandro.model.domain;

import java.io.Serializable;


public class FlorEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private int pk_FlorID;
	private String nomFlor;
	private String paisFlor;
	
	public FlorEntity() {
		
	}

	public FlorEntity(int pk_FlorID, String nomFlor, String paisFlor) {
		
		this.pk_FlorID = pk_FlorID;
		this.nomFlor = nomFlor;
		this.paisFlor = paisFlor;
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

	@Override
	public String toString() {
		return "FlorEntity [pk_FlorID=" + pk_FlorID + ", nomFlor=" + nomFlor + ", paisFlor=" + paisFlor + "]";
	}
	
}
