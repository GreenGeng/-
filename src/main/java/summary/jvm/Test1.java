package summary.jvm;

public class Test1 {
    /**
     * 常见的垃圾回收算法
     * 标记清除：标记引用的对象，没有被饮用的就是垃圾对象
     * 缺点：效率低，碎片化严重
     *
     * 标记压缩：标记引用的对象，把存活的对象压缩到内存另一边，然后清除边界以外的垃圾
     * 缺点：效率低，但是解决了碎片大的问题
     *
     * 标记复制
     * 优点：垃圾对象多的话，效率高且无碎片
     * 缺点：垃圾对象少的话，不适用
     *
     * 分代收集
     *
     * 对象如何分配空间（内存分配的方法）
     * 指针碰撞和空闲列表
     * 指针碰撞：Java堆中，已使用和未使用的内存分别在两侧，中间用指针做分解，需要分配内存的时候，
     * 把指针往空闲的一端移动和对象等大的距离即可（就是移动指针就行）
     * 空闲列表法：JVM维护了一个列表里面记录了内存块信息，分配时从列表中找到一个足够大的内存块分给
     * 对象实例，并更新列表记录
     *
     * 新生代
     * 垃圾回收频繁
     * 永久带存储了类信息，常量、静态变量，一般不GC
     *
     *
     *
     *
     *
     *
     *
     */
}