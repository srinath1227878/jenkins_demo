package in.sp.main.Controllers;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.Dto.LoginRequestDto;
import in.sp.main.Dto.LoginResponseDto;
import in.sp.main.Dto.UserRequestDto;
import in.sp.main.Dto.UserResponseDto;
import in.sp.main.Services.UserService;

@RestController
@RequestMapping("/user")
public class MyUserController {
	
	@Autowired
	UserService userService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/register")
	public String userInsertion(@Valid @RequestBody UserRequestDto userRequestDto) {
		userRequestDto.setPassword(bCryptPasswordEncoder.encode(userRequestDto.getPassword()));

		 return userService.userDataInsert(userRequestDto);
	}
	
	@GetMapping("/AllUser")
	public List<UserResponseDto> userInformation() {
		return userService.showuserInfo();
	}

	@PostMapping("/login1")
	public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto){
		return new ResponseEntity<LoginResponseDto>(userService.loginUser(loginRequestDto),HttpStatus.OK);

	}
	@PostMapping("/login")
	ResponseEntity<LoginResponseDto> loginAndAuthenticate(@Valid @RequestBody LoginRequestDto loginDto){
		LoginResponseDto loginRespDto = this.userService.loginAndAuthenticate(loginDto);
		return new ResponseEntity(loginRespDto,HttpStatus.CREATED);
	}
}
