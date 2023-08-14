using System;
using System.Collections.Generic;

namespace AlgorithmTraining
{
    class Program
    {
        static List<int> move = new List<int>();
        static int[,,] DPTable;

        public static int solve(int left, int right, int n)
        {
            if (n == move.Count) return 0;
            if (DPTable[left, right, n] != -1) return DPTable[left, right, n];
            int min = 2147483647;
            if (move[n] == 1)
            {
                // move left
                if (left == 0) min = Math.Min(min, 2 + solve(1, right, n + 1));
                else if (left == 1) min = Math.Min(min, 1 + solve(1, right, n + 1));
                else if (left == 2) min = Math.Min(min, 3 + solve(1, right, n + 1));
                else if (left == 3) min = Math.Min(min, 4 + solve(1, right, n + 1));
                else if (left == 4) min = Math.Min(min, 3 + solve(1, right, n + 1));
                // move right
                if (right == 0) min = Math.Min(min, 2 + solve(left, 1, n + 1));
                else if (right == 1) min = Math.Min(min, 1 + solve(left, 1, n + 1));
                else if (right == 2) min = Math.Min(min, 3 + solve(left, 1, n + 1));
                else if (right == 3) min = Math.Min(min, 4 + solve(left, 1, n + 1));
                else if (right == 4) min = Math.Min(min, 3 + solve(left, 1, n + 1));
            }
            else if (move[n] == 2)
            {
                // move left
                if (left == 0) min = Math.Min(min, 2 + solve(2, right, n + 1));
                else if (left == 1) min = Math.Min(min, 3 + solve(2, right, n + 1));
                else if (left == 2) min = Math.Min(min, 1 + solve(2, right, n + 1));
                else if (left == 3) min = Math.Min(min, 3 + solve(2, right, n + 1));
                else if (left == 4) min = Math.Min(min, 4 + solve(2, right, n + 1));
                // move right
                if (right == 0) min = Math.Min(min, 2 + solve(left, 2, n + 1));
                else if (right == 1) min = Math.Min(min, 3 + solve(left, 2, n + 1));
                else if (right == 2) min = Math.Min(min, 1 + solve(left, 2, n + 1));
                else if (right == 3) min = Math.Min(min, 3 + solve(left, 2, n + 1));
                else if (right == 4) min = Math.Min(min, 4 + solve(left, 2, n + 1));
            }
            else if (move[n] == 3)
            {
                // move left
                if (left == 0) min = Math.Min(min, 2 + solve(3, right, n + 1));
                else if (left == 1) min = Math.Min(min, 4 + solve(3, right, n + 1));
                else if (left == 2) min = Math.Min(min, 3 + solve(3, right, n + 1));
                else if (left == 3) min = Math.Min(min, 1 + solve(3, right, n + 1));
                else if (left == 4) min = Math.Min(min, 3 + solve(3, right, n + 1));
                // move right
                if (right == 0) min = Math.Min(min, 2 + solve(left, 3, n + 1));
                else if (right == 1) min = Math.Min(min, 4 + solve(left, 3, n + 1));
                else if (right == 2) min = Math.Min(min, 3 + solve(left, 3, n + 1));
                else if (right == 3) min = Math.Min(min, 1 + solve(left, 3, n + 1));
                else if (right == 4) min = Math.Min(min, 3 + solve(left, 3, n + 1));
            }
            else if (move[n] == 4)
            {
                // move left
                if (left == 0) min = Math.Min(min, 2 + solve(4, right, n + 1));
                else if (left == 1) min = Math.Min(min, 3 + solve(4, right, n + 1));
                else if (left == 2) min = Math.Min(min, 4 + solve(4, right, n + 1));
                else if (left == 3) min = Math.Min(min, 3 + solve(4, right, n + 1));
                else if (left == 4) min = Math.Min(min, 1 + solve(4, right, n + 1));
                // move right
                if (right == 0) min = Math.Min(min, 2 + solve(left, 4, n + 1));
                else if (right == 1) min = Math.Min(min, 3 + solve(left, 4, n + 1));
                else if (right == 2) min = Math.Min(min, 4 + solve(left, 4, n + 1));
                else if (right == 3) min = Math.Min(min, 3 + solve(left, 4, n + 1));
                else if (right == 4) min = Math.Min(min, 1 + solve(left, 4, n + 1));
            }
            DPTable[left, right, n] = min;
            return DPTable[left, right, n];
        }

        public static void Main(string[] args)
        {
            // init
            string[] values = Console.ReadLine().Split(' ');
            for (int i = 0; i < values.Length - 1; i++) move.Add(int.Parse(values[i]));
            DPTable = new int[5, 5, move.Count];
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    for (int k = 0; k < move.Count; k++)
                    {
                        DPTable[i, j, k] = -1;
                    }
                }
            }
            // solve
            Console.WriteLine(solve(0, 0, 0));
        }
    }
}