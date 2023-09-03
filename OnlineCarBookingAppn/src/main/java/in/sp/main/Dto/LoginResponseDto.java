package in.sp.main.Dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
	
	private int id;
	private String fname;
	private String lname;
	private LocalDate dob;
	private String email;

}
