package cl.bci.user.adapter.persistence;

import cl.bci.user.adapter.mapper.UserMapper;
import cl.bci.user.adapter.persistence.entity.UserEntity;
import cl.bci.user.adapter.persistence.repository.UserRepository;
import cl.bci.user.application.model.UserRequest;
import cl.bci.user.application.model.UserResponse;
import cl.bci.user.application.port.PersistenceUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersistenceUserAdapter implements PersistenceUserPort {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserResponse save(UserRequest request) {
        UserEntity entity = userMapper.toEntity(request);
        entity.setId(UUID.randomUUID());
        entity = userRepository.save(entity);

        return null;
    }

}
