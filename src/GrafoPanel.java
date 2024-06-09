import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GrafoPanel extends JPanel {
    private Grafo grafo;

    public GrafoPanel(Grafo grafo) {
        this.grafo = grafo;
        setPreferredSize(new Dimension(400, 300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGraph(g);
    }

    private void drawGraph(Graphics g) {
        List<Vertice> vertices = grafo.getVertices();
        List<Arco> arcos = grafo.getArcos();
        int radius = 20;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int verticesCount = vertices.size();
        double angleStep = 2 * Math.PI / verticesCount;
        int i = 0;
        Map<Vertice, Point> positions = new HashMap<>();

        // Calculate positions
        for (Vertice vertice : vertices) {
            int x = (int) (centerX + 100 * Math.cos(i * angleStep));
            int y = (int) (centerY + 100 * Math.sin(i * angleStep));
            positions.put(vertice, new Point(x, y));
            i++;
        }

        // Draw edges
        g.setColor(Color.BLACK);
        for (Arco arco : arcos) {
            Point origenPos = positions.get(arco.getOrigen());
            Point destinoPos = positions.get(arco.getDestino());
            g.drawLine(origenPos.x, origenPos.y, destinoPos.x, destinoPos.y);
        }

        // Draw vertices
        g.setColor(Color.RED);
        for (Map.Entry<Vertice, Point> entry : positions.entrySet()) {
            Vertice vertice = entry.getKey();
            Point pos = entry.getValue();
            g.fillOval(pos.x - radius / 2, pos.y - radius / 2, radius, radius);
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(vertice.getValor()), pos.x - 5, pos.y + 5);
            g.setColor(Color.RED);
        }
    }
}
