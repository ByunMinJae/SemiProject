package minjae._common;

import java.util.HashMap;

import org.json.simple.JSONObject;

import minjae.dto.UserFind;
import minjae.dto.UserInfo;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class Coolsms {
	
	public void sendAuthSms(UserInfo user, UserFind userFind) {
	    String api_key = "NCSFOPP4YLCTU2RB";
	    String api_secret = "RC5K8SODY9LS2X80YFHURURQOVF9WLHT";
	    Message coolsms = new Message(api_key, api_secret);

	    // 4 params(to, from, type, text) are mandatory. must be filled
	    HashMap<String, String> params = new HashMap<String, String>();
	    params.put("to", user.getPhone());	// 수신전화번호
	    params.put("from", "01071041845");	// 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
	    params.put("type", "SMS");
	    params.put("text", "[코딩산악회] 인증번호(" + userFind.getAuthno() + ")를 입력해주세요.");
	    params.put("app_version", "test app 1.2"); // application name and version

	    try {
	      JSONObject obj = (JSONObject) coolsms.send(params);
	      System.out.println(obj.toString());
	    } catch (CoolsmsException e) {
	      System.out.println(e.getMessage());
	      System.out.println(e.getCode());
	    }
	  }
	
}
