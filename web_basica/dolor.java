import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

public class dolor {
    public static void main(String[] args) {
        // ...existing code...
        
        JFrame ventana = new JFrame("venana");
        ventana.setSize(600, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setBackground(Color.white);
        ventana.setLayout(new BorderLayout());



        // Superior
        JPanel superior = new JPanel();
        superior.setBackground(Color.red);
        superior.add(new JLabel("<header>"));
        ventana.add(superior,BorderLayout.NORTH);

        // Inferior
        JPanel inferior = new JPanel();
        inferior.setBackground(Color.red);
        inferior.add(new JLabel("<footer>"));
        ventana.add(inferior,BorderLayout.SOUTH);

        // Izquierda
        JPanel izquierda = new JPanel();
        izquierda.setBackground(Color.red);
        izquierda.add(new JLabel("<nav>"));
        izquierda.setLayout(new GridBagLayout());
        Border bordeIzquierdo = BorderFactory.createMatteBorder(2, 0, 6, 3, Color.white);
        izquierda.setBorder(bordeIzquierdo);
        ventana.add(izquierda,BorderLayout.WEST);
        
        // Derecha
        JPanel derecha = new JPanel();
        derecha.setBackground(Color.red);
        derecha.setLayout(new GridBagLayout());
        derecha.add(new JLabel("<aside>"));
        Border bordeDerecha = BorderFactory.createMatteBorder(2, 3, 6, 0, Color.white);
        derecha.setBorder(bordeDerecha);
        ventana.add(derecha,BorderLayout.EAST);

        // Centro
        JPanel centro = new JPanel();
        // Asegurar que el layout de 'centro' es BoxLayout vertical
        centro.setLayout(new BoxLayout(centro,BoxLayout.Y_AXIS));
        ventana.add(centro,BorderLayout.CENTER);

        // Section Norte
        JPanel sectionNorte = new JPanel();
        // Centrar el texto en article
        sectionNorte.setLayout(new GridBagLayout());
        centro.add(sectionNorte);
        
        // Section
        JPanel section = new JPanel();
        section.setBackground(Color.red);
        // Centrar el texto en section
        section.setLayout(new GridBagLayout());
        section.add(new JLabel("<section>"));
        centro.add(section);
        
        // Section Sur
        JPanel sectionSur = new JPanel();
        // Centrar el texto en article
        sectionSur.setLayout(new GridBagLayout());
        centro.add(sectionSur);

        // Header del centro
        JPanel headerCentral = new JPanel();
        headerCentral.setBackground(Color.yellow);
        // Centrar el texto en headerCentral
        headerCentral.setLayout(new GridBagLayout());
        headerCentral.add(new JLabel("<header>"));
        centro.add(headerCentral);

        // Header Sur
        JPanel headerSur = new JPanel();
        // Centrar el texto en article
        headerSur.setLayout(new GridBagLayout());
        centro.add(headerSur);

        // Article
        JPanel article = new JPanel();
        article.setBackground(Color.yellow);
        // Centrar el texto en article
        article.setLayout(new GridBagLayout());
        article.add(new JLabel("<article>"));
        centro.add(article);

        // Article Sur
        JPanel articleSur = new JPanel();
        // Centrar el texto en article
        articleSur.setLayout(new GridBagLayout());
        centro.add(articleSur);

        // Footer
        JPanel footer = new JPanel();
        footer.setBackground(Color.yellow);
        // Centrar el texto en footer
        footer.setLayout(new GridBagLayout());
        footer.add(new JLabel("<footer>"));        
        centro.add(footer);




        // De la IA personaliza la altura del BoxLayout con % para tener una altura relativa
        // Listener para recalcular alturas proporcionales al redimensionar
        java.awt.event.ComponentAdapter resizer = new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int h = centro.getHeight();
                int w = ventana.getWidth();

                // Gestion altos zona central
                int secNorteH = (int) Math.round(h*0.01);
                int secH = (int) Math.round(h * 0.1);   // 5%
                int secSurH = (int) Math.round(h*0.01);
                int headerH = (int) Math.round(h * 0.15); // 15%
                int headerSurH = (int) Math.round(h*0.01);
                int articleH = (int) Math.round(h * 0.54); // 60%
                int articleSurH = (int) Math.round(h*0.01);
                int footerH = h - secH - headerH - articleH-1; // restante (20%)

                // aplicación los calculos de forma dinamica
                sectionNorte.setPreferredSize(new java.awt.Dimension(centro.getWidth(), secNorteH));
                sectionNorte.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, secNorteH));

                section.setPreferredSize(new java.awt.Dimension(centro.getWidth(), secH));
                section.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, secH));

                sectionSur.setPreferredSize(new java.awt.Dimension(centro.getWidth(), secSurH));
                sectionSur.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, secSurH));

                headerCentral.setPreferredSize(new java.awt.Dimension(centro.getWidth(), headerH));
                headerCentral.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, headerH));

                headerSur.setPreferredSize(new java.awt.Dimension(centro.getWidth(), headerSurH));
                headerSur.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, headerSurH));

                article.setPreferredSize(new java.awt.Dimension(centro.getWidth(), articleH));
                article.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, articleH));

                articleSur.setPreferredSize(new java.awt.Dimension(centro.getWidth(), articleSurH));
                articleSur.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, articleSurH));

                footer.setPreferredSize(new java.awt.Dimension(centro.getWidth(), footerH));
                footer.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, footerH));



                // Laterales
                int anchoLateral = (int)Math.round(w*0.15);
                izquierda.setPreferredSize(new java.awt.Dimension(anchoLateral, h));
                izquierda.setMaximumSize(new java.awt.Dimension(anchoLateral, Integer.MAX_VALUE));

                derecha.setPreferredSize(new java.awt.Dimension(anchoLateral, h));
                derecha.setMaximumSize(new java.awt.Dimension(anchoLateral, Integer.MAX_VALUE));
                

                // Aplica
                centro.revalidate();
                centro.repaint();
                ventana.revalidate();
            }
        };

        ventana.addComponentListener(resizer);
        // forzar cálculo inicial
        resizer.componentResized(null);

        
        // Muestra ventana con todo lo correspondiente
        ventana.setVisible(true);

    }
}
