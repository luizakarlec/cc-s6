from controller import Controller
from model import Banco
from view import View

if __name__ == "__main__":
    banco = Banco()
    view = View()
    controller = Controller(banco, view)

    controller.executar()