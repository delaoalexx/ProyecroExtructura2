
public class Arco {
	
    private Vertice origen;
    private Vertice destino;
    private int peso;

    public Arco(Vertice origen, Vertice destino) {
        this(origen, destino, 1);
    }

    public Arco(Vertice origen, Vertice destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    public Vertice getOrigen() {
        return origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }
}
