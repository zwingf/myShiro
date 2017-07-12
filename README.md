apache-shiro-webapp-tutorial
============================

A [step-by-step tutorial](http://shiro.apache.org/webapp-tutorial.html) showing how to secure a web app with Apache Shiro.

#v1.0版本
**demo1:**  

shiro.ini:	使用ini配置文件直接配置用于校验的用户名跟密码:[users]可以配置多个。
src\test\demo1\Test1.java: 具体看类注解步骤。

#v1.2版本
**demo2**  
demo2加入了自定义验证信息，shiro会根据配置的验证信息进行验证，而不是ini配置文件中的[users]  

shiro2.ini:	引入shiro的realm概念，realm是shiro中用来沟通用户信息跟shiro验证的“桥梁”，我们在realm中配置自定义的验证信息，然后将该realm加入到安全管理器中： 

	myrealm1= demo2.MyRealm
	securityManager.realms=$myrealm1
