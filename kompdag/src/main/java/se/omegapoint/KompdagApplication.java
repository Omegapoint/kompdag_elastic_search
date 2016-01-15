package se.omegapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import se.omegapoint.repositories.ArticleRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {ArticleRepository.class})
@EnableScheduling
public class KompdagApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(KompdagApplication.class);
        springApplication.run(args);
    }
}