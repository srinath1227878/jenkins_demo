package in.sp.main.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotel_id;

	private String hotel;

	private String room;
	private int stay;
	private String manageparking;
	private int finalcost;
	
	// book-now user driver mapping
	// card driver mapping
	@ManyToOne
	@JoinColumn(name="driver_id")
	private Driver driver;
}
