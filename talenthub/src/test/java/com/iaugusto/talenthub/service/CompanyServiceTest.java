package com.iaugusto.talenthub.service;

import com.iaugusto.talenthub.exceptions.ExistingUserException;
import com.iaugusto.talenthub.model.dto.CompanyDto;
import com.iaugusto.talenthub.model.entities.Company;
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
public class CompanyServiceTest {

    @Mock
    private CompanyRepository repository;

    private CompanyService companyService;

    @BeforeEach
    void setUp() {
        companyService = new CompanyService(repository);
    }

    @Test
    @DisplayName("Deve cadastrar uma empresa com sucesso")
    void mustRegisterCompanySuccessfully() {
        CompanyDto dto = new CompanyDto(
                "Igor A.",
                "iaugusto",
                "i9@gmail.com",
                "123456",
                "https://google.com",
                "descrição hipotética");

        when(repository.findByUsernameOrEmail(anyString(), anyString())).thenReturn(Optional.empty());
        when(repository.save(any())).thenReturn(new Company());

        Company registeredCompany = companyService.registerCompany(dto);

        assertNotNull(registeredCompany);
    }

    @Test
    @DisplayName("Deve lançar exceção quando a empresa já estiver cadastrada")
    void mustThrowExceptionWhenCompanyAlreadyRegistered() {
        CompanyDto dto = new CompanyDto(
                "Igor A.",
                "iaugusto",
                "i9@gmail.com",
                "123456",
                "https://google.com",
                "descrição hipotética");

        when(repository.findByUsernameOrEmail(anyString(), anyString())).thenReturn(Optional.of(new Company()));

        assertThrows(ExistingUserException.class,
                () -> companyService.registerCompany(dto)
        );
    }
}

