using System;

namespace AlgorithmTraining
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            string[] tokens = Console.ReadLine().Split(' ');
            int A = int.Parse(tokens[0]);
            int B = int.Parse(tokens[1]);
            Console.WriteLine(A + B);
            Console.WriteLine(A - B);
            Console.WriteLine(A * B);
            Console.WriteLine(A / B);
            Console.WriteLine(A % B);
        }
    }
}