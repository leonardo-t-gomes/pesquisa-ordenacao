using System;
using System.Collections.Generic;

public class Model
{
    public static void Popular(List<int> lista, int quantidade)
    {
        Random gerador = new Random();
        for (int i = 0; i < quantidade; i++)
        {
            lista.Add(gerador.Next(100000));
        }
    }
}
