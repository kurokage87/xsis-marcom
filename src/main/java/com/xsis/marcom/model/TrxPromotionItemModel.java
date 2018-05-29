package com.xsis.marcom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_PROMOTION_ITEM")
public class TrxPromotionItemModel {
	private int id;
	private int tPromotionId;
	private int tDesignItemId;
	private String mProductId;
	private String title;
	private int requestPic;
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
	
	@Column(name="T_DESIGN_ITEM_ID", nullable=true)
	public int gettDesignItemId() {
		return tDesignItemId;
	}
	public void settDesignItemId(int tDesignItemId) {
		this.tDesignItemId = tDesignItemId;
	}
	
	@Column(name="M_PRODUCT_ID", nullable=false)
	public String getmProductId() {
		return mProductId;
	}
	public void setmProductId(String mProductId) {
		this.mProductId = mProductId;
	}
	
	@Column(name="TITLE", nullable=false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="REQUEST_PIC", nullable=false)
	public int getRequestPic() {
		return requestPic;
	}
	public void setRequestPic(int requestPic) {
		this.requestPic = requestPic;
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
