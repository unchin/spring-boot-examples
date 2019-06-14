# shiro 搭建

在 Spring Boot 中整合 Shiro ，有两种不同的方案：
第一种就是原封不动的，将 SSM 整合 Shiro 的配置用 Java 重写一遍。
第二种就是使用 Shiro 官方提供的一个 Starter 来配置，但是，这个 Starter 并没有简化多少配置。

## 原生
- 添加依赖 
- 创建 Realm 
- 创建配置文件 配置 ShiroConfig
- 配置登录 Controller

## Starter
- 添加依赖 
- 创建 Realm 
- 在 application中配置 Shiro 
- 配置 ShiroConfig
- 配置登录 Controller