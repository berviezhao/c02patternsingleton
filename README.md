# 单例模式
单例模式特点： 
1、 构造方法私有化；
2、 提供全局访问点getInstance()方法；

常见单例模式包括：饿汉式单例、懒汉式单例、注册式单例、ThreadLocal线程单例
## 饿汉式单例
饿汉式单例是在类加载时立即初始化，并创建单例对象。

特点：

1、绝对线程安全，在线程还没出现之前就实例化了，不存在线程访问安全问题。

2、没有任何的锁、执行效率比较高，在用户体验上来说，比懒汉式更好。

缺点：

1、类加载时就初始化，不管用与不用都占着空间，浪费了内存，有可能占着内存，从没用过。

Spring中IOC容器ApplicationContex本身就是典型的饿汉式单例。
利用类加载机制：先静态、后动态；先属性、后方法；先上后下。

饿汉式两种写法：

一种是创建静态对象，在类加载时就被实例化。如：HungrySingleton

另一种是利用静态代码块的机制，在静态代码块中实例化。如：HungryStaticSingleton

适用：单例对象较少情况。
## 懒汉式单例
常见懒汉式单例包括：简单懒汉单例、懒汉式线程安全模式单例、双重检查线程安全模式单例、内部类懒汉单例。
### 简单懒汉单例 （LazySimpleSingleton）
特点：1、被外部类调用的时候内部类才会被加载，相较于饿汉式单例性能有所提升。

缺点：1、线程不安全。
### 懒汉式线程安全模式 （LazySychronizedSingleton）
特点：1、在实例化getInstance()方法前，增加sychronized使得线程安全

缺点：1、不可避免方法锁存在性能问题，即线程阻塞问题
### 双重检查线程安全模式单例 （LazyDoubleCheckSingleton）
特点：1、将sychronized关键字放在getInstance()方法内部，并在锁前和锁后同时检测

缺点：1、相较方法锁能够好一些，但是依然存在性能问题
### 内部类懒汉单例 （LazyInnerClassSingleton）
特点：
1、全程无sychronized关键字；
2、利用类加载特性：大类被加载前线检查是否有内部类，
如果有内部类会先加载内部类，
但不会执行内部类中的方法，
只有被用到时才会调用执行。
3、解决了线程安全问题
缺点：也是以上所有懒汉式单例的缺点，会被反射或反序列化的类安全问题可参考SeriableSingleton及其Test类

SeriableSingleton展示了实现序列化的单例会被反序列化的问题，
但是我们在反序列化过程中发现如果重写readResolve()方法，
则可避免被反序列化造成线程安全问题。
但是依然会被反射破坏单例。
## 注册式单例
注册式单例又称登记式单例，就是将每一个实例都登记到某一个地方，使用唯一的标识获取实例。
注册式单例有两种写法：一种为枚举登记，一种为容器缓存。
### 枚举登记 （EnumSingleton）
特点：利用枚举的特性，通过枚举类被编译后的结果可以看到枚举类是饿汉式单例模式，天然的线程安全。
同时JDK层面时的枚举不能被反射和反序列化破坏。
枚举式单例也是《Effective Java》书中推荐的一种单例实现写法。
### 容器缓存式单例 （ContainerSingleton）
特点：适用于创建实例非常多的情况，便于管理。但是，非线程安全的。
同时Spring中也使用了的容器式单例
## ThreadLocal线程单例 （ContainerSingleton）
特点：不能保证其创建的全局唯一，但是能保证在单一线程中唯一，天生的线程安全。
## 单例模式小结
单例模式可以保证内存中只有一个实例，减少了内存开销；可以避免对资源的多重占用。
单例模式看起来非常简单，实现起来也比较简单。








