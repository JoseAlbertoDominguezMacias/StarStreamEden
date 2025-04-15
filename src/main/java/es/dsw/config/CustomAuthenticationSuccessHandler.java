package es.dsw.config;

import java.io.IOException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        // Obtener los roles del usuario autenticado
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Redireccionar según el rol del usuario
        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();
            if (role.equals("ROLE_admin")) {
                response.sendRedirect("/admin");
                return;
            } else if (role.equals("ROLE_user")) {
                response.sendRedirect("/home");
                return;
            } else if (role.equals("ROLE_jugador")) {
                response.sendRedirect("/juego");
                return;
            }
        }
        // Si no tiene un rol específico, redirigir a home por defecto
        response.sendRedirect("/home");
    }
}