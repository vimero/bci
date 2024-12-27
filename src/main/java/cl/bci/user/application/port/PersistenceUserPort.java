package cl.bci.user.application.port;

import cl.bci.user.application.exception.BusinessException;
import cl.bci.user.application.model.UserRequest;
import cl.bci.user.application.model.UserResponse;

public interface PersistenceUserPort {

    UserResponse save(UserRequest request) throws BusinessException;

}
