from dataclasses import dataclass
from datetime import date

@dataclass
class ItemModel:
    id: int
    data: date

class Controller:
    def __init__(self):
        self.minha_lista = [
            ItemModel(id=10, data=date(2026, 8, 25)),
            ItemModel(id=20, data=date(2026, 8, 23)),  # Mesma data, ID maior
            ItemModel(id=5,  data=date(2026, 8, 23)),  # Mesma data, ID menor
            ItemModel(id=1,  data=date(2026, 8, 23))   # Mesma data, ID ainda menor
        ]

    def ordenar(self):
        # 1. Ordenação nativa inicial usando apenas a data
        lista = sorted(self.minha_lista, key=lambda x: x.data)
        
        resultado = []
        bloco_atual = []

        # 2. Laço para agrupar e ordenar os elementos com datas iguais pelo ID
        for item in lista:
            if not bloco_atual or item.data == bloco_atual[0].data:
                bloco_atual.append(item)
            else:
                # Ordena o grupo de datas iguais pelo ID
                bloco_atual.sort(key=lambda x: x.id)
                resultado.extend(bloco_atual)
                bloco_atual = [item]

        # Processa o último grupo restante após o término do laço
        if bloco_atual:
            bloco_atual.sort(key=lambda x: x.id)
            resultado.extend(bloco_atual)

        self.minha_lista = resultado
        return self.minha_lista

# Teste
controller = Controller()
for item in controller.ordenar():
    print(item)
