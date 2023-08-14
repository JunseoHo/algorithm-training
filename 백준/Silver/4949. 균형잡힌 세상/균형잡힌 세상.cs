using System;
using System.Collections.Generic;


namespace ConsoleApplication1
{
    class Program
    {
        static int[] stack = new int[200];
        static int size = 0;

        public static void push(int i)
        {
            stack[size] = i;
            ++size;
        }

        public static int pop()
        {
            if (size == 0) return -1;
            int i = stack[size - 1];
            --size;
            return i;
        }

        public static void Main(string[] args)
        {
            List<string> list = new List<string>();
            while (true)
            {
                string s = Console.ReadLine();
                if (s.Equals(".")) break;
                list.Add(s);
            }

            for (int idx = 0; idx < list.Count; idx++)
            {
                string s = list[idx];
                char[] arr = s.ToCharArray();
                bool ok = true;
                size = 0;
                for (int i = 0; i < arr.Length; i++)
                {
                    if (arr[i] == '(') push(0);
                    else if (arr[i] == ')')
                    {
                        if (pop() != 0)
                        {
                            ok = false;
                            break;
                        }
                    }
                    else if (arr[i] == '[') push(1);
                    else if (arr[i] == ']')
                    {
                        if (pop() != 1)
                        {
                            ok = false;
                            break;
                        }
                    }
                }

                if (size != 0) ok = false;
                Console.WriteLine(ok ? "yes" : "no");
            }
        }
    }
}