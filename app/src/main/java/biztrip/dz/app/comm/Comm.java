package biztrip.dz.app.comm;

public class Comm {
    public static String n2v(Object obj){
        if (obj == null){
            return "";
        }

        return obj.toString();
    }
}
