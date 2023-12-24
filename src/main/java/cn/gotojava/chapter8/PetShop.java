package cn.gotojava.chapter8;

import cn.gotojava.chapter8.interfaces.Pet;
import cn.gotojava.chapter8.exception.PetException;

import java.util.Objects;

/**
 * description：宠物商店
 *
 * @author yangzhao
 * @createBy 2023/12/23
 */
public class PetShop {

    // 存储宠物信息
    private Pet[] pets;

    // 宠物的存储数量
    private int foot;

    public PetShop(int len) {
        System.out.println("宠物商店初始化...");
        this.pets = (len > 0)? new Pet[len] : new Pet[1];
    }

    public Pet[] getPets() {
        return pets;
    }

    public PetShop setPets(Pet[] pets) {
        this.pets = pets;
        return this;
    }

    public int getFoot() {
        return foot;
    }

    public PetShop setFoot(int foot) {
        this.foot = foot;
        return this;
    }

    /**
     * 获取所有宠物信息
     */
    public void getAllPet() throws PetException {
        System.out.println(String.format("获取所有宠物信息，当前宠物数量：%s", pets.length));
        if (pets.length < 0){
            throw new PetException("宠物商店没有宠物!");
        }
        Pet[] pets = filterExistingPets(this.pets);
        for (int i = 0; i < pets.length; i++) {
            System.out.println(String.format("姓名：%s，颜色：%s，年龄：%s",
                    this.pets[i].getName(),
                    this.pets[i].getColor(),
                    this.pets[i].getAge()));
        }
    }

    /**
     * 增加宠物
     * @param pet 宠物信息
     * @exception PetException
     * @return 新增成功返回true,失败返回false
     */
    public boolean add(Pet pet) throws PetException {
        // 宠物商店已经装满了
        if (this.foot >= this.pets.length){
            throw new PetException(String.format("宠物商店装满了，%s", pet));
        }

        // 增加宠物
        System.out.println(String.format("增加宠物，%s", pet.toString()));
        this.pets[this.foot] = pet;
        this.foot++;
        return true;
    }


    /**
     * 查找宠物
     * @param petName 宠物名称
     * @return
     */
    public Pet[] search(String petName) throws PetException {
        if (petName.isEmpty()){
            throw new PetException("检索的宠物名称不能为空");
        }

        // 查找的结果
        Pet[] pet = null;

        // 记录符合条件的宠物数量
        int count = 0;

        // 过滤存在的宠物
        Pet[] pets = filterExistingPets(this.pets);

        // 查询符合条件的宠物数量
        for (int i = 0; i < pets.length; i++) {
            if (this.pets[i].getName().contains(petName)){
                count++;
            }
        }

        // 根据确定的宠物数量开辟空间，存储查询结果
        pet = new Pet[count];

        // 新增宠物的索引位置标记
        int index = 0;
        // 查询符合条件的宠物信息
        for (int i = 0; i < pets.length; i++) {
            if (this.pets[i].getName().contains(petName)){
                pet[index] = this.pets[i];
                index++;
            }
        }

        return pet;
    }

    /**
     * 过滤出存在的宠物，去掉空的宠物对象
     * @param pets 宠物数组
     */
    private Pet[] filterExistingPets(Pet[] pets) {
        // 存储存在的宠物数量，用于给宠物数组对象开辟空间
        int count = 0;

        for (int i = 0; i < pets.length; i++) {
            if (Objects.isNull(pets[i])){
                continue;
            }
            count++;
        }

        // 统计存在的宠物数量
        Pet[] pet = new Pet[count];

        // 保存存在的宠物信息，过滤掉空宠物对象
        for (int i = 0; i < pets.length; i++) {
            if (Objects.isNull(pets[i])){
                continue;
            }
            pet[i] = pets[i];
        }
        return pet;
    }
}
