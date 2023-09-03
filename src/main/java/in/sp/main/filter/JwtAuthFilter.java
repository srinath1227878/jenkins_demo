package in.sp.main.filter;


import in.sp.main.Services.JwtService;
import in.sp.main.config.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization"); //Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzb3VyYWJoQGdtYWlsLmNvbSIsImlhdCI6MTY4ODQwNDk1MiwiZXhwIjoxNjg4NDA2NzUyfQ.Pr9H7mHFGXFvH5AFvg943IlDjhvFijK8cb-lgVwRX7o
        String token = null;
        String username = null;

        System.out.println("doFilterInternal");
        if(authHeader!=null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
            System.out.println(token+" "+username);
        }

        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
            System.out.println("$$ userDetails ");
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            System.out.println("$$ userdetails "+userDetails);
            if(jwtService.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
//        System.out.println("doFilter Internal end");
        filterChain.doFilter(request, response);

    }
}
