import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Calendario {

    public Calendario() {

    }

    public String formatarData(String dataConsulta) {
        // converter 23062017 para 23/06/2017
        DateTimeFormatter parserData = DateTimeFormatter.ofPattern("ddMMuuuu");
        LocalDate data = LocalDate.parse(dataConsulta, parserData);
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(data); // 23/06/2017
        return dataFormatada;

    }

    public String formatarHora(String hora_minuto) {
        // converter 2120 para 21:20
        DateTimeFormatter parserHora = DateTimeFormatter.ofPattern("HHmm");
        LocalTime hora = LocalTime.parse(hora_minuto, parserHora);
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
        String horaFormatada = formatterHora.format(hora); // 21:20
        return horaFormatada;
    }
}
