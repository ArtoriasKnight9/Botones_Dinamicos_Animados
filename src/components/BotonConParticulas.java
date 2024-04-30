package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.beans.*;
/**
 * @author Artorias(Max Bautista Fabián)<maxstell5549@hotmail.com>
 * @author Joaquín Baruc Elorza Pérez<3baruc69@gmail.com>
 */
public class BotonConParticulas extends JButton {
    private List<Particle> particles;

    public BotonConParticulas() {
        super();
        particles = new ArrayList<>();
        setBackground(new Color(51, 153, 255));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addParticles(e.getX(), e.getY());
            }
        });

        new Thread(() -> {
            while (true) {
                updateParticles();
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void addParticles(int x, int y) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int vx = random.nextInt(5) - 2;
            int vy = random.nextInt(5) - 2;
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            particles.add(new Particle(x, y, vx, vy, color));
        }
    }

    private void updateParticles() {
        for (int i = 0; i < particles.size(); i++) {
            Particle particle = particles.get(i);
            particle.update();
            if (particle.getAlpha() <= 0) {
                particles.remove(i);
                i--;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        for (Particle particle : particles) {
            particle.draw(g2d);
        }
        g2d.dispose();
    }

    private static class Particle {
        private int x;
        private int y;
        private int vx;
        private int vy;
        private Color color;
        private int alpha;

        public Particle(int x, int y, int vx, int vy, Color color) {
            this.x = x;
            this.y = y;
            this.vx = vx;
            this.vy = vy;
            this.color = color;
            this.alpha = 255;
        }

        public void update() {
            x += vx;
            y += vy;
            alpha -= 5;
        }

        public int getAlpha() {
            return alpha;
        }

        public void draw(Graphics2D g2d) {
            g2d.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha));
            g2d.fillOval(x, y, 5, 5);
        }
    }

    // Añadir propiedades configurables (opcional)
    public Color getColorFondo() {
        return getBackground();
    }

    public void setColorFondo(Color color) {
        setBackground(color);
    }

    // Registrar el bean y las propiedades configurables
    static {
        BeanInfo info;
        try {
            info = Introspector.getBeanInfo(BotonConParticulas.class);
            BeanDescriptor bd = info.getBeanDescriptor();
            bd.setValue("isContainer", Boolean.FALSE);
            PropertyDescriptor[] pds = info.getPropertyDescriptors();
            for (int i = 0; i < pds.length; i++) {
                PropertyDescriptor pd = pds[i];
                if (pd.getName().equals("colorFondo")) {
                    pd.setBound(true);
                    pd.setConstrained(true);
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
