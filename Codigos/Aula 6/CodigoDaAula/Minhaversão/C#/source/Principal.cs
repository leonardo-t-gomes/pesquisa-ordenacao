using System.Collections.Generic;
using System.Diagnostics;

public class Principal
{
    public static void Main(string[] args)
    {
        int quantidade = 10000; // Reduzido para testes mais rápidos, ajuste conforme necessário

        // Instanciação e população via Model
        List<int> listaOriginal = new List<int>();
        Model.Popular(listaOriginal, quantidade);

        Stopwatch sw = new Stopwatch();

        // 1. Agitação
        List<int> listaAgitacao = new List<int>(listaOriginal);
        sw.Start();
        OrdenacaoController.Agitacao(listaAgitacao);
        sw.Stop();
        View.ExibirTempo(sw, "Ordenação por agitação");
        sw.Reset();

        // 2. Sort Nativo
        List<int> listaSort = new List<int>(listaOriginal);
        sw.Start();
        listaSort.Sort();
        sw.Stop();
        View.ExibirTempo(sw, "Ordenação por sort nativo");
        sw.Reset();

        // 3. Bolha
        List<int> listaBolha = new List<int>(listaOriginal);
        sw.Start();
        OrdenacaoController.Bolha(listaBolha);
        sw.Stop();
        View.ExibirTempo(sw, "Ordenação por bolha");
        sw.Reset();

        // 4. Seleção
        List<int> listaSelecao = new List<int>(listaOriginal);
        sw.Start();
        OrdenacaoController.Selecao(listaSelecao);
        sw.Stop();
        View.ExibirTempo(sw, "Ordenação por seleção");
        sw.Reset();

        // 5. Inserção
        List<int> listaInsercao = new List<int>(listaOriginal);
        sw.Start();
        OrdenacaoController.Insercao(listaInsercao);
        sw.Stop();
        View.ExibirTempo(sw, "Ordenação por inserção");
        sw.Reset();
    }
}
