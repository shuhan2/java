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
1 byte == 8 bite.  
int:4byte

#####7补充   
循环不可能发生栈溢出，栈溢出可能发生在函数调用过深（递归）


###20180905
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
```
  boolean test;
  assertFalse(test);
```

上面这段代码会报错，因为test没有初始化   
 
2.如果是filed，
声明boolean值但没有初始化，它的值是false(有初始值)，

其他的初始变量都是一样的情况

#####5.boolean数组
在方法里面，数组里面的每个值有初始值
####6形式参数&&实际参数
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
传值
传引用

####8. …
可变长参数

####9.unicode&&codepoint&&utf-8

codepoint 是四byte，整型，utf-8是unicode的一种实现方式，可以用1～4字节来表示

####10.补充
codepoint不止一个char 和 两个char两种情况

###20180906
####1. .class Vs Class
.class:类的描述信息的实例(Object)    
Class:类
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
注解是告诉编译器一些信息，删掉不会对运行产生实质性的影响
####8.补充
jvm

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
notice:codepoint不止一个char或两个char两种size;
####2.equal
参考源码,以Object.equal(Object object)为例,层层嵌套之后,
<pre>

</pre>
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
函数加运行环境(和执行没关系),匿名函数类可以看作一个闭包
####7.interface
<pre>

</pre>

####8.homework
summary.md,matrixMultiplication,reverseString,postMachine,innerClass,exceptionClass,

