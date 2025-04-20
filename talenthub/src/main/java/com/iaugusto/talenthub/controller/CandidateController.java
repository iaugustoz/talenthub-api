package com.iaugusto.talenthub.controller;

import com.iaugusto.talenthub.controller.docs.CandidateControllerDocs;
import com.iaugusto.talenthub.model.dto.CandidateDTO;
import com.iaugusto.talenthub.model.entities.Candidate;
import com.iaugusto.talenthub.repository.CandidateRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController implements CandidateControllerDocs {

    private final CandidateRepository candidateRepository;

    private final ModelMapper modelMapper;

    public CandidateController(CandidateRepository candidateRepository, ModelMapper modelMapper) {
        this.candidateRepository = candidateRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/")
    public ResponseEntity<Candidate> registerUser(@Valid @RequestBody CandidateDTO dto) {
        Candidate newCandidate = modelMapper.map(dto, Candidate.class);

        this.candidateRepository.save(newCandidate);

        return ResponseEntity.status(201).body(newCandidate);
    }
}
