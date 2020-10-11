package org.olddriver.learnjava.io;

/**
 * 20200904
 * part 1
 */
public class BasicIO {

    /*
     * 流(Streams)
     * 流是一个数据序列，所有流为使用它的程序提供相同的模型。程序使用输入流从源读取数据到内存，使用输出流向目的地写入内存数据
     *
     * 字节流(Byte Streams)
     * 字节流用于执行字节的输入输出。所有字节流继承于InputStream类和OutputStream类
     * 当不再需要流时要关闭流，防止资源泄露，程序打开文件最大数量是固定的
     * 处理纯文本建议使用字符流
     *
     * 字符流(Character Streams)
     * 执行字符的输入输出，字符流继承于Reader类和Writer类
     * 字符流底层使用字节流进行io操作，添加了字符和字节的转换
     * 字符流处理图片，视频等文件时会出现问题
     *
     * 缓冲流(Buffered Streams)
     * 无缓冲io操作，每次读写都直接调用操作系统api，效率低。
     * 缓冲输入流从缓冲读取数据，当缓冲为空，才调用操作系统api读取数据
     * 缓冲输出流向缓冲中写入数据，当缓冲写满，才调用操作系统api写入数据
     * BufferedInputStream和BufferedOutputStream用于创建缓冲字节流
     * BufferedReader和BufferedWriter用于创建缓冲字符流
     * 当缓冲未被写满就进行写入称为刷新缓冲，PrintWriter支持自动刷新，每当调用PrintWriter对象的println和format方法进行自动刷新
     * 通过flush方法手动刷新缓冲，无缓冲流调用flush方法无效果
     *
     * Scanning
     * Scanner可以对输入进行格式化，将输入进行分割。默认使用空白符(空格，制表符，行分隔符)对输入进行分割
     * Scanner虽然不是流，但使用完毕也需要关闭
     * useDelimiter方法可以自定义分割符
     *
     * Formatting
     * PrintWriter和PrintStream能够对输出进行格式化
     * print和println对单个值进行格式化
     * format方法可以对多个值进行格式化
     *
     * 数据流(Data Streams)
     * 用于执行基本类型数据与String的输入输出，数据流都实现DataInput和DataOutput接口
     * 常用数据流DataInputStream和DataOutputStream
     * DataOutputStream对写入的数据进行处理，只能通过DataInputStream读取
     *
     * 对象流(Object Streams)
     * 用于对象输入输出，对象必须实现Serializable接口
     * ObjectInputStream和ObjectOutputStream是对象流类
     * 写入对象时，会将对象关联的对象一同写入
     */
}
