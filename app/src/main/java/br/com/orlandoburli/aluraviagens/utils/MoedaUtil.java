package br.com.orlandoburli.aluraviagens.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public final class MoedaUtil {

    private static final NumberFormat formatoBrasileiro = DecimalFormat.getCurrencyInstance ( new Locale ( "pt", "br" ) );

    public static String formataParaBrasileiro(BigDecimal valor) {
        return formatoBrasileiro.format ( valor );
    }
}
