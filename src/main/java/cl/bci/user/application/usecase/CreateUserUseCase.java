package cl.bci.user.application.usecase;


import cl.bci.user.application.port.PersistenceUserPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserUseCase {

    private final PersistenceUserPort persistenceProductPort;

}
