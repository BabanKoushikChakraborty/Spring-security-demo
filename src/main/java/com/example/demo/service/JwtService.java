package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
	public String generateToken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder()
				.setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*3))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();

	}
	
	private Key getKey() {
		byte[] keyBytes= Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
