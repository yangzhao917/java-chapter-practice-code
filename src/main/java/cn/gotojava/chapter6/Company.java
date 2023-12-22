package cn.gotojava.chapter6;

/**
 * description：ClassName的实现类，用于获取类名称
 *
 * @author yangzhao
 * @createBy 2023/12/22
 */
public class Company implements ClassName{

    @Override
    public String getClassName() {
        return this.getClass().getName();
    }

}
