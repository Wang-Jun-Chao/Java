package wjc.spring.security.oauth2.distributed.jwt.rsa.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import wjc.spring.security.oauth2.distributed.jwt.rsa.gateway.common.EncryptUtil;

import java.util.HashMap;
import java.util.Map;


/**
 * <pre>
 *
 * </pre>
 * Author: 王俊超
 * Date: 2021-08-08 09:02
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    private final static String AUTHORIZATION = "Authorization";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst(AUTHORIZATION);
        if (StringUtils.hasText(token)) {
            String realToken = token.replace("Bearer ", "");
            Jwt jwt = JwtHelper.decode(realToken);
            String claims = jwt.getClaims();
            JSONObject jsonObject = JSON.parseObject(claims);
            String username = jsonObject.getString("user_name");
            JSONArray authorityArray = jsonObject.getJSONArray("authorities");

            String[] authorites = authorityArray.toArray(new String[]{});

            Map<String, Object> jsonToken = new HashMap<>();
            jsonToken.put("principal", username);
            jsonToken.put("authorities", authorites);

            // 修改请求数据：https://blog.csdn.net/djrm11/article/details/114380867
            ServerHttpRequest decorator = exchange
                    .getRequest()
                    .mutate()
                    .header("json-token", EncryptUtil.encodeUTF8StringBase64(JSON.toJSONString(jsonToken)))
                    .build();


            return chain.filter(exchange.mutate().request(decorator).build());

        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
