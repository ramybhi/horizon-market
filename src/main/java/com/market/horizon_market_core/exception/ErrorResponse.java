package com.market.horizon_market_core.exception;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private LocalDateTime timeStamp;
    private int status;
    private String error;
    private String message;

    public ErrorResponse(int status, String error, String message) {
        this.timeStamp = LocalDateTime.now();
        this.error = error;
        this.status = status;
        this.message = message;
    }

}
