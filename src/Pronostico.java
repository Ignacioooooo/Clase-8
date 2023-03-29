public class Pronostico extends Partido{

    String equipoGanador;
    int golesEquipo1;
    int golesEquipo2;

    public Pronostico(Equipo equipo1, Equipo equipo2) {
        super(equipo1, equipo2);
        this.golesEquipo1 = this.equipos[0].getGoles();
        this.golesEquipo2 = this.equipos[1].getGoles();
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
