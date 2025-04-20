package com.iaugusto.talenthub.controller;

import com.iaugusto.talenthub.controller.docs.CandidateControllerDocs;
import com.iaugusto.talenthub.model.dto.CandidateDTO;
import com.iaugusto.talenthub.model.entities.Candidate;
import com.iaugusto.talenthub.service.CandidateService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController implements CandidateControllerDocs {

    private final CandidateService candidateService;

    public CandidateController(CandidateService service) {
        this.candidateService = service;
    }

    @PostMapping("/")
    public ResponseEntity<Candidate> registerUser(@Valid @RequestBody CandidateDTO dto) {
        Candidate newCandidate = candidateService.createUser(dto);

        return ResponseEntity.status(201).body(newCandidate);
    }
}
