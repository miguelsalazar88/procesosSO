package modelo;

import vista.Ventana;

import java.util.PriorityQueue;
import java.util.Random;

public class Modelo {

    private Random rnd = new Random();
    private Ventana vista;
    private int numProceso = 1;

    //Listas de estados de Procesos
    private PriorityQueue<Proceso> nuevos = new PriorityQueue<Proceso>();
    private PriorityQueue<Proceso> preparados = new PriorityQueue<Proceso>();
    private PriorityQueue<Proceso> ejecucion = new PriorityQueue<Proceso>();
    private PriorityQueue<Proceso> bloqueados = new PriorityQueue<Proceso>();
    private PriorityQueue<Proceso> terminados = new PriorityQueue<Proceso>();

    public Modelo(Ventana vista) {
        this.vista = vista;
    }

    //Se crea un proceso nuevo en el sistema.
    public void crearProceso(){

        int numero = numProceso;
        int ram = rnd.nextInt(15)+1;
        int cpu = rnd.nextInt(15)+1;
        boolean bloqueo = randomBoolean();
        int prioridad = 0;
        int tiempoCreacion = rnd.nextInt(3)+1;
        int tiempoEjecucion = rnd.nextInt(10)+5;

        nuevos.add(new Proceso(numProceso,ram,cpu,bloqueo,prioridad,tiempoCreacion,tiempoEjecucion));
        numProceso++;
        actualizar();

    }


    //Crea un booleano random con probabilidad del 20% de que sea TRUE
    public boolean randomBoolean(){
        return rnd.nextInt(5) == 0;
    }

    public void step() {


        if(nuevos.peek() != null) {

            for (Proceso p: nuevos) {
                if(p.getTiempoCreacion() > 0){
                    p.setTiempoCreacion(p.getTiempoCreacion()-1);
                }
            }

            if (nuevos.peek().getTiempoCreacion() == 0) {
                nuevos.peek().setPrioridad(rnd.nextInt(10)+1);
                preparados.add(nuevos.poll());
            } else {
                nuevos.peek().setTiempoCreacion(nuevos.peek().getTiempoCreacion() - 1);
            }
        }

        if(preparados.peek() != null){

            if((this.vista.getBarraRam().getValue() + preparados.peek().getRam()) <= 100 &&
                    (this.vista.getBarraCpu().getValue() + preparados.peek().getCpu())<=100){
                this.vista.getBarraRam().setValue(this.vista.getBarraRam().getValue() + preparados.peek().getRam());
                this.vista.getBarraCpu().setValue(this.vista.getBarraCpu().getValue()+ preparados.peek().getCpu());
                ejecucion.add(preparados.poll());
            }
        }

        if(ejecucion.peek() != null){
            for (Proceso p: ejecucion) {
                if(p.getTiempoEjecucion() > 0){
                    p.setTiempoEjecucion(p.getTiempoEjecucion()-1);
                }
            }

            if(ejecucion.peek().getTiempoEjecucion() == 0
                && ejecucion.peek().isBloqueo()){
                this.vista.getBarraCpu().setValue(this.vista.getBarraCpu().getValue() - ejecucion.peek().getCpu());
                this.vista.getBarraRam().setValue(this.vista.getBarraCpu().getValue() - ejecucion.peek().getRam());
                bloqueados.add(ejecucion.poll());
            }

            if(ejecucion.peek().getTiempoEjecucion() == 0
                && !ejecucion.peek().isBloqueo() && ejecucion.peek() != null){
                this.vista.getBarraCpu().setValue(this.vista.getBarraCpu().getValue() - ejecucion.peek().getCpu());
                this.vista.getBarraRam().setValue(this.vista.getBarraCpu().getValue() - ejecucion.peek().getRam());
                terminados.add(ejecucion.poll());
            }
        }

        actualizar();
    }

    public void actualizar(){
        //Se actualiza la vista
        String texto = "";

        for (Proceso p: nuevos) {
            texto = texto + p.toString() + "\n";
        }

        this.vista.getTextoNuevos().setText(texto);

        texto = "";
        for (Proceso p: preparados) {
            texto = texto + p.toString() + "\n";
        }
        this.vista.getTextoPreparados().setText(texto);

        texto = "";
        for (Proceso p: ejecucion) {
            texto = texto + p.toString() + "\n";
        }
        this.vista.getTextoEjecucion().setText(texto);

        texto = "";
        for (Proceso p: bloqueados) {
            texto = texto + p.toString() + "\n";
        }
        this.vista.getTextoBloqueados().setText(texto);

        texto = "";
        for (Proceso p: terminados) {
            texto = texto + p.toString() + "\n";
        }
        this.vista.getTextoTerminados().setText(texto);
    }

    public void click(){
        if(bloqueados.peek() != null){
            preparados.add(bloqueados.poll());
            actualizar();
        }
    }



}
