# language: zh-CN
@loginCH
@web
功能: 登录
  @p1 @smoketest
  场景: 用正确的用户名和密码登录
    当 我输入正确的用户名"userName"和密码"password"
    当 我点击登录
    那么 我跳转到首页

  @p2 @11
  场景大纲: 用错误的用户名和密码登录
    当 我输入错误的用户名"<userName>"和密码"<password>"
    当 我点击登录
    那么 显示错误"<errorMessage>"
    例子:
      |userName|password|errorMessage|
      |        |        |用户名不能为空！|
      |  test  |        |密码不能为空！|