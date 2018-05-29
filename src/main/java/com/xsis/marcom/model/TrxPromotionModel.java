package com.xsis.marcom.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_PROMOTION")
public class TrxPromotionModel {
	private int id;
	private String code;
	private String flagDesign;
	private int tEventId;
	private int tDesignId;
	private int requestBy;
	private Date requestDate;
	private int approvedBy;
	private Date approvedDate;
	private int assignTo;
	private Date closeDate;
	private String note;
	private int status;
	private String rejectReason;
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
	
	@Column(name="CODE", nullable=false)
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name="FLAG_DESIGN", nullable=false)
	public String getFlagDesign() {
		return flagDesign;
	}
	public void setFlagDesign(String flagDesign) {
		this.flagDesign = flagDesign;
	}
	
	@Column(name="T_EVENT_ID", nullable=false)
	public int gettEventId() {
		return tEventId;
	}
	public void settEventId(int tEventId) {
		this.tEventId = tEventId;
	}
	
	@Column(name="T_DESIGN_ID", nullable=true)
	public int gettDesignId() {
		return tDesignId;
	}
	public void settDesignId(int tDesignId) {
		this.tDesignId = tDesignId;
	}
	
	@Column(name="REQUEST_BY", nullable=true)
	public int getRequestBy() {
		return requestBy;
	}
	public void setRequestBy(int requestBy) {
		this.requestBy = requestBy;
	}
	
	@Column(name="REQUEST_DATE", nullable=true)
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	@Column(name="APPROVED_BY", nullable=true)
	public int getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(int approvedBy) {
		this.approvedBy = approvedBy;
	}
	
	@Column(name="APPROVED_DATE", nullable=true)
	public Date getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}
	
	@Column(name="ASSIGN_TO", nullable=true)
	public int getAssignTo() {
		return assignTo;
	}
	public void setAssignTo(int assignTo) {
		this.assignTo = assignTo;
	}
	
	@Column(name="CLOSE_DATE", nullable=true)
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	
	@Column(name="NOTE", nullable=true)
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Column(name="STATUS", nullable=true)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(name="REJECT_REASON", nullable=true)
	public String getRejectReason() {
		return rejectReason;
	}
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
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
	
	@Column(name="UPADTE_BY", nullable=true)
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	@Column(name="UPADTE_DATE", nullable=true)
	public Date getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}

}
