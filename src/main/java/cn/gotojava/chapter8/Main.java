package cn.gotojava.chapter8;

import cn.gotojava.chapter8.interfaces.*;
import cn.gotojava.chapter8.interfaces.impl.*;
import cn.gotojava.chapter8.exception.PetException;

/**
 * description：第八章：包及访问控制权限
 * @author yangzhao
 * @createBy 2023/12/24
 */
public class Main {

    /*
    本章要点：
    1.Java中使用包可以实现多人协作的开发模式，避免类名称重复的麻烦。
    2.在Java中使用package关键字来将一个类放入一个包中。
    3.在Java中使用import语句可以导入一个已有的包。
    4.Java中的访问控制权限分为4中，即private、default、protected、public。
    6.使用jar命令可以将一个包打包成一个jar文件，以供用户使用。
     */

    public static void main(String[] args) {

        //将第六章的宠物商品代码中各个不同功能的类放在不同的包中定义，一定要严格遵循命令规范的要求
        PetShop petShop = new PetShop(5);
        try {
            petShop.add(new Cat("白猫", "白色", 3));
            petShop.add(new Cat("中华田园猫", "白灰色", 3));
            petShop.add(new Cat("哈士奇", "灰色", 2));
            petShop.add(new Dog("拉布拉多", "黑色", 4));
            petShop.add(new Cat("金毛", "黄色", 5));
            petShop.getAllPet();

            // 搜索宠物
            String searchPetName = "金毛a";
            Pet[] searchResult = petShop.search(searchPetName);
            printSearch(searchPetName, searchResult);
        } catch (PetException e) {
            System.out.println(String.format("宠物商店异常：%s", e.getMessage()));
        } catch (Exception e){
            System.out.println(String.format("系统异常，%s", e.getMessage()));
            e.printStackTrace();
        }
    }

    /**
     * 打印搜索结果
     * @param petName 搜索的宠物名称
     * @param searchResult 宠物数组对象
     */
    private static void printSearch(String petName, Pet[] searchResult) throws PetException {
        System.out.println(String.format("搜索宠物：%s ...", petName));
        if (searchResult.length == 0){
            throw new PetException("搜索结果不存在!");
        }

        for (int i = 0; i < searchResult.length; i++) {
            System.out.println(String.format("姓名：%s，颜色：%s，年龄：%s",
                    searchResult[i].getName(),
                    searchResult[i].getColor(),
                    searchResult[i].getAge()));
        }
    }
}
