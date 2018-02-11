package wromaciej.moviesrental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class MoviesRentalApplication  {


	public static void main(String[] args) {

		SpringApplication.run(MoviesRentalApplication.class, args);
	}
}
