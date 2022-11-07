package com.devsuperior.movieflix.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.Instant;

public class OAuthError implements Serializable {
    private static final Long serialVersionUID = 1L;

    private String error;
    @JsonProperty("error_description")
    private String errorDescription;

    public OAuthError() {
    }

    public OAuthError(String error, String errorDescription) {
        this.error = error;
        this.errorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
