package in.sp.main.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import in.sp.main.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import in.sp.main.Dto.AtmReqDto;
import in.sp.main.Dto.AtmRespDto;
import in.sp.main.Entity.Driver;
import in.sp.main.Repository.AtmRepository;
import in.sp.main.Repository.Book_now_Repository;
import in.sp.main.Repository.CarRepository;
import in.sp.main.Repository.DriverRepository;
import in.sp.main.Repository.HotelRepository;
import in.sp.main.Repository.UserRepository;

@Service
public class AtmService {
	
	@Autowired
	CarRepository carRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	Book_now_Repository book_now_Repository;
	@Autowired
	AtmRepository atmRepository;
	@Autowired
	DriverRepository driverRepository;
	
	@Autowired
	HotelRepository hotelRepository;
	
	
	//=====================================================================================
	public Car findcar(int id) {
		Optional<Car>car = carRepository.findById(id);
		return car.get();
	}
	//====================================================================================
	public User findUser(int id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}
	//=====================================================================================
	public Book_now findbook_now(int id) {
		Optional<Book_now> book_now = book_now_Repository.findById(id);
		return book_now.get();
	}
	//======================================================================================
	public Driver findDriver(int id) {
		Optional<Driver> drivers = driverRepository.findById(id);
		return drivers.get();
	}
	//=================================================================
	public Hotel findHotel(int id) {
		Optional<Hotel> hotel = hotelRepository.findById(id);
		return hotel.get();
	}
	
	public AtmRespDto dtoToEntity(AtmReqDto atmReqDto) {
		Atmpage atmpage = new Atmpage();
		
		Driver driver = findDriver(atmReqDto.getDriver_id());
		User user = findUser(atmReqDto.getUser_id());
		Book_now book_now = findbook_now(atmReqDto.getBook_id());
		Car car = findcar(atmReqDto.getCar_id());
		Hotel hotel = findHotel(atmReqDto.getHotel_id());
		
		atmpage.setBook_now(book_now);
		atmpage.setCar(car);
		atmpage.setDriver(driver);
		atmpage.setHotel(hotel);
		atmpage.setUser(user);
		atmpage.setEmail(user.getEmail());//set

		//finalcost service logic
		/*int finalcost=0;
		finalcost=book_now.getDays()* drivers.getCharge()+car.getCharge();
		h.setFinalcost(finalcost);*/

		atmpage.setCard_no(atmReqDto.getCard_no());
		
		atmRepository.save(atmpage);
		
		AtmRespDto atmRespDto = mapToAtmRespDto(atmpage);
		
		return atmRespDto;
		
	}
	public AtmRespDto mapToAtmRespDto(Atmpage atmpage) {
		AtmRespDto atmRespDto = new AtmRespDto();

		 atmRespDto.setEmail(atmpage.getUser().getEmail());
		 atmRespDto.setFname(atmpage.getUser().getFname());
		 atmRespDto.setLname(atmpage.getUser().getLname());
		 atmRespDto.setDriverimg(atmpage.getDriver().getDriverimg());
		 atmRespDto.setDrivername(atmpage.getDriver().getDrivername());
		 atmRespDto.setDrivermobno(atmpage.getDriver().getDrivermobno());
		 atmRespDto.setCharge(Integer.parseInt(String.valueOf(atmpage.getDriver().getCharge())));
		 atmRespDto.setName(atmpage.getHotel().getHotel());
		atmRespDto.setRoom(atmpage.getHotel().getRoom());
		atmRespDto.setStay(atmpage.getHotel().getStay());
		atmRespDto.setManageparking(atmpage.getHotel().getManageparking());
		atmRespDto.setFinalcost(atmpage.getHotel().getFinalcost());
		atmRespDto.setCarcompany(atmpage.getCar().getCarcompany());
		atmRespDto.setCarcolor(atmpage.getCar().getCarcolor());
		atmRespDto.setCarmodel(atmpage.getCar().getCarmodel());
		atmRespDto.setCartype(atmpage.getCar().getCartype());
		atmRespDto.setCarimage(atmpage.getCar().getCarimage());
		atmRespDto.setFueltype(atmpage.getCar().getFueltype());
		atmRespDto.setPickuplocation(atmpage.getBook_now().getPickuplocation());
		atmRespDto.setDroplocation(atmpage.getBook_now().getDroplocation());
		atmRespDto.setPickuptime(atmpage.getBook_now().getPickuptime());
		atmRespDto.setDropdate(atmpage.getBook_now().getDropdate());
		atmRespDto.setPassengercapacity(atmpage.getBook_now().getPassangercapacity());
		atmRespDto.setPickupdate(atmpage.getBook_now().getPickupdate());
		atmRespDto.setMembers(atmpage.getBook_now().getMembers());
		atmRespDto.setDays(atmpage.getBook_now().getDays());
		atmRespDto.setCard_no(atmpage.getCard_no());
		atmRespDto.setAtm_id(atmpage.getAtm_id());
		atmRespDto.setCar_id(atmpage.getCar().getCar_id());

		return atmRespDto;
		
	}
	public List<AtmRespDto> getData(String email) {
		List<Atmpage> atmpageList = atmRepository.findByEmail(email);
//		User user = userRepository.findById(atmpage.getUser().getId()).get();
//		Car car = carRepository.findById(atmpage.getCar().getCar_id()).get();
//		Book_now bookNow = book_now_Repository.findById(atmpage.getBook_now().getBook_id()).get();
//		Driver driver = driverRepository.findById(atmpage.getDriver().getId()).get();
		List<AtmRespDto> atmRespDtoList = atmpageList.stream().map(atmpage -> mapToAtmRespDto(atmpage)).collect(Collectors.toList());
		return atmRespDtoList;
	}
}
