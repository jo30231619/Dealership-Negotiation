package dealership.negotiation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dealership.negotiation.entity.Automaker;

public interface AutomakerDao extends JpaRepository<Automaker, Long> {

}
