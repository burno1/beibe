package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    //data no formato dd/MM/yyyy
    static public Date converter(String str) {
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date data = null;
        try {
            data = format.parse(str);
        } catch (ParseException e) {
            System.out.println("Data no formato errado");
            e.printStackTrace();
        }
        return data;
    }

    static public String converter(Date data) {
        // formato da data 
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        // aqui você passa o Date para converter
        String result = fmt.format(data);
        return result;
    }
}
