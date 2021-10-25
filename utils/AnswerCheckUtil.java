package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnswerCheckUtil {

    private static String results[];
    private static double results1[];

    public static void checkAnswer() {
        BufferedReader br=null;
        String line=null;
        //正确与错误的个数
        int i=1,error=0,correct=0,t=0,s=0;
        int[] correctAnswer;
        int[] wrongAnswer;
        //标志为哪个算式
        int symbol;
        if(results==null) {
            correctAnswer=new int[results1.length];
            wrongAnswer=new int[results1.length];
            symbol=1;
        }
        else{
            correctAnswer=new int[results.length];
            wrongAnswer=new int[results.length];
            symbol=2;
        }
        try {
            br = new BufferedReader(new FileReader("write.txt"));
            while((line=br.readLine())!=null) {
                if((symbol==2&&line.equals(results[i]))||(symbol==1&&line.equals(String.valueOf(results1[i])))) {
                    correct++;
                    if(results[i]==null)
                        wrongAnswer[s++]=i;
                    else
                        correctAnswer[t++]=i;
                    i++;
                }
                else {
                    error++;
                    wrongAnswer[s++]=i;
                    i++;
                }
            }
            if(symbol==1)
                while((error+correct)!=results1.length-1) {
                    error++;
                    wrongAnswer[s++]=i++;
                }
            else
                while((error+correct)!=results.length-1) {
                    error++;
                    wrongAnswer[s++]=i++;
                }
            System.out.print("Correct:"+correct+"(");
            for(i=0;i<t;i++) {
                if(i==t-1) {
                    System.out.print(correctAnswer[i]);
                    continue;
                }
                System.out.print(correctAnswer[i]+",");
            }
            System.out.print(")");
            System.out.println();
            System.out.print("Wrong:"+error+"(");
            for(i=0;i<s;i++) {
                if(i==s-1) {
                    System.out.print(wrongAnswer[i]);
                    continue;
                }
                System.out.print(wrongAnswer[i]+",");
            }
            System.out.print(")");
            System.out.println();
        } catch (IOException e) {
            System.out.println("错误，文件不存在或者文件为空");
        }
    }

    public static void setResults(double[] results) {
        AnswerCheckUtil.results1 = results;
    }

    public static void setResults(String[] results) {
        AnswerCheckUtil.results = results;
    }
}
