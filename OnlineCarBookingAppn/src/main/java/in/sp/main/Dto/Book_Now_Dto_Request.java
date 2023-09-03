package in.sp.main.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book_Now_Dto_Request {
	
	private int car_id;
	private String pickuplocation;
	private String droplocation;
	private LocalTime pickuptime;
	private LocalDate pickupdate;
	private LocalDate dropdate;
	private int passangercapacity;
	private int members;
	private int days;
	private int numbags;
	

}
