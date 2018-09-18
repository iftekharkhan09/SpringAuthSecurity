package com.myproject.throttle.ThrottlerApp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RateLimitingInterceptor extends HandlerInterceptorAdapter {
	private Map<String, SimpleRateInterceptor> map = new ConcurrentHashMap<>();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		int maxLimit = 10;
		//System.out.println("Intercepted");
		TimeUnit unit = TimeUnit.SECONDS;
		String clientId = request.getHeader("Client-Id");
		if (clientId != null) {
			SimpleRateInterceptor limiter = getLimiter(maxLimit, unit, clientId);
			if (limiter.acquire()) {
				return true;
			} else {
				response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
				return false;
				// response.addHeader("X-form-Length", "" + maxLimit);
			}
		}
		return true;
	}

	private SimpleRateInterceptor getLimiter(int maxLimit, TimeUnit timeUnit, String clientId) {
		if (map.containsKey(clientId)) {
			return map.get(clientId);
		} else {
			synchronized (clientId.intern()) {
				SimpleRateInterceptor simpleRateInterceptor = SimpleRateInterceptor.create(maxLimit, timeUnit);
				map.put(clientId, simpleRateInterceptor);
				// return map;
			}
		}
		return map.get(clientId);

	}
}
