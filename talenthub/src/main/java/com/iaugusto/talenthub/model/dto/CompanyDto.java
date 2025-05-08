package com.iaugusto.talenthub.model.dto;

public record CompanyDto(
        String  name,
        String username,
        String email,
        String password,
        String website,
        String description
) {
}
