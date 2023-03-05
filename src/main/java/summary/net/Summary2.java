package summary.net;

public class Summary2 {
    /**
     * 单点登陆
     * 方法1 用户登入一个模块后 把session存储到服务器 然后把该session往别的模块到服务器都复制一份 登陆时候就不用重新登陆
     * 方法2
     * 使用cookie+redis
     * 用户登陆一个模块的时候，把用户ID作为key存储到redis里 value为用户信息，key要保证唯一性，然后把key加到cookie里
     * 用户用该cookie去访问别的模块，服务端先根据cookie里到key去redis查找看有没有该用户信息
     * 方法3
     * 使用token（规则生成的字符串）
     * 用户访问一个模块的时候，服务器端会给他返回一个字符串（可以包含用户信息的字符串），用户访问别的模块请求就会带着这个字符串（字符串可以是在cookie里，
     * 也可以在地址栏里）服务端解析字符串就能判断是不是用户信息
     *
     *
     *
     * 拥塞控制
     * 慢开始、拥塞避免、快重传、快恢复
     *
     *
     * 根服务器（根域名服务器 主要负责顶级域名的解析）
     * 13台根服务器 一个主根 12个辅根 根服务器里面的记录很少 主要存储的是顶级域名
     * 我们访问的是递归域名服务器 递归域名服务器在运营商中 递归域名服务器会存储根服务器的镜像数据 起到了根服务器的作用
     * 根域名服务器用来管理顶级域服务器
     * 并不是直接把域名转成IP 而是告诉本地域名服务器应该查询哪个顶级域服务器
     *
     * 域名解析的方式有几种：递归和迭代
     * 递归比较少
     * 一般是递归+迭代
     * 主机向本地域名服务器查询是递归
     * 本地域名服务器向根域名服务器查询是迭代
     *
     * 浏览器缓存--host文件--本地域名服务器--根服务器--顶级域域名服务器 ---权威服务器
     * --本地域名服务器 --IP
     *
     * 顶级域；最后一级的那个域名
     * gtld 通用顶级域
     * ggtld 国家顶级域
     * 根域名服务器
     * 根镜像节点是根域名服务器的数据同步 但是没有数据修改的权限
     *
     * OSI七层：应 表 会 传 网 数 物
     * TCP/IP四层：应 传 网 数
     * 实际：应 传 网 数 物
     *  引用层传输的数据：报文
     *  传输层：段
     *  网络层：包
     *  数据链路层：帧
     *  物理层：比特
     *  报文+原端口+目标端口==段
     *  段+源Ip+目标IP = 包
     *  包+源MAC+目标Mac=帧
     *
     *  网络号+主机号--》完整IPV4
     *  为了解决简单分类导致的IP分配不合理 就造成了子网掩码
     *
     *
     *  ssl证书 服务器申请证书的原因就是让别人知道自己是真实的 不是伪装的
     *  客户端检验SSL证书就是确保避免出现服务器是伪造的情况
     *  等会试着抓一个https的包
     *
     *
     *  http之间的区别
     *  1.1会队头阻塞
     *  2 多路复用
     *
     *
     *
     *
     *
     * ping 测试两个主机的连通性
     * 向目的主机发送多个ICMP的请求报文
     * 根据目的主机返回的回送报文时间和成功响应次数估算数据包往返时间和丢包率
     *
     *
     * 有IP地址为什么还要MAC地址
     * 因为IP地址可以自己修改 MAC不行
     * 那只用MAC 不用IP可以吗
     * 只用Mac地址 网络中的设备越来越多 整个路由过程越来越复杂 就会不方便
     *
     *
     *
     *
     * SYN 发起一个新连接
     * FIN 释放一个连接
     * ACK 确认序号有用 当ACK=1时候确认号字段才有用 ACK=0时候 确认号无效
     *
     * seq是序列号
     * ack确认号字段
     *
     *
     * 三次握手
     * seq=x
     * ack = x+1 seq = y
     * ack = y+1 seq = x+1
     * 第一次握手之后 client状态为syn-sent 服务器端是listen
     * 第二次握手之后 client状态为syn-rcvd client为syn-sent
     * 第三次握手 状态都变成establish
     * 第三次的报文才可以携带数据
     *
     * 第一次握手 建立连接 会占用一个序列号 但三次是没有序列号的
     *
     *
     * 四次挥手
     * seq =u
     * ack = u+1 seq = v
     * ack = u+1 seq = w
     * ack = w+1 seq = u+1
     * 第一次：客户端发起关闭报文 此时状态为fin-wait-1 并停止发送数据 服务器端为close-wait
     * 第二次：服务端接受到请求 发出确认 此时客户端状态为fin-wait-2
     * 第三次 服务器端确认没有要向服务器发送的数据 就通知客户端释放连接 此时
     * 客户端状态为time-wait 服务器端为last-ack ---
     * 第四次 客户端确认关闭 等待2msl之火 双方都进入closed
     *
     *
     * time_wait和close_wait的区别
     * time_wait是主动关闭形成的
     * close_wait是被动关闭形成的 客户端发送FIN报文 服务器端返回ACK报文 就进入close_wait
     *
     * 为什么要time_wait
     * 主动close之后 对方确认后 我方的状态就会改成Time-wait
     *
     *
     *
     * 为什么2msl
     * msl:报文最长寿命，这是一个IP数据包在网上生存的最长时间
     * 由于网络的不可靠性 为了服务器端在规定时间内未收到ACK报文会重新给客户端发FIN 保证服务器端正常关闭
     *
     *
     *
     * http1、1.1与2的区别
     * 1.1 支持长链接，1.1增加了多个错误状态码，
     * 2.0 多路复用，头部压缩（header里信息压缩 避免重复传输）
     *
     * 客户端访问服务器端 带着cookie 服务器会给客户端返回sessionID  服务器端保存一份session
     * 下次请求客户端就把cookie+sessionId 一起发送
     *
     *
     * 套接字：IP+端口
     *
     * 半连接状态
     *  第二次握手完成等待第三次握手
     *
     *
     * syn攻击
     *  第三次握手之前 是半连接状态 服务器端此时是syn rcvd 之后是establish
     *  SYN攻击是指 客户端伪造大量不存在的IP 服务器端回复确认包 等待客户端回应
     *  （就是第二到第三次的握手）
     *  由于IP不存在 服务器端需要不断的重发直至超时  伪造的SYN包长时间占用队列
     *  此时SYN正常请求会被丢弃 导致系统出现异常
     *
     *  如何防御SYN
     *  缩短超时时间
     *  增加最大半连接数
     *  增加网关维护
     *
     * 怎么判断SYN
     * 服务器上有大量半连接状态 而且IP是随机的
     *
     *
     * 哪些握手可以带数据
     * 第三次握手，因为第三次已经是establish状态了
     * 第二次不能带是因为假如如果带了会使服务器消耗非常多的资源来接受数据
     *
     *
     * 沾包
     *
     *
     * 全双工与半双工
     * 全双工：双向数据传输 半双工：单向数据传输
     *
     * NIO编程
     * 具体说一下可靠性
     * 校验和：
     * 序列号
     * 超时重传：
     * 拥塞控制：慢开始、拥塞避免、快重传、快恢复
     *
     *
     *
     *
     */


}
