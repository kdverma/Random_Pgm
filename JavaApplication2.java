package javaapplication2;
import java.io.*;
public class JavaApplication2 {
    public static void main(String[] args) {

        try 
        {
            byte[] CARRIAGE_RETURN = "\n".getBytes();
            byte[] PEM_CERTIFICATE_HEADER = "-----BEGIN CERTIFICATE-----".getBytes();
            byte[] PEM_CERTIFICATE_FOOTER = "-----END CERTIFICATE-----".getBytes();
            //byte[] base64EncodedCertificate = "sdfjskldfjkasjdkalsjdkalsjkdlad".getBytes();
            byte[] base64EncodedCertificate = "sdfjskldfjkasjdkalsjdkalsjkdlad\n".getBytes();   //>>>>>> carriage return inside cert

            int encodedLength = base64EncodedCertificate.length;
            int carriage_return_Length = CARRIAGE_RETURN.length;
            FileOutputStream fos = new FileOutputStream("C:\\pemfile.pem");
            fos.write(PEM_CERTIFICATE_HEADER);
            fos.write(CARRIAGE_RETURN);
            fos.write(base64EncodedCertificate);
            if (!(base64EncodedCertificate[encodedLength - 1] == CARRIAGE_RETURN[carriage_return_Length - 1])) {
                fos.write(CARRIAGE_RETURN);
                System.out.println("writting extra carriage return");
            }
            fos.write(PEM_CERTIFICATE_FOOTER);
            fos.close();
            System.out.println("File write complete");
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}
