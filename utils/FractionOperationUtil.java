package utils;


/*对分数的处理*/
public class FractionOperationUtil {

    //化简分数
    public static String simplifiedFraction(int a,int b) {
        //当分子为0后直接返回0
        if(a==0)
            return 0+"";
        //当分母为1时返回整数
        if(b==1)
            return a+"";
        int simplified = simplified(a,b);
        return a/simplified+"/"+b/simplified;
    }

    //化成真分数
    public static String changeToProperFraction(int a,int b) {
        //当分子为0后直接返回0
        if(a==0)
            return 0+"";
        //当分母为1时返回整数
        if(b==1)
            return a+"";
        int temp,temp2;
        temp=a/b;
        temp2=a%b;
        //化简
        int simplified=simplified(temp2,b);
        if(temp2==0)
            return temp+"";
        return temp+"'"+temp2/simplified+"/"+b/simplified;
    }

    //递归调用，求最大公约数
    private static int simplified(int a, int b) {
        if(b==0)
            return a;
        else
            return simplified(b,a%b);
    }

}
