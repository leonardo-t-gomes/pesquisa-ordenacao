import time
from model.utilidades import Utilidades
from view.exibicao_view import ExibicaoView

class ListaController:

    def executar_processamento(self) -> None:
        lista_aleatoria: list[int] = []
        lista_sequencial: list[int] = []

        # Rotina 1: Aleatória
        tempo_inicio = time.perf_counter()
        Utilidades.popular_lista(lista_aleatoria, 100000, 100, 100000, True)
        tempo_fim = time.perf_counter()
        
        tempo_ms_rotina1 = (tempo_fim - tempo_inicio) * 1000
        ExibicaoView.exibir_tempo_execucao(1, tempo_ms_rotina1)

        # Rotina 2: Sequencial
        tempo_inicio = time.perf_counter()
        Utilidades.popular_lista(lista_sequencial, 100000, 1, 100000, False)
        tempo_fim = time.perf_counter()
        
        tempo_ms_rotina2 = (tempo_fim - tempo_inicio) * 1000
        ExibicaoView.exibir_tempo_execucao(2, tempo_ms_rotina2)

        # Descomente se quiser exibir as listas:
        # ExibicaoView.exibir_lista(lista_aleatoria, "Lista Aleatória:")
