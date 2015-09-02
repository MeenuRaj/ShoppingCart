package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the SHPPINGCARTREVIEWS database table.
 * 
 */
@Entity
@Table(name="SHPPINGCARTREVIEWS", schema="TESTDB")
@NamedQuery(name="Shppingcartreview.findAll", query="SELECT s FROM Shppingcartreview s")
public class Shppingcartreview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Temporal(TemporalType.DATE)
	private Date dates;

	private BigDecimal productid;

	@Column(name="R_USERNAME")
	private String rUsername;

	private BigDecimal rating;

	private String reviews;

	public Shppingcartreview() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDates() {
		return this.dates;
	}

	public void setDates(Date dates) {
		this.dates = dates;
	}

	public BigDecimal getProductid() {
		return this.productid;
	}

	public void setProductid(BigDecimal productid) {
		this.productid = productid;
	}

	public String getRUsername() {
		return this.rUsername;
	}

	public void setRUsername(String rUsername) {
		this.rUsername = rUsername;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public String getReviews() {
		return this.reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

}