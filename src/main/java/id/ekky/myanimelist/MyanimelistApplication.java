package id.ekky.myanimelist;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyanimelistApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		dotenv.entries().forEach(entry -> {
			System.setProperty(entry.getKey(), entry.getValue());
			System.out.println("Setting property: " + entry.getKey() + "=" + entry.getValue());  // Add this line for logging
		});

		SpringApplication.run(MyanimelistApplication.class, args);
	}

}
