using System;

namespace AlgorithmTraining
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            int x = int.Parse(Console.ReadLine());
            int y = int.Parse(Console.ReadLine());
            if (x > 0 && y > 0) Console.WriteLine(1);
            if (x > 0 && y < 0) Console.WriteLine(4);
            if (x < 0 && y > 0) Console.WriteLine(2);
            if (x < 0 && y < 0) Console.WriteLine(3);
        }
    }
}