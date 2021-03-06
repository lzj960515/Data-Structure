# 位图算法(BitMap)

### 问题

假设有2亿个数，范围在0~3亿，给出一个数，判断这个数是否存在该2亿个数之内？使用内存不得超过500M

## 解决方式

定义一个3亿长度的整型数组int[]，预先将所有数初始化，判断是否存在时只需int[number] != 0 即可判断。

时间复杂度：O(1)

空间复杂度：3亿 * 4 / 1024 / 1024 = 1144.5M

> 使用内存不符合要求, 那么我们应当如何解决呢？这时，就该用到BitMap了

## 前置知识

### 位移

位移分为左移和右移

- 左移

  1 << 2 = 4; 表示1往左移2位，我们用二进制如下表示

  ```
  # 1的二进制
  0000 0001
  # 左移2位
  0000 0100 -> 4
  ```

- 右移

  4 >> 2 = 1; 表示4往右移2位，用二进制如下表示

  ```
  # 4的二进制
  0000 0100
  # 右移2位
  0000 0001 -> 1
  ```

### 逻辑运算

- 与运算

  5 & 4 = 4；表示两个数的二进制位做与运算，同位皆为1则结果为1，否则为0

  ```
  # 5
  0000 0101
  # 4
  0000 0100
  # 与运算
  0000 0100 -> 4
  ```

- 或运算

  5 ｜ 4  = 5; 表示两个数的二进制位做或运算，同位有一个为1则结果为1，都为0则为0

  ```
  # 5
  0000 0101
  # 4
  0000 0100
  # 或运算
  0000 0101 -> 5
  ```

- 异或

  5 ^ 4  = 1; 表示两个数的二进制位做异或运算，同位不同则结果为1，相同则为0

  ```
  # 5
  0000 0101
  # 4
  0000 0100
  # 或运算
  0000 0001 -> 1
  ```

## 使用BitMap

我们知道，整型所表示的二进制位有32位，假设我们一个数存在则在该数的位置上表示1，不存在则表示0，则1个整型可表示32个数是否存在，如表示3是否存在的二进制为 `0000 1000`，那么我们的内存将会瞬间缩小32倍！

如假设我们有N个数{3, 10, 36, 66}，则我们开出int[MAX/32+1]的int数组，**这里的MAX指这些数中的最大的数**，所以我们这里是开出3个长度int数组，具体结构表示如下：

```
data[0]: 0~31
data[1]: 31~63
data[2]: 64~95
```

假设我们要判断65是否存在，那么我们可以通过以下方式计算：

`65 / 32 = 2` -> 定位到在下标为2的数组中：data[2]

`65 % 32 = 1` -> 定位到65在data[2]的二进制的下标位置：1

所以我们只需通过一个除法，一个取余，就得到了65所在的位置，这时只需看看这个位置是否为1，就能判断65是否存在了。那这个`看`是怎么看呢？我们画个图表示吧～

因为在给出的数中{3, 10, 36, 66}，在data[2]的数只有66，所以我们的data[2]二进制表示形式如下所示：

![](https://notes.zijiancode.cn/66.png)

> 这里省略了前面24位

而65经过以上的计算方式后的二进制表示形式如下

 		![](https://notes.zijiancode.cn/65.png)

我们将data[2]&65，最后得出为0，则表示65不存在。

> 以上就是BitMap的核心思想了

### 算法实现

算法我们已经明白了，那么代码怎么写呢？

```java
public class BitMap {

    private final int[] data;

    public BitMap(int capacity) {
        this.data = new int[capacity + 1];
    }
    // element = 5
    public void add(int element) {
        // 0
        int dataIndex = element >> 5;
        // 5
        int location = element & 31;
        // 1 << location = 0010 0000
        //   0000 0000
        // | 0010 0000
        //   0010 0000
        data[dataIndex] |= 1 << location;
    }

    public boolean find(int element) {
        int dataIndex = element >> 5;
        int location = element & 31;
        //   0010 0000
        // & 0010 0000
        //   0010 0000
        int exist = data[dataIndex] & (1 << location);
        return exist != 0;
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(100);
        bitMap.add(5);
        bitMap.add(29);
        bitMap.add(66);
        System.out.println(bitMap.find(5));
        System.out.println(bitMap.find(65));
    }
}
```

> 以上代码实现了添加和查找，那么删除该怎么做呢？这个小问题就留给大家了～

## 小结

以上我们从一个小问题开始讲述了如何通过BitMap进行解决，那么我们使用BitMap的时间复杂度和空间复杂度是多少呢？

时间复杂度：O(1)

空间复杂度：对于整型来说，占用空间是整型数组的1/32，对于以上问题所占用的空间为：

​	3亿 / 32 * 4 / 1024 / 1024 = 35.76M

BitMap如此高效且节约空间，我们能够用它解决哪些问题呢？

- 数据判重
- 对**不重复**的数据进行排序

通过这两点，我们可以扩展出很多的场景应用

- 找不重复的数

- 过滤，如我们有1亿的商品，黑客使用一个不存在的商品id查询我们商品库，由于这个商品不存在，那么就无法走缓存了，最后请求会直接打到数据库上，黑客使用这种方式疯狂查询一个不存在的商品，如果没有别的措施，就会把我们的数据库打垮。那么我们就可以使用BitMap将这些商品id存到内存中，请求是判断这个BitMap中是否存在就可以啦～（其实这就是我们大名鼎鼎的布隆过滤器）
- 统计，我们想要统计系统中用户的连续登陆情况，或者在某个时间段呢哪些天是否登陆，传统做法是将用户登陆情况存到数据库中，假设我们日活1亿用户，那么每日都将增加1亿的数据...但是当我们使用BitMap，这个问题将轻松解决，那么应当如何实现呢？
- 用户标签，根据用户标签推荐用户可能需要的商品
- .....

说了这么多BitMap的优点，那它的缺点是什么呢？

- 处理不了重复数据，只知道存不存在（1或者0）,不知道存在几个
- 因为处理不了重复问题，所以处理不了Hash冲突，如果Hash冲突了，那就不知道这个位置上是谁了
- 因为处理不了Hash冲突，所以不能对String类型进行处理，上面描述时也说明了，开的数组是最大数是什么，就要开多大的数组，假设我们只有10个数（范围0～2亿）,这时候我们也得开2亿的空间，但是不如直接使用Map。

> 如何解决重复问题，且听下回分解～