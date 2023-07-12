package com.example.HumanResourceApp.Exception;

public class ErrorResponse {

	private String timeStamp;
	private String message;
	public ErrorResponse() {
	}
	public ErrorResponse(String tStamp, String message) {
		super();
		this.message = message;
		this.timeStamp = tStamp;
	}
	public String getmessage() {
		return message;
	}
	public void setmessage(String message) {
		this.message = message;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
}
