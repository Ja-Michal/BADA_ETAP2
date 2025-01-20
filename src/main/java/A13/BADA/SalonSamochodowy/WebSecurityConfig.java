package A13.BADA.SalonSamochodowy;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/main").permitAll()
                        .requestMatchers("/mechanic/**").hasRole("MECHANIC")
                        .requestMatchers("/wmanager/**").hasRole("WMANAGER")
                        .requestMatchers("/smanager/**").hasRole("SMANAGER")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Strona logowania
                        .failureUrl("/login?error=true") // Przekierowanie w przypadku błędu
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public AuthenticationSuccessHandler customSuccessHandler() {
        return new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                // Pobierz role użytkownika
                Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

                for (GrantedAuthority authority : authorities) {
                    String role = authority.getAuthority();

                    if (role.equals("ROLE_MECHANIC")) {
                        response.sendRedirect("/mechanic/home");
                        return;
                    } else if (role.equals("ROLE_WMANAGER")) {
                        response.sendRedirect("/wmanager/home");
                        return;
                    } else if (role.equals("ROLE_SMANAGER")) {
                        response.sendRedirect("/smanager/home");
                        return;
                    }
                }

                // Domyślne przekierowanie
                response.sendRedirect("/");
            }
        };
    }
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails m1 =
                User.builder()
                        .username("m1")
                        .password(passwordEncoder.encode("m1")) // Kodowanie hasła
                        .roles("MECHANIC")
                        .build();

        UserDetails wmanager =
                User.builder()
                        .username("wmanager")
                        .password(passwordEncoder.encode("wmanager")) // Kodowanie hasła
                        .roles("WMANAGER")
                        .build();

        UserDetails smanager =
                User.builder()
                        .username("smanager")
                        .password(passwordEncoder.encode("smanager")) // Kodowanie hasła
                        .roles("SMANAGER")
                        .build();

        return new InMemoryUserDetailsManager(m1, wmanager, smanager);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
