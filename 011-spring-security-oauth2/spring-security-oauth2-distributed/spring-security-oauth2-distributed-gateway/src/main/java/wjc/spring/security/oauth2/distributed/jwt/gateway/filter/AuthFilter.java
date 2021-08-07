//package wjc.spring.security.oauth2.distributed.jwt.gateway.filter;
//
//import com.alibaba.fastjson.JSON;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.OAuth2Request;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//import wjc.spring.security.oauth2.distributed.jwt.gateway.common.EncryptUtil;
//
//import java.util.*;
//
///**
// * @author Administrator
// * @version 1.0
// **/
//public class AuthFilter implements GlobalFilter, Ordered {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//
//        //从安全上下文中拿 到用户身份对象
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (!(authentication instanceof OAuth2Authentication)) {
//            return chain.filter(exchange);
//        }
//
//
//        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
//        Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
//        //取出用户身份信息
//        String principal = userAuthentication.getName();
//
//        //取出用户权限
//        List<String> authorities = new ArrayList<>();
//        //从userAuthentication取出权限，放在authorities
//        Collection<? extends GrantedAuthority> aus = userAuthentication.getAuthorities();
//        if (!CollectionUtils.isEmpty(aus)) {
//            aus.forEach(c -> authorities.add(c.getAuthority()));
//        }
//
//        OAuth2Request oAuth2Request = oAuth2Authentication.getOAuth2Request();
//        Map<String, String> requestParameters = oAuth2Request.getRequestParameters();
//        Map<String, Object> jsonToken = new HashMap<>();
//        jsonToken.put("principal", principal);
//        jsonToken.put("authorities", authorities);
//
//        if (!CollectionUtils.isEmpty(requestParameters)) {
//            jsonToken.putAll(requestParameters);
//        }
//
//        // 修改请求数据：https://blog.csdn.net/djrm11/article/details/114380867
//        ServerHttpRequest decorator = exchange
//                .getRequest()
//                .mutate()
//                .header("json-token", EncryptUtil.encodeUTF8StringBase64(JSON.toJSONString(jsonToken)))
//                .build();
//
//
//        return chain.filter(exchange.mutate().request(decorator).build());
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
