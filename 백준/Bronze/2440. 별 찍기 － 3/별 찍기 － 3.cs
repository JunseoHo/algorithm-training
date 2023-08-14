using System;

namespace ConsoleApplication1
{
    class Program
    {
        public static void Main(string[] args)
        {
            int N = Convert.ToInt32(Console.ReadLine());
            while (N > 0)
            {
                for (int i = 0; i < N; i++) Console.Write("*");
                if (N != 1) Console.WriteLine();
                --N;
            }
        }
    }
}