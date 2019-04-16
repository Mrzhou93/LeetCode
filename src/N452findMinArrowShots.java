package src;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。
 * 由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。
 *
 * 一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。
 * 我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * Example:
 *
 * 输入:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * 输出:
 * 2
 *
 * 解释:
 * 对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
 *
 * 分析：将结束的位置按照升序排序
 * */

class N452findMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;

        if (points.length == 1)
            return 1;

        int res = 1;

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int end = points[0][1];
        for (int i = 1; i < points.length; i++){
            if (points[i][0] > end){
                end = points[i][1];
                res++;
            }
        }

        for (int i = 0; i < points.length; i++){
            System.out.print("["+points[i][0]+","+points[i][1]+"]");
        }
        System.out.println();

        return res;
    }

    public static void main(String[] args){
        int[][] num = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int[][] num1 = {{1,2}, {2,3}, {3,4}, {4,5}};
        int[][] num2 = {{2,3}, {2,3}};
        int[][] num3 = {{9, 12}, {1, 10}, {4, 11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};

        N452findMinArrowShots s= new N452findMinArrowShots();
        System.out.println(s.findMinArrowShots(num));
        System.out.println(s.findMinArrowShots(num1));
        System.out.println(s.findMinArrowShots(num2));
        System.out.println(s.findMinArrowShots(num3));
    }
}
