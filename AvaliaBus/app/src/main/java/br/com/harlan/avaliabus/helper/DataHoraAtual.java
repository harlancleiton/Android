package br.com.harlan.avaliabus.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataHoraAtual {

    public static String getDataHora(){
        String dataHoraFormatada;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = Calendar.getInstance().getTime();
        dataHoraFormatada = simpleDateFormat.format(date);
        return dataHoraFormatada;
    }
}