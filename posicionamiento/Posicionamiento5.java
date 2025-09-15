import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

public class Posicionamiento5 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("posicionamiento relativo");
        ventana.setSize(600, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Usa el layout relativo
        RelativeLayout rl = new RelativeLayout();
        ventana.setLayout(rl);

        // panel grande arriba-izq (60% x, 60% y)
        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(102, 255, 204));
        ventana.add(panel1, new RelativeConstraints(0.025, 0.025, 0.55, 0.475));

        // panel oscuro derecha superior
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(40, 100, 0));
        ventana.add(panel2, new RelativeConstraints(0.625, 0.025, 0.35, 0.15));

        // panel azul zona derecha central
        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(1, 75, 140));
        ventana.add(panel3, new RelativeConstraints(0.625, 0.25, 0.35, 0.525));

        // beige abajo-derecha
        JPanel panel4 = new JPanel();
        panel4.setBackground(new Color(194, 150, 98));
        ventana.add(panel4, new RelativeConstraints(0.625, 0.825, 0.35, 0.15));

        // rojo centro-izquierda
        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.red);
        ventana.add(panel5, new RelativeConstraints(0.025, 0.55, 0.2, 0.15));

        // magenta centro
        JPanel panel6 = new JPanel();
        panel6.setBackground(new Color(255, 0, 255));
        ventana.add(panel6, new RelativeConstraints(0.25, 0.55, 0.325, 0.425));

        // naranja abajo-izq
        JPanel panel7 = new JPanel();
        panel7.setBackground(new Color(255, 140, 0));
        ventana.add(panel7, new RelativeConstraints(0.025, 0.725, 0.2, 0.25));

        ventana.setVisible(true);
    }
}

/* Constraint sencillo: valores entre 0.0 y 1.0 */
class RelativeConstraints {
    public final double x, y, w, h;
    public RelativeConstraints(double x, double y, double w, double h) {
        this.x = clamp(x); this.y = clamp(y); this.w = clamp(w); this.h = clamp(h);
    }
    private double clamp(double v) { return v < 0 ? 0 : (v > 1 ? 1 : v); }
}

/* LayoutManager2 que coloca componentes con valores relativos al tamaño del contenedor */
class RelativeLayout implements LayoutManager2 {
    private final Map<Component, RelativeConstraints> map = new HashMap<>();

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        if (constraints instanceof RelativeConstraints) {
            map.put(comp, (RelativeConstraints) constraints);
        } else {
            throw new IllegalArgumentException("Se requieren RelativeConstraints");
        }
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        Insets in = parent.getInsets();
        return new Dimension(400 + in.left + in.right, 300 + in.top + in.bottom);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return new Dimension(100, 100);
    }

    @Override
    public void layoutContainer(Container parent) {
        Insets in = parent.getInsets();
        int pw = parent.getWidth() - in.left - in.right;
        int ph = parent.getHeight() - in.top - in.bottom;
        for (Map.Entry<Component, RelativeConstraints> e : map.entrySet()) {
            Component c = e.getKey();
            RelativeConstraints rc = e.getValue();
            int x = in.left + (int) Math.round(rc.x * pw);
            int y = in.top + (int) Math.round(rc.y * ph);
            int w = Math.max(0, (int) Math.round(rc.w * pw));
            int h = Math.max(0, (int) Math.round(rc.h * ph));
            c.setBounds(new Rectangle(x, y, w, h));
        }
    }

    // Métodos no usados en este ejemplo
    @Override public void addLayoutComponent(String name, Component comp) {}
    @Override public void removeLayoutComponent(Component comp) { map.remove(comp); }
    @Override public Dimension maximumLayoutSize(Container target) { return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE); }
    @Override public float getLayoutAlignmentX(Container target) { return 0.5f; }
    @Override public float getLayoutAlignmentY(Container target) { return 0.5f; }
    @Override public void invalidateLayout(Container target) {}
}
