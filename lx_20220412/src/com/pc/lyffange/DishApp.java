package com.pc.lyffange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 点菜主程序
 */
public class DishApp {
    //定义集合接收对象
    static List<Dish> dishList=new ArrayList<>();
    //用户以点的菜品
    static List<Dish> personDish=new ArrayList<>();

    public static void main(String[] args) {

        //展示菜品
        initDish();
        //做菜

        //创建扫描器对象，打印到控制台
        Scanner s = new Scanner(System.in);
       //写死循环
        while (true){
            //给用户展示主菜单
            showMenu();

            //获取内容
            int num = s.nextInt();
            //判断用户输入的数字
            switch (num){
                case 1:
                    while (true){
                        //把主菜单展示给用户
                        showDishMenu();
                        //获取用户输入的id值
                        int id = s.nextInt();
                        //判断 如果为0结束此循环
                        if (id==0){
                            break;
                        }
                        //从集合获取到菜品对象 1 2 3 4 5
                        //集合索引 01234
                        Dish dish = dishList.get(id - 1);
                        System.out.println("亲，您点了："+dish.name);
                        //用户点一个 存一个
                        personDish.add(dish);

                    }

                case 2:
                    //展示用户已经点的菜
                    shoePersonDish();
                    break;
                case 3:
                    //买单
                    buy();
                    return;
            }
        }


    }

    /**
     * 展示主菜单
     */
    public static void showDishMenu(){
        System.out.println("----请您点菜--");
        for (int i = 0; i < dishList.size(); i++) {
            Dish dish = dishList.get(i);
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
        System.out.println("---输入序号选菜，按0返回上一级菜单---");
    }

    /**
     * 客户已点菜单
     */
    public static void shoePersonDish(){
        System.out.println("---您已点菜--");
        for (Dish dish : personDish) {
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
    }

    /**
     * 买单
     */
    public static void buy(){
        System.out.println("请稍等，正再结算...");
        //定义总金额
        double total=0f;
        //便利已点的菜品
        for (Dish dish : personDish) {
            //单价的累加
            total+=dish.price;
        }
        System.out.println("亲，您本次共消费了"+total+"元");
    }

    /**
     * 展示主菜单
     */
    public static void showMenu(){
        System.out.println("----主菜单------");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已点菜品\t\t 2");
        System.out.println("买单\t\t\t 3");
        System.out.println("----根据编号选择服务----");
    }
/**
 * 初始化菜品
 */
    public static  void initDish(){
        Dish dish = new Dish(1,"鱼香肉丝",29.0);
        dishList.add(dish);
        Dish dish2 = new Dish(2,"炖王八",59.0);
        dishList.add(dish2);
        dishList.add(new Dish(3,"家常凉菜",19.0));
        dishList.add(new Dish(4,"地三鲜",9.0));
        dishList.add(new Dish(5,"火锅鸡",79.0));

    }
}
