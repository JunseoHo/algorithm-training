using System;

namespace AlgorithmTraining
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            long A = long.Parse(input[0]);
            long B = long.Parse(input[1]);
            long C = long.Parse(input[2]);
            Console.WriteLine(A + B + C);
        }
    }
}