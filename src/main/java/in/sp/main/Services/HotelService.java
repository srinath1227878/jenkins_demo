package in.sp.main.Services;

import in.sp.main.Entity.Book_now;
import in.sp.main.Entity.Car;
import in.sp.main.Entity.Driver;
import in.sp.main.Repository.Book_now_Repository;
import in.sp.main.Repository.CarRepository;
import in.sp.main.Repository.DriverRepository;
import in.sp.main.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Dto.HotelRequestDto;
import in.sp.main.Dto.HotelResponseDto;
import in.sp.main.Entity.Hotel;
import in.sp.main.Repository.HotelRepository;

import java.util.Optional;

@Service
public class HotelService {
	@Autowired
	HotelRepository hotelRepository;
	@Autowired
	DriverRepository driverRepository;
	@Autowired
	Book_now_Repository bookNowRepository;

	public HotelResponseDto addHotel(HotelRequestDto hotelRequestDto) {

		Driver driver = getDriversFromDb(hotelRequestDto.getDriver_id());

		Book_now book_now = bookNowRepository.findById(hotelRequestDto.getBooknow_id()).orElseThrow(()-> new ResourceNotFoundException());

		int finalCost = driver.getCharge() * book_now.getDays() + book_now.getCar().getCharge()* book_now.getDays();

		//=====================================================================================================
		Hotel hotel = new Hotel();
		hotel.setDriver(driver);
		hotel.setHotel(hotelRequestDto.getHotel());
		hotel.setRoom(hotelRequestDto.getRoom());
		hotel.setStay(hotelRequestDto.getStay());
		hotel.setManageparking(hotelRequestDto.getManageparking());
		hotel.setFinalcost(finalCost);
		
		hotelRepository.save(hotel);
		
		HotelResponseDto hotelResponseDto = entityToDtoConvert(hotel);
		
		return hotelResponseDto;
		
	}

	private Driver getDriversFromDb(int driver_id) {
		Driver driver = driverRepository.findById(driver_id).orElseThrow(()-> new ResourceNotFoundException("Driver","driver id",driver_id));
		return driver;
	}

	private HotelResponseDto entityToDtoConvert(Hotel hotel) {

		HotelResponseDto hotelResponseDto = new HotelResponseDto();

		hotelResponseDto.setHotel_id(hotel.getHotel_id());
		hotelResponseDto.setHotel(hotel.getHotel());
		hotelResponseDto.setManageparking(hotel.getManageparking());
		hotelResponseDto.setRoom(hotel.getRoom());
		hotelResponseDto.setStay(hotel.getStay());
		hotelResponseDto.setDriver_id(hotel.getDriver().getId());
		hotelResponseDto.setFinalcost(hotel.getFinalcost());

		return hotelResponseDto;
	}

}
