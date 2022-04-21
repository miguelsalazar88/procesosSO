package controlador;

import modelo.Modelo;
import vista.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    private Ventana vista;
    private Modelo modelo;

    public Controlador(Ventana vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(this.vista.getBotonNuevo())){
            this.modelo.crearProceso();
        }
        if(e.getSource().equals(this.vista.getBotonStep())){
            this.modelo.step();
        }
        if(e.getSource().equals(this.vista.getBotonClick())){
            this.modelo.click();
        }

    }
}
