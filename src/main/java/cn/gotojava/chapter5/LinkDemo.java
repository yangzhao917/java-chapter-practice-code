package cn.gotojava.chapter5;

import java.util.Objects;

/**
 * description：单向链表的实现
 *
 * @author yangzhao
 * @createBy 2023/12/21
 */
public class LinkDemo {

    public static void main(String[] args) {
//        //定义根节点
//        Node root = new Node("火车头");
//        //定义第一节车厢A
//        Node nodeA = new Node("车厢-A");
//        //定义第二节车厢B
//        Node nodeB = new Node("车厢-B");
//        //定义第三节车厢C
//        Node nodeC = new Node("车厢-C");
//        //定义第四节车厢D
//        Node nodeD = new Node("车厢-D");
//        //根节点链接第一节车厢A
//        root.setNext(nodeA);
//        //第一节车厢A链接第二节车厢B
//        nodeA.setNext(nodeB);
//        //第二节车厢B链接第三节车厢C
//        nodeB.setNext(nodeC);
//        //第三节车厢C链接第四节车厢D
//        nodeC.setNext(nodeD);
//        // 打印节点
//        root.printNode(root);

        Node linkNode = new Node();

        //添加节点
        linkNode.addNode("LINK-A");
        linkNode.addNode("LINK-B");
        linkNode.addNode("LINK-C");
        linkNode.addNode("LINK-D");
        linkNode.addNode("LINK-E");
        linkNode.addNode("LINK-F");
        linkNode.addNode("LINK-G");

        /********** 删除前 **********/
        //打印节点信息
        linkNode.printNode();
        linkNode.deleteNode("LINK-H");
        linkNode.deleteNode("LINK-D");
        linkNode.setNext(new Node("节点-L"));

        /********** 删除后 **********/
        linkNode.printNode();
        String findNodeName = "LINK-C";
        System.out.println(String.format("查找节点：%s，是否存在：%s", findNodeName, linkNode.contains(findNodeName)? "存在" : "不存在"));
    }

}

class Node {
    /** 保存节点内容 */
    private String data;

    /** 保存下一节点 */
    private Node next;

    /** 根节点 */
    private Node root;

    public Node() {
    }

    public Node(String data) {
        this.data = data;
    }

    /**
     * 获取节点内容
     * @return
     */
    public String getData() {
        return data;
    }

    /**
     * 添加节点
     * @param nodeName 节点名称
     */
    private void add(Node nodeName){
        //如果下一个节点不存在，则把新节点设置在next位置上
        if (Objects.isNull(this.next)){
            this.next = nodeName;
        }else {
            //如果还有下一个节点，则在下一个节点位置上增加一个新节点
            this.next.add(nodeName);
        }
    }

    /**
     * 添加节点
     * @param nodeName 新节点名称
     */
    public void addNode(String nodeName){
        Node newNode = new Node(nodeName);

        // 没有根节点，则把新节点作为根节点
        if (Objects.isNull(this.root)){
            this.root = newNode;
            return;
        }

        // 添加到下一节点
        this.root.add(newNode);
    }

    /**
     * 节点搜索
     * @param data
     * @return
     */
    private boolean search(String data){
        // 如果查找的节点是当前节点，则直接返回
        if (this.data.equals(data)){
            return true;
        }

        // 如果存在下一节点就继续查找
        if (Objects.nonNull(this.next)){
            return this.next.search(data);
        }

        // 节点不存在，返回false
        return false;
    }

    /**
     * 删除节点
     * @param prev 上一级节点
     * @param data 要删除的节点
     * @return 删除成功返回true，否则返回false
     */
    private void delete(Node prev, String data){
        // 匹配到了删除的节点
        if (this.data.equals(data)){
            // 空出当前节点，获取节点的上一级节点和节点下一级节点，用下一级节点链接到上一级节点的下级节点，以实现断开节点
            prev.next = this.next;
            return;
        }

        // 没有匹配到，存在下一节点，继续向下查找
        if (Objects.nonNull(this.next)){
            //继续向下查找
            this.next.delete(this, data);
        }
    }

    /**
     * 删除节点
     * @param nodeName 节点名称
     */
    public void deleteNode(String nodeName){
        // 如果节点存在则删除
        if (!this.contains(nodeName)){
            System.out.println(String.format("删除节点：%s，状态：不存在", nodeName));
            return;
        }
        if (this.root.data.equals(nodeName)){
            this.root = this.root.next;
        }else {
            this.root.next.delete(root, nodeName);
            System.out.println(String.format("删除节点：%s，状态：成功", nodeName));
        }
    }

    /**
     * 获得下一节点
     * @return
     */
    public Node getNext() {
        return next;
    }

    /**
     * 设置下一节点
     * @return
     */
    public Node setNext(Node next) {
        this.root.add(next);
        return this;
    }

    /**
     * 打印节点
     */
    public void printNode() {
        // 判断是否存在根节点
        if (Objects.nonNull(this.root)){
            this.root.print();
        }
    }

    /**
     * 打印节点
     * @param node 节点
     */
    public void printNode(Node node) {
        System.out.print(String.format("当前节点：%s ==> ", node.getData()));
        if (Objects.nonNull(node.getNext())){
            System.out.println(String.format("下一节点：%s", node.getNext().getData()));
            printNode(node.getNext());
        }
    }

    /**
     * 打印节点
     */
    private void print(){
        System.out.print(String.format("当前节点：%s ==> ", this.data));
        if (Objects.nonNull(this.next)) {
            System.out.println(String.format("下一节点：%s", this.next.getData()));
            this.next.print();
        }else {
            System.out.println("END");
        }
    }

    /**
     * 判断节点是否存在
     * @param nodeName 节点名称
     * @return 存在返回true,否则返回false
     */
    public boolean contains(String nodeName){
        return this.root.search(nodeName);
    }
}