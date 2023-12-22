package cn.gotojava.chapter7;

import java.util.Scanner;

/**
 * description：第七章：异常的捕获及处理
 *
 * @author yangzhao
 * @createBy 2023/12/23
 */
public class Main {

    /*
    本章要点：
    1.异常是导致程序中断运行的一种指令流，当异常发生的时候，如果没有进行良好地处理，则程序将会中断执行。
    2.异常处理可以使用try...catch进行处理，也可以使用try...catch...finally进行处理，在try语句中捕获异常，
        然后在catch中处理异常，finally作为异常的统一出口，不管是否发生异常都要执行此段代码。
    3.异常的最大父类是Throwable，其分为Exception和Error两个子类。Exception表示程序处理的异常，而Error表示JVM错误，一般不是由程序开发人员处理。
    4.发生异常之后，JVM会自动产生一个异常类的实例化对象，并匹配相应的catch语句中的异常类型，也可以利用对象的向上转型关系，直接捕获Exception。
    5.throws用在方法声明处，表示本方法不处理异常。
    6.throw表示在方法中手工抛出一个异常。
    7.自定义异常类的时候，只需要继承Exception类即可。
    8.断言是JDK1.4之后提供的新功能，可以用来检测程序的执行结果，但开发中并不提倡使用断言进行检测。
     */

    public static void main(String[] args) {
        //编写应用程序，从命令行输入两个小数参数，求它们的商。要求程序中捕获NumberFormatException异常和ArithmeticException。
        // getSystemInput();

        //在第六章讲解的宠物商店程序中加入异常的处理操作
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

    /**
     * 获取系统输入
     */
    private static void getSystemInput() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入第一个小数：");
            int inputVal = Integer.parseInt(scanner.next());
            System.out.print("请输入第二个小数：");
            int inputVal2 = Integer.parseInt(scanner.next());
            if (inputVal < 0 || inputVal2 < 0){
                getSystemInput();
            }
            float result = calculateQuotient(inputVal, inputVal2);
            System.out.println(String.format("%s / %s = %s", inputVal, inputVal2, result));
        }catch (NumberFormatException ex){
            System.out.println("发生NumberFormatException异常: " + ex.getMessage());
            getSystemInput();
        }catch (ArithmeticException ex){
            System.out.println("发生ArithmeticException异常: " + ex.getMessage());
        }catch (Exception ex) {
            System.out.println(String.format("系统异常，%s", ex.getMessage()));
        }
    }

    /**
     * 获取两个除数的商
     * @param val 参数1
     * @param val2 参数2
     * @exception ArithmeticException
     */
    private static float calculateQuotient(int val, int val2) throws ArithmeticException{
        float result = 0;
        try {
            result = val / val2;
        }catch (ArithmeticException ex){
            throw new ArithmeticException("被除数不能为0");
        } finally {
            System.out.println("计算结束 ===> END");
        }
        return result;
    }
}
