package dev.zotta.thankful_messages.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Challenge Mensajes de gratitud API")
            .version("1.0.0")
            .description(
                "La API de mensajes de gratitud permite a los usuarios crear, listar y votar mensajes de gratitud. Los mensajes de gratitud son una forma de expresar agradecimiento y positividad dentro de una comunidad como la AlumniONE.")
            .contact(new Contact()
                .name("Zotta")
                .email("frikilinux@gmail.com"))
            .license(new License()
                .name("GPL 3.0")
                .url("https://www.gnu.org/licenses/gpl-3.0.en.html")));
  }
}
