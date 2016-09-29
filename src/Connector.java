import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by 전세호 on 2016-09-29.
 */
public class Connector {
    private String URL;
    private String text;

    public Connector(String str) {
        this.URL=str;
    }

    public void connect()
    {
        try{
            HttpClient httpClient=new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(URL);
            ResponseHandler<String> responseHandler=new BasicResponseHandler();
            text=httpClient.execute(httpGet, responseHandler);
           //return httpClient.execute(httpGet, responseHandler);
        }
        catch(Exception e){
            //return null;
        }
    }

    public void Json()
    {
        try{
            JSONArray list = new JSONArray(text);

            for(int i=0;i<list.length();i++)
            {
                JSONObject obj=list.getJSONObject(i);

                String id=obj.getString("id");
                String date=obj.getString("dt");
                System.out.println(id+"/"+date);
            }
        }
        catch(Exception e){

        }
    }
}
