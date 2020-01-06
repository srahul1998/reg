/**
 * @author pathuris
 *
 */

package com.dmv.demo.responses.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	private MessageResponse _createSSOResponse(APIStatus apiStatus, Object data) {
        return new MessageResponse(apiStatus, data);
    }

    // base method
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity<MessageResponse> buildResponse(APIStatus apiStatus, Object data, HttpStatus httpStatus) {
        return new ResponseEntity(_createSSOResponse(apiStatus, data), httpStatus);
    }

    @SuppressWarnings("rawtypes")
	public ResponseEntity<MessageResponse> successResponse(Object data) {
        return buildResponse(APIStatus.OK, data, HttpStatus.OK);
    }
    
    @SuppressWarnings("rawtypes")
	public ResponseEntity<MessageResponse> failureResponse(Object data) {
        return buildResponse(APIStatus.INTERNAL_SERVER_ERROR, data, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
