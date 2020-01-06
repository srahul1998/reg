/**
 * @author pathuris
 *
 */

package com.dmv.demo.responses.response;

public class ErrorResponse {

	private String errorcode;
	private String errorDesc;
	
	public String getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
}
