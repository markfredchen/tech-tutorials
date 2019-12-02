# 使用方式

1. 启动 zipkin-server
```shell script
docker run -d -p 9411:9411 --name zipkin_server openzipkin/zipkin
```
2. 启动`ZipkinBarServiceApplication`
3. 启动`ZipkinFooServiceApplication`
4. `sleuth.http` 调用API

# 20191126 笔记

## Spring Cloud Zipkin

1. Zipkin `@EnableZipkinServer` 已经deprecated。官方已经不支持自定义Zipkin Server
2. 使用docker启动官方zipkin server
```shell script
docker run -d -p 9411:9411 --name zipkin_server openzipkin/zipkin
```
3. Sleuth 使用时，在调用其它service时使用的RestTemplate一定要添加`TracingClientHttpRequestInterceptor`
```java
@Bean
public RestTemplate restTemplate(HttpTracing tracing) {
    return new RestTemplateBuilder().additionalInterceptors(TracingClientHttpRequestInterceptor.create(tracing)).build();
}
```
        