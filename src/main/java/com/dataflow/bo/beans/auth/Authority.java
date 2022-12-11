package com.dataflow.bo.beans.auth;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{
	
private static final long serialVersionUID = 2564393101510472177L;
	
	private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
	
}
