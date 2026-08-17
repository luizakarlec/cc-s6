import threading

class Controller:
    def __init__(self, model, view):
        self.model = model
        self.view = view

    def executar(self):
        t1 = threading.Thread(target=self.model.venda, args=(10,))
        t2 = threading.Thread(target=self.model.venda, args=(10,))
        t3 = threading.Thread(target=self.model.venda, args=(10,))
        t4 = threading.Thread(target=self.model.venda, args=(10,))
        t5 = threading.Thread(target=self.model.venda, args=(10,))

        t1.start()
        t2.start()
        t3.start()
        t4.start()
        t5.start()

        t1.join()  
        t2.join()
        t3.join()
        t4.join()
        t5.join()

        self.view.exibir_saldo_final(self.model.saldo_central)