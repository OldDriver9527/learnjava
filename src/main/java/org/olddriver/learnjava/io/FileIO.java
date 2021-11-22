package org.olddriver.learnjava.io;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 文件io
 * 20200905
 * part 2
 */
public class FileIO {
    /**
     * jdk7版本在nio包中引入文件io新api，用于替代io包中api
     *
     * Path类
     * 表示文件系统中路径，由一系列文件或目录名称组成
     * 路径对应的文件或目录可以存在也可以不存在，可替代io包中File类使用
     * Path实现Iterable接口，可以通过迭代器迭代
     * Path实现Comparable接口，路径间可以相互比较
     * i.创建path对象
     * 通过Paths类的get方法创建Path对象
     * ii.检索路径中信息
     * 可以获取路径中名称个数，获取指定索引处的名称，获取指定索引范围的子路径，获取路径中最后一个名称
     * iii.路径标准化
     * 移除路径中当前目录及上一级目录的相关内容
     * iiii.路径转换
     * iiiii.路径组合
     * iiiiii.计算相对路径
     *
     * Files类
     * jdk7中新增操作文件目录的工具类
     * i.判断文件目录是否存在
     * exists方法判断是否存在，当无法访问文件时，返回false
     * notExists方法判断是否不存在，当无法访问文件时，返回false
     * !exists并不等于notExists
     * ii.判断文件是否可读，是否可写，是否可执行
     * iii.判断两个文件是否为同一文件
     * iiii.删除文件目录
     * 仅能删除空目录
     * delete   若文件不存在抛出异常
     * deleteIfExists   若文件不存在返回false
     * iiiii.复制文件
     * copy方法复制非空目录时，不复制内容
     * iiiiii.移动文件
     * move方法移动文件或重命名
     * iiiiiii.获取文件元数据
     * readAttributes批量读取文件元数据
     * iiiiiiii.读写文件
     * 小文件可一次性读取所有字节，之后再一次性写入
     * readAllBytes读取文件中所有字节，会关闭文件
     * 对于文本文件，可通过Files创建缓冲流
     * newBufferedReader
     * newBufferedWriter
     * 可通过Files创建非缓冲流，再使用缓冲流包裹
     * newInputStream
     * newOutputStream
     * 可通过Files创建ByteChannel？？？
     */

    @Test
    public void test() throws IOException {

        Path path1 = Paths.get("d://HelloConsole.java");
        byte[] bytes = Files.readAllBytes(path1);

        System.out.println(bytes.length);

    }



    @Test
    public void testReadAttributes() throws IOException {

        Path path1 = Paths.get("d://foo_move");

        BasicFileAttributes attributes =
                Files.readAttributes(path1, BasicFileAttributes.class);

        System.out.println(attributes.size());
        System.out.println(attributes.creationTime());
        System.out.println(attributes.fileKey());
        System.out.println(attributes.isRegularFile());
        System.out.println(attributes.isDirectory());
        System.out.println(attributes.isOther());
        System.out.println(attributes.isSymbolicLink());
        System.out.println(attributes.lastAccessTime());
        System.out.println(attributes.lastModifiedTime());



    }


    @Test
    public void testMoveFile() throws IOException {
        Path path1 = Paths.get("d://foo");
        Path path2 = Paths.get("d://foo_move");

        System.out.println(Files.move(path1,path2));

    }


    @Test
    public void testFiles() throws IOException {
        Path path1 = Paths.get("d://foo");
        Path path2 = Paths.get("d://foo_copy");

        System.out.println(Files.exists(path1));
        System.out.println(Files.isReadable(path1));
        System.out.println(Files.isWritable(path1));
        System.out.println(Files.isExecutable(path1));
        try {
            System.out.println(Files.isSameFile(path1,path2));
        }catch (NoSuchFileException e){
            e.printStackTrace();
        }


        System.out.println(Files.deleteIfExists(path1));
        System.out.println(Files.createDirectory(path1));

        System.out.println(Files.copy(path1,path2, StandardCopyOption.REPLACE_EXISTING));





    }


    @Test
    public void testPaht(){
        Path path = Paths.get("/home/sally/../joe/foo");

        for(Path name : path){
            System.out.println(name);
        }
    }


    @Test
    public void testCreatePath(){
        String path =
                this.getClass().getClassLoader().getResource("").getPath().substring(1);

        Path temp = Paths.get(path);

        Path root = temp.getRoot();
        Path hello = Paths.get(root.toString(), "helloPath.txt");

        System.out.println(hello.getNameCount());
        System.out.println(hello.normalize());
    }
}
