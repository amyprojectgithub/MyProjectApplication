package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipmentTab")
public class ShipmentType {
	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer shipId;
	@Column(name="smode")
	private String shipMode;
	@Column(name="scode")
	private String shipcode;
	@Column(name="enbShipment")
	private String enbShipment;
	@Column(name="sgrade")
	private String shipGrade;
	@Column(name="sdesc")
	private String shipDesc;
	
	public ShipmentType() {
	}

	public ShipmentType(Integer shipId) {
		this.shipId = shipId;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public String getShipMode() {
		return shipMode;
	}

	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}

	public String getShipcode() {
		return shipcode;
	}

	public void setShipcode(String shipcode) {
		this.shipcode = shipcode;
	}

	public String getEnbShipment() {
		return enbShipment;
	}

	public void setEnbShipment(String enbShipment) {
		this.enbShipment = enbShipment;
	}

	public String getShipGrade() {
		return shipGrade;
	}

	public void setShipGrade(String shipGrade) {
		this.shipGrade = shipGrade;
	}

	public String getShipDesc() {
		return shipDesc;
	}

	public void setShipDesc(String shipDesc) {
		this.shipDesc = shipDesc;
	}

	@Override
	public String toString() {
		return "ShipmentType [shipId=" + shipId + ", shipMode=" + shipMode + ", shipcode=" + shipcode + ", enbShipment="
				+ enbShipment + ", shipGrade=" + shipGrade + ", shipDesc=" + shipDesc + "]";
	}
	

}
