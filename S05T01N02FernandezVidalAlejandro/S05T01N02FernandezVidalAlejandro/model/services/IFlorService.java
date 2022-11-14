package cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.model.dto.FlorDTO;

public interface IFlorService {
	
	public FlorDTO addFlor(FlorDTO florDTO);
	public FlorDTO updateFlor(FlorDTO florDTO);
	public void deleteFlor(int id);
	public FlorDTO getOneFlor(int id);
	public List<FlorDTO> getAllFlor();

}
