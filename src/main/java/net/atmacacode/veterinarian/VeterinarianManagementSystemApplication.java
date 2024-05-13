package net.atmacacode.veterinarian;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Veteriner Yönetim Sistemi", version = "1.0.0", description = "Veteriner yönetim sistemi"))
public class VeterinarianManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(VeterinarianManagementSystemApplication.class, args);
    }

}
