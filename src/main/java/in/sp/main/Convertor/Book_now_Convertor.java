package in.sp.main.Convertor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import in.sp.main.Dto.Book_Now_Dto_Request;
import in.sp.main.Dto.Book_Now_Dto_Response;
import in.sp.main.Entity.Book_now;
import in.sp.main.Entity.Car;

@Component
public class Book_now_Convertor
{
	
	public Book_now dtoToEntity(Book_Now_Dto_Request book_now_Dto_Request) {
		Book_now book_now = new Book_now();
		book_now.setPickuplocation(book_now_Dto_Request.getPickuplocation());
		book_now.setDroplocation(book_now_Dto_Request.getDroplocation());
		book_now.setPickuptime(book_now_Dto_Request.getPickuptime());
		book_now.setPickupdate(book_now_Dto_Request.getPickupdate());
		book_now.setDropdate(book_now_Dto_Request.getDropdate());
		book_now.setPassangercapacity(book_now_Dto_Request.getPassangercapacity());
		book_now.setMembers(book_now_Dto_Request.getMembers());
		book_now.setDays(book_now_Dto_Request.getDays());
		book_now.setNumbags(book_now_Dto_Request.getNumbags());
		
		return book_now;
		
	}
	public List<Book_now> dtoToEntity(List<Book_Now_Dto_Request> book_now_Dto_Request) {
		return book_now_Dto_Request.stream().map(k->dtoToEntity(k)).collect(Collectors.toList());
	}
	
	public Book_Now_Dto_Response entityToDto(Book_now book_now) {
		Car car = book_now.getCar();
		Book_Now_Dto_Response book_Now_Dto_Response = new Book_Now_Dto_Response();
		
		book_Now_Dto_Response.setCarcompany(car.getCarcompany());
		book_Now_Dto_Response.setCarcolor(car.getCarcolor());
		book_Now_Dto_Response.setCarmodel(car.getCarmodel());
		book_Now_Dto_Response.setCartype(car.getCartype());
		book_Now_Dto_Response.setCarowner(car.getCarowner());
		book_Now_Dto_Response.setCarimage(car.getCarimage());
		book_Now_Dto_Response.setNumplate(car.getNumberplate());
		book_Now_Dto_Response.setInsurancevalidity(car.getInsurancevalidity());
		book_Now_Dto_Response.setFueltype(car.getFueltype());
		book_Now_Dto_Response.setFeature(car.getFeatures());
		book_Now_Dto_Response.setCharges(car.getCharge());
		book_Now_Dto_Response.setPickuploation(book_now.getPickuplocation());
		book_Now_Dto_Response.setDroplocation(book_now.getDroplocation());
		book_Now_Dto_Response.setPickuptime(book_now.getPickuptime());
		book_Now_Dto_Response.setPickupdate(book_now.getPickupdate());
		book_Now_Dto_Response.setDropdate(book_now.getDropdate());
		book_Now_Dto_Response.setPassengercapacity(book_now.getPassangercapacity());
		book_Now_Dto_Response.setMembers(book_now.getMembers());
		book_Now_Dto_Response.setDays(book_now.getDays());
		book_Now_Dto_Response.setNumbags(book_now.getNumbags());
		book_Now_Dto_Response.setTotalprice(book_now.getTotalprice());
		book_Now_Dto_Response.setBook_id(book_now.getBook_id());
		
		
		
		return book_Now_Dto_Response;
		
	}
	public List<Book_Now_Dto_Response> entityToDto(List<Book_now> book_now){
		return book_now.stream().map(k->entityToDto(k)).collect(Collectors.toList());
		
	}
	
}
