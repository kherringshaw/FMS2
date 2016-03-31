package com.fms2.model;

public class Tenant extends Person {

	private String type;
	public Tenant (int id) {
		super(id);
		type = "owner";

	}

}
