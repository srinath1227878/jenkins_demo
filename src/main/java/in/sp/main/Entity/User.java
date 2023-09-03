package in.sp.main.Entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fname;
	private String lname;
	private LocalDate dob;
	@Column(unique = true)
	private String email;
	private String password;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("getAuthorities");

		SimpleGrantedAuthority simpleGrantedAuthority= new SimpleGrantedAuthority(getUsername());
		return List.of(simpleGrantedAuthority);
	}

	/*@Override
	public String getPassword() {
		System.out.println("getPassword");
		return this.password( );
	}
*/
	@Override
	public String getUsername() {
		System.out.println("getUsername");

		return this.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		System.out.println("isAccountNonExpired");

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		System.out.println("isAccountNonLocked");

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		System.out.println("isCredentialsNonExpired");

		return true;
	}

	@Override
	public boolean isEnabled() {
		System.out.println("isEnabled");

		return true;
	}

}
