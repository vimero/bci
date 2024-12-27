package cl.bci.user.adapter.rest;

import cl.bci.user.application.api.DefaultApi;
import cl.bci.user.application.model.CrearUsuarioRequest;
import cl.bci.user.application.model.UserResponse;
import cl.bci.user.application.usecase.CreateUserUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
public class UserRest implements DefaultApi {

    private CreateUserUseCase createUserUseCase;

    @Override
    public ResponseEntity<UserResponse> crearUsuario(CrearUsuarioRequest crearUsuarioRequest) {
        return ResponseEntity.ofNullable(createUserUseCase.create(crearUsuarioRequest.getUser()));
    }

}
