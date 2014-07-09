package db.yihao.requestlog.dao;

import java.util.Date;

import db.yihao.requestlog.RequestLog;
import db.yihao.token.Token;

public interface RequestLogDAO {
	public void saveRequestLog(RequestLog log)throws Exception;
	public void updateRequestLog(RequestLog log)throws Exception;
	public void deleteRequestLog(RequestLog log)throws Exception;
	public Date findLatestCreatedtimeByToken(Token token)throws Exception;
	public RequestLog findLogById(long reqLogId);
}
