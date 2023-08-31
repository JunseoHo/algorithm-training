using System;

namespace AlgorithmTraining
{
    class Program
    {
        public static void Main(string[] argv)
        {
            int N = int.Parse(Console.ReadLine());
            for (int i = 1; i < 10; i++)
            {
                Console.WriteLine(N + " * " + i + " = " + (N * i));
            }
        }
    }
}