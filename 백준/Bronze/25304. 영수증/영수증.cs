using System;

namespace AlgorithmTraining
{
    class Program
    {
        public static void Main(string[] argv)
        {
            int P = int.Parse(Console.ReadLine());
            int N = int.Parse(Console.ReadLine());
            int A = 0;
            for (int i = 0; i < N; i++)
            {
                string[] input = Console.ReadLine().Split(' ');
                A += int.Parse(input[0]) * int.Parse(input[1]);
            }
            Console.WriteLine(A == P ? "Yes" : "No");
        }
    }
}