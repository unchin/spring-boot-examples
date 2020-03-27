package com.steven.oauth2service.service;


import com.steven.oauth2service.entity.Client;

public interface ClientService {
    /**
     * 根据clientId查询Client信息
     * @return
     */
     Client findByClientId(String clientId);

    /**
     * 根据clientSecret查询client信息
     */
     Client findByClientSecret(String clientSecret);

}
