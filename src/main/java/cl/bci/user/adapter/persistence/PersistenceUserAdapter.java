package cl.bci.user.adapter.persistence;

import cl.bci.user.adapter.mapper.UserMapper;
import cl.bci.user.adapter.persistence.entity.UserEntity;
import cl.bci.user.adapter.persistence.repository.UserRepository;
import cl.bci.user.application.exception.BusinessException;
import cl.bci.user.application.model.UserRequest;
import cl.bci.user.application.model.UserResponse;
import cl.bci.user.application.port.PersistenceUserPort;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersistenceUserAdapter implements PersistenceUserPort {

    private static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);


    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserResponse save(UserRequest request) throws BusinessException {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new BusinessException("Email already exists");
        } else {
            UserEntity entity = userMapper.toEntity(request);
            entity.setId(UUID.randomUUID());
            entity.setCreated(new Date());
            entity.setIsActive(true);
            entity.setToken(generateToken(entity.getEmail()));
            entity = userRepository.save(entity);
            UserResponse response = userMapper.toUserResponse(entity);
            return response;
        }

    }

    public String generateToken(String subject) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 100000);
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key)
                .compact();
    }

}
