package cl.bci.user.application.usecase;


import cl.bci.user.application.exception.BusinessException;
import cl.bci.user.application.model.UserRequest;
import cl.bci.user.application.model.UserResponse;
import cl.bci.user.application.port.PersistenceUserPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateUserUseCase {

    private final PersistenceUserPort persistenceProductPort;

    public UserResponse create(UserRequest request) throws BusinessException {
        return persistenceProductPort.save(request);
    }

}
