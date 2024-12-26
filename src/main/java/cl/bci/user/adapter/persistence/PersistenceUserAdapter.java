package cl.bci.user.adapter.persistence;

import cl.bci.user.application.model.UserRequest;
import cl.bci.user.application.port.PersistenceUserPort;
import org.springframework.stereotype.Service;

@Service
public class PersistenceUserAdapter implements PersistenceUserPort {

    @Override
    public void save(UserRequest request) {

    }

}
