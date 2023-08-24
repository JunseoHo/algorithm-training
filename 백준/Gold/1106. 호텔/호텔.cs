using System;

namespace AlgorithmTraining
{
    class Program
    {
        public static void Main(string[] argv)
        {
            // init
            string[] values = Console.ReadLine().Split(' ');
            int c = int.Parse(values[0]);
            int C = c + 100;
            int N = int.Parse(values[1]);
            int[] cost = new int[N];
            int[] customer = new int[N];
            for (int i = 0; i < N; i++)
            {
                values = Console.ReadLine().Split(' ');
                cost[i] = int.Parse(values[0]);
                customer[i] = int.Parse(values[1]);
            }

            int[,] dpTable = new int[N, C + 1];
            // solve
            int answer = 2147483647;
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < C + 1; j++)
                {
                    if (j == 0)
                    {
                        dpTable[i, j] = 0;
                    }
                    else if (i == 0)
                    {
                        if (j % customer[i] == 0)
                        {
                            dpTable[i, j] = (j / customer[i]) * cost[i];
                        }
                        else
                        {
                            dpTable[i, j] = 2000000000;
                        }
                    }
                    else
                    {
                        int cost1 = 2000000000;
                        int cost2 = 2000000000;
                        int cost3 = 2000000000;
                        if (j - customer[i] > -1)
                            cost1 = dpTable[i, j - customer[i]] + cost[i];
                        if (i - 1 > -1 && j - customer[i] > -1)
                            cost2 = dpTable[i - 1, j - customer[i]] + cost[i];
                        if (i - 1 > -1)
                            cost3 = dpTable[i - 1, j];
                        dpTable[i, j] = Math.Min(cost1, Math.Min(cost2, cost3));
                    }

                    if (j >= c && i == N - 1) answer = Math.Min(answer, dpTable[i, j]);
                }
            }

            // for (int i = 0; i < N; i++)
            // {
            //     for (int j = 0; j < C + 1; j++)
            //     {
            //         Console.Write(dpTable[i, j] + " ");
            //     }
            //
            //     Console.WriteLine();
            // }

            Console.WriteLine(answer);
        }
    }
}