package com.iaugusto.talenthub.model.dto;

public record CandidateDTO(
        String name,
        String username,
        String email,
        String password,
        String description,
        String curriculum
        ) {
}
