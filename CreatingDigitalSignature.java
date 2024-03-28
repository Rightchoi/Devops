import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class CreatingDigitalSignature{
public static void main(String[] args)throws Exception{
Scanner sc=new Scanner(System.in);
System.out.print("Enter some text:");
String msg=sc.nextLine();
KeyPairGenerator keyPairGen=KeyPairGenerator.getInstance("DSA");
keyPairGen.initialize(2048);
KeyPair pair=keyPairGen.generateKeyPair();
PrivateKey privKey = pair.getPrivate();
Signature sign = Signature.getInstance("SHA256withDSA");
byte[] bytes=msg.getBytes();
sign.initSign(privKey);
sign.update(bytes);
byte[] signature = sign.sign();
System.out.print("Digital signature for given text:"+new String(signature,"ISO-8859-1"));
}
}