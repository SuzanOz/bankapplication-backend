package com.bank.response;

import lombok.Data;

@Data //@Getter, @Setter ....etc. It is complete package with one annotation. 
public class Response {
	boolean isSuccess;
	String message;
}