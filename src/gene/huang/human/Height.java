package gene.huang.human;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by apple on 2016/9/20.
 */
public class Height {
    private double height;

    private static double girlAvgHeight[] = {49.3, 74.0, 86.2, 93.6, 101.1, 108.1, 114.6, 120.8, 126.9, 133.0,
            139.1, 145.1, 150.8, 155.7, 159.6, 162.3, 163.5, 163.4, 162.7, 162.5 };
    private static double girlAvgIncrease[] = {24.70, 12.20, 7.40, 7.50, 7.00, 6.50, 6.20, 6.10, 6.10, 6.10,
            6.00, 5.70, 4.90, 3.90, 2.70, 1.20, -0.10, -0.70, -0.20};
    private static double girlDevHeight[] = {1.88, 2.58, 3.24, 4.09, 4.53, 4.91, 5.33, 5.79, 6.28, 6.67,
            6.97, 7.12, 7.11, 6.97, 6.76, 6.55, 6.41, 6.39, 6.47, 6.53};


    public static double getFemaleHeightByAge(int age){
        if(age > 19){
            age = 19;
        }else if(age < 0){
            age = 0;
        }
        return rand(girlAvgHeight[age], girlDevHeight[age]);
    }

    public static double getFemaleNextHeight(int age, double currentHeight){
        double rel;
        if(age > 18){
            return currentHeight;
        }else if(age < 0){
            age = 0;
        }

        double d = rand(girlAvgIncrease[age], 1.2);
        if(d<0){
            d=0;
        }

        rel = new BigDecimal(currentHeight+d)
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();

        return rel;
    }

    public static double initAdultHeight(Sex sex){
        if(sex == Sex.Male){
            return rand(171.4, 7.42);
        }else{
            return rand(159.9, 7.11);
        }
    }

    public static double rand(double avg, double dev){
        double rel = 0;
        Random random = new Random();

        rel = avg + (random.nextGaussian()*dev);

        // 四捨五入
        rel = new BigDecimal(rel)
                .setScale(1, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        return rel;
    }
}
