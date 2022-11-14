package cat.itacademy.barcelonactiva.fernandezvidal.alejandro.s05.t01.n01.S05T01N01FernandezVidalAlejandro.model.services;

import java.util.List;

import cat.itacademy.barcelonactiva.fernandezvidal.alejandro.s05.t01.n01.S05T01N01FernandezVidalAlejandro.model.dto.SucursalDTO;

public interface ISucursalService {

	public void addSucursal(SucursalDTO sucursalDTO);
	public void updateSucursal(SucursalDTO sucursalDTO);
	public void deleteSucursal(int id);
	public SucursalDTO getOneSucursal(int id);
	public List<SucursalDTO> getAllSucursal();
}
