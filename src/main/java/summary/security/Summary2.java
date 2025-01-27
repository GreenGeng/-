package summary.security;

public class Summary2 {
    /**
     * SQL 注入
     * 一般笼统的称为数字型和字符串型
     * 详细可分为：联合查询、报错注入、时间盲注、布尔盲注等
     * 满足SQL注入的条件：
     * 1 输入可控
     * 2 直接或间接拼接SQL
     *
     * SQL审计：
     * 根据select 或者update等SQL关键字或者是通过执行SQL语句定位到SQL片段
     * 查看SQL语句中是否存在变量引用并跟踪变量是否可控
     * 只有当传进来的参数是String 才可能进行SQL注入
     *
     * Preparestatement里的？占位符是通过SetXXX的方式赋值的
     * SQL语句编译的时候 执行计划会被缓存起来 使用预编译语句比普通语句更快
     *
     * 使用的时候都需要注意
     * like 使用concat拼接
     * in 使用foreach
     * order by 后面的字符如果加了引号就不会被识别为字段 而是普通字符串了 这样order by就会失效
     *
     *
     * #{}底层就是使用？作为占位符来生成preparestatement
     *
     * 常见关键字
     * Statement、createStatement、PrepareStatement、like $、in($、等
     *
     * 二次注入
     *
     * 防护
     * 预编译
     * orderby需要手动过滤
     * 因为SQL注入基本上都是因为String类型的参数导致的
     * 可以类型转换 为Int类型等也可避免注入
     *
     * =======================================================================
     *
     * 一般测试框架的测试程序
     * 1、身份鉴别管理测试
     * 角色定义测试、用户注册测试、账号权限变化测试、账号枚举测试、若用户名策略测试
     * 2、认证测试
     * 口令信息加密传输测试、默认口令测试、账号锁定机制测试、认证绕过测试、记住密码功能测试、浏览器缓存弱点测试、密码策略测试、密码重置测试
     * 3、授权测试
     * 目录遍历/文件包含测试、授权绕过测试、权限提升测试
     * 4、会话管理测试
     * 会话管理绕过测试、会话固定测试、CSRF测试、会话超时测试
     * 5、输入验证
     * XSS、HTTP参数污染测试、SQL注入测试、LDAP测试、XML注入、SSI注入、XPath注入、SMTP注入、代码注入、RCE、缓冲区溢出测试、HTTP伪造测试
     * 6、错误处理测试
     * 错误码分析、栈追踪分析
     * 7、密码学测试
     * Padding Oracle测试、非加密信道传输敏感数据测试
     * 8、业务逻辑测试
     * 请求伪造能力测试、完整性测试、过程时长测试、功能使用次数限制测试、流程绕过测试、非预期文件类型上传测试、恶意文件上传测试
     * 9、客户端测试
     * DOM XSS、HTML注入、URL重定向、
     *
     *审计过程
     * 1、输入验证
     * 关键状态数据外部可控、数据真实性验证（检查数据源或通信源、检查是否存在未验证或不正确验证数据的数字签名）
     * 绕过数据净化和验证：检查字符串在查找、替换、比较等操作时候是否存在大小写问题被绕过的情况
     * 字符串验证前未进行过滤、检查HTTP头中web脚本特殊元素
     * 命令行注入、忽略字符串结尾符（字符串不以结尾符结束会造成字符串越界访问）
     * 除0错误、边界值检查缺失、无法执行的死代码、死循环代码
     * 2、输出编码
     * XSS（输入的数据进行展示前应该编码 ）
     * URL重定向 ：检查重定向的站点情况
     *
     *
     * 数据加密
     * 密码安全、随机数安全
     *
     * 数据保护
     * 敏感信息暴露问题
     *
     *
     * 访问控制
     * 1、身份鉴别
     * 身份鉴别过程中暴露多余信息、身份鉴别被绕过、身份鉴别尝试频率限制、多因素认证（口令、验证码）
     *
     * 口令安全
     * 登陆口令、明文存储口令、明文传递口令
     *
     * 权限管理
     * 权限访问控制
     *
     * 文件管理
     * 过期的文件描述符（被引用其他文件）、不安全的临时文件、路径遍历、及时释放文件资源
     *
     * 网络传输
     * 端口多重绑定、消息容量控制（防止DDOS）、
     *
     *
     * =========================================================================================
     * 文件漏洞
     * 任意文件上传
     * 在进行文件上传操作时没有对文件类型进行检测或者检测功能不规范导致被绕过
     * 危害：攻击内网、破坏服务器数据
     * 常见文件上传的方式
     * 文件流方式上传、通过ServletFileUpload上传、通过MultipartFile上传
     * 关键字：
     * fileupload、File、MultipartFile、RequestMethod
     * 防护：采取白名单限制上传类型并对文件进行随机重命名、校验文件后缀名、去除文件名里的特殊字符、上传图片时候通过图片库检测上传文件是否为图片
     *
     *
     *
     * 目录穿越
     *
     *
     *
     * ==========================================================================================
     * XSS
     * 用户将恶意代码植入web页面中 访问该页面时候 恶意脚本就会被执行
     * 危害：XSS蠕虫、植入木马、结合其他漏洞攻击服务器、截屏、等
     * 关键字：<%=、${}、<c:if、<c:out、<c:foreach、ModelAndView、Model、
     * request.getParameter、request.getAttribute、response.getWriter().print()等
     *
     * 反射性XSS：用户输入没经过处理就直接输出
     *
     *
     * 防护：全局过滤器拦截 拦截web 脚本标签 进行转化
     * 对字符采用HTML编码
     * HttpOnly
     *
     * =========================================================================================
     * 命令执行
     *  关键字：Runtime.getRuntime().exec()、ProcessBuilder().start()
     *
     *
     * =========================================================================================
     * URL跳转
     *  关键字：
     *  ModelAndView、sendRedirect()、redirectAttribute()、Location、redirect...
     *  防护：严格控制要跳转对域名
     *
     *
     * =========================================================================================
     * SSRF
     * 服务端请求伪造
     * 危害：
     * 获取内网主机、端口信息，对内网对应用程序进行攻击，利用file协议读取文件，可以攻击内网程序造成溢出
     * 在Java中SSRF仅仅支持sun.net.www.protocol下的所有协议：http、https、file、ftp、mailto、jar及netdoc协议
     * 在Java中可以通过file协议或netdoc协议进行目录操作 以读取到更多的敏感信息
     * 漏洞点：
     * 社交分享、远程图片加载或下载、图片或文章收藏、转码、通过网址在线翻译、网站采集、从远程服务器请求资源等功能处
     * SSRF会使用HTTP请求远程地址  所以有一下关键字：
     * HttpURLConnection.getInputStream、URLConnection.getInputStream、
     * HttpClient.execute、OkHttpClient.newCall.execute
     * Request.Get.execute、Request.Post.execute、URL.openStream、ImageIO.read
     * 上面的方法都可以发起HTTP请求，导致SSRF
     * 不过想支持protocol里的所有协议 只能使用：URLConnection、URL
     * HTTPURLConnection、HttpClient、OkHttpClient.newCall.execute
     * 修复:
     * 限制协议只能为HTTP/HTTPS 防止跨协议
     * 设置内网IP黑名单
     * 设置常见web端口白名单
     * 正确处理302跳转
     *
     *
     * ========================================================================================
     * XXE
     * XML 注入：解析XML文件时候没有禁止外部实体加载导致外部文件或代码被加载 造成XXE
     * 危害：任意文件读取、内网探测、命令执行等
     *
     *
     * =========================================================================================
     * SPEL
     *
     *
     * ========================================================================================
     * JAVA反序列化
     * 最常见的反序列化就是Session
     * 反序列化的根源不是在公共库（公共库可以作为漏洞利用工具），根源在Java程序没有对序列化生成的对象做限制直接反序列化
     * 危害：任意代码执行、对服务器破坏
     * 关键字：
     * ObjectInputStream.readObject、ObjectInputStream.readUnshared、XMLDecoder.readObject、
     * Yml.load、XStream.fromXml、ObjectMapper.readValue、JSON.parseObject
     * 修复：
     * 对反序列化进行校验 在使用inputStream读取的时候 重写里面的resolveclass方法检测白名单
     *
     *
     * ========================================================================================
     * SSTI
     * 服务器端模板注入
     * (python里的)
     *
     * ========================================================================================
     * spring漏洞
     *
     *
     * ========================================================================================
     * structs漏洞
     *
     *
     *
     *
     *
     *
     */
}
