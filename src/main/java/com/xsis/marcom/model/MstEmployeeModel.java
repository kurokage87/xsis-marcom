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
@Table(name="M_EMPLOYEE")
public class MstEmployeeModel {
	private int id;
	private String code;
	private String firstName;
	private String lastName;
	private int mCompanyId;
	private String email;
	private int isDelete;
	private String createdBy;
	private Date createdDate;
	private String updatedBy;
	private Date updatedDate;
	
	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.TABLE,generator="M_EMPLOYEE")
	@TableGenerator(name="M_EMPLOYEE",table="MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="M_EMPLOYEE", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=1)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="EMPLOYEE_NUMBER", nullable=true)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="FIRST_NAME", nullable=true)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="LAST_NAME", nullable=true)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="M_COMPANY_ID", nullable=true )
	public int getmCompanyId() {
		return mCompanyId;
	}
	public void setmCompanyId(int mCompanyId) {
		this.mCompanyId = mCompanyId;
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
