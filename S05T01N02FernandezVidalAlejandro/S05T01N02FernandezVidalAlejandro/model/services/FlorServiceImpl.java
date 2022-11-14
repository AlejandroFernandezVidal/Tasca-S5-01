package cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.model.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.model.domain.FlorEntity;
import cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.model.dto.FlorDTO;
import cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.model.repository.FlorRepository;

@Service
public class FlorServiceImpl implements IFlorService {

	@Autowired
	FlorRepository florRepository;

	// ModelMapper modelMapper;

	@Override
	@Transactional
	public FlorDTO addFlor(FlorDTO florDTO) {
		// FlorDTO florDTOReturn;
		/*
		 * FlorEntity florEntity = new FlorEntity();
		 * florEntity.setPk_FlorID(florDTO.getPk_FlorID());
		 * florEntity.setNomFlor(florDTO.getNomFlor());
		 * florEntity.setPaisFlor(florDTO.getPaisFlor());
		 * florDTO.setTipusFlor(florDTO.getPaisFlor()); florRepository.save(florEntity);
		 */
		if (!florRepository.existsById(florDTO.getPk_FlorID())) {
			ModelMapper modelMapper = new ModelMapper();
			FlorEntity florEntity = modelMapper.map(florDTO, FlorEntity.class);
			// florDTO = modelMapper.map(florEntity, FlorDTO.class);
			florDTO.setTipusFlor(florDTO.getPaisFlor());
			florRepository.save(florEntity);
		} else {
			florDTO = null;
		}

		return florDTO;
	}

	@Override
	@Transactional
	public FlorDTO updateFlor(FlorDTO florDTO) {
		FlorEntity florEntity = new FlorEntity();

		florEntity.setPk_FlorID(florDTO.getPk_FlorID());
		florEntity.setNomFlor(florDTO.getNomFlor());
		florEntity.setPaisFlor(florDTO.getPaisFlor());
		florDTO.setTipusFlor(florDTO.getPaisFlor());
		florRepository.save(florEntity);

		return florDTO;

	}

	@Override
	@Transactional
	public void deleteFlor(int id) {
		florRepository.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public FlorDTO getOneFlor(int id) {
		FlorEntity florEntity = florRepository.findById(id).orElse(null);
		FlorDTO florDTO = new FlorDTO();
		florDTO.setPk_FlorID(florEntity.getPk_FlorID());
		florDTO.setNomFlor(florEntity.getNomFlor());
		florDTO.setPaisFlor(florEntity.getPaisFlor());
		florDTO.setTipusFlor(florEntity.getPaisFlor());
		return florDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public List<FlorDTO> getAllFlor() {
		List<FlorEntity> listadoEntity = florRepository.findAll();
		List<FlorDTO> listadoDTO = new ArrayList<>();
		for (FlorEntity florEntity : listadoEntity) {
			FlorDTO florDTO = new FlorDTO();
			florDTO.setPk_FlorID(florEntity.getPk_FlorID());
			florDTO.setNomFlor(florEntity.getNomFlor());
			florDTO.setPaisFlor(florEntity.getPaisFlor());
			florDTO.setTipusFlor(florEntity.getPaisFlor());
			listadoDTO.add(florDTO);
		}
		return listadoDTO;
	}
}