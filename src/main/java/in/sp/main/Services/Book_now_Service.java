package in.sp.main.Services;

import in.sp.main.Dto.CarResponseDTO;
import in.sp.main.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Dto.Book_Now_Dto_Request;
import in.sp.main.Dto.Book_Now_Dto_Response;
import in.sp.main.Entity.Book_now;
import in.sp.main.Entity.Car;
import in.sp.main.Repository.Book_now_Repository;
import in.sp.main.Repository.CarRepository;
import in.sp.main.Convertor.Book_now_Convertor;

import java.util.Optional;

@Service
public class Book_now_Service {

	@Autowired
	Book_now_Repository book_now_Repository;
	@Autowired
	Book_now_Convertor book_now_Convertor;
	@Autowired
	CarRepository carRepository;

	public Book_Now_Dto_Response addBook(Book_Now_Dto_Request book_Now_Dto_Request) {
		Car car = carRepository.findById(book_Now_Dto_Request.getCar_id()).orElseThrow(()-> new ResourceNotFoundException("Car","car id",book_Now_Dto_Request.getCar_id()));

		Book_now book_now = book_now_Convertor.dtoToEntity(book_Now_Dto_Request);
		
		book_now.setCar(car);
		double totalprice=0;
		totalprice=book_now.getDays()*car.getCharge();
		book_now.setTotalprice(totalprice);
		Book_now savebooked=book_now_Repository.save(book_now);
		
		
		Book_Now_Dto_Response book_Now_Dto_Response = book_now_Convertor.entityToDto(savebooked);
		
		book_Now_Dto_Response.setTotalprice(totalprice);

	
		return book_Now_Dto_Response;
		

	}

	public CarResponseDTO getCar(Integer id)
	{
		Optional<Car> byId = carRepository.findById(id);
		CarResponseDTO carResponseDTO=new CarResponseDTO();
		carResponseDTO.setCar_id(byId.get().getCar_id());
		carResponseDTO.setCarcolor(byId.get().getCarcolor());
		carResponseDTO.setCarcompany(byId.get().getCarcompany());
		carResponseDTO.setCarimage(byId.get().getCarimage());
		carResponseDTO.setCar360(byId.get().getCar360());
		carResponseDTO.setCarmodel(byId.get().getCarmodel());
		carResponseDTO.setCartype(byId.get().getCartype());
		carResponseDTO.setCarowner(byId.get().getCarowner());
		carResponseDTO.setCharge(byId.get().getCharge());
		carResponseDTO.setFeatures(byId.get().getFeatures());
		carResponseDTO.setFueltype(byId.get().getFueltype());
		carResponseDTO.setInsurance(byId.get().getInsurance());
		carResponseDTO.setInsurancevalidity(byId.get().getInsurancevalidity());
		carResponseDTO.setNumberplate(byId.get().getNumberplate());
		carResponseDTO.setPassengercapacity(byId.get().getPassengercapacity());
		carResponseDTO.setRegdate(byId.get().getRegdate());
		carResponseDTO.setTotalrunning(byId.get().getTotalrunning());

		return carResponseDTO;
	}
}
