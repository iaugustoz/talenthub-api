package com.iaugusto.talenthub.controller.docs;

import com.iaugusto.talenthub.model.dto.CandidateDTO;
import com.iaugusto.talenthub.model.entities.Candidate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Candidatos", description = "Endpoint para gerenciamento de candidatos")
public interface CandidateControllerDocs {

    @Operation(
            summary = "Cadastrar um novo usuário",
            description = "Cria um novo usuário no banco de dados",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Candidato cadastrado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Dados inválidos"
                    )
            }
    )
    ResponseEntity<Candidate> registerUser(CandidateDTO dto);
}
