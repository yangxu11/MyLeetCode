package leetcode;

import java.util.Random;

/**
 * 在圆内随机生成点
 *
 * @author yx
 * @create 2019-05-28  20:09
 **/
public class Q478 {
    //要对radius的平方取随机，再开方，因为是对面积随机，而不是对半径随机
    class Solution {
        private double radius;
        private double x_center;
        private double y_center;
        private Random rand;

        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
            this.rand = new Random();
        }

        public double[] randPoint() {
            double r2 = rand.nextDouble()*(radius*radius);
            double angle = rand.nextDouble()*360;
            double r = Math.sqrt(r2);
            double x = r*Math.cos(angle);
            double y = r*Math.sin(angle);
            return new double[]{x,y};
        }
    }
}
