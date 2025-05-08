package com.iaugusto.talenthub.service;

import com.iaugusto.talenthub.exceptions.ExistingUserException;
import com.iaugusto.talenthub.model.dto.CompanyDto;
import com.iaugusto.talenthub.model.entities.Candidate;
import com.iaugusto.talenthub.model.entities.Company;
import com.iaugusto.talenthub.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository repository) {
        this.companyRepository = repository;
    }

    public Company registerCompany(CompanyDto dto) {
        this.companyRepository.findByUsernameOrEmail(dto.username(), dto.email())
                .ifPresent((company -> {
                    throw new ExistingUserException();
                }));

        Company company =  new Company();
        BeanUtils.copyProperties(dto, company, "id", "createdAt");

        log.info("Usuário {} criado com sucesso.", company.getEmail());

        return companyRepository.save(company);
    }
}
