import threading

class Controller:

    def __init__(self, model, view):
        self.model = model
        self.view = view

    def executar(self):
        self.model.popular_lista(10000)
        self.view.exibir_popular(10000)

        sub1 = self.model.lista[:2500]
        sub2 = self.model.lista[2500:5000]
        sub3 = self.model.lista[5000:7500]
        sub4 = self.model.lista[7500:]

        t1 = threading.Thread(target=self.model.somar_lista, args=(sub1,))
        t2 = threading.Thread(target=self.model.somar_lista, args=(sub2,))
        t3 = threading.Thread(target=self.model.somar_lista, args=(sub3,))
        t4 = threading.Thread(target=self.model.somar_lista, args=(sub4,))

        t1.start()
        t2.start()
        t3.start()
        t4.start()

        t1.join()  
        t2.join()
        t3.join()
        t4.join()

        somas_parciais = []

        while not self.model.fila.empty():
            somas_parciais.append(self.model.fila.get())

        self.view.exibir_resultados(somas_parciais)