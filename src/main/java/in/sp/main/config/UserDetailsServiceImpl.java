package in.sp.main.config;

import in.sp.main.Entity.User;
import in.sp.main.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("loadUserByUsername");
        //fetching user from database
        User user = userRepository.findByEmail(username);

        if(user==null) {
            throw new UsernameNotFoundException("Could not found user !!");
        }

//     CustomUserDetails customUserDetails = new CustomUserDetails(user);

        return user;
    }
}
