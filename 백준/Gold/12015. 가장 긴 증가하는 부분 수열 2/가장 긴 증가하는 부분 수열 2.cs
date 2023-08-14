using System;
using System.Collections.Generic;

namespace AlgorithmTraining
{
    class Program
    {
        public static int Index(int n, int left, int right, List<int> list)
        {
            if (left >= right)
            {
                if (list[left] > n) return left;
                if (list[left] < n) return left + 1;
                return -1;
            }
            int mid = (left + right) / 2;
            if (list[mid] > n) return Index(n, left, mid - 1, list);
            if (list[mid] < n) return Index(n, mid + 1, right, list);
            return -1;
        }

        public static void Main(string[] args)
        {
            // init
            int N = int.Parse(Console.ReadLine());
            string[] values = Console.ReadLine().Split(' ');
            int[] seq = new int[N];
            for (int i = 0; i < N; i++) seq[i] = int.Parse(values[i]);
            List<int> list = new List<int>();
            // solve
            for (int i = 0; i < N; i++)
            {
                if (list.Count == 0) list.Add(seq[i]);
                else if (list[list.Count - 1] < seq[i]) list.Add(seq[i]);
                else if (list[list.Count - 1] > seq[i])
                {
                    int idx = Index(seq[i], 0, list.Count, list);
                    if (idx != -1) list[idx] = seq[i];
                }
            }
            // print
            Console.WriteLine(list.Count);
        }
    }
}