package in.sp.main.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequestDto {

	@Email(message = "Email id is invalid")
	@NotBlank(message = "Email address should not be blank")
	private String email;
	private String password;

}
