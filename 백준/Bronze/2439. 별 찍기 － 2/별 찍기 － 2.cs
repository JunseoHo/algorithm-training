using System;
using System.Text;

namespace AlgorithmTraining
{
    class Program
    {
        public static void Main(string[] argv)
        {
            int N = int.Parse(Console.ReadLine());
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N-(i + 1); j++)
                {
                    Console.Write(" ");
                }
                for (int j = 0; j < i + 1; j++)
                {
                    Console.Write("*");
                }
                Console.WriteLine();
            }
        }
    }
}