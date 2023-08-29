using System;

namespace AlgorithmTraining
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            int h = int.Parse(input[0]);
            int m = int.Parse(input[1]);
            int t = 60 * h + m;
            t -= 45;
            if (t < 0) t += 24 * 60;
            else if (t > 24 * 60) t -= 24 * 60;
            Console.WriteLine((t / 60) + " " + (t % 60));
        }
    }
}