class ExibicaoView:

    @staticmethod
    def exibir_lista(lista: list[int], frase: str) -> None:
        print(frase)
        for item in lista:
            print(item)
        print("--------------------------")
        print(f"Total de registros: {len(lista)}")

    @staticmethod
    def exibir_tempo_execucao(rotina: int, tempo_ms: float) -> None:
        print(f"Tempo (ms) rotina {rotina}: {tempo_ms:.2f}")
