# tbbs
## SpringBoot BBS 后端
### 环境
JDK8

### 说明
包含 gradle，clone 后配置一下 mysql 用户密码，然后 cd 到根目录执行 ./gradlew bootRun，默默等待一切 ok

**不需要手动建表，只需要确认数据库可正常连接即可**

运行成功后访问 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) 即可见接口列表

登陆需要一个默认用户，执行 resources 下的 init.sql 即可生成一个 可登陆的用户
默认用户名 user 默认密码 password

### 简介
- 容器使用 undertow ，为了减小包体积，而且据测试数据看 untertow 性能很好
- 目标是除主要业务逻辑外尽可能少写代码
- lombok 替代冗长的 getter setter
- 使用 SpringSecurity 进行用户权限管理，接口权限管理注解化
- 数据层使用 jpa, 减少啰嗦的代码同时提高可读性
- swagger 自动化 api 文档

## 前端，计划用 react + reudx + material-ui 
