package cat.itacademy.barcelonactiva.fernandezvidal.alejandro.s05.t01.n01.S05T01N01FernandezVidalAlejandro.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.fernandezvidal.alejandro.s05.t01.n01.S05T01N01FernandezVidalAlejandro.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.fernandezvidal.alejandro.s05.t01.n01.S05T01N01FernandezVidalAlejandro.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.fernandezvidal.alejandro.s05.t01.n01.S05T01N01FernandezVidalAlejandro.model.repository.SucursalRepository;

@Service
public class SucursalServiceImpl implements ISucursalService {

	@Autowired
	private SucursalRepository sucursalRepository;

	@Override
	public void addSucursal(SucursalDTO sucursalDTO) {

		Sucursal sucursal = new Sucursal();
		sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
		sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
		sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());

		sucursalRepository.save(sucursal);

	}

	@Override
	public void updateSucursal(SucursalDTO sucursalDTO) {

		Sucursal sucursal = new Sucursal();
		sucursal.setPk_SucursalID(sucursalDTO.getPk_SucursalID());
		sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
		sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());

		sucursalRepository.save(sucursal);

	}

	@Override
	public void deleteSucursal(int id) {

		sucursalRepository.deleteById(id);

	}

	@Override
	public SucursalDTO getOneSucursal(int id) {

		Sucursal sucursal = sucursalRepository.findById(id).orElse(null);
		SucursalDTO sucursalDTO = new SucursalDTO();
		sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
		sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
		sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
		sucursalDTO.setTipusSucursal(sucursal.getPaisSucursal());

		return sucursalDTO;

	}

	@Override
	public List<SucursalDTO> getAllSucursal() {

		List<Sucursal> listadoSucursales = sucursalRepository.findAll();
		List<SucursalDTO> listadoSucursalesDTO = new ArrayList<>();

		for (Sucursal sucursal : listadoSucursales) {
			SucursalDTO sucursalDTO = new SucursalDTO();
			sucursalDTO.setPk_SucursalID(sucursal.getPk_SucursalID());
			sucursalDTO.setNomSucursal(sucursal.getNomSucursal());
			sucursalDTO.setPaisSucursal(sucursal.getPaisSucursal());
			sucursalDTO.setTipusSucursal(sucursal.getPaisSucursal());
			listadoSucursalesDTO.add(sucursalDTO);
		}

		return listadoSucursalesDTO;
	}

}
