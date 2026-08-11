from queue import Queue
import random

class Model:

    def __init__(self):
        self.lista = []
        self.fila = Queue()

    def popular_lista(self, quantidade):
        for i in range(quantidade):
            self.lista.append(random.randint(1, 1000))

    def somar_lista(self, sublista):
        soma = 0
        for i in sublista:
            soma += i
        self.fila.put(soma)
