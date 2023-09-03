package in.sp.main.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;

@Data
public class AtmRespDto {
	private int atm_id;
	private String email;
	private String fname;
	private String lname;
	private String driverimg;
	private String drivername;
	private String drivermobno;
	private int charge; // driver charge
	private String name; //hotel name
	private String room;
	private int stay;
	private String manageparking;
	private int finalcost;
	private String carcompany;
	private String carcolor;
	private String carmodel;
	private String cartype;
	private String carimage;
	private String fueltype;
	private String pickuplocation;
	private String droplocation;
	private LocalTime pickuptime;
	private LocalDate pickupdate;
	private LocalDate dropdate;
	private int passengercapacity;
	private int members;
	private int days;
	private int card_no;
	private int car_id;
	

}
