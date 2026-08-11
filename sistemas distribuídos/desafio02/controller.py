import threading

class Controller:

    def __init__(self, model, view):
        self.model = model
        self.view = view

    def executar(self):
        lista = self.model.ler_arquivo('usuarios.txt')
        bloco1, bloco2 = self.model.dividir_lista(lista)

        t1 = threading.Thread(target=self.model.limpar, args=(bloco1,))
        t2 = threading.Thread(target=self.model.limpar, args=(bloco2,))

        t1.start()
        t2.start()

        t1.join()  
        t2.join()

        lista_final = bloco1 + bloco2
        self.view.exibir_resultados(lista_final)