import threading

class Banco:
    def __init__(self):
        self.saldo_central = 0
        self._lock= threading.Lock()

    def retornar_saldo(self):
        with self._lock:
            return self.saldo_central

    def adicionar_saldo(self, valor):
        with self._lock:
            self.saldo_central += valor

    def venda(self, valor):
        for i in range(1000):
            self.adicionar_saldo(valor)