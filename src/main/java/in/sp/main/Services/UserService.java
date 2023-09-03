
package in.sp.main.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import in.sp.main.Dto.LoginRequestDto;
import in.sp.main.Dto.LoginResponseDto;
import in.sp.main.Dto.UserRequestDto;
import in.sp.main.Dto.UserResponseDto;
import in.sp.main.Entity.User;
import in.sp.main.Repository.UserRepository;
import in.sp.main.Convertor.UserConvertor1;
@Service
public class UserService  {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserConvertor1 userConvertor;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtService jwtService;
	
	//for the inserting the details of user 
	public String userDataInsert(UserRequestDto userRequestDto) {
	User user = userConvertor.dtoToEntity(userRequestDto);
	userRepository.save(user);
		
		return "user information insertion is completed";
	}
	
	
	//for getting the all information of user without password
	public List<UserResponseDto> showuserInfo(){
	List<User> userList=userRepository.findAll();
	
	List<UserResponseDto> userResList=userList.stream().map(user->this.convertEntityToDto(user)).collect(Collectors.toList());
		
	return userResList;
	}

	
	private UserResponseDto convertEntityToDto(User user)
	{
		UserResponseDto userResponseDto = new UserResponseDto();
		userResponseDto.setId(user.getId());
		userResponseDto.setFname(user.getFname());
		userResponseDto.setLname(user.getLname());
		userResponseDto.setDob(user.getDob());
		userResponseDto.setEmail(user.getEmail());
		return userResponseDto;
		
	}
	
	
	//logic for loginpage
	public LoginResponseDto loginUser(LoginRequestDto loginRequestDto) {
		
	String email=	loginRequestDto.getEmail();
		String password=loginRequestDto.getPassword();
		User user=userRepository.findByEmailAndPassword(email, password);


		LoginResponseDto loginResponseDto = new LoginResponseDto();
	BeanUtils.copyProperties(user, loginResponseDto);
	return loginResponseDto;
	}


	public LoginResponseDto loginAndAuthenticate(LoginRequestDto loginDto) {
		System.out.println("loginAndAuthenticate");
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

		if (authentication.isAuthenticated()) {
			final String token = jwtService.generateToken(loginDto.getEmail());

			User user = userRepository.findByEmail(loginDto.getEmail());

			UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
			LoginResponseDto loginRespDto = new LoginResponseDto();

			loginRespDto.setUserResponseDto(userResponseDto);
			loginRespDto.setAuth(token);

			return loginRespDto;
		}
		else {
			throw new UsernameNotFoundException("invalid user request !");
		}
	}
}
