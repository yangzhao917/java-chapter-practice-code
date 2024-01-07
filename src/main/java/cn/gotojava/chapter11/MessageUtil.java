package cn.gotojava.chapter11;

import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class MessageUtil {

    // 中国
    private static final int CHINA = 1;

    // 美国
    private static final int USA = 2;

    // 日本
    private static final int JAPAN = 3;

    // 资源文件KEY
    private static final String KEY = "info";

    //资源文件名

    private static final String BASENAME = "chapter11.message";

    /**
     * 获取地区
     *
     * @param num {@link MessageUtil}
     */
    private Locale getLocale(int num) {
        switch (num) {
            case CHINA:
                return new Locale("zh", "CN");
            case USA:
                return new Locale("en", "US");
            case JAPAN:
                return new Locale("ja", "JP");
            default:
                System.out.printf("未匹配到编码格式，使用默认地区：%s%n", Locale.getDefault());
                return Locale.getDefault();
        }
    }

    /**
     * 获取消息
     */
    public String getMessage(int num) {
        Locale locale = getLocale(num);
        if (Objects.isNull(locale)) return null;
        return ResourceBundle.getBundle(BASENAME, locale).getString(KEY);
    }
}
