public class Partido {
    Equipo[] equipos;
    String equipoGanador;
    int golesEquipo1;
    int golesEquipo2;
    private static int nroPartido= 0;


    public Partido(Equipo equipo1, Equipo equipo2){
        equipos = new Equipo[2];
        this.equipos[0] = equipo1;
        this.equipos[1] = equipo2;
        nroPartido++;
    }

    public static int getNroPartido() {
        return nroPartido;
    }
    
    public Equipo[] getEquipos() {
        return equipos;
    }


    public String GanadorOEmpate(){

        if(this.golesEquipo1 > this.golesEquipo2){
            this.equipoGanador = equipos[0].getNombre();
        }else if(golesEquipo2 > golesEquipo1){
            this.equipoGanador = equipos[1].getNombre();
        }else if(golesEquipo1 == golesEquipo2){
            this.equipoGanador = "Empate";
        }
        return equipoGanador;
    }
}
