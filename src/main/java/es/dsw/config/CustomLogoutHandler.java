package es.dsw.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomLogoutHandler implements LogoutHandler {

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // Eliminar la cookie de "lastAccess"
    	 // Obtener la fecha y hora actual
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = now.format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH:mm:ss"));
        
        
        // Crear una cookie para el último acceso
        Cookie lastAccessCookie = new Cookie("lastAccess",formattedDate);
        lastAccessCookie.setMaxAge(60 * 60 * 24 * 7); // La cookie dura 30 día
        lastAccessCookie.setPath("/"); // La cookie estará disponible en toda la aplicación
        response.addCookie(lastAccessCookie);
    }
    
    

}

