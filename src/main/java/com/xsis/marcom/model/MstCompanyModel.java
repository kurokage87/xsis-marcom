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
@Table(name="M_COMPANY")
public class MstCompanyModel {
	private int id;
	private String code;
	private String name;
	private String address;
	private String phone;
	private String email;
	private int isDelete;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	
	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="M_COMPANY")
	@TableGenerator(name="M_COMPANY",table="MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="M_COMPANY", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="CODE", nullable=true)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="NAME", nullable=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="ADDRESS", nullable=true)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="PHONE", nullable=true)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Column(name="EMAIL", nullable=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="IS_DELETE", nullable=true)
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	@Column(name="CREATED_BY", nullable=true)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="CREATED_DATE", nullable=true)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="UPDATED_BY", nullable=true)
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name="UPDATED_DATE", nullable=true)
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
}
