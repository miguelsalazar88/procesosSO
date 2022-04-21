package modelo;

public class Proceso implements Comparable<Proceso> {
    private int numero;
    private int ram;
    private int cpu;
    private int estado;
    private boolean bloqueo;
    private int prioridad;
    private int tiempoCreacion;
    private int tiempoEjecucion;


    public Proceso(int numero, int ram, int cpu, boolean bloqueo, int prioridad, int tiempoCreacion, int tiempoEjecucion) {
        this.numero = numero;
        this.ram = ram;
        this.cpu = cpu;
        this.estado = 1;
        this.bloqueo = bloqueo;
        this.prioridad = prioridad;
        this.tiempoCreacion = tiempoCreacion;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean isBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(boolean bloqueo) {
        this.bloqueo = bloqueo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getTiempoCreacion() {
        return tiempoCreacion;
    }

    public void setTiempoCreacion(int tiempoCreacion) {
        this.tiempoCreacion = tiempoCreacion;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    @Override
    public String toString() {
        return "Proceso " + numero + " T.C: " +tiempoCreacion
                + " T.Ej: " + tiempoEjecucion + " P: " + prioridad;
    }

    @Override
    public int compareTo(Proceso other) {
        if (this.getPrioridad() == other.getPrioridad()){
            return 0;
        }
        else if(this.getPrioridad() < other.getPrioridad()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
