package db.yihao.token;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import utils.yihao.security.random.RandomNumGeneratorUtil;

import bb6.yihao.constants.ParamConstants;

import db.yihao.requestlog.RequestLog;

@Entity
@Table(name= "token")
@SequenceGenerator(name= "tokenId_Seq", sequenceName= "tokenidseq", allocationSize= 1)
public class Token implements Serializable {
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "tokenId_Seq")
	@Id
	private Long tokenId;
	@OneToMany(mappedBy= "token", targetEntity= RequestLog.class, fetch= FetchType.LAZY)
	private Set<RequestLog> requestLogSet;
	private String token;
	private String suite;
	private Date createdTime;
	private Date expiryTime;
	private String status;
	
	public Token(){}
	public Token(String suite,Date expiryTime){
		try {
			this.token = RandomNumGeneratorUtil.generateString2(30);
			this.suite = suite;
			this.createdTime = new Date();
			this.expiryTime = expiryTime;
			this.status = ParamConstants.TOKEN_STATUS_VALID;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public Long getTokenId() {
		return tokenId;
	}
	public void setTokenId(Long tokenId) {
		this.tokenId = tokenId;
	}
	public Set<RequestLog> getRequestLogSet() {
		return requestLogSet;
	}
	public void setRequestLogSet(Set<RequestLog> requestLogSet) {
		this.requestLogSet = requestLogSet;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSuite() {
		return suite;
	}
	public void setSuite(String suite) {
		this.suite = suite;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	public Date getExpiryTime() {
		return expiryTime;
	}
	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
