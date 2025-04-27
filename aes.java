import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

class AesEncrypter
{
    Cipher ecipher;

    Cipher dcipher;

    AesEncrypter(SecretKey key) throws Exception
    {
        ecipher = Cipher.getInstance("AES");
        dcipher = Cipher.getInstance("AES");
        ecipher.init(Cipher.ENCRYPT_MODE, key);
        dcipher.init(Cipher.DECRYPT_MODE, key);
    }

public
    String encrypt(String str) throws Exception
    {
        // Encode the string into bytes using utf-8 byte[] utf8 = str.getBytes("UTF8");

        // Encrypt
        byte[] enc = ecipher.doFinal(utf8);

        // Encode bytes to base64 to get a string
        // return new sun.misc.BASE64Encoder().encode(enc); return Base64.getEncoder().encodeToString(enc);
    }

public
    String decrypt(String str) throws Exception
    {
        // Decode base64 to get bytes
        // byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str); byte[] dec = Base64.getDecoder().decode(str);

        byte[] utf8 = dcipher.doFinal(dec);

        // Decode using utf-8
        return new String(utf8, "UTF8");
    }
}

public class AES
{
public
    static void main(String[] argv) throws Exception
    {
        SecretKey key = KeyGenerator.getInstance("AES").generateKey();
        AesEncrypter encrypter = new AesEncrypter(key);

        String encrypted = encrypter.encrypt("Don't tell anybody!");
        System.out.println(encrypted);
        String decrypted = encrypter.decrypt(encrypted);
        System.out.println(decrypted);
    }
}
