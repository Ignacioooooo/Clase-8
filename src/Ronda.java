public class Ronda {
    //Atributo con su respectivo get, para hipoteticamente solicitar el número de nuestra instancia de Ronda.
    private static int nroRonda = 0;
    
    //Otros atributos.
    Pronostico[] pronosticos;
    Resultado[] resultados;
    String ganadorPronostico1;
    String ganadorPronostico2;
    String ganadorResultado1;
    String ganadorResultado2;



    int puntos = 0;

    public Ronda(Pronostico partidoPronostico1, Resultado partidoResultado1, Pronostico partidoPronostico2, Resultado partidoResultado2){
        pronosticos = new Pronostico[2];
        this.pronosticos[0] = partidoPronostico1;
        this.pronosticos[1] = partidoPronostico2;
        resultados = new Resultado[2];
        this.resultados[0] = partidoResultado1;
        this.resultados[1] = partidoResultado2;

        this.ganadorPronostico1 = this.pronosticos[0].GanadorOEmpate();
        this.ganadorPronostico2 = this.pronosticos[1].GanadorOEmpate();
        this.ganadorResultado1 = this.resultados[0].GanadorOEmpate();
        this.ganadorResultado2 = this.resultados[1].GanadorOEmpate();

        nroRonda++;

    }

    public static int getNroRonda() {
        return nroRonda;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getGanadorPronostico1() {
        return ganadorPronostico1;
    }
    public String getGanadorPronostico2() {
        return ganadorPronostico2;
    }
    public String getGanadorResultado1() {
        return ganadorResultado1;
    }
    public String getGanadorResultado2() {
        return ganadorResultado2;
    }

    public void dibujar(){

        System.out.println(this.ganadorPronostico1);
        System.out.println(this.ganadorResultado1);
        
    } 

    public void ComprobarAcierto(){
        if(this.ganadorPronostico1.equals(this.ganadorResultado1) && this.ganadorPronostico2.equals(this.ganadorResultado2)){
            puntos++;
            System.out.println("¡Acertó los resultados de ambos partidos!\nSu puntaje es " + puntos);

        }else{
            System.out.println("No ha acertado uno o más partidos.\nSu puntaje es " + puntos);
        }
    }

}
