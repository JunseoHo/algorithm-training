using System;

namespace AlgorithmTraining
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            int A = int.Parse(Console.ReadLine());
            int B = int.Parse(Console.ReadLine());
            Console.WriteLine(A * (B % 10));
            Console.WriteLine(A * (((B % 100) - (B % 10)) / 10));
            Console.WriteLine(A * (B / 100));
            Console.WriteLine(A * B);
        }
    }
}