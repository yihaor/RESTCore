package db.yihao.token.dao;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import db.yihao.token.Token;

public class TokenDAOImpl extends HibernateDaoSupport implements TokenDAO {

	@Override
	public void deleteToken(Token token) throws Exception {
		// TODO Auto-generated method stub
		if(token != null && token.getTokenId() != null)
			this.getHibernateTemplate().delete(token);
	}

	@Override
	public void saveToken(Token token) throws Exception {
		// TODO Auto-generated method stub
		if(token != null){
			if(token.getTokenId() != null)
				this.getHibernateTemplate().update(token);
			else
				this.getHibernateTemplate().save(token);
		}
	}

	@Override
	public void updateToken(Token token) throws Exception {
		// TODO Auto-generated method stub
		if(token != null){
			if(token.getTokenId() != null)
				this.getHibernateTemplate().update(token);
			else
				this.getHibernateTemplate().save(token);
		}
	}
	
	@Override
	public Token findTokenByTokenString(String tokenStr) throws Exception {
		// TODO Auto-generated method stub
		Token token = null;
		Session session = getSession();
		String query = "select * from Token t where t.token= :token";
		SQLQuery q = session.createSQLQuery(query);
		q.addEntity(Token.class);
		q.setString("token", tokenStr);
		List<Token> tl = (List<Token>)q.list();
		if(!tl.isEmpty())
			token = (Token)tl.get(0);
		return token;
	}

	@Override
	public List<Token> findAllToken() throws Exception {
		// TODO Auto-generated method stub
		Session session = getSession();
		String query = "select * from Token t where t.status= :status";
		SQLQuery q = session.createSQLQuery(query);
		q.addEntity(Token.class);
		q.setString("status", "V");
		List<Token> tl = (List<Token>)q.list();
		if(!tl.isEmpty())
			return tl;
		else 
			return null;
	}
	
	

}
