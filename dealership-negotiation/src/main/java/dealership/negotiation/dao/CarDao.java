package dealership.negotiation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dealership.negotiation.entity.Car;

public interface CarDao extends JpaRepository<Car, Long> {

}
