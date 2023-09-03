package in.sp.main.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Dto.Book_Now_Dto_Request;
import in.sp.main.Dto.Book_Now_Dto_Response;
import in.sp.main.Entity.Book_now;
import in.sp.main.Entity.Car;
import in.sp.main.Repository.Book_now_Repository;
import in.sp.main.Repository.CarRepository;
import in.sp.main.Convertor.Book_now_Convertor;

@Service

public class Book_now_Service {
	
	@Autowired
	Book_now_Repository book_now_Repository;
	@Autowired
	Book_now_Convertor book_now_Convertor;
	@Autowired
	CarRepository carRepository;
	
	
	public Book_Now_Dto_Response addBook(Book_Now_Dto_Request book_Now_Dto_Request) {
		Car car = carRepository.findById(book_Now_Dto_Request.getCar_id()).get();
		
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
	
	

}
