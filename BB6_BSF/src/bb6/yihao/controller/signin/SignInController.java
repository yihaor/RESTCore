package bb6.yihao.controller.signin;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import bb6.yihao.token.services.TokenService;
import db.yihao.token.Token;


@Controller
public class SignInController{
	public String email;
	public String country;
	public String language;
	public String token;
	
	@Autowired
	@Qualifier("tokenService")
	public TokenService tokenService;
	
	public TokenService getTokenService() {
		return tokenService;
	}
	public void setTokenService(TokenService tokenService) {
		this.tokenService = tokenService;
	}
	
	@RequestMapping(value="signIn")
	public ModelAndView reqSuite(@RequestParam("email")String email, @RequestParam("country")String country, @RequestParam("language")String language){
		ModelAndView mav = new ModelAndView();
		try {
			
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			cal.add(cal.MONTH, 3);
			Date expiryTime = cal.getTime();
			Token t = tokenService.createToken("yh-123", expiryTime);
			System.out.println("----------token: "+t.getToken());
			
			Map<String,Object> modelMap = new HashMap<String,Object>();
			modelMap.put("email", email);
			modelMap.put("country", country);
			modelMap.put("language", language);
			modelMap.put("token", t.getToken());
			modelMap.put("date", new Date().toGMTString());
			mav.addObject(modelMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


	

}
