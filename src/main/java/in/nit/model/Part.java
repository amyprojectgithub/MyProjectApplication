package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "partTab")
public class Part {
	@Id
	@GeneratedValue
	@Column(name = "pid")
	private Integer partId;
	@Column(name = "pcode")
	private String partCode;
	@Column(name = "width")
	private Float width;
	@Column(name = "length")
	private Float length;
	@Column(name = "height")
	private Float height;
	@Column(name = "bcost")
	private Double baseCost;
	@Column(name = "bcurrency")
	private String baseCurrency;
	
	@ManyToOne
	@JoinColumn(name = "uomIdFk")
	private Uom uomOb;
	
	@ManyToOne
	@JoinColumn(name = "orderSaleIdFk")
	private OrderMethod omSaleOb;
	
	@Column(name = "pdesc")
	private String pdesc;

	public Part() {

	}
	

	public Part(Integer partId) {
		this.partId = partId;
	}


	public Integer getPartId() {
		return partId;
	}


	public void setPartId(Integer partId) {
		this.partId = partId;
	}


	public String getPartCode() {
		return partCode;
	}


	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}


	public Float getWidth() {
		return width;
	}


	public void setWidth(Float width) {
		this.width = width;
	}


	public Float getLength() {
		return length;
	}


	public void setLength(Float length) {
		this.length = length;
	}


	public Float getHeight() {
		return height;
	}


	public void setHeight(Float height) {
		this.height = height;
	}


	public Double getBaseCost() {
		return baseCost;
	}


	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}


	public String getBaseCurrency() {
		return baseCurrency;
	}


	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}


	public String getPdesc() {
		return pdesc;
	}


	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}


	public Uom getUomOb() {
		return uomOb;
	}


	public void setUomOb(Uom uomOb) {
		this.uomOb = uomOb;
	}


	public OrderMethod getOmSaleOb() {
		return omSaleOb;
	}


	public void setOmSaleOb(OrderMethod omSaleOb) {
		this.omSaleOb = omSaleOb;
	}


	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", width=" + width + ", length=" + length
				+ ", height=" + height + ", baseCost=" + baseCost + ", baseCurrency=" + baseCurrency + ", uomOb="
				+ uomOb + ", omSaleOb=" + omSaleOb + ", pdesc=" + pdesc + "]";
	}
}
