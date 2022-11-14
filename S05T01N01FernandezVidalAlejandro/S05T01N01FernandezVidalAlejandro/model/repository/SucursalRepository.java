package cat.itacademy.barcelonactiva.fernandezvidal.alejandro.s05.t01.n01.S05T01N01FernandezVidalAlejandro.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.fernandezvidal.alejandro.s05.t01.n01.S05T01N01FernandezVidalAlejandro.model.domain.Sucursal;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

}
