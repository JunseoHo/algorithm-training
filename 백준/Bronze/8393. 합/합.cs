using System;

namespace AlgorithmTraining
{
    class Program
    {
        public static void Main(string[] argv)
        {
            int T = int.Parse(Console.ReadLine());
           Console.WriteLine(T * (T + 1) / 2);
        }
    }
}