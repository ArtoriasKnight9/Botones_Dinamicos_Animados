package components;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Artorias(Max Bautista Fabián)<maxstell5549@hotmail.com>
 * @author Joaquín Baruc Elorza Pérez<3baruc69@gmail.com>
 */
public class BotonFlecha extends JButton {
    private Timer timer;
    private int animationDelay = 10; // Delay de la animación en milisegundos
    private int displacement = 0; // Desplazamiento de la flecha durante la animación

    public BotonFlecha() {
         // Carga el icono de flecha hacia la izquierda desde el archivo proporcionado
        // Carga el icono de flecha hacia la izquierda desde el archivo proporcionado
        setIcon(new ImageIcon("src/Icons/atras.png"));

        // Añade un ActionListener para manejar el clic del botón
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Inicia la animación cuando se hace clic en el botón
                startAnimation();

                // Ejecuta la acción en un hilo separado
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        // Aquí inserta el código para realizar la acción deseada
                        // Por ejemplo:
                        // VentanaPrincipal ventana = new VentanaPrincipal();
                        // ventana.setVisible(true);
                        return null;
                    }
                };
                worker.execute();
            }
        });
    }

    // Método para iniciar la animación
    private void startAnimation() {
        // Crea un Timer para controlar la animación
        if (timer == null) {
            timer = new Timer(animationDelay, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Decrementa el desplazamiento para la animación (lo mueve hacia la izquierda)
                    displacement -= 3;
                    repaint(); // Vuelve a pintar el botón para mostrar el desplazamiento

                    // Detiene la animación cuando el desplazamiento llega a ser negativo (moverse completamente hacia la izquierda)
                    if (displacement <= -getWidth()) {
                        stopAnimation();
                    }
                }
            });
            timer.start();
        }
    }

    // Método para detener la animación
    private void stopAnimation() {
        if (timer != null) {
            timer.stop();
            timer = null;
            displacement = 0; // Reinicia el desplazamiento para la próxima animación
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // Mueve el icono de acuerdo al desplazamiento para simular la animación
        g2d.translate(displacement, 0);

        // Dibuja el icono en la posición actual
        super.paintComponent(g2d);

        g2d.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Botón Animado");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(200, 100);

                // Crea un nuevo botón animado
                BotonFlecha botonAnimado = new BotonFlecha();
                frame.add(botonAnimado);

                frame.setVisible(true);
            }
        });
    }
}

