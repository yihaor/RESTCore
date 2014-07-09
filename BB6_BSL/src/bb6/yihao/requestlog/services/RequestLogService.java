package bb6.yihao.requestlog.services;

import java.util.Date;

import db.yihao.requestlog.RequestLog;
import db.yihao.token.Token;

public interface RequestLogService {
	public void saveRequestLog(RequestLog log)throws Exception;
	public void updateRequestLog(RequestLog log)throws Exception;
	public void deleteRequestLog(RequestLog log)throws Exception;
	public RequestLog createRequestLog(Token token,String request,String status,String requestUrl,String requestValues,String results)throws Exception;
	public Date findLatestCreatedtimeByToken(Token token)throws Exception;
	public RequestLog findLogById(long reqLogId);
}
