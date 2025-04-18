package es.dsw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="es.dsw")
//@ComponentScan(basePackages="es.dsw")
//@EnableJpaRepositories(basePackages = "es.dsw.repositories")
//@EntityScan(basePackages = "es.dsw.models") // 🔹 Agregar esta línea para escanear entidades JPA
//@SpringBootApplication
public class StarStreamEdenApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarStreamEdenApplication.class, args);
	}

}
