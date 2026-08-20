using System;
using System.Collections.Generic;
using System.Diagnostics;

public class View
{
    public static void Exibir(List<int> lista)
    {
        foreach (var item in lista)
        {
            Console.WriteLine(item.ToString());
        }
    }

    public static void ExibirTempo(Stopwatch sw, string frase)
    {
        Console.WriteLine(frase + " (ms): " + sw.ElapsedMilliseconds);
    }
}
