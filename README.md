# Java8 API 函数式编程指南


-------

★★★ 喜欢这个项目吗? 可以**★Star**一下. Thanks! ★★★


-------

- [ ] 接口可以有default方法，可以有方法体
- [ ] 从匿名内部类到Lambda表达式的初体验
- [ ] 函数式接口


## 接口可以存在```default```方法实现体

Java8允许接口定义自己的方法实现。但是必须是```default```关键字修饰的。
实现类可以覆盖该方法，也可以直接使用该方法。

- IBasic.java 接口

```java
public interface IBasic {

    default void sayHello(){
        System.out.println("Hello");
    }
}


```

- SubImpl 子类实现
```java
public class SubImpl implements IBasic {

    @Test
    public void test(){
        SubImpl sub = new SubImpl();
        sub.sayHello();
    }
}
```

## 从匿名内部类到Lambda表达式

我们来看一个匿名内部类的案例;

```java
List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

Collections.sort(names, new Comparator<String>() {
    @Override
    public int compare(String a, String b) {
        return b.compareTo(a);
    }
});
```

这段代码真是又臭又长是吧，而在Java8中增加了一种方式--lambda表达式来简化匿名内部类的使用：

```java
Collections.sort(names, (String a, String b) -> {
    return b.compareTo(a);
});
```

还可以更短---对于一行方法主体，可以省略大括号{}和return关键字：
```java
Collections.sort(names, (String a, String b) -> b.compareTo(a));
```

但是他还可以更短：
```java
names.sort((a, b) -> b.compareTo(a));
```

因为List在java8中新增了一个```default void sort(Comparator<? super E> c) ```方法。

接下来我们来了解一下更深层次的关于lambda表达式的技巧。


## 函数式接口

lambda表达式是如何适应Java的类型系统的呢?每个lambda表达式对应于由接口指定的给定类型。

### 概念、特征

- 函数接口必须包含一个抽象方法声明
    - 这个接口类型的每个lambda表达式才能匹配到这个抽象方法
- 只要接口只包含一个抽象方法，我们就可以使用lambda表达式

- 为了确保接口符合要求，必须添加```@FunctionalInterface```注解
    - 如果你添加了第二个抽象方法在   ```@FunctionalInterface```标记的接口上，编译器会抛出error
    
    
示例-函数式接口：
```java
@FunctionalInterface
public interface IBasic {

    void sing();
}

```
测试：
```java
@Test
public void java8(){
    // 使用lambda表达式创建了匿名内部类IBasic
    // 然后将其作为参数传入了arg中
    // arg 方法中执行了sing()方法
    // sing() 方法体则为：System.out.println("sing....");
    arg(() -> {
        System.out.println("sing....");
    });
}

private void arg(IBasic basic){
    basic.sing();
}
```
    
   
### 示例

#### 编写函数式接口

```java
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}
```

#### 编写lambda测试方法

```java
@Test
public void test(){
    // 使用lambda表达式获取一个匿名内部类对象
    //Converter<Integer, String> converter = (arg) -> {return Integer.valueOf(arg);};
    // 单行的方法体可以省略return 以及  {}吧。
    Converter<Integer, String> converter = (arg) -> Integer.valueOf(arg);

    // 使用该匿名内部类对象
    Integer convert = converter.convert("123");
    System.out.println(convert);
}
```

-  如果Converter中省略了```@FunctionalInterface```，代码也是正确的，只要你保证Converter只有一个抽象方法。

### 备忘

- 编写函数式接口
    - 编写接口，最好```@FunctionalInterface```标记
    - 接口保证有且只有一个抽象方法
    
- 使用lamdba表达式
    - 使用lambda创建匿名内部类
        - 方法体如果只有一行，则可以省略 ```return``` 以及 ```{}```
    - 调用匿名内部类的抽象方法



## ```::```关键字方法和构造器的引用

- Java8允许通过关键字```::```传递方法和构造器的引用

- ```::``` 引用静态方法

通过使用静态方法引用，可以进一步简化上面的示例代码：
```java
// 使用lambda表达式获取一个匿名内部类对象
//Converter<Integer, String> converter = (arg) -> {return Integer.valueOf(arg);};
// 单行的方法体可以省略return 以及  {}吧。
//Converter<Integer, String> converter = (arg) -> Integer.valueOf(arg);
// 静态方法引用更简洁
Converter<Integer, String> converter = Integer::valueOf;

// 使用该匿名内部类对象
Integer convert = converter.convert("123");
System.out.println(convert);
```

- ```::``` 引用实例方法
我们也可以引用实例方法：

```java
class Something {
    String startsWith(String s) {
             return String.valueOf(s.charAt(0));
         }
}
```

```java
Something something = new Something();
Converter<String, String> converter = something::startsWith;
String converted = converter.convert("Java");
System.out.println(converted);    // "J"
```

- - ```::``` 引用构造器

我们创建一个类，并且编写两个构造器：
```java
class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
```
编写函数式接口：
```java
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
```

```java
PersonFactory<Person> personFactory = Person::new;
Person person = personFactory.create("Peter", "Parker");
```

