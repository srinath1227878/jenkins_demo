package in.sp.main.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class HotelRequestDto {

	private int hotel_id;
	private String hotel;
	private String room;
	private int stay;
	private String manageparking;
//	private double finalcost;
	private int finalcost;
	private int driver_id;
	private int booknow_id;

}
