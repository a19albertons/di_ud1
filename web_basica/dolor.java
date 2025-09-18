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
        
        JFrame ventana = new JFrame("venana");
        ventana.setSize(600, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setBackground(Color.white);
        ventana.setLayout(new BorderLayout());



        // Superior
        JPanel superior = new JPanel();
        superior.setBackground(new Color(205,92,92));
        JLabel superiorLabel = new JLabel("<header>");
        superiorLabel.setForeground(Color.white);
        superior.add(superiorLabel);
        ventana.add(superior,BorderLayout.NORTH);

        // Inferior
        JPanel inferior = new JPanel();
        inferior.setBackground(new Color(205,92,92));
        JLabel inferiorLabel = new JLabel("<footer>");
        inferiorLabel.setForeground(Color.white);
        inferior.add(inferiorLabel);
        ventana.add(inferior,BorderLayout.SOUTH);

        // Izquierda
        JPanel izquierda = new JPanel();
        izquierda.setBackground(new Color(205,92,92));
        JLabel izquierdaLabel = new JLabel("<footer>");
        izquierdaLabel.setForeground(Color.white);
        izquierda.add(izquierdaLabel);
        izquierda.setLayout(new GridBagLayout());
        Border bordeIzquierdo = BorderFactory.createMatteBorder(2, 0, 6, 3, Color.white);
        izquierda.setBorder(bordeIzquierdo);
        ventana.add(izquierda,BorderLayout.WEST);
        
        // Derecha
        JPanel derecha = new JPanel();
        derecha.setBackground(new Color(205,92,92));
        derecha.setLayout(new GridBagLayout());
        JLabel derechaLabel = new JLabel("<aside>");
        derechaLabel.setForeground(Color.white);
        derecha.add(derechaLabel);
        Border bordeDerecha = BorderFactory.createMatteBorder(2, 3, 6, 0, Color.white);
        derecha.setBorder(bordeDerecha);
        ventana.add(derecha,BorderLayout.EAST);

        // Centro
        JPanel centro = new JPanel();
        centro.setBackground(Color.white);
        // Asegurar que el layout de 'centro' es BoxLayout vertical
        centro.setLayout(new BoxLayout(centro,BoxLayout.Y_AXIS));
        ventana.add(centro,BorderLayout.CENTER);

        // Section Norte
        JPanel sectionNorte = new JPanel();
        sectionNorte.setBackground(Color.white);

        // Centrar el texto en article
        sectionNorte.setLayout(new GridBagLayout());
        centro.add(sectionNorte);
        
        // Section
        JPanel section = new JPanel();
        section.setBackground(new Color(205,92,92));
        section.setLayout(new GridBagLayout());
        JLabel sectionLabel = new JLabel("<section>");
        sectionLabel.setForeground(Color.white);
        section.add(sectionLabel);
        centro.add(section);
        
        // Section Sur
        JPanel sectionSur = new JPanel();
        sectionSur.setBackground(new Color(205,92,92));
        sectionSur.setLayout(new GridBagLayout());
        centro.add(sectionSur);

        // Header del centro
        JPanel headerCentral = new JPanel();
        headerCentral.setBackground(new Color(189,183,107));
        headerCentral.setLayout(new GridBagLayout());
        JLabel headerCentralLabel = new JLabel("<header>");
        headerCentralLabel.setForeground(Color.white);
        headerCentral.add(headerCentralLabel);
        centro.add(headerCentral);

        // Header Sur
        JPanel headerSur = new JPanel();
        headerSur.setBackground(new Color(205,92,92));
        headerSur.setLayout(new GridBagLayout());
        centro.add(headerSur);

        // Article
        JPanel article = new JPanel();
        article.setBackground(new Color(189,183,107));
        article.setLayout(new GridBagLayout());
        JLabel articleLabel = new JLabel("<article>");
        articleLabel.setForeground(Color.white);
        article.add(articleLabel);
        centro.add(article);

        // Article Sur
        JPanel articleSur = new JPanel();
        articleSur.setBackground(new Color(205,92,92));

        // Centrar el texto en article
        articleSur.setLayout(new GridBagLayout());
        centro.add(articleSur);

        // Footer
        JPanel footer = new JPanel();
        footer.setBackground(new Color(189,183,107));
        footer.setLayout(new GridBagLayout());
        JLabel footerLabel = new JLabel("<footer>");
        footerLabel.setForeground(Color.white);
        footer.add(footerLabel);
        centro.add(footer);

        JPanel surFooter = new JPanel();
        surFooter.setBackground(new Color(205,92,92));
        surFooter.setLayout(new GridBagLayout());
        centro.add(surFooter);




        // De la IA personaliza la altura del BoxLayout con % para tener una altura relativa
        // Listener para recalcular alturas proporcionales al redimensionar
        java.awt.event.ComponentAdapter resizer = new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int h = centro.getHeight();
                int w = ventana.getWidth();

                // Gestion altos zona central
                int secNorteH = (int) Math.round(h*0.01);
                int secH = (int) Math.round(h * 0.1);
                int secSurH = (int) Math.round(h*0.01);
                int headerH = (int) Math.round(h * 0.15);
                int headerSurH = (int) Math.round(h*0.01);
                int articleH = (int) Math.round(h * 0.52);
                int articleSurH = (int) Math.round(h*0.01);
                int footerH = (int) Math.round(h*0.16);
                int surFooterH = h - secNorteH - secH - secSurH - headerH - headerSurH - articleH - articleSurH - footerH - 6;

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

                surFooter.setPreferredSize(new java.awt.Dimension(centro.getWidth(), surFooterH));
                surFooter.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, surFooterH));



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

        
        // Muestra ventana con todo lo correspondiente y matamos al peligros Resizable
        ventana.setResizable(false);
        ventana.setVisible(true);

    }
}
