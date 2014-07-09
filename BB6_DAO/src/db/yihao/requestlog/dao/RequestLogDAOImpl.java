package db.yihao.requestlog.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import db.yihao.requestlog.RequestLog;
import db.yihao.token.Token;

public class RequestLogDAOImpl extends HibernateDaoSupport implements RequestLogDAO {

	@Override
	public void deleteRequestLog(RequestLog log) throws Exception {
		// TODO Auto-generated method stub
		if(log != null && log.getRequestId() != null)
			this.getHibernateTemplate().delete(log);
	}

	@Override
	public void saveRequestLog(RequestLog log) throws Exception {
		// TODO Auto-generated method stub
		if(log != null){
			if(log.getRequestId() != null)
				this.getHibernateTemplate().update(log);
			else
				this.getHibernateTemplate().save(log);
		}
	}

	@Override
	public void updateRequestLog(RequestLog log) throws Exception {
		// TODO Auto-generated method stub
		if(log != null){
			if(log.getRequestId() != null)
				this.getHibernateTemplate().update(log);
			else
				this.getHibernateTemplate().save(log);
		}
	}
	
	@Override
	public RequestLog findLogById(long reqLogId) {
		// TODO Auto-generated method stub
		RequestLog log = null;
		Session session = getSession();
		String query = "select r from RequestLog r where r.requestId= :requestId";
		SQLQuery q = session.createSQLQuery(query);
		q.addEntity(RequestLog.class);
		q.setLong("requestId", reqLogId);
		List<RequestLog> rl = q.list();
		if(!rl.isEmpty())
			log = (RequestLog)rl.get(0);
		return log;
	}

	@Override
	public Date findLatestCreatedtimeByToken(Token token) throws Exception {
		// TODO Auto-generated method stub
		Date latestTime = null;
		Session session = getSession();
		String query = "select max(r.createdTime) from RequestLog r where r.token= :token";
		SQLQuery q = session.createSQLQuery(query);
		q.addEntity(RequestLog.class);
		q.setLong("token", token.getTokenId());
		List<Date> tl = q.list();
		if(!tl.isEmpty())
			latestTime = (Date)tl.get(0);
		return latestTime;
	}

}
