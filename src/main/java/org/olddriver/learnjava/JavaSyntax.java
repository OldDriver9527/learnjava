package org.olddriver.learnjava;

public class JavaSyntax {
	/*
	 * java 
	 * java既是一种高级编程语言，也是一个平台
	 * 使用java语言编写代码包含在.java源文件中，通过javac编译器将源文件编译成字节码文件，然后通过java启动工具
	 * 可以在虚拟机上运行程序
	 * 平台一般指程序运行的硬件及软件环境，java平台不同于其他大多数平台，仅是软件环境。
	 * java平台由java虚拟机和api组成
	 * 
	 * 关键字 keyword
	 * java程序中被赋予特殊含义的单词，关键字都小写
	 * 
	 * 标识符 identifier
	 * 程序中自定义名称，包名，类名，方法名，变量名，常量名都属于标识符
	 * i.标识符命名规则
	 * 标识符由数字，字母，下划线，美元符号，人民币符号，中文构成
	 * 标识符不能以数字开头，标识符不能与关键字重复
	 * ii.标识符命名规范
	 * 包名要求所有字母小写
	 * 类名要求首字母大写，其后每个单词的首字母大写
	 * 方法名要求首字母小写，其后每个单词首字母大写
	 * 变量名要求首字母小写，其后每个单词首字母大写
	 * 常量名要求所有字母大写
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
	 *  存储数据的容器，一旦常量初始化完毕，存储的数据就不能修改
	 *  使用常量前必须声明，java中常量通常使用public static final修饰
	 *  常量值
	 *  指程序中可以直接使用的数据，如整数常量值，浮点数常量值，字符常量值，字符串常量值，布尔常量值
	 *  i.整数常量值
	 *  整数常量值默认int类型，内存中占4byte。常量值后添加L，表示long类型，内存中占8字节。
	 *  整数常量值存在四种表示形式，分为二进制，八进制，十进制，十六进制
	 *  一个二进制位称为一个比特位（bit）
	 *  八个二进制位称为一个字节（byte）
	 *  三个二进制位对应一个八进制位
	 *  四个二进制位对应一个十六进制位
	 *  负数二进制等于对应正数二进制取反，加一
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
	 * 基本数据类型
	 * byte		占1byte	-128~127					
	 * short		占2byte	-2^15~2^15-1
	 * int			占4byte	-2^31~2^31-1
	 * long		占8byte	-2^63~2^63-1
	 * float		占4byte	
	 * double	占8byte
	 * char		占2byte
	 * boolean	
	 * 引用数据类型
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
	 * 
	 */
	public static void main(String[] args) {
		
	}
}
