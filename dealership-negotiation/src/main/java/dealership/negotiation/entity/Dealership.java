package dealership.negotiation.entity;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Dealership {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dealershipId;
	
	private String dealershipName;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	private String phone;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "dealership", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Car> cars = new HashSet<>();
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "dealership_automaker",
			joinColumns = @JoinColumn(name = "dealership_id"),
			inverseJoinColumns = @JoinColumn(name = "automaker_id")
			)
	private Set<Automaker> automakers = new HashSet<>();
}
