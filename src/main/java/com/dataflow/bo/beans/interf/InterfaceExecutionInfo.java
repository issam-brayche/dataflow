package com.dataflow.bo.beans.interf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class InterfaceExecutionInfo {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long interfaceExecutionInfoId;
	
	private Integer chunkPartition;
	private Boolean multiThreads;
	private Integer concurrentThreads;
	private Integer dataPerThread;
	
	@OneToOne
	private InterfaceDBDatasource dbDataSource;
	
	@OneToOne
	private InterfaceFileDatasource fileDataSource;
	
	@OneToOne
	private InterfaceApiDatasource apiDataSource;

	public InterfaceExecutionInfo(Integer chunkPartition, Boolean multiThreads, Integer concurrentThreads,
			Integer dataPerThread, InterfaceDBDatasource dbDataSource, InterfaceFileDatasource fileDataSource,
			InterfaceApiDatasource apiDataSource) {
		super();
		this.chunkPartition = chunkPartition;
		this.multiThreads = multiThreads;
		this.concurrentThreads = concurrentThreads;
		this.dataPerThread = dataPerThread;
		this.dbDataSource = dbDataSource;
		this.fileDataSource = fileDataSource;
		this.apiDataSource = apiDataSource;
	}

	public InterfaceExecutionInfo() {
		
	}

	public Long getInterfaceExecutionInfoId() {
		return interfaceExecutionInfoId;
	}

	public void setInterfaceExecutionInfoId(Long interfaceExecutionInfoId) {
		this.interfaceExecutionInfoId = interfaceExecutionInfoId;
	}

	public Integer getChunkPartition() {
		return chunkPartition;
	}

	public void setChunkPartition(Integer chunkPartition) {
		this.chunkPartition = chunkPartition;
	}

	public Boolean getMultiThreads() {
		return multiThreads;
	}

	public void setMultiThreads(Boolean multiThreads) {
		this.multiThreads = multiThreads;
	}

	public Integer getConcurrentThreads() {
		return concurrentThreads;
	}

	public void setConcurrentThreads(Integer concurrentThreads) {
		this.concurrentThreads = concurrentThreads;
	}

	public Integer getDataPerThread() {
		return dataPerThread;
	}

	public void setDataPerThread(Integer dataPerThread) {
		this.dataPerThread = dataPerThread;
	}

	public InterfaceDBDatasource getDbDataSource() {
		return dbDataSource;
	}

	public void setDbDataSource(InterfaceDBDatasource dbDataSource) {
		this.dbDataSource = dbDataSource;
	}

	public InterfaceFileDatasource getFileDataSource() {
		return fileDataSource;
	}

	public void setFileDataSource(InterfaceFileDatasource fileDataSource) {
		this.fileDataSource = fileDataSource;
	}

	public InterfaceApiDatasource getApiDataSource() {
		return apiDataSource;
	}

	public void setApiDataSource(InterfaceApiDatasource apiDataSource) {
		this.apiDataSource = apiDataSource;
	}
	
	
	
	
}
