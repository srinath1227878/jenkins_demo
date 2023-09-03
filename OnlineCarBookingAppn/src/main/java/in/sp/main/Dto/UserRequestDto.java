package in.sp.main.Dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class UserRequestDto {
	
	private int id;
	private String fname;
	private String lname;
	private LocalDate dob;
	private String email;
	private String password;
	

}
