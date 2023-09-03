package in.sp.main.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.Dto.LoginRequestDto;
import in.sp.main.Dto.LoginResponseDto;
import in.sp.main.Dto.UserRequestDto;
import in.sp.main.Dto.UserResponseDto;
import in.sp.main.Entity.User;
import in.sp.main.Services.UserService;

@RestController
@RequestMapping("/user")
public class MyUserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/userInfo")
	public String userInsertion(@RequestBody UserRequestDto userRequestDto) {
		 return userService.userDataInsert(userRequestDto);
	}
	
	@GetMapping("/AllUser")
	public List<UserResponseDto> userInformation() {
		return userService.showuserInfo();
	}
	
@GetMapping("/login")
	public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequestDto){
		return new ResponseEntity<LoginResponseDto>(userService.loginUser(loginRequestDto),HttpStatus.OK);
		
		
	}
}
