package com.bill.eshop.inventory.vo;

/**
 * 请求响应
 * @author seabreeze
 *
 */
public class Response {

	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
	
	private String status;
	private String message;
	
	public Response(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
