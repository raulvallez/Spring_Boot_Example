package com.privalia.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//import org.hibernate.annotations.DynamicUpdate;

import io.swagger.annotations.ApiModelProperty;




@Entity
//@DynamicUpdate(value = true) //solo modifica los campos que han cambiado, PERO sigo haciendo select
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated product ID")
	private Integer id;
	
	@Version
	@ApiModelProperty(notes = "The auto-generated version of the product")
	private Integer version;
	
	@ApiModelProperty(notes = "The application-specific product ID")
	private String productId;
	
	@ApiModelProperty(notes= "The product description")
	@Size(min = 2, max = 200)
	private String description;
	
	
	@ApiModelProperty(notes= "The image URL of the product")
	@Size(min = 6, max = 400)
	private String imageUrl;
	
	@ApiModelProperty(notes = "The price of the product" , required=true)
	@NotNull
	@Min(1)
	private BigDecimal price;
	
	/**
	 * @return the id
	 */
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
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
