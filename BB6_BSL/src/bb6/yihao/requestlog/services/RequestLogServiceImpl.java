package bb6.yihao.requestlog.services;

import java.util.Date;
import org.springframework.stereotype.Service;
import db.yihao.requestlog.RequestLog;
import db.yihao.requestlog.dao.RequestLogDAO;
import db.yihao.token.Token;

@Service("requestLogService")
public class RequestLogServiceImpl implements RequestLogService {
	private RequestLogDAO requestLogDAO;
	
	@Override
	public RequestLog createRequestLog(Token token, String request,String status, String requestUrl, String requestValues,String results) throws Exception {
		// TODO Auto-generated method stub
		RequestLog log = new RequestLog(token,request,status,requestUrl,requestValues,results);
		requestLogDAO.saveRequestLog(log);
		return log;
	}

	@Override
	public void deleteRequestLog(RequestLog log) throws Exception {
		// TODO Auto-generated method stub
		if(log != null && log.getRequestId() != null)
			requestLogDAO.deleteRequestLog(log);
	}

	@Override
	public void saveRequestLog(RequestLog log) throws Exception {
		// TODO Auto-generated method stub
		if(log != null)
			requestLogDAO.saveRequestLog(log);
	}

	@Override
	public void updateRequestLog(RequestLog log) throws Exception {
		// TODO Auto-generated method stub
		if(log != null)
			requestLogDAO.updateRequestLog(log);
	}
	
	@Override
	public Date findLatestCreatedtimeByToken(Token token) throws Exception {
		// TODO Auto-generated method stub
		return requestLogDAO.findLatestCreatedtimeByToken(token);
	}

	@Override
	public RequestLog findLogById(long reqLogId) {
		// TODO Auto-generated method stub
		return requestLogDAO.findLogById(reqLogId);
	}

	public RequestLogDAO getRequestLogDAO() {
		return requestLogDAO;
	}

	public void setRequestLogDAO(RequestLogDAO requestLogDAO) {
		this.requestLogDAO = requestLogDAO;
	}
	
}
