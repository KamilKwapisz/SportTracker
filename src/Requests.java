import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Requests {

    public double addTraining(String urlStr, String user, String type, double time, int reps, int distance) {
        try{

            URL url = new URL("http://127.0.0.1:5000/trainings/new");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection)con;
            http.setRequestMethod("POST"); // PUT is another valid option
            http.setDoOutput(true);
    //        byte[] out = "{\"user\":\"kamil\",\"training_type\":\"running\",\"training_type\":\"running\",\"training_time\":200,\"reps\":0,\"distance\":1000}" .getBytes(StandardCharsets.UTF_8);
            byte[] out = ("{\"user\":\"" + user +"\"," +
                    "\"training_type\":\"" +  type + "\"," +
                    "\"training_time\":" + time + "," +
                    "\"reps\":" + reps + "," +
                    "\"distance\":" + distance + "}").getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            http.connect();
            try(OutputStream os = http.getOutputStream()) {
                os.write(out);
                System.out.println(os.toString());
            }
            StringBuilder result = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(http.getInputStream()));
//            System.out.println(http.getResponseMessage());
            String line;
            double points = 0;
            while ((line = rd.readLine()) != null) {
                result.append(line);
                try{ // parse points number
                    points = Double.parseDouble(line);
                } catch (Exception e){

                }

            }
            rd.close();
//            return result.toString();
            return points;


        } catch (Exception e){
            // do nothing :)
        }
        return 0;
    }

    public static String getHTML(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }


    public static void main(String[] args) {
        Requests r = new Requests();
        try{
            System.out.println(r.addTraining("http://127.0.0.1:5000/trainings/new",
                    "nowy",
                    "jumping",
                    200,
                    300,
                    0
                    ));
            System.out.println(getHTML("http://127.0.0.1:5000/mine"));

        } catch (Exception e){

        }

    }
}
