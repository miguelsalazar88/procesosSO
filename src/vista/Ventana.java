package vista;

import controlador.Controlador;
import modelo.Proceso;

import javax.swing.*;
import java.util.PriorityQueue;


public class Ventana extends JFrame {

    private Controlador controlador;

    //Componentes
    private JButton botonNuevo = new JButton("Crear Proceso");
    private JButton botonStep = new JButton("Step");
    private JButton botonClick = new  JButton("Click");
    private JProgressBar barraRam = new JProgressBar(0,100);
    private JProgressBar barraCpu = new JProgressBar(0,100);
    private JTextArea textoNuevos = new JTextArea();
    private JScrollPane JSPnuevos = new JScrollPane(textoNuevos);
    private JTextArea textoPreparados = new JTextArea();
    private JScrollPane JSPpreparados = new JScrollPane(textoPreparados);
    private JTextArea textoEjecucion = new JTextArea();
    private JScrollPane JSPEjecucion = new JScrollPane(textoEjecucion);
    private JTextArea textoTerminados = new JTextArea();
    private JScrollPane JSPTermiados = new JScrollPane(textoTerminados);
    private JTextArea textoBloqueados = new JTextArea();
    private JScrollPane JSPBloqueados = new JScrollPane(textoBloqueados);


    //Labels
    private JLabel labelRam = new JLabel("RAM:");
    private JLabel labelCpu = new JLabel("CPU:");
    private JLabel labelNuevos = new JLabel("Nuevos:");
    private JLabel labelPreparados = new JLabel("Preparados:");
    private JLabel labelEjecucion = new JLabel("En Ejecución:");
    private JLabel labelBloqueados = new JLabel("Bloqueados:");
    private JLabel labelTerminados = new JLabel("Terminados:");



    //Tamaños
    private final int anchoBarra = 500;
    private final int anchoTexto = 200;
    private final int largoTexto = 300;

    public Ventana(){
        this.setTitle("Procesos Sistema Operativo");
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1260,700);
        this.setLocationRelativeTo(null);
        this.initComponents();
    }

    public void initComponents(){
        this.add(labelCpu);
        this.labelCpu.setBounds(300,30,50,30);
        this.add(barraCpu);
        this.barraCpu.setBounds(350,30,anchoBarra,30);
        this.barraCpu.setStringPainted(true);
        this.add(labelRam);
        this.labelRam.setBounds(300,80,50,30);
        this.add(barraRam);
        this.barraRam.setBounds(350,80,anchoBarra,30);
        this.barraRam.setStringPainted(true);
        this.add(JSPnuevos);
        this.add(labelNuevos);
        this.labelNuevos.setBounds(30,180,100,20);
        this.JSPnuevos.setBounds(30,200,anchoTexto,largoTexto);
        this.add(labelPreparados);
        this.labelPreparados.setBounds(280,180,100,20);
        this.add(JSPpreparados);
        this.JSPpreparados.setBounds(280,200,anchoTexto,largoTexto);
        this.add(labelEjecucion);
        this.labelEjecucion.setBounds(530,180,100,20);
        this.add(JSPEjecucion);
        this.JSPEjecucion.setBounds(530,200,anchoTexto,largoTexto);
        this.add(JSPBloqueados);
        this.JSPBloqueados.setBounds(780,200,anchoTexto,largoTexto);
        this.add(labelBloqueados);
        this.labelBloqueados.setBounds(780,180,100,20);
        this.add(JSPTermiados);
        this.JSPTermiados.setBounds(1030,200,anchoTexto,largoTexto);
        this.add(labelTerminados);
        this.labelTerminados.setBounds(1030,180,100,20);

        //Botones

        this.add(botonNuevo);
        this.botonNuevo.setBounds(50,510,150,30);
        this.add(botonStep);
        this.botonStep.setBounds(500,600,300,50);
        this.add(botonClick);
        this.botonClick.setBounds(800,510,150,30);
    }

    public void setControlador(Controlador cont){
        this.controlador = cont;
        this.botonStep.addActionListener(this.controlador);
        this.botonClick.addActionListener(this.controlador);
        this.botonNuevo.addActionListener(this.controlador);
    }

    public JButton getBotonNuevo() {
        return botonNuevo;
    }

    public JButton getBotonStep() {
        return botonStep;
    }

    public JButton getBotonClick() {
        return botonClick;
    }

    public JProgressBar getBarraRam() {
        return barraRam;
    }

    public JProgressBar getBarraCpu() {
        return barraCpu;
    }

    public JTextArea getTextoNuevos() {
        return textoNuevos;
    }

    public JTextArea getTextoPreparados() {
        return textoPreparados;
    }

    public JTextArea getTextoEjecucion() {
        return textoEjecucion;
    }

    public JTextArea getTextoTerminados() {
        return textoTerminados;
    }

    public JTextArea getTextoBloqueados() {
        return textoBloqueados;
    }

    public void setBarraRam(JProgressBar barraRam) {
        this.barraRam = barraRam;
    }

    public void setBarraCpu(JProgressBar barraCpu) {
        this.barraCpu = barraCpu;
    }

    public void setTextoNuevos(JTextArea textoNuevos) {
        this.textoNuevos = textoNuevos;
    }

    public void setTextoPreparados(JTextArea textoPreparados) {
        this.textoPreparados = textoPreparados;
    }

    public void setTextoEjecucion(JTextArea textoEjecucion) {
        this.textoEjecucion = textoEjecucion;
    }

    public void setTextoTerminados(JTextArea textoTerminados) {
        this.textoTerminados = textoTerminados;
    }

    public void setTextoBloqueados(JTextArea textoBloqueados) {
        this.textoBloqueados = textoBloqueados;
    }
}
