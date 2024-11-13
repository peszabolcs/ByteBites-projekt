package hu.university.etelprojekt.etelprojekt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("hu.university.etelprojekt.etelprojekt.repository")
@EntityScan("hu.university.etelprojekt.etelprojekt.entity")
public class EtelProjektApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtelProjektApplication.class, args);
	}

}
