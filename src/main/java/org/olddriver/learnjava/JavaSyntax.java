package org.olddriver.learnjava;

import java.math.BigInteger;

public class JavaSyntax {
	/*
	 * java 
	 * java既是一种高级编程语言，也是一个平台
	 * java是基于类且面向对象的语言，使用java语言编写代码包含在.java源文件中，通过javac编译器将源文件编译成字节码文件，然后通过java启动工具
	 * 可以在虚拟机上运行程序
	 * 平台一般指程序运行的硬件及软件环境，java平台不同于其他大多数平台，仅是java程序运行所需的软件环境。
	 * java平台由java虚拟机和api组成
	 * 
	 * 关键字 keyword
	 * java程序中被赋予特殊含义的单词，关键字都小写
	 * 
	 * 标识符 identifier
	 * 程序中自定义名称，包名，类名，方法名，变量名，常量名都属于标识符
	 * i.标识符命名规则
	 * 标识符由java数字，java字母组成，java字母包括所有unicode字符
	 * 标识符不能以java数字开头，标识符不能与关键字重复
	 * ii.标识符命名规范
	 * 包名要求所有字母小写
	 * 类名要求首字母大写，其后每个单词的首字母大写
	 * 方法名要求首字母小写，其后每个单词首字母大写
	 * 变量名要求首字母小写，其后每个单词首字母大写
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
	 * 文档注释是java特有，定义在类，成员变量，成员方法上，可以通过javadoc工具提取
	 * 文档注释中可以包含html，文档标签
	 * iiii.文档注释中常用文档标签
	 * @see 	引用其他类或类中成员，在see also中生成超链接
	 * 				@see fully-qualified-classname
	 * 				@see fully-qualified-classname#member
	 * {@link}	行内引用其他类或类中成员，生成超链接
	 * 				{@link fully-qualified-classname label}
	 * 				{@link fully-qualified-classname#member label}
	 * @version 版本信息
	 * 				@version version-information
	 * @author	作者信息
	 * 				@author author-information
	 * @since	jdk版本
	 * @param	方法参数说明
	 * 				@param paramName paramInformation
	 * @return	方法返回值说明
	 * 				@return returnInformation
	 * @throws	方法异常说明
	 * 				@throws exceptionClassName exceptionInformation
	 *  
	 *  常量 Constant
	 *  存储数据的容器，一旦常量初始化完毕，常量中存储数据就不能修改
	 *  使用常量前必须声明，java中常量通常使用public static final修饰
	 *  常量值 Literals
	 *  指程序中直接使用的数据，如整数常量值，浮点数常量值，字符常量值，字符串常量值，布尔常量值
	 *  i.整数常量值
	 *  整数常量值默认int类型，内存中占4byte。常量值后添加L，表示long类型，内存中占8字节。
	 *  整数常量值存在四种表示形式，分为二进制，八进制，十进制，十六进制
	 *  一个二进制位称为一个比特位（bit）
	 *  八个二进制位称为一个字节（byte）
	 *  三个二进制位对应一个八进制位
	 *  四个二进制位对应一个十六进制位
	 *  负数二进制等于其绝对值的补码
	 *  负数二进制最高位为1，正数二进制最高位为0
	 *  ii.浮点数常量值
	 *  浮点数常量值默认double类型，内存中占8byte。常量值后添加F，表示float类型，内存中占4byte
	 *  浮点数常量值存在两种表示形式，十进制，科学计数法
	 *  科学计数法中E表示十的幂次，E后的数字必须是整数
	 *  iii.布尔常量值
	 *  true，false
	 *  iiii.字符常量值
	 *  字符常量值指单个字符，转移字符，unicode字符，字符常量值使用单引号标识
	 *  java中转义字符常量值
	 *  \r	回车
	 * 	\b	退格
	 * \n 换行
	 * \f 	？？？
	 * \t	制表符
	 * \\	反斜线字符
	 * \'	单引号字符
	 * \" 	双引号字符
	 * iiiii.字符串常量值
	 * 字符串常量值使用双引号标识，每个字符串常量值都是String的实例
	 * 
	 * 变量
	 * 存储数据的容器，对应内存中的一块存储空间
	 * java属于强类型语言，使用变量前必须声明，指定类型变量只能接收同一类型值
	 * 声明变量的格式 数据类型 变量名 = 初始化值；
	 * i.数据类型
	 * java中包含两种数据类型，基本数据类型，引用数据类型
	 * 基本数据类型 Primitive Data Types
	 * byte		占1byte	-128~127					
	 * short		占2byte	-2^15~2^15-1
	 * int			占4byte	-2^31~2^31-1
	 * long		占8byte	-2^63~2^63-1
	 * float		占4byte	
	 * double	占8byte
	 * char		占2byte
	 * boolean
	 * 引用数据类型 Reference Data Types
	 * 引用数据类型包括，类，接口，数组。引用数据类型由用户自定义
	 * null值可以转换为任意引用类型，赋值给任意引用类型变量
	 * ii.高精度数字
	 * BigInteger	
	 * 可以封装超出long类型的整数常量值
	 * BigDecimal
	 * 二进制无法准确表示浮点数，使用基本类型值进行运算存在误差，当有精度要求时，建议使用BigDecimal
	 * 创建BigInteger，BigDecimal对象时建议使用字符串作为构造器参数，减小误差
	 * BigInteger，BigDecimal对象不可变，进行运算后会产生新对象
	 * BigDecimal对象进行除法运算，结果除不尽时必须指定保留小数点位数
	 * iii.自动类型提升
	 * 对于boolean以外的七种基本数据类型，参与运算时低等级数据类型会提升为最高等级数据类型，之后再进行运算
	 * 进行自动类型提升运算包括算数运算，比较运算，三元运算，位运算
	 * 1若操作数最高级类型为double，将所有操作数都提升为double类型，且结果也为double类型
	 * 2若操作数最高级类型为float，将所有操作数都提升为float类型，且结果也为float类型
	 * 3若操作数最高级类型为long，将所有操作数都提升为long类型，且结果也为long类型
	 * 4若操作数最高级类型为int，将所有操作数都提升为int类型，且结果也为int类型
	 * 5若操作数最高级类型为int以下，将所有操作数都提升为int类型，且结果也为int类型
	 * iiii.强制类型转换
	 * 对boolean以外七种基本数据类型，将数据类型从高等级转换为低等级，称为强制类型转换
	 * 负数强转为char类型问题？？？？
	 * 
	 * 运算符 Operator
	 * 优先级，结合性
	 * 优先级和结合性用于将表达式划分为多个子表达式，多个子表达式从左到右执行
	 * 
	 * 赋值运算符 Assignment Operator
	 * i.当高等级数据类型赋值给低等级数据类型时，
	 * 若右侧操作数为常量或常量值，会进一步判断常量是否在左侧变量取值范围内，
	 * 只有在取值范围内的常量才能完成赋值
	 * 若右侧操作数包含变量，无法赋值
	 * ii.复合赋值运算符包含强制类型转换，不存在高等级数据类型无法赋值给低等级数据类型的情况
	 * 
	 * 算数运算符 Arithmetic Operator
	 * + - * / %
	 * %	有负数参与的模运算，结果参考被模数
	 * + - 用于指明符号
	 * + 会将byte，short，char提升为int类型
	 * ++ --
	 * ++a	前缀式，先执行+1运算，然后整个表达式取a的值
	 * a++	后缀是，表达式先去a的值，然后a执行+1运算
	 * 
	 * 比较运算符
	 * > >= < <= == !=
	 * > >= < <=	适用于boolean以外的七种基本数据类型
	 * == !=	适用于基本数据类型及引用数据类型
	 * 
	 * 逻辑运算符
	 * &&	||	！
	 * 逻辑运算符用于连接boolean表达式
	 * i.&&有假即假，同真为真；当左侧表达式为false，右侧表达式不参与运算
	 * true && true	true
	 * true && false	false
	 * false && false	false
	 * false && false	false
	 * ii.||	有真即真，同假为假；左侧表达式为true，右侧表达式不参与运算
	 * true || false	true
	 * false || true	true
	 * true || true	true
	 * false || false	false
	 * iii.！ 非真即假，非假即真
	 * 
	 * instanceof
	 * 用于判断对象是否是某个类的实例，null值不是任意类的实例
	 * 
	 * 位运算符
	 * &	| ^ ~
	 * <<	>>	>>>	
	 * i.&	左右两侧操作数的二进制在对应位上进行与运算
	 * ii.|		左右两侧操作数的二进制在对应位上进行或运算
	 * iii.^	左右两侧操作数的二进制在对应位上进行异或运算
	 * iiii.~	操作数的二进制进行取反操作
	 * iiiii.<<	左侧操作数的二进制向左移动指定位数，空位补0
	 * 			左移几位相当于乘以2的几次幂
	 * iiiiii.>>	左侧操作数的二进制向右移动指定位数，空位补符号位
	 * 			右移几位相当于除以2的几次幂
	 * iiiiiii.>>>	左侧操作数的二进制向右移动指定位数，空位补0
	 * 
	 * 三元运算符
	 * boolean-expression?value0:value1;
	 * 当boolean-expression为true，整个表达式取value0；
	 * 当boolean-expression为false，整个表达式取value1
	 * 
	 * 表达式，语句，块 Expressions, Statements, Blocks
	 * i.表达式由变量，运算符，方法调用构成，表达式运算后产生唯一的值
	 * ii.语句由表达式构成
	 * 语句分为表达式语句，声明语句，流程控制语句
	 * 表达式语句，声明语句以分号结束；流程控制语句中do-while语句使用分号结尾
	 * iii.块由{}构成，块中可以包含零个或多个语句；块定义在类中
	 * 
	 * 流程控制语句
	 * if	在多个执行路径中选择一个执行
	 * if(boolean-expression){
	 * 		statement;
	 * }
	 * booealn-expression为true执行{}内语句，为false不执行{}内语句
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
	 * 当所有boolean-expression都为false，执行else后的语句
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
	 * 当switch语句中未定义break语句，switch语句会从匹配的case标签开始执行，一直执行到switch语句结束或遇到break语句
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
	 * 增加表达式在每次迭代后执行一次
	 * ii.初始化表达式中声明的变量，随循环的执行而创建，随着循环的结束而消失；初始化表达式中声明的变量
	 * 可以在终止表达式，增加表达式中使用
	 * 
	 * foreach 增强for语句
	 * for(LocalVariableType VariableDeclaratorId:Expression){
	 * 		statement;
	 * }
	 * 增强for循环用于迭代数组及单列容器
	 * 
	 * break
	 * break语句用于终止switch语句，for语句，while语句，do-while语句
	 * break语句具有两种形式，具有标签，不具有标签；在嵌套循环中，不带标签的break语句默认终止当前循环，带标签的break语句
	 * 可以终止指定循环
	 * 
	 * continue
	 * continue语句用于跳过当前迭代，进入下一次迭代
	 * continue语句具有两种形式，具有标签形式，不具有标签形式；在嵌套循环中，不具有标签的continue语句默认跳过当前迭代，
	 * 具有标签的continue语句可以跳过指定迭代
	 * 
	 * return
	 * return语句用于退出当前方法
	 * 
	 * 方法
	 * 类中可以被调用执行的代码，定义了类的行为
	 * i.方法声明
	 * modifier	returnType	methodName(argument list)exception list{
	 * 		method body
	 * }
	 * ii.方法只有被调用时才会执行
	 * iii.调用对象方法的行为称为向对象发送调用请求
	 * iiii.方法签名由方法名及参数类型构成
	 * iiiii.overload
	 * 多个方法共享同一名称的情况称为重载
	 * 同一个类中多个方法可以共享一个名称，只要其参数列表不同即可，参数列表不同指参数个数不同，参数类型不同，参数顺序不同
	 * 方法重载与返回值类型无关，因为编译器无法根据返回值类型区分方法
	 * 
	 * 
	 * 
	 * 
	 */
}
