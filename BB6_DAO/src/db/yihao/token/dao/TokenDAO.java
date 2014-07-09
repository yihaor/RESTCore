package db.yihao.token.dao;

import java.util.List;

import db.yihao.token.Token;

public interface TokenDAO {
	public void saveToken(Token token)throws Exception;
	public void updateToken(Token token)throws Exception;
	public void deleteToken(Token token)throws Exception;
	public Token findTokenByTokenString(String tokenStr)throws Exception;
	public List<Token> findAllToken()throws Exception;

}
