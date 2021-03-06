package huawei.hj24;

import java.util.Scanner;

/**
 * N 位同学站成一排，音乐老师要请最少的同学出列，使得剩下的 K 位同学排成合唱队形。
 *
 * 设K位同学从左到右依次编号为 1，2…，K ，他们的身高分别为T_1,T_2,…,T_K
 * 若存在i(1≤i≤K)使得 T_1 < T_2 < ... < T_i > T_i+1 > ...  > T_K 则称这K名同学排成了合唱队形。
 * 通俗来说，能找到一个同学，他的两边的同学身高都依次严格降低的队形就是合唱队形。
 * 例子：
 * 123 124 125 123 121 是一个合唱队形
 * 123 123 124 122不是合唱队形，因为前两名同学身高相等，不符合要求
 * 123 122 121 122不是合唱队形，因为找不到一个同学，他的两侧同学身高递减。
 *
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
 *
 * 数据范围： 1≤n≤3000
 *
 * 输入描述：
 * 用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
 *
 * 输出描述：
 * 最少需要几位同学出列
 *
 * 示例1
 * 输入：
 * 8
 * 186 186 150 200 160 130 197 200
 *
 * 输出：
 * 4
 *
 * 说明：
 * 由于不允许改变队列元素的先后顺序，所以最终剩下的队列应该为186 200 160 130或150 200 160 130
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = scanner.nextInt();
        }
        int min = deal(students);
        System.out.println(min);
    }

    /**
     *
     * @param students
     * @return
     */
    private static int deal(int[] students) {
        int max = 0;
        int[] dpl = new int[students.length];
        int[] dpr = new int[students.length];
        dpl[0] = 1;
        dpr[students.length - 1] = 1;
        for (int i = 0; i < students.length; i++) {
            // 左侧
            dpl[i] = 1;
            for (int j = 0; j < i; j++) {
                if (students[i] > students[j]) {
                    dpl[i] = Math.max(dpl[j] + 1, dpl[i]);
                }
            }


            // 右侧
            int index = students.length - 1 - i;
            dpr[index] = 1;

            for (int j = students.length - 1; j > index; j--) {
                if (students[index] > students[j]) {
                    dpr[index] = Math.max(dpr[j] + 1, dpr[index]);
                }
            }


        }
        for (int i = 0; i < students.length; i++) {
            int tmp = dpl[i] + dpr[i];
            if (max < tmp) {
                max = tmp;
            }
        }
//        for (int i : dpl) {
//            System.out.print(i + "\t");
//        }
//        System.out.println();
//        for (int i : dpr) {
//            System.out.print(i + "\t");
//        }
//        System.out.println();
        // 计算了两次自己 故+1
        return students.length - max + 1;
    }


}
