package cn.gotojava.chapter6;

/**
 * description：第六章：面向对象编程（高级篇）
 *
 * @author yangzhao
 * @createBy 2023/12/22
 */
public class Main {

    /*
    本章要点：
    1.继承可以扩充已有类的功能。通过extends关键字实现，可将父类的成员（包含数据成员与方法）继承到子类。
    2.Java在执行子类的构造方法之前，会先调用父类中无参的构造方法，其目的是为了对继承自父类的成员做初始化的操作。
    3.父类有多个构造方法时，如果要调用特定的构造方法，则可在子类的构造方法中，通过super()这个关键字来完成。
    4.this()是在同一类中调用其他的构造方法，而super()则是从子类的构造方法调动其父类的构造方法。
    5.使用this调用属性或方法的时候会先从本类中查找，如果本类中没有查找到，则再从父类中查找，
        而使用super()的话会直接从父类中查找需要的属性或方法。
    6.this()与super()其相似之处：
        1)当构造方法有重载时，两者均会根据所给予的参数的类型与个数，正确地执行相对应的构造方法。
        2)两者均必修编写在构造方法内的第一行，因此，this()与super()无法同时存在于同一个构造方法内。
    7."重载"（overloading），它是指在相同类内，定义名称相同，但参数个数或类型不同的方法，
        因此Java便可依据参数的个数或类型调用相应的方法。
    8."覆写"（overriding），它是在子类中，定义名称、参数个数与类型均与父类相同的想法，用于覆写父类里的方法。
    9.如果父类的方法不希望被子类覆写，可在父类的方法之前加上"final"关键字，如此该方法便不会被覆写。
    10.final的另一个作用是把它加在数据成员变量前面，如此该变量就变成了一个常量，这样便无法在程序代码中再做修改了。
        使用public static final可以声明一个全局常量。
    11.所有的类均继承自Object类。一个好的类应该覆写Object类中的toString()、equals()、hashCode()3个方法，
        所有的对象都可以向Object类进行向上转型。
    12.Java可以创建抽象类，专门用来当做父类。抽象类的作用类似于"模板"，其目的是依据其格式来修改并创建新的类。
    13.抽象类的方法可分为两种，一种是一般的方法，另一种是以abstract关键字开头的"抽象方法"。"抽象方法"并没有定义方法体，
        而是要保留给由抽象类派生出的新类来定义。
    14.抽象类不能直接用来产生对象，必须通过对象的多态性进行实例化操作。
    15.接口是方法和全局常量的集合，接口必须被子类实现，一个接口可以同时继承多个接口，一个子类可以同时实现多个接口，从JDK1.8k开始，
        接口允许使用default与static定义普通方法。
    16.Java并不允许类的多重继承，但是允许实现多个接口。
    17.接口与一般类一样，均可通过扩展的技术来派生出新的接口。原来的接口称为基本接口或父接口；派生出的接口称为派生接口或子接口。
        通过这种机制，派生接口不仅可以保留父接口的成员，同时也可以加入新的成员以满足实际的需要。
    18.Java对象的多态性分为：向上转型（自动）、向下转型（强制）。
    19.通过instanceof关键字，可以判断对象属于哪个类。
    20.匿名内部类的好处是可利用内部类创建不具有名称的对象，并利用它访问到类里的成员。
     */

    public static void main(String[] args) {
        /*
        定义一个ClassName接口，接口中只有一个抽象方法getClassName()；
        设计一个类Company，该类实现接口ClassName中的方法getClassName()，功能是获取该类的类名称；
        编写应用程序使用Company类。
         */
        Company company = new Company();
        String className = company.getClassName();
        System.out.println(String.format("类名称：%s", className));

        //考虑一个表示图形的类，写出类中的属性及方法
        Circle circle = new Circle("蓝色", "圆形", 5);
        System.out.println(String.format("形状：%s，面积：%s，周长：%s", circle.getShapeName(), circle.area(), circle.perimeter()));

        /*
        建立一个人类（Person）和学生类（Student），功能要求如下：
        1）Person类中包含四个私有型的数据成员name、addr、sex、age，分别为字符串型、字符串型、字符型及整型，
            表示姓名、地址、性别和年龄。一个4参构造方法、一个两参构造方法、一个无参构造方法、一个输出方法显示4种属性。
        2）Student类继承Person类，并增加成员math、english存放数学和英语成绩。一个6参构造方法、一个两参构造方法、
            一个无参构造方法和重写输出方法用于显示6中属性。
         */
        Person student = new Student("张三", "中国上海", '男', 22, 117.3, 100.2);
        System.out.println(student.print());

        //使用面向对象的概念表示出下面的生活场景：小明去超市买东西，所有买到的东西都放在了购物车之中，最后到收银台一起结账
        Supermarket.main(args);
    }
}