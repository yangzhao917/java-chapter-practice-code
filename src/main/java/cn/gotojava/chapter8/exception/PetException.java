package cn.gotojava.chapter8.exception;

/**
 * description：宠物自定义异常类
 *
 * @author yangzhao
 * @createBy 2023/12/23
 */
public class PetException extends Exception{

    /**
     * 宠物异常
     * @param message 异常消息
     */
    public PetException(String message) {
        super(message);
    }
}
