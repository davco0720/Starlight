package starlight;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

public class Md5Encript {

    String secretkey = "holamundo";

    public String ecnode(String Cadena) {
        String encriptacion = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavePassword = md5.digest(secretkey.getBytes("utf-8"));
            byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = Cadena.getBytes("utf-8");
            byte[] buf = cifrado.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            encriptacion = new String(base64Bytes);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Algo salio mal");

        }
        return encriptacion;

    }

    public String deecnode(String CadenaEncript) {
        String desencriptacion = "";
        try {

            byte[] message = Base64.decodeBase64(CadenaEncript.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md5.digest(secretkey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decifrado = Cipher.getInstance("DESede");
            decifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = decifrado.doFinal(message);
            desencriptacion = new String(plainText, "UTF-8");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Algo salio mal");

        }

        return desencriptacion;
    }
}