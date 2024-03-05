package pt.gladlyGivenApi.GladlyGiven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
@EnableTransactionManagement
@EnableAutoConfiguration
public class GladlyGivenApplication {

	public static void main(String[] args) {
		SpringApplication.run(GladlyGivenApplication.class, args);
	}
}
