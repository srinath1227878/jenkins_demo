package in.sp.main.Convertor;

import org.springframework.stereotype.Component;

import in.sp.main.Dto.UserRequestDto;
import in.sp.main.Entity.User;

@Component
public class UserConvertor1 {
	public User dtoToEntity(UserRequestDto userRequestDto) {
		
		User user = new User();
		user.setId(userRequestDto.getId());
		user.setFname(userRequestDto.getFname());
		user.setLname(userRequestDto.getLname());
		user.setDob(userRequestDto.getDob());
		user.setEmail(userRequestDto.getEmail());
		user.setPassword(userRequestDto.getPassword());
		return user;
	}

}
