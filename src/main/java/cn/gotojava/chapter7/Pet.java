package cn.gotojava.chapter7;

/**
 * description：宠物接口
 *
 * @author yangzhao
 * @createBy 2023/12/23
 */
public interface Pet {

    /**
     * 获取宠物名字
     * @return
     */
    public String getName();

    /**
     * 获取宠物颜色
     * @return
     */
    public String getColor();

    /**
     * 获取宠物年龄
     * @return
     */
    public int getAge();
}
