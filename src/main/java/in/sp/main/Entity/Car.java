package in.sp.main.Entity;


import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer car_id;
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
	private int charge;

	@OneToMany(mappedBy = "car",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
	private List<Book_now> book_nows;
}
