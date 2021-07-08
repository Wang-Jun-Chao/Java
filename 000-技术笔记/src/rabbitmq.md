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







