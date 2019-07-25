package com.steven.shiro.service;

import com.steven.shiro.entity.Client;

public interface ClientService {
    /**
     * 根据clientId查询Client信息
     */
     Client findByClientId(String clientId);

    /**
     * 根据clientSecret查询client信息
     */
     Client findByClientSecret(String clientSecret);

}
