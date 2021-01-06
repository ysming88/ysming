package Demo;

import java.util.Random;

public class RandomNum {//生成随机数
    public static String getRandomNumCode(int number)
    {
        String codeNum = "";
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random random = new Random();//建立一个生产随机数的对象
        for (int i = 0; i < number; i++)
        {
            int next = random.nextInt(10000);
            //随机数的范围是 0 ~ 10000，目的是产生足够随机的数，避免产生的数字重复率高的问题
            codeNum += numbers[next % 9];
        }
        System.out.println(codeNum);
        return codeNum;
    }
    public static void main(String[] args){
        getRandomNumCode(10);
    }
}
