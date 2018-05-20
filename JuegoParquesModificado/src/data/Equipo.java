
package data;

public class Equipo extends Jugador {
    private Ficha[] fichas;
    private String color;
    private int turno;
    private boolean habilidadDisponible;
    private boolean jugador;
    
    public Ficha[] getFichas() {
        return fichas;
    }

    public void setFichas(Ficha[] fichas) {
        this.fichas = fichas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public boolean isHabilidadDisponible() {
        return habilidadDisponible;
    }

    public void setHabilidadDisponible(boolean habilidadDisponible) {
        this.habilidadDisponible = habilidadDisponible;
    }

    public boolean isJugador() {
        return jugador;
    }

    public void setJugador(boolean jugador) {
        this.jugador = jugador;
    }
    
    @Override
    public String toString(){
        return super.toString()+"Equipo color: "+this.getColor()+"\nTurno numero: "+Integer.toString(this.getTurno())+"\n";
    }
    
        
    public void usarPoder(){
    }
    
}
