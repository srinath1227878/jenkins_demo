package in.sp.main;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@SpringBootApplication
public class OnlineCarBookingAppnApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineCarBookingAppnApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new  ModelMapper();
		//SimpleJpaRepository
	}
}
