package com.steven.oauth2service.service.impl;

import com.steven.oauth2service.service.AuthorizeService;
import com.steven.oauth2service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AuthorizeServiceImpl implements AuthorizeService {

    private Cache cache;

    @Autowired
    private ClientService clientService;

    @Autowired
    public AuthorizeServiceImpl(CacheManager cacheManager) {
        this.cache = cacheManager.getCache("code-cache");
    }

    /**
     * 根据客户端id 查询客户端是否存在
     *
     * @param clientId
     */
    @Override
    public boolean checkClientId(String clientId) {
        return clientService.findByClientId(clientId) != null;
    }

    /**
     * 添加 auth code
     *
     * @param authCode
     * @param username
     */
    @Override
    public void addAuthCode(String authCode, String username) {
        cache.put(authCode, username);
    }

    /**
     * 检查客户端安全 Key是否正确
     *
     * @param clientSecret
     */
    @Override
    public boolean checkClientSecret(String clientSecret) {
        return clientService.findByClientSecret(clientSecret) != null;
    }

    /**
     * 检查authCode是否可用
     *
     * @param authCode
     */
    @Override
    public boolean checkAuthCode(String authCode) {
        return cache.get(authCode) != null;
    }

    /**
     * 根据 authCode 获取用户名
     *
     * @param authCode
     */
    @Override
    public String getUsernameByAuthCode(String authCode) {
        return (String) cache.get(authCode).get();
    }

    /**
     * 添加accessToken
     *
     * @param accessToken
     * @param username
     */
    @Override
    public void addAccessToken(String accessToken, String username) {
        cache.put(accessToken, username);
    }

    /**
     * access token 过期时间
     */
    @Override
    public long getExpireIn() {
        return 3600L;
    }

    /**
     * 检查 accessToken 是否可用
     *
     * @param accessToken
     */
    @Override
    public boolean checkAccessToken(String accessToken) {
        return cache.get(accessToken) != null;
    }

    /**
     * 根据 accessToken 获取用户名
     *
     * @param accessToken
     */
    @Override
    public String getUsernameByAccessToken(String accessToken) {
        return (String) cache.get(accessToken).get();
    }
}
