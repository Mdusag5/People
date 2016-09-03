import java.net.*;
import java.io.*;

public class People {
        public static int x=0,y=0;
        public static void get() throws Exception {
                URL misis = new URL("http://api.lod-misis.ru/testassignment/");
                URLConnection mis = misis.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(mis.getInputStream()));
                String input= in.readLine();
                System.out.println("Server says:"+input);
                if(input.charAt(1)!='"')
                {
                    if(input.charAt(1)=='M') 
                          if(input.charAt(6)=='B') 				x+=(input.length()-2)/10+1;
                          else 							x-=(input.length()-2)/10+1;
                    else 
                          if(input.charAt(8)=='B') 				y+=(input.length()-2-11)/12+1;
                          else 							y-=(input.length()-2-11)/12+1;
                }
                if(x<0||x==0)
                {
                    if(x==0) 		System.out.println("Кол-во мужчин не изменилось.");
                    else 		System.out.println("Уменьшение количества мужчин - "+(-x)+" человек(а).");
                }
                else			System.out.println("Увеличение количества мужчин - "+x+" человек(а).");
                if(y<0||y==0)
                {
                    if(y==0) 		System.out.println("Кол-во женщин не изменилось.");
                    else 		System.out.println("Уменьшение количества женщин - "+(-y)+" человек(а).");
                }
                else			System.out.println("Увеличение количества женщин - "+y+" человек(а).");
                in.close();
    }
    public static void main(String[] args) throws Exception{
        while(true){
                get();
                Thread.sleep(60000);
        }
    }
}