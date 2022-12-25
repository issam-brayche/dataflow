package com.dataflow.bo.beans.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DataInfoDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long dataInfoDetailsId;
	
	private String sourceName;
	private String sourceType;
	private Boolean sourceMandatory;
	private String sourceDefaultValue;
	private String resultName;
	private String resultType;
	private Boolean resultUpdatable;
	
	@OneToMany(mappedBy = "dataInfoDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
	private List<DataDetailsMutation> dataDetailsMutations;
	
	@ManyToOne
    @JoinColumn(name = "data_info_id")
	private DataInfo dataInfo;

	public DataInfoDetails() {
		
	}

	public DataInfoDetails(String sourceName, String sourceType, Boolean sourceMandatory, String sourceDefaultValue,
			String resultName, String resultType, Boolean resultUpdatable,
			List<DataDetailsMutation> dataDetailsMutations) {
		super();
		this.sourceName = sourceName;
		this.sourceType = sourceType;
		this.sourceMandatory = sourceMandatory;
		this.sourceDefaultValue = sourceDefaultValue;
		this.resultName = resultName;
		this.resultType = resultType;
		this.resultUpdatable = resultUpdatable;
		this.dataDetailsMutations = dataDetailsMutations;
	}

	public Long getDataInfoDetailsId() {
		return dataInfoDetailsId;
	}

	public void setDataInfoDetailsId(Long dataInfoDetailsId) {
		this.dataInfoDetailsId = dataInfoDetailsId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public Boolean getSourceMandatory() {
		return sourceMandatory;
	}

	public void setSourceMandatory(Boolean sourceMandatory) {
		this.sourceMandatory = sourceMandatory;
	}

	public String getSourceDefaultValue() {
		return sourceDefaultValue;
	}

	public void setSourceDefaultValue(String sourceDefaultValue) {
		this.sourceDefaultValue = sourceDefaultValue;
	}

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public Boolean getResultUpdatable() {
		return resultUpdatable;
	}

	public void setResultUpdatable(Boolean resultUpdatable) {
		this.resultUpdatable = resultUpdatable;
	}

	public List<DataDetailsMutation> getDataDetailsMutations() {
		return dataDetailsMutations;
	}

	public void setDataDetailsMutations(List<DataDetailsMutation> dataDetailsMutations) {
		this.dataDetailsMutations = dataDetailsMutations;
	}
	
	
	
	
}
