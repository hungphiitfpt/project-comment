package com.poly.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Anotation dùng để mapping xuống database, nếu ko ánh xạ thì database sẽ không hiểu
@Entity
//Annotation để chỉ rõ table tương ứng với entity name.
@Table(name = "mstproduct")
public class MstProduct implements Serializable {
	
	/*
	 * Anotation chú thích đây là khoá chính, ánh xạ với ở dưới database trường product_id
	 * Lưu ý: name phải truyền giống như ở dưới database
	 */
	@Id
	@Column(name="product_id")
	private String productId;

	/*
	 * Anotation chú thích đây là khoá chính, ánh xạ với ở dưới database trường createtime
	 * Lưu ý: name phải truyền giống như ở dưới database
	 */
	@Column(name="createtime")
	private Timestamp createtime;

	/*
	 * Anotation chú thích đây là khoá chính, ánh xạ với ở dưới database trường createuser
	 * Lưu ý: name phải truyền giống như ở dưới database
	 */
	@Column(name="createuser")
	private String createuser;

	/*
	 * Anotation chú thích đây là khoá chính, ánh xạ với ở dưới database trường product_amount
	 * Lưu ý: name phải truyền giống như ở dưới database
	 */
	@Column(name="product_amount")
	private Integer productAmount;

	/*
	 * Anotation chú thích đây là khoá chính, ánh xạ với ở dưới database trường product_description
	 * Lưu ý: name phải truyền giống như ở dưới database
	 */
	@Column(name="product_description")
	private String productDescription;

	/*
	 * Anotation chú thích đây là khoá chính, ánh xạ với ở dưới database trường product_img
	 * Lưu ý: name phải truyền giống như ở dưới database
	 */
	@Column(name="product_img")
	private String productImg;

	/*
	 * Anotation chú thích đây là khoá chính, ánh xạ với ở dưới database trường product_name
	 * Lưu ý: name phải truyền giống như ở dưới database
	 */
	@Column(name="product_name")
	private String productName;

	/*
	 * Anotation chú thích đây là khoá chính, ánh xạ với ở dưới database trường producttype_id
	 * Lưu ý: name phải truyền giống như ở dưới database
	 */
	@Column(name="producttype_id")
	private String productTypeId;

	/*
	 * Anotation chú thích đây là khoá chính, ánh xạ với ở dưới database trường status
	 * Lưu ý: name phải truyền giống như ở dưới database
	 */
	@Column(name="status")
	private Boolean status;

	/*
	 * Anotation chú thích đây là khoá chính, ánh xạ với ở dưới database trường updatetime
	 * Lưu ý: name phải truyền giống như ở dưới database
	 */
	@Column(name="updatetime")
	private Timestamp updatetime;

	/*
	 * Anotation chú thích đây là khoá chính, ánh xạ với ở dưới database trường updateuser
	 * Lưu ý: name phải truyền giống như ở dưới database
	 */
	@Column(name="updateuser")
	private String updateuser;

	/*
	 * Quan hệ nhiều một với bảng MstProductType, 
	 * có nghĩa là 1 loại sẽ có nhiều sản phẩm
	 */
	@ManyToOne
	//Cột này đang ánh xạ với bảng MstProductType
	@JoinColumn(name = "producttype_id",insertable = false, updatable = false)
	MstProductType productType;
	
	public MstProductType getProductType() {
		return productType;
	}
	
	
	public void setProductType(MstProductType productType) {
		this.productType = productType;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Timestamp getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}

	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
}