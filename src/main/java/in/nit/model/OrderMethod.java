package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "orderMethodTab")
public class OrderMethod {
	@Id
	@GeneratedValue
	@Column(name = "OMid")
	private Integer orderMId;
	@Column(name = "OMode")
	private String orderMode;
	@Column(name = "OCode")
	private String orderCode;
	@Column(name = "OMethod")
	private String orderMethod;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name ="omAcceptTab",joinColumns =@JoinColumn(name="omid"))
	@OrderColumn(name ="pos")
	@Column(name = "OAccept")
	private List<String> orderAccept;
	@Column(name = "ODesc")
	private String orderDesc;
	
	public OrderMethod() {
		
	}

	public Integer getOrderMId() {
		return orderMId;
	}

	public void setOrderMId(Integer orderMId) {
		this.orderMId = orderMId;
	}

	public String getOrderMode() {
		return orderMode;
	}

	public void setOrderMode(String orderMode) {
		this.orderMode = orderMode;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOrderMethod() {
		return orderMethod;
	}

	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}

	public List<String> getOrderAccept() {
		return orderAccept;
	}

	public void setOrderAccept(List<String> orderAccept) {
		this.orderAccept = orderAccept;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	@Override
	public String toString() {
		return "OrderMethod [orderMId=" + orderMId + ", orderMode=" + orderMode + ", orderCode=" + orderCode
				+ ", orderMethod=" + orderMethod + ", orderAccept=" + orderAccept + ", orderDesc=" + orderDesc + "]";
	}

	
	
	

}
