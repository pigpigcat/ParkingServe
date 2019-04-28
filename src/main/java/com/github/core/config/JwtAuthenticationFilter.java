package com.github.core.config;

import com.github.core.util.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * token的校验
 * 该类继承自BasicAuthenticationFilter，在doFilterInternal方法中，
 * 从http头的Authorization项读取token数据，然后用jjwt包提供的方法校验token的合法性。
 * 如果校验通过，就认为这是一个取得授权的合法请求
 *
 * @author wulitech
 * @version 1.0
 */
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    private JwtTokenUtils jwtTokenUtils;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtTokenUtils jwtTokenUtils) {
        super(authenticationManager);
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(jwtTokenUtils.getHeader());

        if (header == null || !header.startsWith(jwtTokenUtils.getHead())) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(jwtTokenUtils.getHeader());
        if (token != null) {
            // 解析token
//            String user = Jwts.parser()
//                    .setSigningKey("wulitech")
//                    .parseClaimsJws(token.replace(START, ""))
//                    .getBody()
///                    .getSubject();
            UserDetails userDetails = jwtTokenUtils.buildUserDetails(token.replace(jwtTokenUtils.getHead(), ""));

            if (userDetails != null) {
                return new UsernamePasswordAuthenticationToken(userDetails, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }
}
