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
@Table(name="M_SOUVENIR")
public class MstSouvenirModel {
	private Integer id;
	private String code;
	private String name;
	private String description;
	private Integer mUnitId;
	private Integer isDelete;
	private String createdBy;
	private Date createdDate;
	private String updateBy;
	private Date updateDate;
	/**
	 * @return the id
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.TABLE,generator="M_SOUVENIR")
	@TableGenerator(name="M_SOUVENIR",table="MST_SEQUENCE", pkColumnName="SEQUENCE_ID", pkColumnValue="M_SOUVENIR", valueColumnName="SEQUENCE_VALUE", allocationSize=1, initialValue=0)
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the code
	 */
	@Column(name="code")
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the mUnitId
	 */
	@Column(name="m_unit_id")
	public Integer getmUnitId() {
		return mUnitId;
	}
	/**
	 * @param mUnitId the mUnitId to set
	 */
	public void setmUnitId(Integer mUnitId) {
		this.mUnitId = mUnitId;
	}
	/**
	 * @return the isDelete
	 */
	@Column(name="is_delete")
	public Integer getIsDelete() {
		return isDelete;
	}
	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	/**
	 * @return the createdBy
	 */
	@Column(name="created_by")
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the createdDate
	 */
	@Column(name="created_date")
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	/**
	 * @return the updateBy
	 */
	@Column(name="update_by")
	public String getUpdateBy() {
		return updateBy;
	}
	/**
	 * @param updateBy the updateBy to set
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/**
	 * @return the updateDate
	 */
	@Column(name="update_date")
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
	
}
