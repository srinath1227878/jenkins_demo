package in.sp.main.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Drivers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String driverimg;
	private String drivername;
	private String drivingexperiance;
	private String drivermobno;
	private String availability;
	private String food;
	private String smoke;
	private String drink;
	private String charge;
	private String v;

}
