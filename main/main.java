package main;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import utils.AnswerCheckUtil;
import utils.ExerciseFractionUtil;
import utils.ExerciseIntegerUtil;

public class main {


    public static void main(String[] args) {
        //n表示输入题目数量，x表示输入数字的范围
        int in,n,x,over;
        System.out.println("自动生成小学四则运算题目");
        while(true) {
            Scanner scanner=new Scanner(System.in);
            System.out.println("选择题目类型：1整数类型，2分数类型");
            //判断是否输入为数字
            if(!scanner.hasNextInt())
                continue;
            in=scanner.nextInt();
            if(in==1) {
                System.out.println("请输入出题的数量和数字的范围");
                n=new Scanner(System.in).nextInt();
                x=new Scanner(System.in).nextInt();
                ExerciseIntegerUtil.getExerise(n, x);
                File file=new File("write.txt");
                try {
                    if(!file.exists())
                        file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("请在write.txt中作答,答题完毕请输入1");
                over=scanner.nextInt();
                //判断是否输入正确
                while(over!=1) {
                    System.out.println("输入有误，请重新输入");
                    over=new Scanner(System.in).nextInt();
                }
                AnswerCheckUtil.checkAnswer();
            }
            else if(in==2) {
                System.out.println("请输入出题的数量和数字的范围");
                n=new Scanner(System.in).nextInt();
                x=new Scanner(System.in).nextInt();
                ExerciseFractionUtil.getExercise(n, x);
                File file=new File("write.txt");
                try {
                    if(!file.exists())
                        file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("请在write.txt中作答,答题完毕请输入1");
                over=scanner.nextInt();
                while(over!=1) {
                    System.out.println("输入有误，请重新输入");
                    over=new Scanner(System.in).nextInt();
                }
                AnswerCheckUtil.checkAnswer();
            }
            else {
                System.out.println("你输入有误");
            }
        }
    }

}
