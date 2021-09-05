# DDD 微服务落地实战

适用用于增删改查，不适用于统计分析

## 模型拆分原则

变化和原有的内容是否具有同一性

- 有：修改原有功能

- 无：引入新的设计

  

> **领域对象持久化设计思想：**
>
> - 将暂时不用的领域对象从内存中持久化存储到磁盘中，在次使用是，根据key到数据库中查找记录，在恢复成领域对象，应用程序继续使用他。

## DDD如何落地到数据库设计

### 继承关系：关系型数据库设计

> **传统的四种关系：**
>
> - 一对一：表字段
> - 多对一：表关联
> - 一对多：表关联
> - 多对多：构造中间表
>
> **非传统：继承关系**
>
> - 处理方式一：继承少，使用一张表存储所有子类数据（多对一）
>   - 优点：简单，整个继承关系数据全部保存在表中
>   - 缺点：表稀疏
>
> - 处理方式二：继承多，子类个性化字段多，不使用父类表，每个子类使用一张完整的表（一对一）
> - 处理方式二：继承多，子类个性化字段多，使用父类表，每个子类使用表，只保存个性化字段（多对一）

### 继承关系：NoSQL数据库设计

> **传统的四种关系：**
>
> - 一对一：使用字段
> - 多对一：换成一对一
> - 一对多：使用数组
> - 多对多：转换成一对多
>
> **非传统：继承关系**
>
> 每个子类使用一个对象存储

## 领域模型如何指导程序设计

**服务：**标识的是在领域对象之外的操作和行为，接收用户的请求和执行某些操作。

**实体：**（可变性）通过一个唯一标识字段来区分真实世界中的每一个个体的**领域对象**。

**值对象：**（不变性）代表的是真实世界中那些一成不变、本质的事物，这样的**领域对象**叫做“值对象”

### 将业务领域模型转换为程序设计的思路

**贫血模型：**软件设计中，有很多POJO对象，出来一对set/get，几乎没有任何业务逻辑。

- 优点：保持了领域模型的原貌，比较直接地映射程序变更，代码修改直接。
- 优点：更简单易行
- 优点：更容易应对复杂业务场景
- 缺点：所以业务都在service中完成

**充血模型：**数据和业务逻辑组合

- 对能力要求比较高
- 对团队协作要求比较高
- 业务在领域对象中实现

### 设计原则

将需要封装的内容放入充血模型中实现。其他的放入贫血模型中设计。

> 那些需要使用充血模型？
>
> - 领域中出现了类似继承，多态的情况
> - 需要将一下类型或者编码进行转换
> - 希望在软件设计中更好地表现领域对象之间的关系
> - “聚合”，在真实世界中那些代表整体和部分的事物

**聚合：**整体和部分的关系。聚合根：外部访问聚合事物的唯一入口。

**仓库：**访问数据库

**工厂：**创建领域模型，是领域模型生命周期的起点

## 界限上下文

每个限界上下文中实现的都是软件变化同一个原因的业务

![image-20210829125828617](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829125828617.png)

![image-20210829150045482](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829150045482.png)

![image-20210829150237418](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829150237418.png)

![image-20210829150304513](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829150304513.png)

![image-20210829150415410](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829150415410.png)



![image-20210829150443607](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829150443607.png)





![image-20210829150711746](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829150711746.png)







![image-20210829150723114](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829150723114.png)



![image-20210829150737771](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829150737771.png)

![image-20210829150755075](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829150755075.png)

![image-20210829150840041](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829150840041.png)



![image-20210829150905098](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829150905098.png)



![image-20210829151145519](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829151145519.png)

![image-20210829151407465](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829151407465.png)

![image-20210829151439718](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829151439718.png)



![image-20210829151752436](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829151752436.png)

![image-20210829151828700](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829151828700.png)

![image-20210829152929864](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829152929864.png)



![image-20210829153034000](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829153034000.png)

![image-20210829153244659](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829153244659.png)

![image-20210829153308945](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829153308945.png)

![image-20210829153326790](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829153326790.png)



![image-20210829153341869](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829153341869.png)

![image-20210829153417033](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829153417033.png)



![](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829153514792.png)

![image-20210829153602260](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829153602260.png)

![image-20210829153631386](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829153631386.png)

![image-20210829153834979](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829153834979.png)

![image-20210829153850678](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829153850678.png)

![image-20210829192458181](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829192458181.png)

![image-20210829192552128](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829192552128.png)

![image-20210829192647770](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829192647770.png)

![image-20210829192821763](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829192821763.png)

![image-20210829192836921](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829192836921.png)

![image-20210829192932192](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829192932192.png)

![image-20210829193028531](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829193028531.png)

![image-20210829193044425](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829193044425.png)

![image-20210829193113581](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829193113581.png)

![image-20210829193307431](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829193307431.png)

![image-20210829193353261](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829193353261.png)

![image-20210829193537784](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829193537784.png)

![image-20210829193715599](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829193715599.png)

![image-20210829194351096](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829194351096.png)

![image-20210829194419699](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829194419699.png)

![image-20210829194440111](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829194440111.png)

![image-20210829194544303](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829194544303.png)







![image-20210829194640254](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829194640254.png)



![image-20210829194733867](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829194733867.png)

![image-20210829195003001](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829195003001.png)

![image-20210829195855332](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829195855332.png)

![image-20210829195912535](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829195912535.png)

![image-20210829200006012](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829200006012.png)

![image-20210829200029551](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829200029551.png)

![image-20210829200044493](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829200044493.png)

![image-20210829200119853](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829200119853.png)

![image-20210829200151594](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829200151594.png)

![image-20210829200231628](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829200231628.png)

![image-20210829200703376](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829200703376.png)

![image-20210829200718871](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829200718871.png)

![image-20210829200801229](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829200801229.png)

![image-20210829200843300](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829200843300.png)





![image-20210829200858044](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829200858044.png)

![image-20210829215703137](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829215703137.png)

![image-20210829220549850](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829220549850.png)

![image-20210829220724618](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829220724618.png)

![image-20210829221348045](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829221348045.png)



![image-20210829221507739](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829221507739.png)

![image-20210829221536920](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829221536920.png)



![image-20210829222801942](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829222801942.png)

![image-20210829223501612](C:\Users\Administrator.AEAOC-610072222\AppData\Roaming\Typora\typora-user-images\image-20210829223501612.png)



