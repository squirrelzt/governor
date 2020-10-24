package com.governer.service.security;

public enum ResourceType {

	VIEW("view"), BTN("btn"), UNIT("unit"), DATA("rule"), URL("url");

	private String type;

	private ResourceType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
