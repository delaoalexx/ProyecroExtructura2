import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class Grafo {
    private List<Vertice> vertices;
    private List<Arco> arcos;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.arcos = new ArrayList<>();
    }

    public void agregarVertice(int valor) {
        vertices.add(new Vertice(valor));
    }

    public void agregarArco(int valorOrigen, int valorDestino) {
        Vertice origen = buscarVertice(valorOrigen);
        Vertice finali = buscarVertice(valorDestino);
        if (origen != null && finali != null) { //fallo existen - origen != null && finali != null
            arcos.add(new Arco(origen, finali));
            arcos.add(new Arco(finali, origen)); 
        }
    }

    private Vertice buscarVertice(int valor) {
        for (Vertice vertice : vertices) {
            if (vertice.getValor() == valor) {
                return vertice;
            }
        }
        return null;
    }

    public void recorridoAnchura(int valorInicio) {
        Vertice inicio = buscarVertice(valorInicio);
        if (inicio == null) {
            System.out.println("Vertice de inicio no encontrado.");
            return;
        }

        Queue<Vertice> cola = new LinkedList<>();
        cola.add(inicio);
        inicio.setVisitado(true);

        while (!cola.isEmpty()) {
            Vertice actual = cola.poll();
            System.out.print(actual.getValor() + " ");

            for (Arco arco : arcos) {
                if (arco.getOrigen().equals(actual) && !arco.getDestino().isVisitado()) {
                    cola.add(arco.getDestino());
                    arco.getDestino().setVisitado(true);
                }
            }
        }

        reiniciarVisitados();
    }

    public void recorridoProfundidad(int valorInicio) {
        Vertice inicio = buscarVertice(valorInicio);
        if (inicio == null) {
            System.out.println("Vertice de inicio no encontrado.");
            return;
        }

        Stack<Vertice> pila = new Stack<>();
        pila.push(inicio);
        inicio.setVisitado(true);

        while (!pila.isEmpty()) {
            Vertice actual = pila.pop();
            System.out.print(actual.getValor() + " ");

            for (Arco arco : arcos) {
                if (arco.getOrigen().equals(actual) && !arco.getDestino().isVisitado()) {
                    pila.push(arco.getDestino());
                    arco.getDestino().setVisitado(true);
                }
            }
        }

        reiniciarVisitados();
    }

    public void dijkstra(int valorInicio) {
        Vertice inicio = buscarVertice(valorInicio);
        if (inicio == null) {
            System.out.println("Vertice de inicio no encontrado.");
            return;
        }

        Map<Vertice, Integer> distancias = new HashMap<>();
        PriorityQueue<Vertice> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        for (Vertice vertice : vertices) {
            if (vertice.equals(inicio)) {
                distancias.put(vertice, 0);
            } else {
                distancias.put(vertice, Integer.MAX_VALUE);
            }
            colaPrioridad.add(vertice);
        }

        while (!colaPrioridad.isEmpty()) {
            Vertice actual = colaPrioridad.poll();

            for (Arco arco : arcos) {
                if (arco.getOrigen().equals(actual)) {
                    Vertice vecino = arco.getDestino();
                    int nuevaDistancia = distancias.get(actual) + arco.getPeso();

                    if (nuevaDistancia < distancias.get(vecino)) {
                        distancias.put(vecino, nuevaDistancia);
                        colaPrioridad.remove(vecino);
                        colaPrioridad.add(vecino);
                    }
                }
            }
        }

        for (Map.Entry<Vertice, Integer> entrada : distancias.entrySet()) {
            System.out.println("Distancia de " + inicio.getValor() + " a " + entrada.getKey().getValor() + " es " + entrada.getValue());
        }
    }
    
    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Arco> getArcos() {
        return arcos;
    }

    private void reiniciarVisitados() {
        for (Vertice vertice : vertices) {
            vertice.setVisitado(false);
        }
    }

}
