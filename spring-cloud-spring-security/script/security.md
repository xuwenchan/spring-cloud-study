spring security作用：
完成统一的认证和授权

spring security oauth2客户端授权模式
1.简化模式 ，不推荐使用
简化模式适用于纯静态页面应用，所谓纯静态也就是
应用没有在服务器上执行代码的权限
这种场景下，应用是没有持久化存储的能力的，因此
按照oauth2的规范，这种应用是拿不到refresh token
，该模式下，access_token容易泄露且不可刷新



2，授权码模式
授权码模式适用于有自己的服务器的应用，他是一个一次性的
临时凭证，用来换取access_token，和refresh_token，认证
服务器提供了一个类似于这样的接口
https://www.funtl.com/exchange?code=&client_id=&client_secret=
需要传入code，client_id,以及client_secure，验证通过后，
返回access_token,和refresh_token，一旦换取成功，
code立即作废，不能在使用第二次，


3，密码模式
4，客户端模式

