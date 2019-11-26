# 使用方式

1. 启动 zipkin-server
```shell script
docker run -d -p 9411:9411 --name zipkin_server openzipkin/zipkin
```
2. 启动`ZipkinBarServiceApplication`
3. 启动`ZipkinFooServiceApplication`
4. `sleuth.http` 调用API
