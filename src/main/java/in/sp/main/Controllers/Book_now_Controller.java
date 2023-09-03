package in.sp.main.Controllers;

import in.sp.main.Dto.CarResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.sp.main.Dto.Book_Now_Dto_Request;
import in.sp.main.Dto.Book_Now_Dto_Response;
import in.sp.main.Services.Book_now_Service;

@RestController
public class Book_now_Controller {
	
	@Autowired
	Book_now_Service book_now_Service;
	
	@PostMapping("/booknow")
	public Book_Now_Dto_Response response(@RequestBody Book_Now_Dto_Request book_Now_Dto_Request) {
		return book_now_Service.addBook(book_Now_Dto_Request);
	}
	@GetMapping("/book-car/{id}")
	public CarResponseDTO getBookCar(@PathVariable Integer id) {
		return book_now_Service.getCar(id);
	}

}
