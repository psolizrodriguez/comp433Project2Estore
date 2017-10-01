package com.ebook.common.dao;

import java.io.Serializable;



public class ApplicationException extends RuntimeException {


	private static final long serialVersionUID = 4861395186424691374L;

	private static final String DEFAULT_ERROR_CODE = "error.technical.application";

	private String errorCode;


	public ApplicationException(final Throwable error) {
		this(null, error, null, null);
	}


	public ApplicationException(final String msg, final String newErrorCode, final Serializable[] args) {
		this(msg, null, newErrorCode, args);
	}

	/**
     * 
     * 
     */
	public ApplicationException(final String msg, final Throwable error) {
		this(msg, error, null, null);
	}


	public ApplicationException(final String msg, final String newErrorCode) {
		this(msg, null, newErrorCode, null);
	}


	public ApplicationException(final Throwable error, final String newErrorCode) {
		this(null, error, newErrorCode, null);
	}


	public ApplicationException(final String msg) {
		this(msg, null, null, null);
	}


	public ApplicationException() {
		this(null, null, null, null);
	}

	public ApplicationException(final String msg, final Throwable error, final String newErrorCode, final Serializable[] args) {

		super(msg, error);
		this.errorCode = newErrorCode;
	}


	public String getErrorCode() {
		return this.errorCode;
	}


	public String setErrorCode() {
		return DEFAULT_ERROR_CODE;
	}
}
