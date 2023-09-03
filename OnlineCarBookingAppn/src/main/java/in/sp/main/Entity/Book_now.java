package in.sp.main.Entity;

import java.time.LocalDate;
import java.time.LocalTime;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book_now {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int book_id;
	private String pickuplocation;
	private String droplocation;
	private LocalTime pickuptime;
	private LocalDate pickupdate;
	private LocalDate dropdate;
	private int passangercapacity;
	private int members;
	private int days;
	private int numbags;
	private double totalprice;
	
	@OneToOne
	private Car car;
	
	

}
