using System;
using System.Collections.Generic;
using System.Text;

namespace AlgorithmTraining
{
    class Program
    {
        public static void Main(string[] argv)
        {
            var list = new List<int>();
            while (true)
            {
                string[] s = Console.ReadLine().Split();
                int a = int.Parse(s[0]);
                int b = int.Parse(s[1]);
                if (a == 0 && b == 0) break;
                list.Add(a + b);
            }

            foreach (int c in list)
            {
                Console.WriteLine(c);
            }
        }
    }
}