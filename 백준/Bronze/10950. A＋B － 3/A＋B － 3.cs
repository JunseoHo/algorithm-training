using System;

namespace AlgorithmTraining
{
    class Program
    {
        public static void Main(string[] argv)
        {
            int T = int.Parse(Console.ReadLine());
            int[] answer = new int[T];
            for (int i = 0; i < T; i++)
            {
                string[] input = Console.ReadLine().Split(' ');
                answer[i] = int.Parse(input[0]) + int.Parse(input[1]);
            }

            for (int i = 0; i < T; i++)
            {
                Console.WriteLine(answer[i]);
            }
        }
    }
}