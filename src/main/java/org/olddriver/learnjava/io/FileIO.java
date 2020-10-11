package org.olddriver.learnjava.io;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 20200905
 * part 2
 */
public class FileIO {
    /*
     * 文件系统
     * 在某种媒介上存储和组织文件的方式，大部分文件系统采用树形结构
     * 树的顶部称为根节点，根节点下包含文件和目录；根节点不算文件
     * Windows中支持多根节点
     *
     * 路径
     * 文件系统中用于定位文件的字符串
     * 路径有相对路径，绝对路径之分
     * 绝对路径中总是包含根元素和需要定位的文件
     * 相对路径必须和另一路径结合使用才能定位文件
     *
     * 符号链接(Symbolic Links)
     * 一种特殊的文件，用于引用其他文件
     *
     * Path类
     * 表示文件系统中路径，Path对象中包含文件名和目录列表。路径对应的文件可以存在也可以不存在
     * 操作
     * 通过Paths类的get方法创建Path对象，get方法中调用FileSystems.getDefault().getPath()创建Path对象
     * getFileName  获取路径中最后一个文件的名称
     * getName(int index) 获取路径中指定索引处的文件名称，第一个文件名索引为0；
     * getNameCount()   获取路径中文件名个数
     * subpath(int beginIndex, int endIndex)    获取当前路径子路径，从beginIndex开始到endIndex-1结束
     *
     *
     *
     */

    public static void main(String[] args) {
        Path p1 = Paths.get("/tmp/foo");

        System.out.println(p1.getFileName());
        System.out.println(p1.getName(0));
        System.out.println(p1.getNameCount());

        System.out.println(p1.subpath(1,2));

        System.out.println(p1.getParent());

        System.out.println(p1.getRoot());
    }

}
