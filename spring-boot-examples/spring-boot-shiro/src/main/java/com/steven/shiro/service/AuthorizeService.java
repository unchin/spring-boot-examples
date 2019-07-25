package com.steven.shiro.service;

interface AuthorizeService {

    /**
     * 根据客户端id 查询客户端是否存在
     */
    boolean checkClientId(String clientId);

    /**
     * 添加 auth code
     */
    void addAuthCode(String authCode, String username);

    /**
     * 检查客户端安全Key是否正确
     */
    boolean checkClientSecret(String clientSecret);

    /**
     * 检查authCode是否可用
     */
    boolean checkAuthCode(String authCode);

    /**
     * 根据 authCode 获取用户名
     */
    String getUsernameByAuthCode(String authCode);

    /**
     * 添加accessToken
     */
    void addAccessToken(String accessToken, String username);

    /**
     * access token 过期时间
     */
    long getExpireIn();

    /**
     * 检查 accessToken 是否可用
     */
    boolean checkAccessToken(String accessToken);

    /**
     * 根据 accessToken 获取用户名
     */
    String getUsernameByAccessToken(String accessToken);
}
