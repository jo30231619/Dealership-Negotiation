package dealership.negotiation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dealership.negotiation.entity.Dealership;

public interface DealershipDao extends JpaRepository<Dealership, Long> {

}
