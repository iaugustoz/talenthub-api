package com.iaugusto.talenthub.service;

import com.iaugusto.talenthub.exceptions.ExistingUserException;
import com.iaugusto.talenthub.model.dto.CandidateDTO;
import com.iaugusto.talenthub.model.dto.CompanyDto;
import com.iaugusto.talenthub.model.entities.Candidate;
import com.iaugusto.talenthub.model.entities.Company;
import com.iaugusto.talenthub.repository.CandidateRepository;
import com.iaugusto.talenthub.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CandidateServiceTest {

    @Mock
    private CandidateRepository repository;

    private CandidateService candidateService;

    @BeforeEach
    void setUp() {
        candidateService = new CandidateService(repository);
    }

    @Test
    @DisplayName("Deve cadastrar um candidato com sucesso")
    void mustRegisterCandidateSuccessfully() {
        CandidateDTO dto = new CandidateDTO(
                "Igor A.",
                "iaugusto",
                "i9@gmail.com",
                "123456",
                "https://google.com",
                "igor.pdf");

        when(repository.findByUsernameOrEmail(anyString(), anyString())).thenReturn(Optional.empty());
        when(repository.save(any())).thenReturn(new Candidate());

        Candidate registeredCompany = candidateService.createUser(dto);

        assertNotNull(registeredCompany);
    }

    @Test
    @DisplayName("Deve lançar exceção quando o candidato já possuir cadastrada")
    void mustThrowExceptionWhenCandidateAlreadyRegistered() {
        CandidateDTO dto = new CandidateDTO(
                "Igor A.",
                "iaugusto",
                "i9@gmail.com",
                "123456",
                "https://google.com",
                "descrição hipotética");

        when(repository.findByUsernameOrEmail(anyString(), anyString())).thenReturn(Optional.of(new Candidate()));

        assertThrows(ExistingUserException.class,
                () -> candidateService.createUser(dto)
        );
    }
}

