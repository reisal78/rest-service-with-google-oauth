package ru.reisal7i.rest.config.oauth;

public interface AccessTokenValidator {
    AccessTokenValidationResult validate(String accessToken);
}
