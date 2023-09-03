package in.sp.main.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelResponseDto {
	
	private int hotel_id;
	private String name;
	private String room;
	private int stay;
	private String manageparking;
	private double finalcost;

}
