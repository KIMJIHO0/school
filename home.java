package HW_2;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Base64.Decoder;

public class home {
    public void run() throws Exception {
        String key = "8iE3bf1se6N76HGPP8S0Xw==";//key
        String iv = "cHml3oX848/0uBwDJtChOA==";//iv
        String c = "QDr9NZNG9Bgc3TTnfRuqjjzf/kVSYwbP7F9mR4GQZ/IneIh7HTc/xnwzEeVBc" +
                "H3pPlIbLFySKZruedJc9X87CGNDJ1f2Dat8BR3Ypbei5Q42xc306/AkSuGsjfqb" +
                "X9/ELxmdKn7MyvY/Jbc0v0AJHV6odgNzygKRRrFJcUIF/50=";
        //c
        byte[] byteKey = key.getBytes();
        byte[] byteIv = iv.getBytes();
        byte[] byteC = c.getBytes();
        //base64
        byte[] decodedByteKey = base64Decode(byteKey);
        byte[] decodedByteIv = base64Decode(byteIv);
        byte[] decodedByteC = base64Decode(byteC);

        String answer = decode(decodedByteC, decodedByteKey, decodedByteIv);
        System.out.println("복호화된 plaintext ");
        System.out.println(answer);
    }
    public byte[] base64Decode(byte[] bytes) {
        Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(bytes);
        return decodedBytes;
    }

    public String decode(byte[] decodedByteC ,byte[] decodedByteKey, byte[] decodedByteIv) throws Exception{

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding"); //cipher 모드
        SecretKeySpec key = new SecretKeySpec(decodedByteKey, "AES"); //사용할 key 생성
        IvParameterSpec iv = new IvParameterSpec(decodedByteIv); //사용할 iv 생성
        cipher.init(Cipher.DECRYPT_MODE, key, iv); // 초기화
        String decodedString = new String(cipher.doFinal(decodedByteC)); //return 받기
        return decodedString;
    }
    public static void main(String[] args) throws Exception {
        home aes = new home();
        aes.run();
    }
}


