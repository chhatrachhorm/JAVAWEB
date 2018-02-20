package model.helper;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHelper {

    public static String hashPassword(String pText){
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        return BCrypt.hashpw(pText, salt);
    }
    public static boolean checkPassword(String pText, String hashText){
        if(null == hashText || !hashText.startsWith("$2a$"))
            throw new IllegalArgumentException("Invalid hash provided for comparison");
        return BCrypt.checkpw(pText, hashText);
    }
}
