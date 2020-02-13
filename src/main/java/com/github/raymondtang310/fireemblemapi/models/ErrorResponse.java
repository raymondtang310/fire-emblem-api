package com.github.raymondtang310.fireemblemapi.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private int status;
    private String statusText;
    private String code;
    private String message;

    /**
     * Initializes a new {@link ErrorResponse} instance with the specified {@link HttpStatus} and message.
     *
     * @since 1.0.0
     */
    public ErrorResponse(HttpStatus httpStatus, String code, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = httpStatus.value();
        this.statusText = httpStatus.getReasonPhrase();
        this.code = code;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusText() {
        return statusText;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
