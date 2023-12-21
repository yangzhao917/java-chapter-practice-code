package cn.gotojava.chapter5;

import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * description：图书类
 *
 * @author yangzhao
 * @createBy 2023/12/21
 */
public class Books {

    /**书名*/
    private String title;

    /** 静态变量，用于自动编号 */
    private static long nextId = 1;

    /**价格*/
    private double price;

    private long id;

    /**书籍册数*/
    private static long totalBooks = 0;

    public Books(String title, double price) {
        this.title = title;
        this.price = price;
        this.id = nextId++;

        // 新增书籍自动增加总册数
        totalBooks++;
    }

    /**
     * 获取总册数
     * @return
     */
    public static long getTotalBooks() {
        return totalBooks;
    }

    @Override
    public String toString() {
        return "书籍{" +
                "标题='" + title + '\'' +
                ", 价格=" + price +
                ", 编号=" + id +
                '}';
    }
}
