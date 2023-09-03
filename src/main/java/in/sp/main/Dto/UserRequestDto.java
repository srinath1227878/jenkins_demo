package in.sp.main.Dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class UserRequestDto {
	
	private Integer id;
	private String fname;
	private String lname;
	private LocalDate dob;
	@Email(message = "Invalid Email Id not Found")
	@NotBlank(message = "Email address should not be blank")
	private String email;
	private String password;
	

}
