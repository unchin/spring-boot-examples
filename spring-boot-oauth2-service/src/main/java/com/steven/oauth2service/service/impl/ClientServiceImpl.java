package com.steven.oauth2service.service.impl;

import com.steven.oauth2service.entity.Client;
import com.steven.oauth2service.mapper.ClientMapper;
import com.steven.oauth2service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientMapper clientMapper;

    /**
     * 根据clientId查询Client信息
     * @return
     */
    @Override
    public Client findByClientId(String clientId) {
        Client client = new Client();
        client.setClientId(clientId);
        return clientMapper.selectOne(client);
    }

    /**
     * 根据clientSecret查询client信息
     */
    @Override
    public Client findByClientSecret(String clientSecret) {
        Client client = new Client();
        client.setClientSecret(clientSecret);
        return clientMapper.selectOne(client);
    }
}
