package com.jp.party_ticket_api.exception;

public class DataException extends RuntimeException{
	
	public DataException(){
	    super("Só é permitido colocar datas que sejam a partir de hoje.");
	}
}
