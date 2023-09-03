package in.sp.main.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book_Now_Dto_Response
{

	private int book_id;
	private String carcompany;
	private String carcolor;
	private String carmodel;
	private String cartype;
	private String carowner;
	private String carimage;
	private String numplate;
	private int charges;
	private LocalDate insurancevalidity;
	private String fueltype;
	private String feature;
	private String pickuploation;
	private String droplocation;
	private LocalTime pickuptime;
	private LocalDate pickupdate;
	private LocalDate dropdate;
	private int passengercapacity;
	private int members;
	private int days;
	private int numbags;
	
	private double totalprice;

}
