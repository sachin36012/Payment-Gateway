package com.payment.dto;

public class ResetPasswordResponse {
    private String message;

    public ResetPasswordResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
