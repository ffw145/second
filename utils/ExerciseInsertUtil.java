package utils;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

/* 将题目以及答案存储进文本文件中*/
public class ExerciseInsertUtil {

    private static String filename1="exercise.txt";
    private static String filename2="answer.txt";

    public static void insertAnswer(String[] answer) {
        File file=new File(filename2);
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            if(!file.exists())
                file.createNewFile();
            fos=new FileOutputStream(file);
            osw=new OutputStreamWriter(fos);
            bw=new BufferedWriter(osw);
            for(int i=1;i<=answer.length-1;i++) {
                bw.write("答案"+i+":"+" "+answer[i]+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw!=null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null)
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fos!=null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public static void insertAnswer(double[] answer) {
        File file=new File(filename2);
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        BigDecimal fomat=null;
        double result=0;
        try {
            if(!file.exists())
                file.createNewFile();
            fos=new FileOutputStream(file);
            osw=new OutputStreamWriter(fos);
            bw=new BufferedWriter(osw);
            for(int i=1;i<=answer.length-1;i++) {
                //转化为两位小数
                fomat=new BigDecimal(answer[i]);
                result=fomat.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                bw.write("答案"+i+":"+" "+result+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw!=null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null)
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fos!=null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public static void insertExercise(String[] exercise) {
        File file=new File(filename1);
        FileOutputStream fos=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            if(!file.exists())
                file.createNewFile();
            fos=new FileOutputStream(file);
            osw=new OutputStreamWriter(fos);
            bw=new BufferedWriter(osw);
            for(int i=1;i<=exercise.length-1;i++) {
                bw.write("题目"+i+":"+" "+exercise[i]+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bw!=null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw!=null)
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(fos!=null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}

