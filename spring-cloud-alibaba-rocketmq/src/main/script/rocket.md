push  consumer
consumer的一种，应用通常向consumer对象注册一个
listener接口，一旦受到消息，consumer对象立刻回调
listener接口

pull consumer
consumer的一种，应用通常主动调用consumer的拉消息方法
从broker拉消息，主动权由应用控制

producer group
一类producer的集合名称，这类producer通常发送一类消息
但发送逻辑一致

consumer group
一类consumer的集合名称，这类consumer通常消费一类消息，
但消费逻辑一致

broker
消息中转角色，负责存储消息，转发消息，一般也称为server
在jms规范中称为provider

广播消息
一条消息被多个consumer消费，及时这些consumer属于一个
consumer group，消息也会被consumer group中的每一个
consumer都消费一次，广播中的consumer group概念可以认为
在消息划分方面无意义

集群消费
一个consumer group中的consumer实例平均分摊消费消息，
rocketmq天生可实现负载均衡



顺序消费 
消费消息的顺序要同发送消息的顺序一致，在rocketmq中，
主要指的是局部消费，既一类消息为满足顺序性，
必须producer单线程顺序发送，且发送一个队列，这样，
consumer就可以按照producer发送的顺序去消费消息

多master 多slave模式, 同步双写
每个master配置一个slave，有多对master-slave，HA采用
同步双写方式，主备都写成功，向应用返回成功，
优点:数据与服务都无单点，master宕机情况下，消息无延迟，
服务可用性与数据可用性都非常高
缺点:性能比异步复制模式略低，大约10%左右，发送单个消息的RT
会略高，目前主宕机后，备机不能自动切换为主机，后续会支持
自动切换功能









