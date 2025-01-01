package tn.springboot.bitshest;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;

@SpringBootApplication
@EnableScheduling
public class BitshestApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(BitshestApplication.class);
		app.setBannerMode(Banner.Mode.OFF); 

		
		app.addListeners((ApplicationListener<ApplicationReadyEvent>) event -> {
			System.out.println("🚀 L'application a démarré avec succès !");
		});

		
		app.addListeners((ApplicationListener<ApplicationFailedEvent>) event -> {
			System.err.println("❌ Échec du démarrage de l'application !");
			Throwable cause = event.getException(); 
			cause.printStackTrace();
		});

		app.run(args); 
	}
}
