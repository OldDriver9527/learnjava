package org.olddriver.learnjava.io;

import org.junit.Before;
import org.junit.Test;


import java.io.*;
import java.net.URLDecoder;
import java.util.Objects;
import java.util.Scanner;

/**
 * IO流
 * 20200904
 * part 1
 */
public class IOStream implements Serializable{

    /**
     * 流(Streams)
     * 流是对有能力产出数据的源对象或有能力接收数据的目的地对象的抽象。
     * 程序使用输入流从源读取数据到内存，使用输出流向目的地写入内存数据
     *
     * 字节流(Byte Streams)
     * 字节流用于执行字节的输入输出。所有字节流继承于InputStream类或OutputStream类
     * 当不再需要流时要关闭流，防止资源泄露，进程打开文件最大数量是固定的
     *
     * 字符流(Character Streams)
     * 执行字符的输入输出，字符流继承于Reader类或Writer类
     * 字符流实际是对字节流的包裹，通过字节流实现io操作，字符流负责字符和字节的转换
     * 字符流处理图片，视频等文件时会出现问题；处理纯文本建议使用字符流
     * InputStreamReader和OutputStreamWriter可以实现字节流向字符流的转换
     * BufferedReader和PrintWriter可以实现以行为单位的读写操作
     *
     * 缓冲流(Buffered Streams)
     * 无缓冲的io操作，每次读写都直接由操作系统处理，效率低。
     * 缓冲流利用缓冲(一块内存空间)减少操作系统的处理次数
     * 缓冲输入流从缓冲读取数据，当缓冲为空，才调用操作系统api读取数据
     * 缓冲输出流向缓冲中写入数据，当缓冲写满，才调用操作系统api写入数据
     * BufferedInputStream和BufferedOutputStream用于创建缓冲字节流
     * BufferedReader和BufferedWriter用于创建缓冲字符流
     * 刷新缓冲区将输出流缓冲中内容写入目的地
     * PrintWriter支持自动刷新缓冲区，每当调用PrintWriter对象的println和format方法进行自动刷新
     * 通过flush方法手动刷新缓冲区，flush方法对具有缓冲区的输出流有效
     *
     * Scanning
     * Scanner对输入分词，通过各种next方法获取拆分后的分词。默认使用空白符(空格，制表符，行分隔符)作为词项的分隔符
     * Scanner虽然不是流，但使用完毕也需要关闭
     * useDelimiter方法可以自定义分割符
     *
     * 格式化流
     * PrintWriter和PrintStream能够对输出进行格式化
     * PrintStream仅在获取标准输出流，标准错误流时使用
     * print和println将值转换为String后输出
     * format方法基于格式化字符串进行格式化
     *
     * 数据流(Data Streams)
     * 执行对基本类型数据与String输入输出，数据流都实现DataInput和DataOutput接口
     * 常用数据流DataInputStream和DataOutputStream
     * DataInput接口中各种read方法，在读取到数据末尾时抛出异常而不是返回特殊值
     *
     * 对象流(Object Streams)
     * 用于对象输入输出，对象必须实现Serializable接口
     * 对象流均实现ObjectInput和ObjectOutput接口，ObjectInput和ObjectOutput接口为DataInput和DataOutput接口的子接口
     * 常用对象流类ObjectInputStream和ObjectOutputStream
     * 写入对象时，会将对象关联的对象一同写入流
     * 向一个流中多次写入同一对象，反序列化时获取的仍是同一对象
     * 向多个流中写入同一对象，反序列化时获取的是不同对象
     */


    private String file = "";

    private String otherFile = "";

    @Test
    public void testObjectInputStream(){

        try(ObjectInputStream in1 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            ObjectInputStream in2 = new ObjectInputStream(new BufferedInputStream(new FileInputStream(otherFile)));){

            IOStream o1 = (IOStream) in1.readObject();
            IOStream o2 = (IOStream) in2.readObject();
            System.out.println(o1 == o2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testObjectOutputStream(){

        try (ObjectOutputStream out1 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
             ObjectOutputStream out2 = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(otherFile)));){

            IOStream o = new IOStream();
            out1.writeObject(o);
            out2.writeObject(o);


        } catch (IOException  e) {
            e.printStackTrace();
        }


    }



    @Test
    public void test(){

        try(DataOutputStream out = new DataOutputStream(System.out)){
            out.writeUTF("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testConsole(){

        Console console = System.console();
        System.out.println(console);
        String s = console.readLine("Enter your login:");
        System.out.println(s);

    }

    @Test
    public void testScanner(){
        try (Scanner scanner = new Scanner(new File(file));){

            while (scanner.hasNext()){
                System.out.println(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCopyLines(){
        File copyFile = new File(new File(file).getParentFile().getPath().concat(System.getProperty("file.separator").concat("copy.txt")));
        String temp = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(file));
            PrintWriter writer = new PrintWriter(copyFile)) {
            while(Objects.nonNull(temp = reader.readLine())){
                writer.println(temp.toCharArray());
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testCharSet() {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf8"))){
            int read = reader.read();
            System.out.println((char)read);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Before
    public void loadFile() throws UnsupportedEncodingException {
        file =
                URLDecoder.decode(this.getClass().getClassLoader().getResource("object.txt").getPath(),
                        "utf8");

        otherFile =
                URLDecoder.decode(this.getClass().getClassLoader().getResource("otherobject.txt").getPath(),
                        "utf8");
    }
}
