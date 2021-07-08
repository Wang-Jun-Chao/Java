# 基本概念

**Queue**: 队列，是 RabbitMQ 的内部对象，用于存储消息。

**Exchange**: 交换器。生产者将消息发送到 Exchange，由交换器将消息路由到一个或者多个队列中。如果路由不到，或许会返回给生产者，或许直接丢弃。

**RoutingKey**: 路由键。生产者将消息发给交换器的时候， 一般会指定一个 RoutingKey ，用来指定这个消息的路由规则，而这个 RoutingKey 需要与交换器类型和绑定键 (BindingKey)合使用才能最终生效。

**Binding**: 绑定 RabbitM 中通过绑定将交换器与队列关联起来，在绑定的时候一般会指定一 绑定键 BindingKey ，这样 RabbitMQ 就知何正确将消息路由队列

> 注：。大多数时候，包括官方文档和 RabbitMQ Java API 中都把 BindingKey 和 RoutingKey 看作 RoutingKey
> - 在使用绑定的时候，其中需要的路由键是 BindingKey 。
> - 在发送消息的时候，其中需要的路由键是 RoutingKey 。



# 交换器类型

RabbitMQ 常用的交换器类型有 fanout、direct、topic、headers 这四种

- **fanout**：（全匹配）它会把所有发送到该交换器的消息路由到所有与该交换器绑定的队列中。

- **direct** ：（精确匹配）direct 类型的交换器路由规则也很简单，它会把消息路由到那些 BindingKey RoutingKey 完全匹配的队列中。
- **topic**：（模糊匹配）类型的交换器在匹配规则上进行了 扩展，它与 direct 类型的交换器相似，也是将消息路由到 BindingKey RoutingKey 相匹配的队 列中，但这里的匹配规则有些不同，它约定: 
  - RoutingKey 为一个点号". "分隔的字符串
  - BindingKey RoutingKey 样也是点号"."分隔的字符串
  - BindingKey 中可以存在两种特殊字符串"*"和"#"，用于做模糊匹配，其中"#"用于匹配 个单词，吁"用于匹配多规格单词(可以是零个)。

# 死信队列

[【RabbitMQ】一文带你搞定RabbitMQ死信队列 - 云+社区 - 腾讯云 (tencent.com)](https://cloud.tencent.com/developer/article/1463065)

## 死信队列是什么

死信，在官网中对应的单词为“Dead Letter”，可以看出翻译确实非常的简单粗暴。那么死信是个什么东西呢？

“死信”是RabbitMQ中的一种消息机制，当你在消费消息时，如果队列里的消息出现以下情况：

1. 消息被否定确认，使用 `channel.basicNack` 或 `channel.basicReject` ，并且此时`requeue` 属性被设置为`false`。
2. 消息在队列的存活时间超过设置的TTL时间。
3. 消息队列的消息数量已经超过最大队列长度。

那么该消息将成为“死信”。

“死信”消息会被RabbitMQ进行特殊处理，如果配置了死信队列信息，那么该消息将会被丢进死信队列中，如果没有配置，则该消息将会被丢弃。

# 延迟队列

[rabbitMQ实现延迟消息队列 - 简书 (jianshu.com)](https://www.jianshu.com/p/7e5f0742c8e3)

# RabbitMQ消息大小限制，队列长度限制

[(2条消息) RabbitMQ（四）：RabbitMQ消息大小限制，队列长度限制_cuibin1991的专栏-CSDN博客_rabbitmq消息最大多大](https://blog.csdn.net/cuibin1991/article/details/107930479)

在版本3.7中的源码，我们可以看到最大消息大小为2GiB。

在版本3.8开始是512MiB

> 推荐：客户端与RabbitMQ服务端的最大帧是128K，但消息大小却可支持数MB。消息大小不要超过4MB

# 优先队列

[(1条消息) RabbitMQ：队列优先级和消息优先级的介绍和使用_编程学习者的博客-CSDN博客_rabbitmq优先级队列](https://blog.csdn.net/weixin_45492007/article/details/106187727)
