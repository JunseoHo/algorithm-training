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
                string input = Console.ReadLine();
                if (input == null) break;
                string[] s = input.Split();
                int a = int.Parse(s[0]);
                int b = int.Parse(s[1]);
                list.Add(a + b);
            }

            foreach (int c in list)
            {
                Console.WriteLine(c);
            }
        }
    }
}