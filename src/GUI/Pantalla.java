package GUI;

import javax.swing.*;

public abstract class Pantalla extends JFrame {
    protected JPanel panelPrincipal;
    protected InterfazDeUsuario iu;

    public Pantalla(InterfazDeUsuario iu) {
        setTitle("Ventana");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.iu = iu;

        panelPrincipal = new JPanel();
        add(panelPrincipal);
    }

    public void mostrar() {
        inicializar();
        setVisible(true);
    }

    protected abstract void inicializar();
}
