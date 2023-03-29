import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;


public class App {
    public static void main(String[] args) throws Exception{

        String pronosticos = ".\\pronosticos.csv";
        String resultados = ".\\resultados.csv"; 

        //llamada al método que comparar dos archivos para evaluar si el pronóstico fue acertado o no.
        App.compararResultados(pronosticos, resultados);
    }



    
    public static void compararResultados(String pronosticoPath, String resultadosPath) throws NumberFormatException, IOException {

        BufferedReader pronosticoLector = null;
        BufferedReader resultadosLector = null;
        //Variable por la cuál se dividirán los datos en los archivos.
        String csvDelimitador = ";";
        int puntos;


        pronosticoLector = new BufferedReader(new FileReader(pronosticoPath));
        resultadosLector = new BufferedReader(new FileReader(resultadosPath));
    

        String pronosticoLine, resultadosLine;

        while ((pronosticoLine = pronosticoLector.readLine()) != null && (resultadosLine = resultadosLector.readLine()) != null) {
            //Separacón de los datos de ambos archivos. 
            String[] pronosticoInfo = pronosticoLine.split(csvDelimitador);
            String[] resultadoInfo = resultadosLine.split(csvDelimitador);

// SECCIÓN DE EVALUACION DE DATOS Y CREACIÓN DE INTANCIAS DE CLASE PARA PRONOSTICOS.
            //Conversión de los números tipo String a int para poder incluirlos en una nueva intancia de Equipo.
            int pronosticoGolesEquipo1 = Integer.parseInt(pronosticoInfo[1]);
            int pronosticoGolesEquipo2 = Integer.parseInt(pronosticoInfo[3]);
            int pronosticoGolesEquipo3 = Integer.parseInt(pronosticoInfo[5]);
            int pronosticoGolesEquipo4 = Integer.parseInt(pronosticoInfo[7]);

            //Creación de los equipos del pronóstico.
            Equipo equipo1Pronostico = new Equipo(pronosticoInfo[0], pronosticoGolesEquipo1);
            Equipo equipo2Pronostico = new Equipo(pronosticoInfo[2], pronosticoGolesEquipo2);
            
            Equipo equipo3Pronostico = new Equipo(pronosticoInfo[4], pronosticoGolesEquipo3);
            Equipo equipo4Pronostico = new Equipo(pronosticoInfo[6], pronosticoGolesEquipo4);


            //Creacion de partidos tipo pronostico, extensiones de la clase Partido.
            Pronostico partidoPronostico1 = new Pronostico(equipo1Pronostico, equipo2Pronostico);
            Pronostico partidoPronostico2 = new Pronostico(equipo3Pronostico, equipo4Pronostico);




            //Evaluacion de ganador del primer partido de pronostico.
            String equipoGanadorPronostico1 = partidoPronostico1.GanadorOEmpate();
            //Evaluacion del ganador del segundo partido de pronostico.
            String equipoGanadorPronostico2 = partidoPronostico2.GanadorOEmpate();



// SECCIÓN DE EVALUACION DE DATOS Y CREACIÓN DE INTANCIAS DE CLASE PARA RESULTADOS.

            //Nueva conversión de los números tipo String a int pero ahora para la parte de Resultados.
            int resultadoGolesEquipo1 = Integer.parseInt(resultadoInfo[1]);
            int resultadoGolesEquipo2 = Integer.parseInt(resultadoInfo[3]);
            int resultadoGolesEquipo3 = Integer.parseInt(resultadoInfo[5]);
            int resultadoGolesEquipo4 = Integer.parseInt(resultadoInfo[7]);

            //Creación de los equipos para la parte de Resultados.
            Equipo equipo1Resultado = new Equipo(resultadoInfo[0], resultadoGolesEquipo1);
            Equipo equipo2Resultado = new Equipo(resultadoInfo[2], resultadoGolesEquipo2);
            
            Equipo equipo3Resultado = new Equipo(resultadoInfo[4], resultadoGolesEquipo3);
            Equipo equipo4Resultado = new Equipo(resultadoInfo[6], resultadoGolesEquipo4);


            //Creacion de partidos tipo resultado, extensiones de la clase Partido.
            Resultado partidoResultado1 = new Resultado(equipo1Resultado, equipo2Resultado);
            Resultado partidoResultado2 = new Resultado(equipo3Resultado, equipo4Resultado);

            //Evaluacion del ganador del primer partido de Resultado.
            String equipoGanadorResultado1 = partidoResultado1.GanadorOEmpate();
            //Evaluacion del ganador del segundo partido de Resultado.
            String equipoGanadorResultado2 = partidoResultado2.GanadorOEmpate();


            //Creación de la primera y unica ronda del día.
            Ronda ronda = new Ronda(partidoPronostico1, partidoResultado1, partidoPronostico2, partidoResultado2);

            //Llamada final al método que evaluará si el usuario acertó o no.
            ronda.ComprobarAcierto();
        }

        pronosticoLector.close();
        resultadosLector.close();
    }
}

    
