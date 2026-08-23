class View:
    def exibir_lista(self, lista):
        print(f"{'ID':<10} | {'Data':<12}")
        print("-" * 25)
        for item in lista:
            print(f"{item.id:<10} | {item.data.strftime('%d/%m/%Y'):<12}")
