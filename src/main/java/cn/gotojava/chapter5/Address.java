package cn.gotojava.chapter5;

import java.util.Objects;

/**
 * description：代表地址的Address类，地址信息由国家、省份、城市、街道、邮编组成，并可以返回完整的地址信息。
 * @author yangzhao
 * @createBy 2023/12/21
 */
public class Address {

    /** 国家 */
    private String nation;

    /** 省份 */
    private String province;

    /** 城市 */
    private String city;

    /** 街道 */
    private String street;

    /** 邮编 */
    private String postcode;

    public Address() { }

    public Address(String nation, String province, String city, String street, String postcode) {
        this.nation = nation;
        this.province = province;
        this.city = city;
        this.street = street;
        this.postcode = postcode;
    }

    /**
     * 获取地址信息
     * @return 地址信息
     */
    public String print(){
        return "Address{" +
                "nation='" + nation + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }

}
