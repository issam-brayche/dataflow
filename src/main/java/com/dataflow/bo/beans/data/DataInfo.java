package com.dataflow.bo.beans.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DataInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long dataInfoId;
	
	private Boolean sourceAutoDetails;
	private Boolean resultAutoDetails;
	
	@OneToMany(mappedBy = "dataInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
	private List<DataInfoDetails> dataInfoDetails;

	public DataInfo() {

	}

	public DataInfo(Boolean sourceAutoDetails, Boolean resultAutoDetails, List<DataInfoDetails> dataInfoDetails) {
		super();
		this.sourceAutoDetails = sourceAutoDetails;
		this.resultAutoDetails = resultAutoDetails;
		this.dataInfoDetails = dataInfoDetails;
	}

	public Long getDataInfoId() {
		return dataInfoId;
	}

	public void setDataInfoId(Long dataInfoId) {
		this.dataInfoId = dataInfoId;
	}

	public Boolean getSourceAutoDetails() {
		return sourceAutoDetails;
	}

	public void setSourceAutoDetails(Boolean sourceAutoDetails) {
		this.sourceAutoDetails = sourceAutoDetails;
	}

	public Boolean getResultAutoDetails() {
		return resultAutoDetails;
	}

	public void setResultAutoDetails(Boolean resultAutoDetails) {
		this.resultAutoDetails = resultAutoDetails;
	}

	public List<DataInfoDetails> getDataInfoDetails() {
		return dataInfoDetails;
	}

	public void setDataInfoDetails(List<DataInfoDetails> dataInfoDetails) {
		this.dataInfoDetails = dataInfoDetails;
	}
	
	
	
}
