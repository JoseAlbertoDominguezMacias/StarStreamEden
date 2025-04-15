package es.dsw.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import es.dsw.services.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig {

    private final AuthenticationSuccessHandler customAuthenticationSuccessHandler;

    public SecurityConfig(CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // 🚨 Solo para pruebas. No en producción.
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/index", "/login", "/register", "/style/**", "/js/*", "/images/**").permitAll()
                .requestMatchers("/home").hasAnyRole("user", "jugador", "admin")
                .requestMatchers("/juego", "/asignarFlota").hasRole("jugador")
                .requestMatchers("/admin", "/usuarios", "/flotas", "/tripulaciones", "misiones").hasRole("admin")
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage("/login")
                .successHandler(customAuthenticationSuccessHandler)
                .failureUrl("/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }
		/*
		http
		.csrf().disable()
        .authorizeHttpRequests(auth -> auth
        	
            .requestMatchers("/", "/index","/login", "home", "juego", "panelAdmin", "/register", "/style/**", "/js/*", "/images/**").permitAll()
            .requestMatchers("/home").hasAnyRole("ADMIN", "USER", "JUGADOR")
	            .requestMatchers("/admin/**").hasRole("ADMIN")  
	            .requestMatchers("/jugador/**").hasRole("JUGADOR")  
	            .requestMatchers("/usuario/**").hasAnyRole("USER", "JUGADOR")  
	            .anyRequest().authenticated()
	        )
        .formLogin(login -> login
                .loginPage("/login")
                .usernameParameter("alias") // Aquí aseguramos que alias sea tratado como username
                .passwordParameter("contraseña") 
                .defaultSuccessUrl("/home", true)
                .permitAll()
            )
            
	        .logout(logout -> logout
	            .logoutUrl("/logout")
	            .logoutSuccessUrl("/index")
	            .invalidateHttpSession(true)
	            .deleteCookies("JSESSIONID")
	            .permitAll()
	        );

	    return http.build();
	    */
    
    @Bean
    public UserDetailsService userDetailsService() {
    	return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        String idForEncode = "sha256"; 
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        
        encoders.put("sha256", new MessageDigestPasswordEncoder("SHA-256"));
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        
        return new DelegatingPasswordEncoder(idForEncode, encoders);
    }
    }

