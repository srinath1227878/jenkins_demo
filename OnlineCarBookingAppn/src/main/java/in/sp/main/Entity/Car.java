package in.sp.main.Entity;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int car_id;
	private String carcompany;
	private String carcolor;
	private String carmodel;
	private String cartype;
	private String carimage;
	private String car360;
	private String carowner;
	private String numberplate;
	private LocalDate regdate;
	private String insurance;
	private LocalDate insurancevalidity;
	private String passengercapacity;
	private String fueltype;
	private String features;
	private String totalrunning;
	private String v;
	private float charge;
	
	
	

}
