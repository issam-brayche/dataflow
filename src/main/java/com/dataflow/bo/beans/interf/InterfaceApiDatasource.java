package com.dataflow.bo.beans.interf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dataflow.bo.beans.enums.InterfaceApiReturnType;
import com.dataflow.bo.beans.enums.InterfaceApiType;

@Entity
public class InterfaceApiDatasource {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long interfaceApiDatasourceId;
	
	private String host;
	private String port;
	private String username;
	private String password;
	private String serviceName;
	private InterfaceApiType apiType;
	private InterfaceApiReturnType returnType;
	
	public InterfaceApiDatasource() {
		
	}

	public InterfaceApiDatasource(String host, String port, String username, String password, String serviceName,
			InterfaceApiType apiType, InterfaceApiReturnType returnType) {
		super();
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		this.serviceName = serviceName;
		this.apiType = apiType;
		this.returnType = returnType;
	}

	public Long getInterfaceApiDatasourceId() {
		return interfaceApiDatasourceId;
	}

	public void setInterfaceApiDatasourceId(Long interfaceApiDatasourceId) {
		this.interfaceApiDatasourceId = interfaceApiDatasourceId;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public InterfaceApiType getApiType() {
		return apiType;
	}

	public void setApiType(InterfaceApiType apiType) {
		this.apiType = apiType;
	}

	public InterfaceApiReturnType getReturnType() {
		return returnType;
	}

	public void setReturnType(InterfaceApiReturnType returnType) {
		this.returnType = returnType;
	}
	
	
}
