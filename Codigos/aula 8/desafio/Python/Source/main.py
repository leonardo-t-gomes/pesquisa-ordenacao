def main():
    controller = Controller()
    lista_ordenada = controller.ordenar()

    view = View()
    view.exibir_lista(lista_ordenada)
