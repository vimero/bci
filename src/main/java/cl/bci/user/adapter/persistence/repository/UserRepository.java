package cl.bci.user.adapter.persistence.repository;

import cl.bci.user.adapter.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

        UserEntity findByEmail(String email);

}
