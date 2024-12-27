package cl.bci.user.adapter.persistence.repository;

import cl.bci.user.adapter.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

        Optional<UserEntity> findByEmail(String email);

}
