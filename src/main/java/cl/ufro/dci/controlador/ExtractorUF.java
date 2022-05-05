package cl.ufro.dci.controlador;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

public class ExtractorUF {

    public ExtractorUF(){
    }

    public String obtenerUF()  throws IOException {
        Document doc = Jsoup.connect("https://si3.bcentral.cl/indicadoressiete/secure/Serie.aspx?gcode=UF&param=RABmAFYAWQB3AGYAaQBuAEkALQAzADUAbgBNAGgAaAAkADUAVwBQAC4AbQBYADAARwBOAGUAYwBjACMAQQBaAHAARgBhAGcAUABTAGUAYwBsAEMAMQA0AE0AawBLAF8AdQBDACQASABzAG0AXwA2AHQAawBvAFcAZwBKAEwAegBzAF8AbgBMAHIAYgBDAC4ARQA3AFUAVwB4AFIAWQBhAEEAOABkAHkAZwAxAEEARAA=").get();

        Month mes = LocalDate.now().getMonth();
        String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        String primeraLetra = nombre.substring(0, 1);
        String mayuscula = primeraLetra.toUpperCase();
        String demasLetras = nombre.substring(1, nombre.length());
        nombre = mayuscula + demasLetras;

        Calendar fecha = Calendar.getInstance();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        dia = dia + 1;
        String day;
        if (dia < 10) {
            day = "0" + String.valueOf(dia);
        } else {
            day = String.valueOf(dia);
        }

        Elements tabla = doc.select("table.table");

        Element valor = doc.getElementById("gr_ctl" + day + "_" + nombre);

        String uf = valor.text();
        return uf;
    }
}
