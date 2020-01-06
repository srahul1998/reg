/**
 * @author pathuris
 *
 */

package com.dmv.demo.responses.response;

public enum APIStatus {

    INVALID_DATA(100, "Input data is not valid."),
    USER_NOT_EXIST(110, "User does not exist"),
    USER_NOT_VALID(111, "User name or password is not correct"),
   
    ORDER_NOT_EXIST(112, "Order does not exist"),
    
    USER_PENDING_STATUS(113, "User have not activated"),
    UNAUTHORIZED(401, "Unauthorized or Access Token is expired"),
    PERMISSION_DENIED(402, "Access Permission denied"),
    EXPIRED(409, "Email Token is Expired"),
    NOT_VERIFIED(410, "Not Verified"),
    LIMIT_EXCEEDED(411, "Limit Exceeded. Please Contact our Customer Support."),
    MISMATCH_OTP(412, "Wrong OTP"),
    ALREADY_VERIFIED(413, "Already Verified"),
    TOKEN_NOT_EXISTED(414, "Token Not Existed"),
    MISMATCH_PASSWORD(415, "Old Password doesn't match"),
    
    // Common status
    OK(200, "OK"),
    CREATED(201, "Created"),
    NO_CONTENT(204, "No Content"),
    NOT_FOUND(404, "Not Found"),
    ALREADY_EXIST(208, "Already exist"),
    INTERNAL_SERVER_ERROR(500, "Internal Error"),
    SQL_ERROR(501, "SQL Error"),
    BAD_REQUEST(400, "Bad request"),    
    SESSION_DATA_INVALID(603, "Session data invalid"),
    SESSION_NOT_FOUND(604, "Session not found"),
    
    // File upload error
    ERR_UPLOAD_FILE(900, "Upload file error."),
    
    //User status
    
    USER_ADDRESS_NOT_FOUND(405, "User Address Not Found"),
    MISSING_PASSWORD(407, "Missing new password"),
    UNCORRECT_PASSWORD(408, "Your old password is uncorrect");
    
    
    private final int code;
    private final String description;

    private APIStatus(int s, String v) {
        code = s;
        description = v;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
