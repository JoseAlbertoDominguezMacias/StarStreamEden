package es.dsw.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainTextPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        // Retorna la contraseña tal cual está
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // Compara la contraseña en texto plano directamente
        return rawPassword.toString().equals(encodedPassword);
    }
}