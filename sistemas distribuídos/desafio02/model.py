class Model:
    
    def ler_arquivo(self, caminho_arquivo):
        with open(caminho_arquivo, 'r') as arquivo:
            linhas = arquivo.readlines()
            
        return linhas

    def dividir_lista(self, lista):
        meio = len(lista) // 2

        bloco1 = lista[:meio]
        bloco2 = lista[meio:]

        return bloco1, bloco2

    def limpar(self, bloco):
        for i in range(len(bloco)):
            bloco[i] = bloco[i].strip().upper()