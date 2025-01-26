package A13.BADA.SalonSamochodowy;

import A13.BADA.SalonSamochodowy.service.CustomUserDetailsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

@Configuration
public class WebSecurityConfig {


    private final CustomUserDetailsService userDetailsService;

    public WebSecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/main").permitAll()
                        .requestMatchers("/static/**", "/images/**").permitAll()
                        .requestMatchers("/mechanic/**").hasRole("MECHANIC")
                        .requestMatchers("/wmanager/**").hasRole("WMANAGER")
                        .requestMatchers("/smanager/**").hasRole("SMANAGER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
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
                    } else if (role.equals("ROLE_ADMIN")) {
                        response.sendRedirect("/admin/home");
                    }
                }

                // Domyślne przekierowanie
                response.sendRedirect("/");
            }
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
