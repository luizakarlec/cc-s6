class View:

    def exibir_popular(self, quantidade):
        print(f"Lista populada com {quantidade} elementos")

    def exibir_resultados(self, somas_parciais):
        print(f"Lista com as 4 somas parciais coletadas: {somas_parciais}")
        print(f"Soma total final: {sum(somas_parciais)}")
    