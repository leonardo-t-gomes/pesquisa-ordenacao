import random

class Utilidades:

    @staticmethod
    def popular_lista(lista: list[int], quantidade_numeros: int, inicio: int, fim: int, aleatorio: bool) -> None:
        if aleatorio:
            for _ in range(quantidade_numeros):
                lista.append(random.randint(inicio, fim - 1))
        else:
            for i in range(quantidade_numeros):
                lista.append(inicio + i)
