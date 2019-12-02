# 问题


## 20191126
### spring cloud zipkin
- [x] ~~日志中无法打印 service name~~

必须把`spring.application.name`添加在 `bootstrap.yml`中才可以打印出来。
- [x] ~~是否可以不使用eureka~~

Zipkin可以单独使用

- [x] ~~是否可以只使用sleuth~~

可以。不用zipkin采集日志。可以使用spanId去日志中grep

- [ ] `spring.sleuth.sampler.probability=1.0` 如果使用zipkin采集样本不是100%，意义何在？

## 20191127

- gradle `buildscript {}` 需要放在`build.gradle`最外层
- Spring Boot v2.2.x 依赖与Spring Cloud v.Greenwich.SR4有冲突。需要使用Hoxton.RC1
- Spring Security 新版必须指定`PasswordEncoder`
