package com.dataflow.bo.beans.interf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dataflow.bo.beans.enums.InterfaceDbType;

@Entity
public class InterfaceDBDatasource {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long interfaceDBDatasourceId;
	
	private String host;
	private String port;
	private String username;
	private String password;
	private String dbName;
	private String dataName;
	private InterfaceDbType dbType;
	private Boolean showSql;
	private String dialect;
	
	public InterfaceDBDatasource(String host, String port, String username, String password, String dbName,
			String dataName, InterfaceDbType dbType, Boolean showSql, String dialect) {
		super();
		this.host = host;
		this.port = port;
		this.username = username;
		this.password = password;
		this.dbName = dbName;
		this.dataName = dataName;
		this.dbType = dbType;
		this.showSql = showSql;
		this.dialect = dialect;
	}

	public InterfaceDBDatasource() {
		
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

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public InterfaceDbType getDbType() {
		return dbType;
	}

	public void setDbType(InterfaceDbType dbType) {
		this.dbType = dbType;
	}

	public Boolean getShowSql() {
		return showSql;
	}

	public void setShowSql(Boolean showSql) {
		this.showSql = showSql;
	}

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}
	
	
	
	
}
