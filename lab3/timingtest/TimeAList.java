package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // 储存所有测试AList
        AList<AList<Integer>> AList_List = new AList<AList<Integer>>();
        // 不同AList的大小
        AList<Integer> Ns = new AList<Integer>();
        // 不同AList运行时间
        AList<Double> times = new AList<Double>();
        // 不同AList调用addLast次数
        AList<Integer> ops = new AList<Integer>();

        // 构建8个测试AList
        for(int i = 0; i < 8; ++i){
            AList<Integer> Test_List = new AList<Integer>();
            AList_List.addLast(Test_List);
            // 计数器
            int tmp = 0;

            // N个元素，开始测试
            // 开始计时
            Stopwatch sw = new Stopwatch();
            for(int j = 0; j < Math.pow(2,i) * 1000; ++j){
                Test_List.addLast(j);
                ++tmp;
            }

            // 停止计时
            double timeInSeconds = sw.elapsedTime();
            Ns.addLast(tmp);
            ops.addLast(tmp);
            times.addLast(timeInSeconds);
        }

        // 调用printTimingTable
        printTimingTable(Ns,times,ops);
    }
}
