package in.sp.main.Dto;


import java.time.LocalDate;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

	private Integer id;
	private String fname;
	private String lname;
	private LocalDate dob;
	private String email;

}
