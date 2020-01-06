/**
 * @author pathuris
 *
 */

package com.dmv.demo.responses.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@SuppressWarnings("serial")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageResponse<T extends Object> implements Serializable {
	
	private int statusCode ;
	private String statusDesc ;
	private Date timestamp;
	private String message;
	private String details;
	private T data;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private ArrayList<ErrorResponse> errorsList=null;
	@SuppressWarnings("unused")
	private List<String> errors = null;
	
	public MessageResponse() {
		
	}
	
	public MessageResponse(APIStatus apiStatus, T data) {

        if (apiStatus == null) {
            throw new IllegalArgumentException("APIStatus must not be null");
        }

        this.statusCode = apiStatus.getCode();
        this.message = apiStatus.getDescription();
        this.data = data;
    }

	
	public MessageResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public MessageResponse(Date timestamp, String message, String details,int statusCode ) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.statusCode = statusCode;
	}
	
	public MessageResponse(Date timestamp, String message, String details,ArrayList<ErrorResponse> errorsList,int statusCode,String statusDesc ) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.errorsList = errorsList;
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
	}
	
	public MessageResponse(Date timestamp, String message, String details,List<String> errors,int statusCode ) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		this.errors = errors;
		this.statusCode = statusCode;
	}
	
	public MessageResponse(ArrayList<ErrorResponse> errorsList ) {
		super();
		this.errorsList = errorsList;
		
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	public ArrayList<ErrorResponse> getErrorsList() {
		return errorsList;
	}
	public void setErrors(ArrayList<ErrorResponse> errorsList) {
		this.errorsList = errorsList;
	}
	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
