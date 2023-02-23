package summary;

public class Summary {
    //面试笔记

    //-------------------------------------------------------------------基础
    // 类与类之间是单继承 接口与接口之间是多继承
    // stringbuffer（安全） 和 stringbuilder（不安全）
    // arrayList怎么扩容
    // Hashcode的返回值(int)
    //vector和map的区别
    // vector扩容的原理
    // springbean是不是线程安全的  是不是线程安全和作用域没关系，查看bean这个对象是不是线程安全还得看本身是不是有状态 有则不安全
    //hashmap怎么扩容 1.7的头插法是扩容的时候出现的死循环 所以要提到扩容 这块还得根据代码再看看
    //string为什么不是基础数据类型（因为String对象是System.Char对象的有序集合，基本类型是简单的字符或者数字，引用类型是复杂的数据结构）
    //-------------------------------------------------------------------JVM
    //类加载器有哪些
    //年轻代和老年代的比例（1：2）
    // 可达性分析 根节点是哪些
    //New一个对象 生命周期
    //Jvm常用参数
    // 引用计数法的缺陷
    // 为什么要常量池
    //---------------------------------------------------------------------springboot
    //
    //-----------------------------------------------------------------------设计模式
    // 单例模式
    // 什么时候用单例
    //spring里面的设计模式
    // --------------------------------------------------------------------多线程
    //reentrantlock使用
    //volatile使用
    //线程池销毁线程和使用
    //拒绝策略
    //线程池的状态
    //为什么不用Executors创建线程池
    //多线程和异步的区别
    // 线程池 的工作流程
    // Sleep wait
    // Thread的sleep会进入什么状态
    //如何查看线程死锁
    // Threadlocal里的entry
    //threadlocal内存泄漏
    //  线程之间如何通信
    //--------------------------------------------------------------------mysql+数据库
    //事务隔离级别怎么解决事务的问题
    //怎么加行锁
    //了解一下为什么es倒排索引那么快
    //怎么实现可重复读
    // 跳跃表
    // mybatis的分页
    // 普通索引
    //可为null的字段适合加索引吗 （is null走索引 is not null 不走索引）
    // 数据变化频繁怎么加索引(频繁修改对字段不建议🏠索引，如果数据量大可以考虑分库分表)
    // B+树怎么平衡的
    // Redis指令
    // 慢sql的优化思路
    // char和varchar
    //mysql死锁
    // aof重写的过程
    //聚簇
    //布隆过滤器
    // 分布式ID
    //rdb和aof怎么配合使用
    //------------------------------------------------------------------------网络
    // session怎么失效的（设置最大存活时间）
    //whois信息
    //什么是报文
    //单点登陆（直接复制session、redis+cookie（用户信息存redis key放cookie里 后端解析cookie去redis里查询）、token）
    //nginx怎么负载均衡
    // 分布式session
    //---------------------------------------------------------------------springcloud
    //
    //------------------------------------------------------------------------消息队列
    //topic和group
    //消息队列
    //————————————————————————————————————————————————————————————————————————————
    //—————————————————————————————————————————————————————————————————————————————

    // fign的原理

    //redis分布式锁
    //redis批量处理 批量读写和删除

    //AOP、AQS、KMP
    //为什么用Reactor、Webflux
    //二叉树的题目有时间整理一下
    //堆排序
    //红黑树

    //G1垃圾回收器
    // 拦截器和过滤器谁先执行、过滤器和拦截器的区别、
    // Mirror gc和full gc

    // 拥塞控制算法
    //第三次握手没收到怎么办（重发？还有呢）
    // Tcp限流 滑动窗口
    // Tcp客户端没有找到服务端 他的状态机是什么
    // Tcp可靠性保障
    // 拥塞控制

    // es优化
    //除了b树 b+树还有什么索引结构
    //myisam的索引结构
    // 怎么解决幻读
    // Mvcc加锁实现隔离 为什么要加锁
    // 最左前缀法则索引树是什么样
    // Mysql的日志
    // 建立索引的原则
    //left join和right join的区别
    //回表
    //分库分表
    // mysql里的count准确吗

    // 线程池里的线程工厂怎么使用
    //线程池里多余的线程是怎么回收的
    // Countdownlatch任务失败怎么办
    // 阻塞队列


    // 循环依赖
    //自动装配怎么实现的
    // bean的实例化流程
    // springboot加载顺序
    //Bean的生命周期
    // spring事务

}
