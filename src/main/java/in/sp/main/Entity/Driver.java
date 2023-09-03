package in.sp.main.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String driverimg;
	private String drivername;
	private String drivingexperiance;
	private String drivermobno;
	private String availability;
	private String food;
	private String smoke;
	private String drink;
	private int charge;
	private String v;

	@OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)
	private List<Hotel> hotels;
}
