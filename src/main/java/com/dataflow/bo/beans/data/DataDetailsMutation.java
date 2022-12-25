package com.dataflow.bo.beans.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.dataflow.bo.beans.enums.MutationMode;

@Entity
public class DataDetailsMutation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long dataDetailsMutationId;
	
	private String sourceValue;
	private String resultValue;
	private Integer priority;
	private MutationMode mutationMode;
	
	@ManyToOne
    @JoinColumn(name = "data_details_info_id")
	private DataInfoDetails dataInfoDetails;
	
	public DataDetailsMutation() {
		
	}

	public DataDetailsMutation(String sourceValue, String resultValue, Integer priority, MutationMode mutationMode,
			DataInfoDetails dataInfoDetails) {
		super();
		this.sourceValue = sourceValue;
		this.resultValue = resultValue;
		this.priority = priority;
		this.mutationMode = mutationMode;
		this.dataInfoDetails = dataInfoDetails;
	}

	public Long getDataDetailsMutationId() {
		return dataDetailsMutationId;
	}

	public void setDataDetailsMutationId(Long dataDetailsMutationId) {
		this.dataDetailsMutationId = dataDetailsMutationId;
	}

	public String getSourceValue() {
		return sourceValue;
	}

	public void setSourceValue(String sourceValue) {
		this.sourceValue = sourceValue;
	}

	public String getResultValue() {
		return resultValue;
	}

	public void setResultValue(String resultValue) {
		this.resultValue = resultValue;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public MutationMode getMutationMode() {
		return mutationMode;
	}

	public void setMutationMode(MutationMode mutationMode) {
		this.mutationMode = mutationMode;
	}

	public DataInfoDetails getDataInfoDetails() {
		return dataInfoDetails;
	}

	public void setDataInfoDetails(DataInfoDetails dataInfoDetails) {
		this.dataInfoDetails = dataInfoDetails;
	}
	
	
	
	

}
