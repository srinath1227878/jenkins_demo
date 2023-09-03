package in.sp.main.Services;

import java.util.List;
import java.util.stream.Collectors;

import in.sp.main.Dto.CarResponseDTO;
import in.sp.main.Dto.DriverResponseDto;
import in.sp.main.Entity.Car;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.Entity.Driver;
import in.sp.main.Repository.DriverRepository;

@Service
public class DriverService {

	@Autowired
	DriverRepository driverRepository;

	@Autowired
	ModelMapper modelMapper;
	
	public String driverData(Driver driver) {
		driverRepository.save(driver);
		return "Driver information inserted successfully";
	}
	
	
	//for getting driver information
	public List<DriverResponseDto> driversInfo(){

		List<Driver> drivers = driverRepository.findAll();
		List<DriverResponseDto> driverResponseDtoList =drivers.stream().map(driver->this.modelMapper.map(driver,DriverResponseDto.class)).collect(Collectors.toList());

		return driverResponseDtoList;
	}

	
}
