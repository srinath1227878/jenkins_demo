package in.sp.main.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Atmpage { //foreign key (mapping into atm / pay)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int atm_id;
	private int card_no;
	
	@ManyToOne
	@JoinColumn(name="driver_fk")
	private Driver driver;
	
	@OneToOne
	@JoinColumn(name="book_now_fk")
	private Book_now book_now;
	
	@ManyToOne
	@JoinColumn(name="user_fk")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="car_fk")
	private Car car;
	
	@OneToOne
	@JoinColumn(name="hotel_fk")
	private Hotel hotel;

	private String email;
	
}
