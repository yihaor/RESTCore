package bb6.yihao.controller.token;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import db.yihao.token.Token;
import bb6.yihao.token.services.TokenService;



@RestController
@RequestMapping("/service/token/")
public class TokenController {
	
	@Autowired
	@Qualifier("tokenService")
	public TokenService tokenService;
	
	public TokenService getTokenService() {
		return tokenService;
	}
	public void setTokenService(TokenService tokenService) {
		this.tokenService = tokenService;
	}
	
	@RequestMapping(value = "/{tokenStr}",method = RequestMethod.GET,headers = "Accept=application/json")
	public Token getUser(@PathVariable String tokenStr){
		Token token = null;
		try {
			token = tokenService.getTokenByTokenString(tokenStr);
			System.out.println("-----rest----token: "+token.getToken());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return token;
	}
	@RequestMapping(value = "/",method = RequestMethod.GET,headers = "Accept=application/json")
	public List<Token> getAllUsers(){
		List<Token> tokens = null;
		try {
			tokens = tokenService.getAllToken();
			System.out.println("-----rest----all ");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tokens;
	}
}
