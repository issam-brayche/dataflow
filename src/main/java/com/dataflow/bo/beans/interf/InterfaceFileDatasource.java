package com.dataflow.bo.beans.interf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InterfaceFileDatasource {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long interfaceFileDatasourceId;
	
	private String filePath;
	private String fileName;
	private String fileExtension;
	private Boolean remote;
	
	public InterfaceFileDatasource(String filePath, String fileName, String fileExtension, Boolean remote) {
		super();
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileExtension = fileExtension;
		this.remote = remote;
	}
	
	public InterfaceFileDatasource() {
		
	}

	public Long getInterfaceFileDatasourceId() {
		return interfaceFileDatasourceId;
	}

	public void setInterfaceFileDatasourceId(Long interfacefileDatasourceId) {
		this.interfaceFileDatasourceId = interfacefileDatasourceId;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public Boolean getRemote() {
		return remote;
	}

	public void setRemote(Boolean remote) {
		this.remote = remote;
	}
	
	
	
}
