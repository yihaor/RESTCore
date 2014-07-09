package bb6.yihao.token.services;

import java.util.Date;
import java.util.List;

import db.yihao.token.Token;

public interface TokenService {
	public void saveToken(Token token)throws Exception;
	public void updateToken(Token token)throws Exception;
	public void deleteToken(Token token)throws Exception;
	public Token createToken(String suite,Date expiryTime)throws Exception;
	public Token closeToken(Token token)throws Exception;
	public Token getTokenByTokenString(String tokenStr)throws Exception;
	public List<Token> getAllToken()throws Exception;
}
