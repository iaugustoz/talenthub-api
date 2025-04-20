package com.iaugusto.talenthub.service;

import com.iaugusto.talenthub.model.dto.CandidateDTO;
import com.iaugusto.talenthub.model.entities.Candidate;
import com.iaugusto.talenthub.repository.CandidateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;


    public CandidateService(CandidateRepository repository) {
        this.candidateRepository = repository;
    }

    public Candidate createUser(CandidateDTO dto) {
        Candidate candidate =  new Candidate();
        BeanUtils.copyProperties(dto, candidate, "id", "createdAt");

        log.info("Usuário {} criado com sucesso.", candidate.getEmail());

        return candidateRepository.save(candidate);
    }
}
