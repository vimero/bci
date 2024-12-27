package cl.bci.user.adapter.rest;

import cl.bci.user.application.exception.BusinessException;
import cl.bci.user.application.model.ErrorResponse;
import cl.bci.user.application.model.UserRequest;
import cl.bci.user.application.model.UserResponse;
import cl.bci.user.application.usecase.CreateUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
public class UserRest {

    private CreateUserUseCase createUserUseCase;

    @Operation(
            operationId = "crearUsuario",
            summary = "Crear un nuevo usuario",
            description = "Permite crear un usuario con información básica y sus teléfonos.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida.", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/usuarios",
            produces = { "application/json" },
            consumes = { "application/json" }
    )

    public ResponseEntity<UserResponse> crearUsuario(@Valid @RequestBody UserRequest request) throws BusinessException{
        return ResponseEntity.ofNullable(createUserUseCase.create(request));
    }

}
