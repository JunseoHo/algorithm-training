using System;

namespace AlgorithmTraining
{
    class Program
    {
        public static void Main(string[] argv)
        {
            int N = int.Parse(Console.ReadLine()) / 4;
            for (int i = 0; i < N; i++)
            {
                Console.Write("long ");
            }
            Console.Write("int");
        }
    }
}