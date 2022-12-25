package com.dataflow.bo.beans.interf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.dataflow.bo.beans.enums.InterfaceMode;
import com.dataflow.bo.beans.enums.InterfaceType;

@Entity
public class InterfaceDatasource {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long interfaceDataSourceId;
	
	private InterfaceType sourceInterfaceType;
	private InterfaceType resultInterfaceType;
	private InterfaceMode mode;
	
	@OneToOne
	private InterfaceExecutionInfo readingInterfaceInfo;
	
	@OneToOne
	private InterfaceExecutionInfo resultInterfaceInfo;
	
	public InterfaceDatasource() {
		
	}

	public InterfaceDatasource(InterfaceType sourceInterfaceType, InterfaceType resultInterfaceType, InterfaceMode mode,
			InterfaceExecutionInfo readingInterfaceInfo, InterfaceExecutionInfo resultInterfaceInfo) {
		super();
		this.sourceInterfaceType = sourceInterfaceType;
		this.resultInterfaceType = resultInterfaceType;
		this.mode = mode;
		this.readingInterfaceInfo = readingInterfaceInfo;
		this.resultInterfaceInfo = resultInterfaceInfo;
	}

	public Long getInterfaceDataSourceId() {
		return interfaceDataSourceId;
	}

	public void setInterfaceDataSourceId(Long interfaceDataSourceId) {
		this.interfaceDataSourceId = interfaceDataSourceId;
	}

	public InterfaceType getSourceInterfaceType() {
		return sourceInterfaceType;
	}

	public void setSourceInterfaceType(InterfaceType sourceInterfaceType) {
		this.sourceInterfaceType = sourceInterfaceType;
	}

	public InterfaceType getResultInterfaceType() {
		return resultInterfaceType;
	}

	public void setResultInterfaceType(InterfaceType resultInterfaceType) {
		this.resultInterfaceType = resultInterfaceType;
	}

	public InterfaceMode getMode() {
		return mode;
	}

	public void setMode(InterfaceMode mode) {
		this.mode = mode;
	}

	public InterfaceExecutionInfo getReadingInterfaceInfo() {
		return readingInterfaceInfo;
	}

	public void setReadingInterfaceInfo(InterfaceExecutionInfo readingInterfaceInfo) {
		this.readingInterfaceInfo = readingInterfaceInfo;
	}

	public InterfaceExecutionInfo getResultInterfaceInfo() {
		return resultInterfaceInfo;
	}

	public void setResultInterfaceInfo(InterfaceExecutionInfo resultInterfaceInfo) {
		this.resultInterfaceInfo = resultInterfaceInfo;
	}
	
	
	
	
}
