
package data;

public class Equipo {
    
    private Ficha[] fichas;
    private String color;
    private int turno;
    private boolean habilidadDisponible;
    
    public Equipo(){
        fichas = new Ficha[4];
    }    

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
        
    public void usarPoder(){
    }
    
}
