class View:

    def exibir_resultados(self, lista_final):
        print(f"Total de registros limpos: {len(lista_final)}")
        print("Amostra das primeiras 5 linhas: ", lista_final[:5])
    