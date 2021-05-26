package com.olx;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/*Assignment:
Override /info endpoint inside OLX-login app. It should display information about:
1) No of registered users
2) Active login count
{ "total-registered-users": 478, "active-login-count": 35 }
Hint: Implement the interface InfoContributor*/

@Component
public class LoginInfo implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		// TODO Auto-generated method stub\
		Random random=new Random();
		int totalUser=random.nextInt(1000);
		int activeLogin=random.nextInt(100);
		Map<String, Object> hs=new HashMap<>();
		hs.put("total-registered-users", totalUser);
		hs.put("active-login-count", activeLogin);
		builder.withDetails(hs);
	}

}
