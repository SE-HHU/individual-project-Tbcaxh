//名称：软工工程课个人项目作业
//个人信息：软件工程2班2103010516陈晨
//开发时间：9.28-10.4
//程序功能：随机生成指定数量不重复的俩位数或者三位数相加减的算法题并将题目和答案分别生成在txt文档里

package com.cc2 ;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class homework1 {
    public static void main(String[] args) {
//创建0-99的数组numbers
        String[] s = new String[]{"+", "-", "null"};
        List<String> dateList = new ArrayList<>();
        int[] numbers = new int[100];
        for (int i = 1; i <= 100; i++) {
            numbers[i - 1] = i;
        }

//设置生成题目次数函数
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入随机生成题目的数量：");
        int x = sc.nextInt();
        for (int i = 1; i <= x; ) {
            int a, b, c, d, e;
            String operate1, operate2, formula;
            formula = "0";

            //定义formula式子中各数和符号
            a = numbers[r.nextInt(100)];
            b = numbers[r.nextInt(100)];
            c = numbers[r.nextInt(100)];
            d = r.nextInt(2);
            e = r.nextInt(3);
            operate1 = s[d];
            operate2 = s[e];

            //随机生成formula式子 并且是两个数或者三个数随机相加减
            switch (e) {
                case 0:
                case 1:
                    formula = a + operate1 + b + operate2 + c + "=";
                    System.out.println(formula);
                    break;
                case 2:
                    formula = a + operate1 + b + "=";
                    System.out.println(formula);
                    break;
            }
            //计算出各式子的结果m
            int m = 0;
            if (d == 0) {
                if (e == 0) {
                    m = a + b + c;
                }
                if (e == 1) {
                    m = a + b - c;
                }
                if (e == 2) {
                    m = a + b;
                }
            } else {
                if (e == 0) {
                    m = a - b + c;
                }
                if (e == 1) {
                    m = a - b - c;
                }
                if (e == 2) {
                    m = a - b;
                }
            }
            System.out.println(m);


            //将生成的式子写入一个数组里，用来判断是否重复
            boolean result = !dateList.contains(formula);
            StringBuffer exercises = new StringBuffer();
            if (result) {
                writeExercises(formula);
                // exercises.append(dateList.get(i));
                dateList.add(formula);
                i++;
            }


          //将整数m转换成字符串
            String str =m+"";
            writeAnswers(str);

        }
    }

    //将生成的题目放入文件Exercises.txt
    public static void writeExercises(String exercises){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Exercises.txt", true));
            bufferedWriter.write(exercises + System.lineSeparator());
            bufferedWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }}
    //将题目的答案放入文件Answers.txt
    public static void writeAnswers(String answers){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Answers.txt", true));
            bufferedWriter.write( answers + System.lineSeparator());
            bufferedWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }}}



