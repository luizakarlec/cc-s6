import threading
import random
from queue import Queue

def popular_lista(lista, quantidade):
    for i in range(quantidade):
        lista.append(random.randint(1, 1000))
    print(f"Lista populada com {quantidade} elementos.")

def somar_lista(lista, fila_res):
    soma = 0
    for i in lista:
        soma += i
    fila_res.put(soma)

lista = []
popular_lista(lista, 10000)

sub1 = lista[:2500]
sub2 = lista[2500:5000]
sub3 = lista[5000:7500]
sub4 = lista[7500:]

fila = Queue()

t1 = threading.Thread(target=somar_lista, args=(sub1, fila))
t2 = threading.Thread(target=somar_lista, args=(sub2, fila))
t3 = threading.Thread(target=somar_lista, args=(sub3, fila))
t4 = threading.Thread(target=somar_lista, args=(sub4, fila))

t1.start()
t2.start()
t3.start()
t4.start()

t1.join()  
t2.join()
t3.join()
t4.join()

lista_somas = list(fila.queue)

print(f"Lista com as 4 somas coletadas: {lista_somas}")
print(f"Soma total final: {sum(lista_somas)}")
