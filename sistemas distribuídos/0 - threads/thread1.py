import threading

def tarefa1():
    for i in range(50):
        print("Thread1 executando!")

def tarefa2():
    for i in range(50):
        print("Thread2 em acao!")

t1 = threading.Thread(target=tarefa1)
t2 = threading.Thread(target=tarefa2)
t1.start()
t2.start()