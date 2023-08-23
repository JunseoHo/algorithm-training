using System;

namespace AlgorithmTraining
{
    class Program
    {
        public static void Main(string[] argv)
        {
            string[] values = Console.ReadLine().Split(' ');
            int N = int.Parse(values[0]);
            int L = int.Parse(values[1]);
            int sum = 0;
            int i = 0;
            int j = 0;
            int[] answer = { 0, 100 };
            while (true)
            {
                if (j - i + 1 >= L && sum == N)
                {
                    if (answer[1] - answer[0] > j - i)
                    {
                        answer[0] = i;
                        answer[1] = j;
                    }
                }
                if (j >= N) break;
                if (sum > N || sum == N)
                {
                    sum -= i;
                    i++;
                }
                else if (sum < N)
                {
                    sum += j + 1;
                    j++;
                }
            }

            if (answer[1] - answer[0] + 1 > 100)
            {
                Console.Write(-1);
                return;
            }
            if (answer[1] - answer[0] + 1 != L && answer[0] == 0) answer[0] = 1;
            for (int k = answer[0]; k <= answer[1]; k++)
            {
                Console.Write(k + " ");
            }
        }
    }
    
}