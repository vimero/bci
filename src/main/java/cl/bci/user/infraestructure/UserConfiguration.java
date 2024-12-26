package cl.bci.user.infraestructure;


import cl.bci.user.application.port.PersistenceUserPort;
import cl.bci.user.application.usecase.CreateUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    CreateUserUseCase createProductUseCase(PersistenceUserPort persistenceProductPort){
        return new CreateUserUseCase(persistenceProductPort);
    }

}
