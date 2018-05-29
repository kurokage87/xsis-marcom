package com.xsis.marcom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "M_PRODUCT")
public class MstProductModel {
	private int id;
	private String code;
	private String name;
	private String description;
	private int isDelete;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;

	@Id
	@Column(name = "ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="M_PRODUCT")
	@TableGenerator(name="M_PRODUCT",table="MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="M_PRODUCT", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "CODE", nullable=false)
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="DESCRIPTION", nullable=true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="IS_DELETE", nullable=false)
	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "CREATED_BY", nullable=false)
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_DATE", nullable=false)
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "UPDATED_BY", nullable=true)
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "UPDATED_DATE", nullable=true)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
