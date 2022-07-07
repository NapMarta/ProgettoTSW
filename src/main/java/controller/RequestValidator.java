package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestValidator {

    public static boolean assertEmail(String email){
        Pattern pattern = Pattern.compile("^[A-z0-9\\.\\+-]+@[A-z0-9\\.-]+\\.[A-z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches())
            return true;
        else return false;
    }


    public static boolean assertNome(String name){
        Pattern pattern = Pattern.compile("^[A-z0-9_-]{3,30}$");
        Matcher matcher = pattern.matcher(name);
        if(matcher.matches())
            return true;
        else return false;
    }

    public static boolean assertCognome(String cognome){
        Pattern pattern = Pattern.compile("^[A-z0-9_-]{3,30}$");
        Matcher matcher = pattern.matcher(cognome);
        if(matcher.matches())
            return true;
        else return false;
    }

    public static boolean assertPassword(String password){
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([@_\\.,!?#]*)(([a-zA-Z0-9]([@_\\.,!?#]*)){8,20})$");
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches())
            return true;
        else return false;
    }

    public static boolean assertData(String data){
        Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        Matcher matcher = pattern.matcher(data);
        if(matcher.matches())
            return true;
        else return false;
    }

    public static  boolean assertNumeroCarta(String numCarta){
        Pattern pattern = Pattern.compile("^\\d{16}$");
        Matcher matcher = pattern.matcher(numCarta);
        if(matcher.matches())
            return true;
        else return false;
    }

    public static boolean assertCAP(String cap){
        Pattern pattern = Pattern.compile("^\\d{5}$");
        Matcher matcher = pattern.matcher(cap);
        if(matcher.matches())
            return true;
        else return false;
    }


    public static boolean assertIndirizzo(String indirizzo){
        Pattern pattern = Pattern.compile("^[A-z0-9,\\. ]{3,30},[A-z0-9,\\. ]{2,3}$");
        Matcher matcher = pattern.matcher(indirizzo);
        if(matcher.matches())
            return true;
        else return false;
    }

    public static boolean assertCitta(String citta){
        Pattern pattern = Pattern.compile("^[a-z]{3,20}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(citta);
        if(matcher.matches())
            return true;
        else return false;
    }

    public static boolean assertDescrizione(String descrizione){
        Pattern pattern = Pattern.compile("^[a-z0-9,\\. ]{3,200}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(descrizione);
        if(matcher.matches())
            return true;
        else return false;
    }

    public static boolean assertDouble(String value){
        Pattern pattern = Pattern.compile("^(0|[1-9]\\d*)(\\.\\d+)?$");
        Matcher matcher = pattern.matcher(value);
        if(matcher.matches())
            return true;
        else return false;
    }
}
