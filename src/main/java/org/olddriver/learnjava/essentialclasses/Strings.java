package org.olddriver.learnjava.essentialclasses;

/**
 * 20200510
 * part 1
 */
public class Strings {
    /*
     * String类表示字符串，String类实例不可变，一旦初始化完毕，实例中名为value字符数组指向对象不可变，value数组中的元素可以通过反射修改
     *
     * String类方法
     * charAt(int)  获取指定索引处字符
     * substring(int)   从起始索引处开始，到当前字符串结尾结束，截取当前字符串，返回子串
     * substring(int,int)   从起始索引处开始，到结束索引结束，截取当前字符串，返回子串
     *                      包含起始索引，不包含结束索引
     * split(String)    在匹配正则的子串位置对当前字符串分割，返回字符串数组
     *                  返回结果中不包含匹配正则的子串，不会包含结尾空字符串
     * split(String,int)    int类型参数用于控制分割次数
     *                      若参数n大于0，最多分割n-1次，数组长度小于等于n，数组会包含结尾空字符串
     *                      若参数n小于0，分割次数不受限，数组包含结尾空字符串
     *                      若参数n等于0，分割次数不受限，数组不包含结尾空字符串
     * trim()   返回新字符串，去除当前字符串首尾空格
     * toLowerCase()    返回当前字符串副本，所有字母转变为小写
     * toUpperCase()    返回当前字符串副本，所有字母转变为大写
     * indexOf(int) 返回当前字符串中指定字符第一次出现的索引
     *              -1表示指定字符不在当前字符串中
     * lastIndexOf(int) 返回当前字符串中指定字符最后一次出现的索引
     *                  -1表示指定字符不在当前字符串中
     * indexOf(int,int) 返回当前字符串中指定字符第一次出现的位置，从指定索引处开始向后搜索
     * lastIndexOf(int,int)    返回当前字符串中指定字符最后一次出现的位置，从指定索引处开始向前搜索
     * indexOf(String)  返回当前字符串中指定子串第一次出现的首字符索引
     * lastIndexOf(String)  返回当前字符串中指定子串最后一次出现的首字符索引
     * indexOf(String,int)  返回当前字符串中指定子串第一次出现的首字符索引，从指定索引处开始向后搜索
     * lastIndexOf(String,int)  返回当前字符串中指定子串最后一次出现的首字符索引，从指定索引处开始向前搜索
     * contains(CharSequence)   判断当前字符串中是否包含指定字符序列
     * replace(char,char)   返回新字符串，使用指定字符替换所有旧字符
     * replaceAll(String, String)   返回新字符串，使用指定子串替换所有匹配正则的子串
     * replaceFirst(String, String) 返回新字符串，使用指定子串替换第一个匹配正则的子串
     * endsWith(String) 判断当前字符串是否以指定后缀结尾
     * startsWith(String)   判断当前字符串是否以指定前缀开始
     * startsWith(String, int)  判断当前字符串子串是否以指定前缀开始，子串从指定索引处开始，到当前字符串结尾结束
     * compareTo(String)    将当前字符串与指定字符串进行比较，比较对应索引处字符
     *                      结果大于0，表示当前字符串大于指定字符串
     *                      结果等于0，表示当前字符串等于指定字符串
     *                      结果小于0，表示当前字符串小于指定字符串
     * compareToIgnoreCase(String)  忽略大小写比较两个字符串大小
     * equals(Object)   判断指定参数是否等于当前字符串
     *                  只有当参数为String类型，且内容与当前字符串相同，返回true
     * equalsIgnoreCase(String) 忽略大小写，判断参数与当前字符串是否相同
     * regionMatches(int,String,int,int)    判断当前字符串子区域是否等于参数字符串子区域
     * regionMatches(boolean,int,String,int,int)    判断当前字符串子区域是否等于参数字符串子区域，可以控制是否忽略大小写比较
     * matches(String)  判断当前字符串是否匹配正则表达式
     *
     * 字符串生成器(StringBuilder)，字符串缓冲区(StringBuffer)
     * StringBuffer线程安全，方法使用synchronized修饰；StringBuilder线程不安全，但单线程情况下效率高于StringBuffer
     * StringBuilder，StringBuffer与String类似，同样存储字符序列，但StringBuilder，StringBuffer中字符序列可以修改
     * StringBuilder长度表示存储字符个数，容量表示已分配的字符存储量，容量会在必要时自动扩充
     * 在预知最终字符串长度情况下，可以设置容量，减少StringBuilder扩容次数
     * StringBuilder类方法
     * StringBuilder()  创建容量为16的StringBuilder
     * StringBuilder(CharSequence)  创建包含相同字符序列的StringBuilder，容量为16加字符序列长度
     * StringBuilder(int)   创建指定容量的StringBuilder
     * StringBuilder(String)    创建包含相同字符串的StringBuilder，容量为16加字符串长度
     * setLength(int)   设置StringBuilder中字符序列长度
     *                  若新长度小于当前长度，会截取字符序列
     *                  若新长度大于当前长度，会使用null填充空位
     * ensureCapacity   确保StringBuilder容量大于指定参数
     *                  新容量应大于指定参数，且大于原容量2倍加2
     * append(boolean)  将参数追加到StringBuilder字符序列末尾，会将参数转为String后追加
     * append(char)
     * append(char[])
     * append(char[], int, int)
     * append(double)
     * append(float)
     * append(int)
     * append(long)
     * append(Object)
     * append(String)
     * deleteCharAt(int)    删除指定索引处字符
     * delete(int, int)     删除指定范围内字符序列，从起始索引开始，到结束索引-1结束
     * insert(int, boolean) 在指定索引处插入参数，参数转变为String后插入
     * insert(int, char)
     * insert(int, char[])
     * insert(int, char[], int, int)
     * insert(int, double)
     * insert(int, float)
     * insert(int, int)
     * insert(int, long)
     * insert(int, Object)
     * insert(int, String)
     * setCharAt(int, char) 替换指定索引处字符
     * replace(int, int, String)    使用指定参数替换索引范围内的字符序列，替换范围从起始索引开始，到结束索引-1结束
     * reverse()    将字符序列反转
     *
     * 创建字符串的两种方式
     * i.使用字符串常量值创建String对象
     * ii.使用构造器创建String对象
     * 使用字符串常量值创建字符串，会在字符串常量池中寻找指定字符串对象返回引用，若字符串常量池中不存在指定对象，才会
     * 创建该对象，并主动将对象加入字符串常量池中
     * 使用构造器创建字符串对象，可能会在字符串常量池及堆中创建两个对象，并且不会主动将堆中对象加入字符串常量池中
     *
     * 字符串连接符(+)
     * +对Stirng重载
     * 在Stirng初始化器中，使用字符串连接符连接多个字符串(无论是字面常量值或是字符串变量)，编译器直接将多个字符串作为一个字符串处理
     * 当String对象初始化完毕，再使用字符串连接符连接字符串，编译器通过隐式声明StringBuilder实现字符串连接，
     * 不建议在循环中使用字符串连接符连接字符串，会导致创建多个StringBuilder中间对象
     *
     * String格式化
     * jdk5中实现C中格式化输出功能
     * 格式化说明符语法
     * %[argument_index$][flags][width][.precision]conversion
     * 日期时间转换符包含两个字符，前缀字符为t或T，后缀字符表示使用日期时间格式
     */
}
