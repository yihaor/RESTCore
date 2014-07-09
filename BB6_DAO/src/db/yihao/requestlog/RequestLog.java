package db.yihao.requestlog;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import db.yihao.token.Token;

@Entity
@Table(name= "requestlog")
@SequenceGenerator(name= "requestLogId_Seq", sequenceName= "requestlogidseq", allocationSize= 1)

public class RequestLog implements Serializable {
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator= "requestLogId_Seq")
	@Id
	private Long requestId;
	@ManyToOne
	@Cascade(value= { CascadeType.REFRESH})
	@JoinColumn(name= "token")
	private Token token;
	private Date createdTime;
	private String request;
	private String status;
	private String requestUrl;
	private String requestValues;
	private String results;
	
	public RequestLog(){}
	public RequestLog(Token token,String request,String status,String requestUrl,String requestValues,String results){
		try {
			this.token = token;
			this.createdTime = new Date();
			this.request = request;
			this.status = status;
			this.requestUrl = requestUrl;
			this.requestValues = requestValues;
			this.results = results;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequestUrl() {
		return requestUrl;
	}

	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getRequestValues() {
		return requestValues;
	}

	public void setRequestValues(String requestValues) {
		this.requestValues = requestValues;
	}

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
	}
	
}
