package com.example.ToDoAppPost.Exceptions;

public enum ErrorCode {
    unknown(400),
    validation(422),
    unauthorized(401),
    resource_missing(404),
    account_already_exists(409),
    account_missing(404),
    password_mismatch(409),
    account_already_verified(403),
    account_not_verified(403);

    private final int httpCode;

    ErrorCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public int getHttpCode() { return httpCode; }
}
