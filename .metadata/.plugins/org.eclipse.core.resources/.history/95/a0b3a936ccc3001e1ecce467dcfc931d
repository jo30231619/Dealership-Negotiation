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
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private String dealershipName;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private String streetAddress;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private String city;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private String state;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private String zip;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private String phone;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
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
