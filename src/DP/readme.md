#面向对象的原则
maintainability
- 修改功能，需要改动的地方越少，可维护性就越好

reusability
- 代码可以被以后重复使用
- 写出自己总结的类库

extensibility、scalability
- 添加功能无需修改原来代码

flexibility、mobility、adaptability
- 代码接口可以灵活调用
## 单一职责
- single responsibility principle
- 一个类别负责单一职责

高内聚 低耦合

##开闭原则
- open-closed principle
- 对扩展开放，对修改关闭
    - 尽量不修改原来代码的情况下进行扩展
- 抽象化，多态是开闭原则的关键

##里氏替换原则
- liscov substitution principle
- 所有使用父类的地方，必须能狗透明的使用子类对象

##依赖倒置
- dependency inversion priciple
- 依赖抽象而不是具体
- 面向抽象编程

##接口隔离原则
- interface segregation principle
- 每一个接口应该承担独立的角色
- flyable 和 runnable不能合二为一
- 避免子类实现不需要的实现的方法
- 需要对客户提供接口的时候，只需要暴露最小的接口

##迪米特法则
- law of demeter
- 尽量不要和陌生人说话
- 在迪米特法则中，对于一个对象，非陌生人包括以下几类：
    - 当前对象本身
    - 以参数形式传入到当前对象方法中的对象
    - 当前对象的成员对象
    - 如果当前对象的成员对象是一个集合，那么集合中的元素也都是朋友
    - 当前对象所创建的对象
- 和其它类的耦合度变低
    