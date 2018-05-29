package com.xsis.marcom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_PROMOTION_ITEM_FILE")
public class TrxPromotionItemFileModel {
	private int id;
	private int tPromotionId;
	private int filename;
	private String sizes;
	private String extention;
	private Date startDate;
	private Date endDate;
	private Date requestDueDate;
	private long qty;
	private int todo;
	private String note;
	private int isDelete;
	private String createdBy;
	private Date createdDate;
	private String updateBy;
	private Date UpdateDate;
	
	@Id
	@Column(name="ID", nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="T_PROMOTION_ID", nullable=false)
	public int gettPromotionId() {
		return tPromotionId;
	}
	public void settPromotionId(int tPromotionId) {
		this.tPromotionId = tPromotionId;
	}
	
	@Column(name="FILENAME", nullable=false)
	public int getFilename() {
		return filename;
	}
	public void setFilename(int filename) {
		this.filename = filename;
	}
	
	@Column(name="SIZES", nullable=true)
	public String getSizes() {
		return sizes;
	}
	public void setSizes(String sizes) {
		this.sizes = sizes;
	}
	
	@Column(name="EXTENTION", nullable=true)
	public String getExtention() {
		return extention;
	}
	public void setExtention(String extention) {
		this.extention = extention;
	}
	
	
	@Column(name="START_DATE", nullable=true)
	public Date getStarDate() {
		return startDate;
	}
	public void setStarDate(Date starDate) {
		this.startDate = starDate;
	}
	
	@Column(name="END_DATE", nullable=true)
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Column(name="REQUEST_DUE_DATE", nullable=true)
	public Date getRequestDueDate() {
		return requestDueDate;
	}
	public void setRequestDueDate(Date requestDueDate) {
		this.requestDueDate = requestDueDate;
	}
	
	@Column(name="QTY", nullable=true)
	public long getQty() {
		return qty;
	}
	public void setQty(long qty) {
		this.qty = qty;
	}
	
	@Column(name="TODO", nullable=false)
	public int getTodo() {
		return todo;
	}
	public void setTodo(int todo) {
		this.todo = todo;
	}
	
	@Column(name="NOTE", nullable=true)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Column(name="IS_DELETE", nullable=true)
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	@Column(name="CREATED_BY", nullable=false)
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="CREATED_DATE", nullable=false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name="UPADATE_BY", nullable=true)
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	@Column(name="UPDATE_DATE", nullable=true)
	public Date getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}
	
	
}
