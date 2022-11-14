package cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.fernandezVidal.alejandro.s05.t01.n02.S05T01N02FernandezVidalAlejandro.model.domain.FlorEntity;

@Repository
public interface FlorRepository extends JpaRepository<FlorEntity, Integer> {

}
