#summary-0909
##20180904
#####IntegerTest && FloatingTypeTest && CharTypeTest 
####basic
java整数类型有byte,short,int,long,运算过程中计算的是数字的补码,首位是符号位,char都是java的基本数据类型,默认值是'\u0000'(16位)
####1.>>>  (unsigned ) && >>(signed).

``` 
assertEquals(-Math.pow(2,31),0x80000000 >>> 32)    
```
移到尽头会移回去    
10000……1000     
unsigned 01000……0100     （>>）(原码)      
signed  10000……0100    （>>>）.  （原码）
```
assertEquals(0xC0000004,0x80000008 >> 1);       
assertEquals(0x40000004,0x80000008 >>> 1);
```
####2.判断首位是不是符号位

```
@Test
    void should_return_symbol_int_type() {
        for (int i = Integer.MIN_VALUE; i < 0; i++) {
            assertEquals(1,i >>> 31);
        }
        
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            assertEquals(0,i >>> 31);
        }

        for (int i = 0; i < 31; i++) {
            assertEquals(true,(1 << i) >= 0);
        }
    }
```
####3.MAX_VALUE and MIN_VALUE
```
Integer.MAX_VALUE = 0x80000000;
Integer.MIN_VALUE = 0x7fffffff;
Integer.MIN_VALUE = Integer.MAX_VALUE + 1;
```
####4.补码. 
正数的补码和原码相等，负数的补码在其原码的基础上, 符号位不变,    其余各位取反, 最后+1. 写的时候都是写的数的补码      
eg:0x80000000 == -0x80000000. (补码是其本身)    
 
####5.整数类型
 byte(8),short(16),int(32),long(64),float(32),double(64).      
注:从下向上转可以隐式转换,从上向下需要显示转换

####6.byte && bite
1 byte = 8 bite.  
int:4byte

#####7.补充   
循环不可能发生栈溢出，栈溢出可能发生在函数调用过深（递归）


##20180905
####BooleanOperatorsTest && ArrayTest && StringTest
####basic 
boolean 是java的基本数据类型,默认值是false,array 和 string都是对象.

####1.& | ~ priority.  
~ > & > |   
command + shift +option + down: exchange two parameters.

####2.default value

| Data Type	   | Default Value (for fields)          |
| ------------- |:-------------:| 
|    byte       |      0        | 
|     int       |      0        |   
| long | 0L      |   
| float | 0.0f|
| double | 0.0d|
| char | '\u0000'|
|String (or any object) | null|
| boolean | false|

####3.String
String 是一个object/array（具体可参考源码），在没有运行构造函数之前，它的值时null(对象的初始值)

####4.final
eg

```
public final char originalString[] = {'1','2','3','4','5','6'};
originalString[0] = 6;
```

explanation:final表示的是绑定关系不变，object里面的内容可变。
#####4.boolean(method里面和file里面不一样)
1.如果在一个方法里面，
声明一个boolean值但没有初始化，它的值不是false，eg:    
<pre>
  boolean test;
  assertFalse(test);
</pre>

上面这段代码会报错，因为test没有初始化   
 
2.如果是filed，
声明boolean值但没有初始化，它的值是false(有初始值)，

其他的原始变量都是一样的情况

#####5.boolean数组
在方法里面，数组里面的每个值有初始值
#####6形式参数&&实际参数
argument 实际参数。  
parameter 形式参数        

```
SimpleObjectWithInternalState instance = new SimpleObjectWithInternalState("Initial Name");
tryingToUpdateState(instance);
private static void tryingToUpdateState(SimpleObjectWithInternalState instance) {
        instance.setName("Updated Name");
    }
```
调用函数里面的instance是实际参数，函数参数里面的instance是形式参数

####7.函数传参
1.传值:参数是基本数据类型。   
2.传引用:参数是object

####8. …
可变长参数

####9.unicode&&codepoint&&utf-8

codepoint 是四byte，整型，utf-8是unicode的一种实现方式，可以用1～4字节来表示,目前java 使用的是utf-16

##20180906
####InheritanceTest && ReflectionTest
####basic
inheritance,多个子类可以继承一个superclass,一个类只能继承一个superclass,继承链不能跨级调用
reflection,可以利用反射取到Class内部的信息,用来做验证.
####1. .class Vs Class
.class:类的描述信息的 例(Object)    
Class:类    
注:简历和人的关系
####2.static
is shared by all the instances
####3.实例化过程

####4.super,this
super:调用父类的实例，    
this:调用当前对象的实例   
两个关键字都只能用在方法的第一行（只能用一次，且不能同时出现） 

####5.堆，栈
common:ram.   
difference<br>
stack:value      
heap:address     
todo :jvm

####6.reflection
反射可以取到类内部的信息，可以用这个特性来进行测试
eg:
<pre>
 @Test
    void should_be_able_to_print_all_static_methods_of_double() {
        Class<Double> doubleClass = Double.class;
        // <--start
        String[] publicStaticMethods = Arrays.stream(doubleClass.getDeclaredMethods())
                                .filter(method->Modifier.isPublic(method.getModifiers())
                                        && Modifier.isStatic(method.getModifiers()))
                                .map(method ->method.getName()).toArray(String[]::new);
        // --end-->
        final String[] expected = {
            "compare", "doubleToLongBits", "doubleToRawLongBits", "hashCode",
            "isFinite", "isInfinite", "isNaN", "longBitsToDouble", "max",
            "min", "parseDouble", "sum", "toHexString", "toString", "valueOf",
            "valueOf"
        };
        assertArrayEquals(expected, publicStaticMethods);
    }
</pre>
####7.annotion
注解是告诉编译器一些信息，删掉不会对运行产生实质性的影响类型(spring的注解是用反射实现的)

####8.补充
todo:jvm

###20180907
####1.codepoint
<pre>
private int[] getCodePointsFromString(String withSurrogatePairs) {
        int length = withSurrogatePairs.codePointCount(0,withSurrogatePairs.length());
        int[] result =  new int[length];
        int codePointIndex = 0;
        for (int charIndex = 0; charIndex < withSurrogatePairs.length();
             charIndex += Character.charCount(withSurrogatePairs.codePointAt(charIndex))) {
            result[codePointIndex++] = withSurrogatePairs.codePointAt(charIndex);
        }
        return result;
    }
</pre>

注意:这里不能直接index加1,应该加上字符的size.

####2.equal    
参考源码,以Object.equal(Object object)为例,层层嵌套之后,
判断完null之后,最后调用的是自己重写的equal方法,    
重写equal方法的时候,一定要重写hashcode方法

####3.interface
1)multi implemen.  
2)No self implement
3)except abstract,static or default.  
4)field tobe static default final public.  
5)No initialization.  
6)Only extends interface.    
7)class implements an interface, the class must override all methods.   
8)static method can not inherit.   
9)method to be public
10)default mmethod can inherite
11)to be abstract.   
12)to be package-private
13)can be type能作为一种类型去使用
####4.Comparable
####5.匿名类
功能式接口，里面只有一个抽象函数，实例化的实例可以写成匿名类的样式，
<pre> 
GenericFunc<ArrayList<Integer>> lambda = new GenericFunc<ArrayList<Integer>>() {
            @Override
            public ArrayList<Integer> getValue() {
                return new ArrayList<>();
            }
        };
</pre>
如果再进一步简化，可以将其写成lambda表达式的表达样式
<pre>
GenericFunc<ArrayList<Integer>> lambda = () -> new ArrayList<>();
</pre>

####6.closure
函数加运行环境(定义环境),匿名函数类可以看作一个闭包


##shortcuts
#####1.插入自定义代码块
cmd + j     
#####2.跳转到类型声明处？？？
cmd + option + B
#####3.删除到单词的开头
option + del 
#####4.添加书签
option + f3
#####5.跳到下一个错误
option + f2
#####6.提取参数
cmd + option + p
#####7.调用层级结构
control + option + h
#####8.恢复程序运行，如果该断点下面代码还有断点
cmd + option + r&&f9
#####9.切换断点
cmd + f8
#####10.左右切换代开的tab页
ctr + tab
#####11.打开相应的
cmd + 1/2/3/4
#####12.连续选中代码块
option + up
#####13.切换全凭模式
ctr + cmd + f
#####14.优化import
control + option + O
#####15.自动缩进行
ctr + option + i
#####16.包围代码
cmd + option + t

#####17.注释
cmd + /

#####18.自动结束代码
cmd + shift +enter
 
####19 safe delete
 Command + Delete 
 
#####20.编译选择的文件
Command + Shift + F9

#####21覆盖方法
ctr + o

#####22查找所有类型文件
Command + Shift + O

#####23跳转到声明处
cmd +  B

#####24显示方法层次结构
cmd + shift + H/cmd + f12

#####25前往当前光标所在方法的父类的方法 / 接口定义
Command + U

#####26恢复程序运行，如果该断点下面代码还有断点则停在下一个断点上
Command + Option + R

#####27打开项目结构对话框
cmd +;

cmd + shift +u
#####27基本代码补全！！！！
control + space

#####28.切换文件窗口
cmd + shift +[/cmd + shift +]


 

