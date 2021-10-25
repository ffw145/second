package utils;


/* 全部为分数的题目 */
public class ExerciseFractionUtil {

    // n为传入的题目数量,x为传入的数值范围
    public static void getExercise(int n, int x) {
        // 结果
        int sum = 0;
        // 题目数量
        int count = 0;
        // 数值，运算符，运算符个数
        int a, b, c, d, e, f, g, h, operator1, operator2, operator3, nterms;
        // 储存题目以及答案
        String[] results = new String[n + 1];
        String[] exercise = new String[n + 1];
        // 随机运算符+-*/,0表示+，1表示-，2表示*，3表示/
        while (n != count) {
            operator1 = (int) (Math.random() * 4);
            operator2 = (int) (Math.random() * 4);
            operator3 = (int) (Math.random() * 4);
            a = (int) (Math.random() * x);
            b = (int) (Math.random() * x);
            c = (int) (Math.random() * x);
            d = (int) (Math.random() * x);
            e = (int) (Math.random() * x);
            f = (int) (Math.random() * x);
            g = (int) (Math.random() * x);
            h = (int) (Math.random() * x);
            nterms = (int) (Math.random() * 3);
            //一个运算符的情况下
            if (b != 0 && d != 0 && nterms == 0) {
                if (operator1 == 0) {
                    exercise[++count] = a + "/" + b + "+" + c + "/" + d + "=";
                    // 储存临时值，方便化简
                    sum = a * d + b * c;
                    b = b * d;
                    //判断是否为假分数，下同
                    if (sum > b)
                        //将其转换成带分数，下同
                        results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                    else
                        //将分数化简，下同
                        results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                } else if (operator1 == 1) {
                    if ((a / b) > (c / d)) {
                        exercise[++count] = a + "/" + b + "-" + c + "/" + d + "=";
                        // 储存临时值，方便化简
                        sum = a * d - b * c;
                        b = b * d;
                        if (sum > b)
                            results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                        else
                            results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                    }
                } else if (operator1 == 2) {
                    exercise[++count] = a + "/" + b + "×" + c + "/" + d + "=";
                    // 储存临时值，方便化简
                    sum = a * c;
                    b = b * d;
                    if (sum > b)
                        results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                    else
                        results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                } else if (operator1 == 3) {
                    // 防止C为0出错
                    if (c == 0)
                        continue;
                    exercise[++count] = a + "/" + b + "÷" + c + "/" + d + "=";
                    // 储存临时值，方便化简
                    sum = a * d;
                    b = b * c;
                    if (sum > b)
                        results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                    else
                        results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                }
                //两个运算符的情况下
            } else if (b != 0 && d != 0 && f != 0 && nterms == 1) {
                if (operator1 == 0) {
                    if (operator2 == 0) {
                        exercise[++count] = a + "/" + b + "+" + c + "/" + d + "+" + e + "/" + f + "=";
                        b = b * d * f;
                        sum = a * d * f + c * b * f + e * b * d;
                        if (sum > b)
                            results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                        else
                            results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                    }
                } else if (operator2 == 1) {
                    if ((a / b + c / d - e / f) > 0) {
                        exercise[++count] = a + "/" + b + "+" + c + "/" + d + "-" + e + "/" + f + "=";
                        b = b * d * f;
                        sum = a * d * f + c * b * f - e * b * d;
                        if (sum > b)
                            results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                        else
                            results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                    }
                } else if (operator2 == 2) {
                    exercise[++count] = a + "/" + b + "+" + c + "/" + d + "×" + e + "/" + f + "=";
                    sum = a * d * f + c * e * b;
                    b = b * d * f;
                    if (sum > b)
                        results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                    else
                        results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                } else if (operator2 == 3 && e != 0) {
                    exercise[++count] = a + "/" + b + "+" + c + "/" + d + "÷" + e + "/" + f + "=";
                    sum = a * d * e + c * f * b;
                    b = b * d * e;
                    if (sum > b)
                        results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                    else
                        results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                } else if (operator1 == 1) {
                    if (operator2 == 0)
                        if ((a / b - c / d + e / f) > 0) {
                            exercise[++count] = a + "/" + b + "-" + c + "/" + d + "+" + e + "/" + f + "=";
                            sum = a * d * f - c * b * f + e * b * d;
                            b = b * d * f;
                            if (sum > b)
                                results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                            else
                                results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                        } else if (operator2 == 1)
                            if ((a / b - c / d - e / f) > 0) {
                                exercise[++count] = a + "/" + b + "-" + c + "/" + d + "-" + e + "/" + f + "=";
                                sum = a * d * f - c * b * f - e * b * d;
                                b = b * d * f;
                                if (sum > b)
                                    results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                                else
                                    results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                            } else if (operator2 == 2) {
                                if ((a / b - (c / d) * (e / f)) > 0) {
                                    exercise[++count] = a + "/" + b + "-" + c + "/" + d + "×" + e + "/" + f + "=";
                                    sum = a * d * f - b * c * e;
                                    b = b * d * f;
                                    if (sum > b)
                                        results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                                    else
                                        results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                                }
                            } else if (operator2 == 3) {
                                if ((a / b - (c / d) / (e / f)) > 0) {
                                    exercise[++count] = a + "/" + b + "-" + c + "/" + d + "÷" + e + "/" + f + "=";
                                    sum = a * d * e - b * c * f;
                                    b = b * d * e;
                                    if (sum > b)
                                        results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                                    else
                                        results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                                }
                            } else if (operator1 == 2) {
                                exercise[++count] = a + "/" + b + "×" + c + "/" + d + "×" + e + "/" + f + "=";
                                sum = a * c * e;
                                b = b * d * f;
                                if (sum > b)
                                    results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                                else
                                    results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                            } else if (operator1 == 3) {
                                if (a / b * c / d * e / f >= 0) {
                                    exercise[++count] = a + "/" + b + "÷" + c + "/" + d + "÷" + e + "/" + f + "=";
                                    sum = a * d * f;
                                    b = b * c * e;
                                    if (sum > b)
                                        results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                                    else
                                        results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                                }
                            }
                    //3个运算符的情况下，仅仅举出了较为简单的运算+法
                } else if (b != 0 && d != 0 && f != 0 && h != 0 && nterms == 2) {
                    if (operator1 == 0 && operator2 == 0 && operator3 == 0) {
                        exercise[++count] = a + "/" + b + "+" + c + "/" + d + "+" + e + "/" + f + "+" + g + "/" + h
                                + "=";
                        sum = a * d * f * h + c * b * f * h + e * b * d * h + g * b * d * f;
                        b = b * d * f * h;
                        if (sum > b)
                            results[count] = FractionOperationUtil.changeToProperFraction(sum, b);
                        else
                            results[count] = FractionOperationUtil.simplifiedFraction(sum, b);
                    }
                }
            }
        }
        // 此处为实现将答案存入文本文件
        ExerciseInsertUtil.insertExercise(exercise);
        ExerciseInsertUtil.insertAnswer(results);
        // 将答案存起来
        AnswerCheckUtil.setResults(results);
    }
}
