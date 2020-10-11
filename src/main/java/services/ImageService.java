package services;

import models.Image;
import models.SessionUtils;
import org.hibernate.Session;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.nio.file.Paths;
import java.util.Base64;

public class ImageService {
    private static Session session=new SessionUtils().getSession();
    public static long insertImage(String base64) {
        Image image=new Image();
        image.setBase64image(base64);
        session.beginTransaction();
        session.save(image);
        session.getTransaction().commit();
        return image.getId();
    }
    public static String saveBase64ToFile(String base64) throws FileNotFoundException, IOException {
        //String filename="images/"+Long.toString(insertImage(base64))+".jpg";
        //byte[] data= DatatypeConverter.parseBase64Binary(base64.split(",")[1]);
        //String resDir= Paths.get("").toAbsolutePath().toString();
        //String resDir="/home/g4chewbaca/images/";
        String resDir="C:\\Games\\client";
        System.out.println(resDir);
        String base64Image=base64.split(",")[1];
        String filename=(PostService.getLastId()+1)+".jpg";
        String filepath=resDir+filename;
        byte[] data= Base64.getDecoder().decode(base64Image);
        OutputStream stream = new FileOutputStream(filepath);
        stream.write(data);
        return filename;
    }
}
