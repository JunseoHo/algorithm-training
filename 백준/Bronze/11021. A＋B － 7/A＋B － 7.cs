using System;
using System.Text;

namespace AlgorithmTraining
{
    class Program
    {
        public static void Main(string[] argv)
        {
            StringBuilder answer = new StringBuilder();
            int t = int.Parse(Console.ReadLine());
            int[] a = new int[t];
            int[] b = new int[t];
            for (int i = 0; i < t; i++)
            {
                string[] s = Console.ReadLine().Split();
                a[i] = int.Parse(s[0]);
                b[i] = int.Parse(s[1]);
                answer.AppendLine("Case #" + (i + 1) + ": " + (a[i] + b[i]).ToString());
            }

            Console.WriteLine(answer.ToString());
        }
    }
}