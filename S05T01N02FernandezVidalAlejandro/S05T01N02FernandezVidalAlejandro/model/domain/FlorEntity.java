package cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flores")
public class FlorEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID_Flor")
	private int pk_FlorID;
	
	@Column(name = "Nombre_Flor")
	private String nomFlor;
	
	@Column(name = "Pais_Flor")
	private String paisFlor;
	
	public FlorEntity() {
		
	}

	public FlorEntity(String nomFlor, String paisFlor) {
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