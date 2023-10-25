package config;

import component.ContactInitializer;
import component.FileSaver;
import component.InitContactsInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-init.yaml")
@Profile("init")
public class InitAppConfig {

	@Bean
	public FileSaver fileSaver() {
		return new FileSaver();
	}

	@Bean
	public ContactInitializer contactInitializer() {
		return new InitContactsInitializer();
	}
}
