package org.olddriver.learnjava.syntax;

/**
 * 20200421
 * java语法
 * 第一部分
 */
public class JavaSyntax {
    /**
     * unicode标准
     * 包含字符集和编码规则
     * 字符集中收录世界各个国家的字符，每个字符对应一个码点。
     * 早期使用ucs-2字符集(码点占2字节)，后期由于字符数量增加使用ucs-4字符集(码点占4字节)
     * 计算机中并不直接存储码点，使用utf-8，utf-16，utf-32等编码规则将码点转换为字节序列进行存储
     * java使用unicode标准，文本使用utf-16编码规则。char存储utf-16的代码单元
     *
     * 关键字 keyword
     * 程序中被赋予特殊含义的单词，关键字都小写。java中保留50个关键字
     *
     * 标识符 identifier
     * 没有长度限制的名称，包名，类名，方法名，字段名，常量名 都属于标识符
     * i.标识符命名规则
     * 标识符由数字，字母，下划线，美元符号构成
     * 标识符不能以数字开头
     * 标识符不能与关键字，布尔字面值，null字面值重复
     * ii.标识符命名规范
     * 包名要求所有字母小写
     * 类名要求首字母大写，其后每个单词的首字母大写
     * 方法名要求首字母小写，其后每个单词首字母大写；方法名第一个单词应为动词
     * 类变量，实例变量，局部变量要求首字母小写，其后每个单词首字母大写
     * 常量名要求所有字母大写，单词之间下划线分隔
     *
     * 注释 comment
     * 注解说明的文字
     * java中包含三种注释，单行注释，多行注释，文档注释
     * i.单行注释
     * 单行注释中能够嵌套单行注释及多行注释
     * ii.多行注释
     * 多行注释中不能嵌套多行注释
     * iii.文档注释
     * 文档注释定义在类，成员变量，成员方法，构造器上，可以通过javadoc工具提取
     * 文档注释中可以包含html，注释标签 comment tag
     * iiii.文档注释中常用注释标签
     * @see    引用其他类或类中成员，在see also中生成超链接
     * @see    fully-qualified-classname
     * @see    fully-qualified-classname#member
     * {@link}	行内引用其他类或类中成员，生成超链接
     * {@link fully-qualified-classname label}
     * {@link fully-qualified-classname#member label}
     * @version 版本信息
     * @version version-information
     * @author	作者信息
     * @author author-information
     * @since	jdk版本
     * @param	方法参数说明
     * @param paramName paramInformation
     * @return	方法返回值说明
     * @return returnInformation
     * @throws	方法异常说明
     * @throws exceptionClassName exceptionInformation
     *
     * 数据类型
     * java是强类型静态类型语言。
     * 强类型语言偏向不容忍隐式类型转换。静态类型语言一旦变量声明以后，变量类型不允许变化
     * java中数据类型分为基本数据类型，引用数据类型
     * 基本数据类型
     * 数值型，布尔型
     * 数值型分为整数型，浮点数型
     * 整数型分为
     * byte     占用1 byte，取值范围[-128，127]
     * short    占用2 byte，取值范围[-32768，32767]
     * int      占用4 byte
     * long     占用8 byte
     * char     占用2 byte，取值范围[0x0000,0xFFFF]。用于存储utf-16编码的代码单元，但一个char类型变量无法表示所有unicode字符
     * 整数类型在内存中以二进制补码形式存储，表示精确值
     * 浮点数型分为
     * float    占用4 byte，二进制浮点数中符号位占1位、指数位占8位、有效数字占23位
     * double   占用8 byte，二进制浮点数中符号位占1位、指数位占11位、有效数字占52位
     * 浮点数类型进能表示近似值，不能用于计算
     * 布尔型包括
     * boolean
     * 引用数据类型
     * 类，接口，数组
     *
     * 隐式类型转换
     * 对于boolean以外的七种基本数据类型，允许取值范围小的类型隐式转换为取值范围大的类型，
     * int常量赋值时允许大范围数据类型隐式转换为小范围数据类型，其余情况均不允许大范围类型转为小范围类型
     * 复合赋值运算发生隐式类型转换
     * 进行算数运算、比较运算、三元运算、位运算
     * i.若操作数中最大范围类型为double，将所有操作数都提升为double类型，且结果也为double类型
     * ii.若操作数中最大范围类型为float，将所有操作数都提升为float类型，且结果也为float类型
     * iii.若操作数中最大范围类型为long，将所有操作数都提升为long类型，且结果也为long类型
     * iiii.若操作数中最大范围类型为int，将所有操作数都提升为int类型，且结果也为int类型
     * iiiii.若操作数中最大范围类型为int以下，将所有操作数都提升为int类型，且结果也为int类型
     * long提升为float，double类型可能丢失精度
     * int提升为float类型可能精度丢失
     *          byte
     *            |
     *          short
     *            |
     * char  ——  int   --   float
     *            |     X     |
     *          long   --   double
     * 显示类型转换
     * 对boolean以外七种基本数据类型，手动将一种数据类型转换为另一种数据类型
     *
     * 常量 Constant
     * 程序指行过程中，常量值不允许发生变化
     * 常量分为字面常量，符号常量
     * 字面常量包括整数常量，浮点数常量，字符常量，字符串常量，布尔常量，null常量，文本块，转义序列
     * i.整数常量
     * 整数常量默认int类型，内存中占4byte。常量后添加类型后缀L，表示long类型，内存中占8字节。
     * 整数常量存在四种进制，二进制(前缀0b)，八进制(前缀0)，十进制，十六进制(前缀0x)
     * 一个二进制位称为一个比特位（bit）
     * 八个二进制位称为一个字节（byte）
     * 三个bit位对应一个八进制位
     * 四个bit位对应一个十六进制位
     * 二进制中最高位是符号位，负数符号位为1，正数符号位为0
     * 正数原码，反码，补码一致
     * 负数反码等于原码取反符号位不变，补码等于反码加1
     * 二进制以补码形式表示
     * ii.浮点数常量
     * 浮点数常量默认double类型，内存中占8byte。常量后添加类型后缀F，表示float类型，内存中占4byte
     * 浮点数常量存在两种进制表示形式，十进制，十六进制
     * 十进制浮点数中指数指示符E表示十的幂次，十六进制浮点数中指数指示符P表示二的幂次
     * 科学计数法表示的常量值默认double类型
     * 浮点数常量包含几种特殊值，正负无穷，正负零，NaN用于表示出错
     * 负无穷 < 负非零浮点数 < 正负零 < 正非零浮点数 < 正无穷
     * NaN无序，当NaN参与>，<，>=，<=，==比较时，结果为false；当NaN参与!=比较时，返回true
     * iii.布尔常量
     * true，false
     * iiii.字符常量
     * 使用单引号标识的单个字符
     * iiiii.字符串常量
     * 使用双引号标识的字符序列，每个字符串常量值都是String类的一个实例，存储在字符串常量池中
     * iiiiii.文本块(jdk13特性)
     * 使用三引号标识的多行字符串，文本块中的特殊字符不需转义
     * 运行时，将文本块实例化为String
     * iiiiiii.null常量
     * null常量的类型为null类型，null类型不需了解
     * null常量可以转型为任意任意引用数据类型
     * 通过等于null的引用可以调用类中类方法，不会抛出空指针
     * iiiiiiii.转义序列
     * java中转义序列
     * \r	回车
     * \b	退格
     * \n 换行
     * \f 	？？？
     * \t	制表符
     * \\	反斜线字符
     * \'	单引号字符
     * \" 	双引号字符
     * 符号常量
     * 符号常量使用final修饰，只能赋值一次
     *
     * 变量
     * 程序执行过程中，变量值允许发生变化
     * 变量声明语句
     * 修饰符 数据类型 变量名 = 初始化值；
     * 引用数据类型变量简称引用，是指向对象的指针，存储内存单元地址
     *
     * BigInteger
     * 可以封装超出long类型的整型常量值
     * BigDecimal
     * 浮点数常量值仅能表示近似值，当要控制精度时，建议使用BigDecimal进行计算
     * 创建BigInteger，BigDecimal对象时建议使用字符串作为构造器参数，减小误差
     * BigInteger，BigDecimal对象不可变，进行运算后会产生新对象
     * BigDecimal对象进行除法运算，结果除不尽时必须指定保留小数点位数
     *
     * 表达式，语句，块 Expressions, Statements, Blocks
     * i.表达式由算子及运算符构成。算子包含常量，变量，方法调用
     * ii.语句由表达式构成，语句分为表达式语句，声明语句，流程控制语句
     * iii.块由{}构成，块中可以包含零个或多个语句；块定义在类中
     *
     * 运算符 Operator
     * 优先级，结合性
     * 优先级高的运算符优先执行，优先级相等按照结合性决定运算顺序
     * 有包装类类型参与的运算可能会抛出NullPointerException(自动拆箱)和内存溢出(自动装箱)
     * java保证运算符的操作数从左向右依次计算，操作数计算在操作之前完成
     * 赋值运算符 Assignment Operator
     * i.int常量值赋值给byte，short，char类型变量，可能发生隐式类型转换
     * ii.复合赋值运算符一定进行隐式类型转换，不能在声明语句中使用
     * 算数运算符 Arithmetic Operator
     * + - * / % ++ --
     * 相同类型操作数才能进行运算，结果仍是操作数类型
     * / % 右操作数为0，会抛出ArithmeticException
     * %	有负数参与的模运算，结果参考被模数;
     *      当模数为2的幂次，模运算可以转换为&运算，被模数&(模数-1)
     * ++ --
     * ++a	前缀式，先执行+1运算，然后整个表达式取a的值
     * a++	后缀式，表达式先去a的值，然后a执行+1运算
     * ++，--运算符不能操作常量值
     * boolean以外的七种基本数据类型进行运算，若结果超出数据类型范围会进行截取
     * 比较运算符
     * > >= < <= == !=
     * > >= < <=	适用于boolean以外的七种基本数据类型及包装类类型
     * == !=	适用于基本数据类型及引用数据类型
     * 逻辑运算符
     * &&	||	！ ^ & |
     * 逻辑运算符用于连接boolean表达式
     * i.&&有假即假，同真为真；当左侧表达式为false，右侧表达式不参与运算
     * true && true	true
     * true && false	false
     * false && true	false
     * false && f alse	false
     * ii.||	有真即真，同假为假；左侧表达式为true，右侧表达式不参与运算
     * true || false	true
     * false || true	true
     * true || true	true
     * false || false	false
     * iii.！ 非真即假，非假即真
     * iiii.^   相同为假，不同为真
     * 三元运算符
     * boolean-expression?value0:value1;
     * 当boolean-expression为true，整个表达式取value0；
     * 当boolean-expression为false，整个表达式取value1
     * instanceof
     * 用于判断对象是否是某个类的实例，null值不是任意类的实例
     * 位运算符(适用于整数字面值)
     * &    |   ^   ~
     * <<	>>	>>>
     * i.&
     * 操作数为整数字面值，左右两侧操作数的二进制在对应位上进行与运算
     * ii.|
     * 操作数为整数字面值，左右两侧操作数的二进制在对应位上进行或运算
     * iii.^
     * 操作数为整数字面值，左右两侧操作数的二进制在对应位上进行异或运算，相同为假，不同为真
     * iiii.~
     * 操作数的二进制进行取反操作
     * iiiii.<<
     * 左侧操作数的二进制向左移动指定位数，空位补0，左移几位相当于乘以2的几次幂
     * iiiiii.>>
     * 左侧操作数的二进制向右移动指定位数，空位补符号位，右移几位相当于除以2的几次幂
     * iiiiiii.>>>	左侧操作数的二进制向右移动指定位数，空位补0，无数学含义
     *
     * 流程控制语句
     * if	在多个执行路径中选择一个执行
     * if(boolean-expression){
     * 		statement;
     * }
     * boolean-expression为true执行{}内语句，为false不执行{}内语句
     * if(boolean-expression){
     * 		statement;
     * }else{
     * 		statement;
     * }
     * 当boolean-expression为true，执行if后语句
     * 当boolean-expression为false，执行else后语句
     * if(boolean-expression){
     * 		statement;
     * }else if(boolean-expression){
     * 		statement;
     * }else{
     * 		statement;
     * }
     * 从上向下顺序判断boolean-expression，当boolean-expression为true，执行对应语句且不再向下判断
     * 当boolean-expression为false，继续判断下一个boolean-expression；当所有boolean-expression都为false，执行else后的语句
     * 多个语句中仅会有一个执行
     *
     * switch 在多个执行路径中选择一个或多个执行
     * switch(expression){
     * 		case	value0:statement;break;
     * 		case	value1:statement;break;
     * 		default:statement;
     * }
     * i.switch表达式仅支持byte，Byte，short，Short，int，Integer，char，Character，枚举（jdk5），String（jdk7）类型
     * ii.case标签，default标签在书写上无顺序，在执行上存在顺序。从上向下判断case标签，当所有case标签都不匹配，执行default标签
     * iii.可以为switch块中的语句定义一个或多个case标签及一个default标签
     * iiii.break语句用于终止switch语句
     * 当switch语句中未定义break语句，switch语句会从匹配位置开始执行，一直执行到switch语句结束或遇到break语句
     * iiiii.switch语句只能判断单个值，if语句可以判断区间值
     *
     * while
     * while(boolean-expression){
     * 		statement;
     * }
     * 当boolean-expression为true，执行一次循环体，之后继续判断boolean-expression，直到boolean-expression为false
     * 循环停止
     *
     * do-while
     * do{
     * 		statement;
     * }while(boolean-expression);
     * do-while语句循环体至少会执行一次
     *
     * for
     * for(initialization;termination;increment statement){
     * 		statement;
     * }
     * i.初始化表达式在循环开始时执行一次
     * 终止表达式为false循环终止
     * 增量表达式在每次迭代后执行一次
     * ii.初始化表达式中声明的变量，随循环的执行而创建，随着循环的结束而消失；初始化表达式中声明的变量
     * 可以在终止表达式，增量表达式中使用
     *
     * foreach 增强for语句
     * for(LocalVariableType VariableDeclaratorId:Expression){
     * 		statement;
     * }
     *
     * 跳转语句
     * break
     * break语句用于终止switch语句，for语句，while语句，do-while语句
     * break语句具有两种形式，具有标签，不具有标签；在嵌套循环中，不带标签的break语句默认终止当前循环，带标签的break语句
     * 可以终止指定循环
     * continue
     * continue语句用于跳过当前迭代，进入下一次迭代
     * continue语句具有两种形式，具有标签形式，不具有标签形式；在嵌套循环中，不具有标签的continue语句默认跳过当前迭代，
     * 具有标签的continue语句可以跳过指定迭代
     * return
     * return语句用于退出当前方法
     *
     * 数组 Array
     * 存储同一类型数据的容器，使用一组连续存储单元存放数据。通过索引可以随机访问数组中任意元素
     * 数组是一个对象，通过数组可以调用Object类中所有方法，也可以将数组地址赋值给Object类型引用
     * i.数组类型
     * 若源数组中元素类型为T，数组类型为T[]，中括号个数表示数组维度
     * 数组长度不是数组类型的一部分
     * ii.数组类型变量
     * 声明数组类型变量并不会创建数组对象，声明格式：
     * 数组类型 数组名；
     * iii.创建数组对象
     * 通过数组创建表达式(new)，数组初始化器可以创建数组对象
     * 通过数组初始化器创建数组，需指定数组中所有元素，只能在声明数组类型变量同时使用
     * 通过数组创建表达式创建数组，需指定源数组成员类型，数组维度，最外层数组长度(与c语言存在差异)
     * 一维数组 new 元素类型[一维数组长度];
     * 二维数组 new 成员类型[第一维数组长度][];
     * 数组对象中的元素存在默认初始化值
     * iiii.数组Class对象
     * 每个数组对象都对应一个Class对象，元素类型相同的数组共享同一个Class对象
     * iiiii.数组操作
     * 数组工具类Arrays中提供操作数组的方法
     * toString	获取数组的字符串表现形式
     * sort	数组排序
     * equals	数组比较，仅当数组长度一直，元素一致时数组相同
     * deepEquals	用于比较多维数组是否相同
     * binarySearch		二分查找
     * asList	数组转换为列表，该列表不支持增删操作
     * fill	使用指定元素重写数组中的元素
     * copyOf	从起始位置复制数组
     * copyOfRange	从指定索引赋值数组
     *
     * 方法
     * 类中具有特定功能的代码块
     * i.方法声明，包含六部分
     * modifier	returnType  methodName(argument list) throws exception list{
     * 		method body
     * }
     * ii.方法只有被调用时才会执行
     * iii.调用对象方法的行为称为向对象发送调用请求
     * iiii.方法签名由方法名及参数列表构成
     * iiiii.返回值类型声明为void，方法不返回返回值
     * iiiiii.overload
     * 同一类中，多个方法共享同一名称的情况称为重载。应谨慎使用，会降低代码可读性
     * 同一个类中多个方法可以共享一个名称，只要其方法签名不同即可
     * 方法重载与返回值类型无关，因为编译器无法根据返回值类型区分方法
     */
}