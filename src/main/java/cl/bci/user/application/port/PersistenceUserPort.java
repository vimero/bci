package cl.bci.user.application.port;

import cl.bci.user.application.model.UserRequest;

public interface PersistenceUserPort {

    void save(UserRequest request);
}
