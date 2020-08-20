[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# SpringBoot RESTful API 脚手架

## 简介

这是一个基于`SpringBoot`，用于搭建`RESTful API`工程的纯净脚手架，只需`三分钟`你就可以开始编写业务代码，不再烦恼于构建项目与风格统一。

## 快速开始

### 先决条件

首先本机先要安装以下环境，建议先学习了解springboot基础知识。

- [git](https://git-scm.com/)
- [java8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 
- [maven](http://maven.apache.org/) 

组织架构

```
Springboot
├─docs  项目SQL语句以及文档
│
├─attachments 附件管理模块
├─common 公共模块
│  ├─base Base继承通用类
│  ├─conf springBoot所有配置
│  ├─domain 前台返回包
│  ├─druid druid连接池
│  ├─exception 异常处理包
│  ├─file 文件上传
│  ├─interceptor 拦截器
│  ├─log 日志记录AOP
│  ├─result 接口返回实体
│  ├─quartz Spring定时器
│  └─support 工具包
│
├─controller 请求访问模块
│
├─Mapper Dao模块
│
├─Model 实体类模块
│
├─Service 服务层模块
│
├─shiro 权限模块
│  ├─config shiro配置
│  ├─service shiro服务层
│  └─util shiro通用方法
│
├─util 工具模块
│
├─SpringbootSwagger2Application 启动类
│
├─test 测试类
│
├─resources 配置文件夹
│  │   │
│  │
│  ├─mybatis mybatis Mapper.xml生成文件夹
│  │   ├─auto自动生成的Mapper.xml文件夹
│  │   └─custom 手写Mapper.xml文件夹
│  │
│  ├─application-dev.yml 开发环境配置
│  ├─application-prod.yml 生产环境配置
│  ├─banner.txt springboot 启动动画
│  
└─pom.xml   maven.xml
```

### 技术选项

技术|名称|官网|备注
---|---|---|---
springboot|springboot框架 ||
Apache Shiro|权限框架||
PageHelper|MyBatis物理分页插件||
Log4J|日志组件||
Swagger2|接口测试框架||
Maven|项目构建管理||
druid|阿里连接池||
quartz|定时框架||


