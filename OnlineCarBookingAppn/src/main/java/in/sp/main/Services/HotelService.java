package in.sp.main.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Dto.HotelRequestDto;
import in.sp.main.Dto.HotelResponseDto;
import in.sp.main.Entity.Hotel;
import in.sp.main.Repository.HotelRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository hotelRepository;
	
	
	public HotelResponseDto dtoToEntity(HotelRequestDto hotelRequestDto) {
		
		Hotel hotel = new Hotel();
		
		hotel.setName(hotelRequestDto.getName());
		hotel.setRoom(hotelRequestDto.getRoom());
		hotel.setStay(hotelRequestDto.getStay());
		hotel.setManageparking(hotelRequestDto.getManageparking());
		hotel.setFinalcost(hotelRequestDto.getFinalcost());
		
		hotelRepository.save(hotel);
		
		HotelResponseDto hotelResponseDto = mapToHotelResponseDto(hotel);
		
		return hotelResponseDto;
		
	}
	private static HotelResponseDto mapToHotelResponseDto(Hotel hotel) {
		
		HotelResponseDto hotelResponseDto = new HotelResponseDto();
		
		hotelResponseDto.setHotel_id(hotel.getHotel_id());
		hotelResponseDto.setName(hotel.getName());
		hotelResponseDto.setManageparking(hotel.getManageparking());
		hotelResponseDto.setRoom(hotel.getRoom());
		hotelResponseDto.setStay(hotel.getStay());
		hotelResponseDto.setFinalcost(hotel.getFinalcost());
		
		
		
		return hotelResponseDto;
	}
	
	
	
	
}
