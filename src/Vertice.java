import java.util.Objects;

public class Vertice {
	
	private int valor;
    private boolean visitado;

    public Vertice(int valor) {
        this.valor = valor;
        this.visitado = false;
    }

    public int getValor() {
        return valor;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertice vertice = (Vertice) obj;
        return valor == vertice.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}