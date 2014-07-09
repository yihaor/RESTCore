package utils.yihao.security.random;
import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;



public class RandomNumGeneratorUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//System.out.println(suiteGen(3955));
			//System.out.println(generatePassword(10));
			//generateString(30);
			generateString2(30);
			//generateNumber(6);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String generateString(int length) throws Exception{
		String rs = "";
		long startT = System.nanoTime();
		char[] allowedChars = new char[]{
				 'a','b','c','d','e','f','g','h','j','k','l','m'
				,'n','p','q','r','s','t','u','v','w','x','y','z'
				,'A','B','C','D','E','F','G','H','J','K','L','M'
				,'N','P','Q','R','S','T','U','V','W','X','Y','Z'
				,'0','1','2','3','4','5','6','7','8','9'
		};

		rs = RandomStringUtils.random(length, allowedChars);
		System.out.println("---rs: "+rs);
		long endT = System.nanoTime();
		System.out.println("--->>>diff："+(endT-startT));
		return rs;
	}
	
	public static String generateString2(int length) throws Exception{
		String rs = "";
		long startT = System.nanoTime();
		
		rs = RandomStringUtils.randomAlphanumeric(length);
		System.out.println("---rs2: "+rs);
		long endT = System.nanoTime();
		System.out.println("--->>>diff2："+(endT-startT));
		return rs;
	}
	
	public static String generateNumber(int length) throws Exception{
		String rs = "";
		long startT = System.nanoTime();
		
		rs = RandomStringUtils.randomNumeric(length);
		System.out.println("---Num rs: "+rs);
		long endT = System.nanoTime();
		System.out.println("--->>>Num diff："+(endT-startT));
		return rs;
	}
	

	
	public static String generatePassword(int length) throws Exception{
		String password = "";
		long startT = System.nanoTime();
		if(length < 1) return password;
		
		String allowedChar = "ABCDEFGHJKLMNPQRSTUVWXYZ0123456789";//去掉I,O 两个字母，还剩34个字母
		int availLength = allowedChar.length();
		//System.out.println(availLength);
		//--->>>diff：228354
		/*for(int i = 0; i < length; i ++){
			double rand = Math.random();
			int position = (int) (rand*availLength);
			password += allowedChar.charAt(position);
		}*/
		//--->>>diff：210393
		Random r = new Random();
		for(int i = 0; i < length; i ++){
			int position = r.nextInt(availLength);
			password += allowedChar.charAt(position);
		}
		long endT = System.nanoTime();
		System.out.println("--->>>diff："+(endT-startT));
		return password;
	}
	
	
	
	public static String suiteGen(int userCount) throws Exception{
		String id21 = "";
		long startT = System.nanoTime();
		while(userCount > 0) {
			
			int rem = userCount%21;//求余数 , 利用21进制把数字和21个字母绑定起来
			//System.out.println("userCount: "+userCount+" ;rem: "+rem);
			//除去A, E, I, O, U，还剩21个字母
			
			//--->>>diff：57730 by String[] --->>>diff：36348 by char[]
			char[] alphaArr = {'B','C','D','F','G','H','J','K','L','M','N','P','Q','R','S','T','V','W','X','Y','Z'};
			id21 = alphaArr[rem]+id21;

			userCount = userCount/21;
		}
		long endT = System.nanoTime();
		System.out.println("--->>>diff："+(endT-startT));
		
		return id21;
	}

}
