package br.com.orlandoburli.aluraviagens.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class DataUtil {

    private static final SimpleDateFormat formatoData = new SimpleDateFormat ( "dd/MM" );

    public static String periodoEmTexto(int dias) {
        Calendar dataIda   = Calendar.getInstance ();
        Calendar dataVolta = Calendar.getInstance ();
        dataVolta.add ( Calendar.DATE, dias );

        return formatoData.format ( dataIda.getTime () ) + " - " +
                formatoData.format ( dataVolta.getTime () ) + " de " +
                dataVolta.get ( Calendar.YEAR );
    }
}
