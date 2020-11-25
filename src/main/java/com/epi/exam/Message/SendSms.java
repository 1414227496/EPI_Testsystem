package com.epi.exam.Message;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.epi.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendSms {
	@Autowired
	UserService userService;

	public String sendSms(String telnumber) {
		//生成随机数
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i <= 5; i++) {
			int random = (int) (Math.random() * (10 - 1));
			stringBuffer.append( random );
		}
		String string = stringBuffer.toString();


		DefaultProfile profile = DefaultProfile.getProfile( "cn-hangzhou",
				"546767R",
				"568768767" );
		IAcsClient client = new DefaultAcsClient( profile );

		CommonRequest request = new CommonRequest();
		request.setMethod( MethodType.POST );
		request.setDomain( "dysmsapi.aliyuncs.com" );
		request.setVersion( "2017-05-25" );
		request.setAction( "SendSms" );
		request.putQueryParameter( "RegionId", "cn-hangzhou" );
		request.putQueryParameter( "PhoneNumbers", telnumber );
		request.putQueryParameter( "SignName", "EPI在线考试系统" );
		request.putQueryParameter( "TemplateCode", "SMS_179600406" );
		request.putQueryParameter( "TemplateParam", "{\"code\":\"" + string + "\"}" );

		try {
			CommonResponse response = client.getCommonResponse( request );
			System.out.println( response.getData() );
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return string;
	}
}
