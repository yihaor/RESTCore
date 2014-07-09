package bb6.yihao.token.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import bb6.yihao.constants.ParamConstants;
import db.yihao.token.Token;
import db.yihao.token.dao.TokenDAO;

@Service("tokenService")
public class TokenServiceImpl implements TokenService {
	private TokenDAO tokenDAO;
	
	@Override
	public Token closeToken(Token token) throws Exception {
		if(ParamConstants.TOKEN_STATUS_VALID.equals(token.getStatus())){
			token.setStatus(ParamConstants.TOKEN_STATUS_EXPIRED);
			tokenDAO.updateToken(token);
		}
		return token;
	}

	@Override
	public Token createToken(String suite,Date expiryTime) throws Exception {
		Token token = new Token(suite,expiryTime);
		tokenDAO.saveToken(token);
		return token;
	}

	@Override
	public void deleteToken(Token token) throws Exception {
		if(token != null && token.getTokenId() != null)
			tokenDAO.deleteToken(token);
	}

	@Override
	public void saveToken(Token token) throws Exception {
		if(token != null)
			tokenDAO.saveToken(token);
	}

	@Override
	public void updateToken(Token token) throws Exception {
		if(token != null)
			tokenDAO.updateToken(token);
	}
	
	@Override
	public Token getTokenByTokenString(String tokenStr) throws Exception {
		Token token = null;
		if(!"".equals(tokenStr) && tokenStr!=null){
			token = tokenDAO.findTokenByTokenString(tokenStr);
		}
		return token;
	}
	
	@Override
	public List<Token> getAllToken() throws Exception {
		return tokenDAO.findAllToken();
	}

	public TokenDAO getTokenDAO() {
		return tokenDAO;
	}

	public void setTokenDAO(TokenDAO tokenDAO) {
		this.tokenDAO = tokenDAO;
	}
	
}
