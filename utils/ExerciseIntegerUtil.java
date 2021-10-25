package utils;


/*全部为整数的题目*/
public class ExerciseIntegerUtil {

    /*
     * 未处理除法的情况下变为分数
     * 仅仅是变成了两位小数输出
     */

    //n为传入的题目数量,x为传入的数值范围
    public static void getExerise(int n,int x) {
        //结果
        double sum=0;
        //题目数量
        int count=0;
        double[] results=new double[n+1];
        String[] exercise=new String[n+1];
        while(count!=n) {
            //四个数据a,b,c,d
            double a=(int) (Math.random()*x)+1;
            double b=(int) (Math.random()*x)+1;
            double c=(int) (Math.random()*x)+1;
            double d=(int) (Math.random()*x)+1;
            //随机运算符+-*/,0表示+，1表示-，2表示*，3表示/
            int operator1=(int) (Math.random()*4);
            int operator2=(int) (Math.random()*4);
            int operator3=(int) (Math.random()*4);
            //控制题目的项数,0表示2两项，1表示3项,2表示4项
            int nterms=(int) (Math.random()*3);
            //运算符为1个的情况下
            if(operator1==0&&nterms==0) {
                sum=a+b;
                exercise[++count]=a+"+"+b+"=";
            }
            //运算符为2个的情况下
            else if(operator1==0&&operator2==0&&nterms==1) {
                sum=a+b+c;
                exercise[++count]=a+"+"+b+"+"+c+"=";
            }
            else if(operator1==0&&operator2==2&&nterms==1) {
                sum=a+b*c;
                exercise[++count]=a+"+"+b+"×"+c+"=";
            }
            else if(operator1==0&&operator2==1&&nterms==1) {
                if(a+b<c) {
                    sum=a+c-b;
                    exercise[++count]=a+"+"+c+"-"+b+"=";
                }
                else {
                    sum=a+b-c;
                    exercise[++count]=a+"+"+b+"-"+c+"=";
                }
            }
            else if(operator1==0&&operator2==3&&nterms==1) {
                if(c==0&&b!=0) {
                    sum=a+c/b;
                    exercise[++count]=a+"+"+c+"÷"+b+"=";
                }
                else if(c!=0){
                    sum=a+b/c;
                    exercise[++count]=a+"+"+b+"÷"+c+"=";
                }
            }
            else if(operator1==1&&nterms==0) {
                if(a<b) {
                    sum=b-a;
                    exercise[++count]=b+"-"+a+"=";
                }
                else {
                    sum=a-b;
                    exercise[++count]=a+"-"+b+"=";
                }
            }
            else if(operator1==1&&operator2==0&&nterms==1) {
                if(a-b+c<0) {
                    sum=b-a+c;
                    exercise[++count]=b+"-"+a+"+"+c+"=";
                }
                else {
                    sum=a-b+c;
                    exercise[++count]=a+"-"+b+"+"+c+"=";
                }
            }
            else if(operator1==1&&operator2==1&&nterms==1) {
                if(a-b-c<0) {
                    continue;
                }
                else {
                    sum=a-b-c;
                    exercise[++count]=a+"-"+b+"-"+c+"=";
                }
            }
            else if(operator1==1&&operator2==2&&nterms==1) {
                if(a<b) {
                    sum=(b-a)*c;
                    exercise[++count]="("+b+"-"+a+")"+"×"+c+"=";
                }
                else {
                    sum=(a-b)*c;
                    exercise[++count]="("+a+"-"+b+")"+"×"+c+"=";
                }
            }
            else if(operator1==1&&operator2==3&&nterms==1) {
                if(a-b<0) {
                    if(c==0) {
                        continue;
                    }
                    else {
                        sum=(b-a)/c;
                        exercise[++count]="("+b+"-"+a+")"+"÷"+c+"=";
                    }
                }
                else if(c!=0){
                    sum=(a-b)/c;
                    exercise[++count]="("+a+"-"+b+")"+"÷"+c+"=";
                }
            }
            else if(operator1==2&&nterms==0) {
                sum=a*b;
                exercise[++count]=a+"×"+b+"=";
            }
            else if(operator1==2&&operator2==0&&nterms==1) {
                sum=a*b+c;
                exercise[++count]=a+"×"+b+"+"+c+"=";
            }
            else if(operator1==2&&operator2==1&&nterms==1) {
                if(a*b<c) {
                    sum=a*c-b;
                    exercise[++count]=a+"×"+c+"+"+b+"=";
                }
                else {
                    sum=a*b-c;
                    exercise[++count]=a+"×"+b+"+"+c+"=";
                }
            }
            else if(operator1==2&&operator2==2&&nterms==1) {
                sum=a*b*c;
                exercise[++count]=a+"×"+b+"×"+c+"=";
            }
            else if(operator1==2&&operator2==3&&nterms==1) {
                if(c==0&&b!=0) {
                    sum=a*c/b;
                    exercise[++count]=a+"×"+c+"÷"+b+"=";
                }
                else if(c!=0){
                    sum=a*b/c;
                    exercise[++count]=a+"×"+b+"÷"+c+"=";
                }
            }
            else if(operator1==3&&nterms==0) {
                if(b==0&&a!=0) {
                    sum=b/a;
                    exercise[++count]=b+"÷"+a+"=";
                }
                else if(b!=0){
                    sum=a/b;
                    exercise[++count]=a+"÷"+b+"=";
                }
            }
            else if(operator1==3&&operator2==0&&nterms==1) {
                if(b==0&&c!=0) {
                    sum=a/c+b;
                    exercise[++count]=a+"÷"+c+"+"+b+"=";
                }
                else if(b!=0) {
                    sum=a/b+c;
                    exercise[++count]=a+"÷"+b+"+"+c+"=";
                }
            }
            else if(operator1==3&&operator2==2&&nterms==1) {
                if(b==0&&c!=0) {
                    sum=a/c*b;
                    exercise[++count]=a+"÷"+c+"×"+b+"=";
                }
                else if(b!=0) {
                    sum=a/b*c;
                    exercise[++count]=a+"÷"+b+"×"+c+"=";
                }
            }
            else if(operator1==3&&operator2==1&&nterms==1) {
                if(b==0&&c!=0&&a/c>b) {
                    sum=a/c-b;
                    exercise[++count]=a+"÷"+c+"×"+b+"=";
                }
                else if(b!=0&&a/b>c) {
                    sum=a/b-c;
                    exercise[++count]=a+"÷"+b+"×"+c+"=";
                }
            }
            else if(operator1==3&&operator2==3&&nterms==1) {
                if(a!=0&&b!=0&&c!=0) {
                    sum=a/b/c;
                    exercise[++count]=a+"÷"+b+"÷"+c+"=";
                }
            }
            //运算符为3个的情况下
            else if(operator1==0&&operator2==0&&operator3==0&&nterms==2) {
                sum=a+b+c+d;
                exercise[++count]=a+"+"+b+"+"+c+"+"+d+"=";
            }
            else if(operator1==0&&operator2==2&&operator3==0&&nterms==2) {
                sum=a+b*c+d;
                exercise[++count]=a+"+"+b+"×"+c+"+"+d+"=";
            }
            else if(operator1==0&&operator2==1&&operator3==0&&nterms==2) {
                if(a+b-c+d<0) {
                    continue;
                }
                else {
                    sum=a+b-c+d;
                    exercise[++count]=a+"+"+b+"-"+c+"+"+d+"=";
                }
            }
            else if(operator1==0&&operator2==3&&operator3==0&&nterms==2) {
                if(c==0) {
                    continue;
                }
                else {
                    sum=a+b/c+d;
                    exercise[++count]=a+"+"+b+"÷"+c+"+"+d+"=";
                }
            }
            else if(operator1==0&&operator2==3&&operator3==1&&nterms==2) {
                if(c==0||a+b/c-d<0) {
                    continue;
                }
                else {
                    sum=a+b/c-d;
                    exercise[++count]=a+"+"+b+"÷"+c+"-"+d+"=";
                }
            }
            else if(operator1==0&&operator2==3&&operator3==2&&nterms==2) {
                if(c==0) {
                    continue;
                }
                else {
                    sum=a+b/c*d;
                    exercise[++count]=a+"+"+b+"÷"+c+"×"+d+"=";
                }
            }
            else {
                continue;
            }
            //存储结果
            results[count]=sum;
        }
        //此处为实现将答案存入文本文件
        ExerciseInsertUtil.insertExercise(exercise);
        ExerciseInsertUtil.insertAnswer(results);
        //将答案存起来
        AnswerCheckUtil.setResults(results);
    }
}
