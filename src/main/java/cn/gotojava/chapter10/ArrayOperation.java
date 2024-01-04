package cn.gotojava.chapter10;

import java.util.Objects;

public class ArrayOperation<T> {

    private T[] array;

    public ArrayOperation(int size) {
        this.array = (T[]) new Object[size];
    }

    /**
     * 添加元素到数组指定位置
     * @param index 索引下标
     * @param element 添加的元素
     * @exception ArrayIndexOutOfBoundsException 索引超出范围
     */
    public void addElement(int index, T element) throws ArrayIndexOutOfBoundsException{
        if (index >= 0 && index < array.length){
            this.array[index] = element;
            return;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("错误的索引范围，索引范围应该在0-%s", this.array.length -1));
    }

    /**
     * 获取元素
     * @param index 索引下标
     * @exception ArrayIndexOutOfBoundsException 索引超出范围
     * @return
     */
    public T getElement(int index) throws ArrayIndexOutOfBoundsException{
        if (index >= 0 && index < array.length){
            return this.array[index];
        }
        throw new ArrayIndexOutOfBoundsException(String.format("错误的索引范围，索引范围应该在0-%s", this.array.length -1));
    }

    /**
     * 查询数组内容
     * @param element 元素内容
     * @return 存在返回元素下标，不存在返回-1
     * @exception NullPointerException 参数
     */
    public int indexOf(T element) throws IllegalArgumentException{
        if (Objects.isNull(element)){
            throw new IllegalArgumentException("参数不能为空");
        }

        for (int i = 0; i < this.array.length; i++) {
            if (Objects.nonNull(array[i]) && array[i].equals(element)){
                return i;
            }
        }

        return -1;
    }

    /**
     * 删除元素
     * @param element 元素内容
     * @return 删除成功返回true，失败返回false
     */
    public boolean delete(T element){
        boolean flag = false;

        // 查询元素是否存在
        int index = indexOf(element);
        if (index >= 0){
            this.array[index] = null;
            flag = true;
        }
        return flag;
    }

    /**
     * 更新元素内容
     * @param index 索引位置
     * @param element 更新的元素内容
     * @return 更新成功返回true，失败返回false
     */
    public boolean update(int index, T element){
        boolean flag = false;
        // 查询索引是否存在
        T result = getElement(index);
        if (Objects.nonNull(result)){
            this.array[index] = element;
            flag = true;
        }
        return flag;
    }
}