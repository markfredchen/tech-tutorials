# 使用方式

- 浏览器访问
```http request
http://localhost:8080/oauth/authorize?response_type=token&client_id=mc-authorization-code&redirect_uri=http://localhost:8000/sso
```
- 获取code
```http request
http://localhost:8000/sso?code=3DQ4Gl
```
- 获取access token
```http request

POST http://localhost:8080/oauth/token
Content-Type: application/x-www-form-urlencoded
Authorization: Basic bWMtcGFzc3dvcmQ6MTIzNDU2

grant_type=password&username=admin&password=123456&scope=write read

```