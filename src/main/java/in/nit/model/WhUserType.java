package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whUserTab")
public class WhUserType {
	@Id
	@GeneratedValue
	@Column(name = "whuId")
	private Integer whUserId;
	@Column(name = "whuType")
	private String whUserType;
	@Column(name = "whuCode")
	private String whUserCode;
	@Column(name = "userFor")
	private String userFor;
	@Column(name = "whuMail")
	private String whUserMail;
	@Column(name = "whuContact")
	private String whUserContact;
	@Column(name = "whuIdType")
	private String whUserIdType;
	@Column(name = "whuOtherIdType")
	private String whUserOtherIdType;
	@Column(name = "whuIdNum")
	private String whUserIdNum;
	public WhUserType() {
		
	}
	public Integer getWhUserId() {
		return whUserId;
	}
	public void setWhUserId(Integer whUserId) {
		this.whUserId = whUserId;
	}
	public String getWhUserType() {
		return whUserType;
	}
	public void setWhUserType(String whUserType) {
		this.whUserType = whUserType;
	}
	public String getWhUserCode() {
		return whUserCode;
	}
	public void setWhUserCode(String whUserCode) {
		this.whUserCode = whUserCode;
	}
	public String getUserFor() {
		return userFor;
	}
	public void setUserFor(String userFor) {
		this.userFor = userFor;
	}
	public String getWhUserMail() {
		return whUserMail;
	}
	public void setWhUserMail(String whUserMail) {
		this.whUserMail = whUserMail;
	}
	public String getWhUserContact() {
		return whUserContact;
	}
	public void setWhUserContact(String whUserContact) {
		this.whUserContact = whUserContact;
	}
	public String getWhUserIdType() {
		return whUserIdType;
	}
	public void setWhUserIdType(String whUserIdType) {
		this.whUserIdType = whUserIdType;
	}
	public String getWhUserOtherIdType() {
		return whUserOtherIdType;
	}
	public void setWhUserOtherIdType(String whUserOtherIdType) {
		this.whUserOtherIdType = whUserOtherIdType;
	}
	public String getWhUserIdNum() {
		return whUserIdNum;
	}
	public void setWhUserIdNum(String whUserOtherIdNum) {
		this.whUserIdNum = whUserOtherIdNum;
	}
	@Override
	public String toString() {
		return "WhUserType [whUserId=" + whUserId + ", whUserType=" + whUserType + ", whUserCode=" + whUserCode
				+ ", userFor=" + userFor + ", whUserMail=" + whUserMail + ", whUserContact=" + whUserContact
				+ ", whUserIdType=" + whUserIdType + ", whUserOtherIdType=" + whUserOtherIdType + ", whUserOtherIdNum="
				+ whUserIdNum + "]";
	}
	

}
