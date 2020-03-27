package com.steven.oauth2service.entity;

import lombok.Data;

/**
 * 客户端信息表
 * @author StevenGuo
 * @date 18:00 2019/7/25
 **/

@Data
public class Client {
    private String id;
    private String clientName;
    private String clientId;
    private String clientSecret;
}
