package in.sp.main.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Entity.Car;
import in.sp.main.Repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	CarRepository carRepository;
	
	public String insertCarInfo(Car car) {
		carRepository.save(car);
		
		return "car information inserted successfully.....!";
		
	}
	public List<Car> carDetails(){
		return carRepository.findAll();
	}
	
	public Car findCar(int id) {
		Optional<Car> optional =carRepository.findById(id);
	return optional.get();
	}
}
