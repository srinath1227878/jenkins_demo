package in.sp.main.Services;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import in.sp.main.Dto.CarResponseDTO;
import in.sp.main.Dto.UserResponseDto;
import in.sp.main.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Entity.Car;
import in.sp.main.Repository.CarRepository;

@Service
public class CarService
{
	@Autowired
	CarRepository carRepository;

	@Autowired
	ModelMapper modelMapper;
	
	public String insertCarInfo(Car car) {
		carRepository.save(car);
		
		return "car information inserted successfully.....!";
		
	}
	public List<CarResponseDTO> carDetails()
	{
		List<Car> cars = carRepository.findAll();
		List<CarResponseDTO> carResponseDTOList=cars.stream().map(car->this.modelMapper.map(car,CarResponseDTO.class)).collect(Collectors.toList());

		return carResponseDTOList;
	}

	public Car findCar(int id) {
	Car car=carRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Car","carid",id));
	return car;
	}
}
