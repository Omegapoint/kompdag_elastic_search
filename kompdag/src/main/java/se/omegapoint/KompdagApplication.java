package se.omegapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import se.omegapoint.repositories.ArticleRepository;
import se.omegapoint.repositories.BrandRepository;

/***
 * DB-settings:
 *
 * HOST: ec2-52-91-135-230.compute-1.amazonaws.com
 *
 */

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {ArticleRepository.class, BrandRepository.class})
@EnableScheduling
public class KompdagApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(KompdagApplication.class);
        springApplication.run(args);

    }
}