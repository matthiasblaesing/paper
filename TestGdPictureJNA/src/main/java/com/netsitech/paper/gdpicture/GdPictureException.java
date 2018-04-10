package com.netsitech.paper.gdpicture;

import com.netsitech.paper.gdpicture.enums.GdPictureStatus;

public class GdPictureException extends Exception {

	private static final long serialVersionUID = 70145264731047096L;

	private GdPictureStatus status = null;

	public GdPictureException(int status) {
		super();
		this.status = GdPictureStatus.translate(status);
	}

	public GdPictureException(int status, String userMessage) {
		super(userMessage);
		this.status = GdPictureStatus.translate(status);
	}

	public GdPictureException(GdPictureStatus status) {
		super();
		this.status = status;
	}

	public GdPictureException(GdPictureStatus status, String userMessage) {
		super(userMessage);
		this.status = status;
	}

	public GdPictureStatus getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		String message = super.getMessage();
		return (message != null ? message + " - " : "") + status.toString();
	}

	public String getStatusDescription() {
		return status.getDescription();
	}

}
