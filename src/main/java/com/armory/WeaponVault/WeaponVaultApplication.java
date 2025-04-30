package com.armory.WeaponVault;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.armory.WeaponVault", "org.openapitools.configuration"})
public class WeaponVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeaponVaultApplication.class, args);
	}

}
