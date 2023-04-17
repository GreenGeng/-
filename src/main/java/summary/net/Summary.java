package summary.net;

public class Summary {
    /**
     * NIO
     * 同步非阻塞IO
     *
     * IO是以流的形式 NIO是以块的形式
     *
     *
     * NIO的场景
     * 服务器需要支持大量的长时间连接
     * jetty netty tomcat zookeeper都是NIO的方式实现的
     * 数据从通道读取到缓冲区 或者  从缓冲区写到通道里
     *
     * 先获取channel
     * 创建buffer缓冲区
     * 将数据从channel读到buffer
     *
     * 解决的问题：
     * 解决了阻塞
     *
     *
     * 添加 删除 修改 使用post 不是只是添加
     * 获取使用get
     *
     *
     *
     * 非对称加密的弊端
     * 速度慢  只适合对少量数据加密
     * 计算机资源使用率高
     * 私钥易丢失
     * 密钥位数多
     *
     *
     * 沾包
     *  什么是沾包：发送若干个数据包到接收方时粘在一起了 udp不会沾包
     *  原因：由于tcp协议的nagle算法，会将较小的内容拼接成大的内容，一次性发送到服务器端，或者由于网络的原因
     *  解决：标记数据块大小，或者给数据块加一个分割信息，
     *
     *
     *
     */
}
