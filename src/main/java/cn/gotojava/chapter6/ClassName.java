package cn.gotojava.chapter6;

/**
 * description：获取类名称
 *
 * @author yangzhao
 * @createBy 2023/12/22
 */
public interface ClassName {

    /**
     * 获取类名称
     * @return
     */
    // 接口中的方法永远是public，String getClassName()等同于：public abstract String getClassName()
    String getClassName();
}
