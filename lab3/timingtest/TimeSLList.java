package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        // 储存所有测试SLList
        AList<SLList<Integer>> AList_List = new AList<SLList<Integer>>();
        // 不同AList的大小
        AList<Integer> Ns = new AList<Integer>();
        // 不同AList运行时间
        AList<Double> times = new AList<Double>();
        // 不同AList调用addLast次数
        AList<Integer> ops = new AList<Integer>();

        // 构建8个测试SLList
        for(int i = 0; i < 8; ++i){
            SLList<Integer> Test_List = new SLList<Integer>();
            AList_List.addLast(Test_List);
            // 计数器
            int tmp1 = 0;
            int tmp2 = 0;

            // 构建含有N个元素的SSList
            for(int j = 0; j < Math.pow(2,i) * 1000; ++j){
                Test_List.addLast(j);
                ++tmp1;
            }

            // Start the timer sw
            Stopwatch sw = new Stopwatch();

            // Perform getLast operation for M times (10000 times)
            for(int k = 0; k < 10000; ++k){
                int tmp_num;
                tmp_num = Test_List.getLast();
                ++tmp2;
            }

            // Stop the timer
            double timeInSeconds = sw.elapsedTime();
            Ns.addLast(tmp1);
            ops.addLast(tmp2);
            times.addLast(timeInSeconds);
        }

        // 调用printTimingTable
        printTimingTable(Ns,times,ops);
    }

}
