package id.ekky.myanimelist.configurations;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfiguration {
    private String title;
    private String description;
    private Contact contact;
    private String version;

    public SwaggerConfiguration() {
        this.title = "MyAnimeList Clone REST API";
        this.description = "REST API untuk Clone MyAnimeList";
        this.contact = new Contact().name("Rezky Putratama Raharjo");
        this.version = "v0.1.0";
    }

    @Bean
    public OpenAPI appDocumentation(){
        var info = new Info()
                .title(title)
                .description(description)
                .contact(contact)
                .version(version);

//        String bearerAuth = "bearerAuth";

//        var securityRequirement = new SecurityRequirement().addList(bearerAuth);
//        var securityScheme = new SecurityScheme()
//                .name(bearerAuth)
//                .type(SecurityScheme.Type.HTTP)
//                .scheme("Bearer")
//                .bearerFormat("JWT");
//        var securitySchemes = new Components().addSecuritySchemes(bearerAuth, securityScheme);

        return new OpenAPI().info(info);
//                .addSecurityItem(securityRequirement)
//                .components(securitySchemes);
    }
}
