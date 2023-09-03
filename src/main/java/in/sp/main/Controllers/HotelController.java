package in.sp.main.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.Dto.HotelRequestDto;
import in.sp.main.Dto.HotelResponseDto;
import in.sp.main.Services.HotelService;

@RestController
public class HotelController {

	@Autowired
	HotelService hotelService;

	
	@PostMapping("/addhotel")
	public HotelResponseDto createHotel(@RequestBody HotelRequestDto hotelRequestDto) {
		return hotelService.addHotel(hotelRequestDto);
	}
}
