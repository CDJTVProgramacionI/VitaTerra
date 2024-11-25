import javax.swing.*;

public abstract class Pantallas extends JFrame {
    protected JPanel panelPrincipal;

    public Pantallas() {
        setTitle("Ventana");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelPrincipal = new JPanel();
        add(panelPrincipal);

        inicializar();
        setVisible(true);
    }

    protected abstract void inicializar();
}
