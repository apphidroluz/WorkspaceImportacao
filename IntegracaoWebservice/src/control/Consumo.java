package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import entity.Dados;

public class Consumo {

	private static final long serialVersionUID = 1L;
	public final static String path = "http://mizar.net.br:8080/mizar-services/medicoes?dataDe=2018-07-25";
	String rt = null;
	ArrayList<Dados> dados = null;  

	public static void main(String[] args) throws JSONException {
		Consumo c = new Consumo();

	}

	public ArrayList<Dados> retorna_token(String Login, String Senha) throws JSONException {

		try {
			rt = new Resgata_Token().retorna_token(Login,Senha);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		Date data = new Date(System.currentTimeMillis());
		
	/*	Calendar c = Calendar.getInstance();
		
		c.setTime(data);
		
		c.add(Calendar.DATE, -1);
		
		System.out.println(c.getTime());*/

		String restUrl = path;

		Consumo httpGetReq = new Consumo();
	
		HttpGet httpGet = httpGetReq.createHttpGetConnection(restUrl , rt);

		dados = httpGetReq.executeReq(httpGet);
		
	
		
		return dados;

	}


	
	HttpGet createHttpGetConnection(String restUrl, String rs)
    {
        HttpGet get = new HttpGet(restUrl);
        
       
        get.setHeader("Content-Type", "application/json");
        get.setHeader("Charset", "UTF-8");
        get.setHeader("X-Mizar-Auth-Token" , rs);
        return get;
    }

	ArrayList<Dados> executeReq(HttpGet httpGet) {

		try {
			dados = executeHttpGetRequest(httpGet);
			
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("error while encoding api url : " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ioException occured while sending http request : " + e);
		} catch (Exception e) {
			System.out.println("exception occured while sending http request : " + e);
			e.printStackTrace();
		} finally {
			
			
			httpGet.releaseConnection();
		}
		
		return dados;
	}
	
	 public ArrayList<Dados> executeHttpGetRequest(HttpGet httpGet)  throws UnsupportedEncodingException, IOException, JSONException {
	        
		 	HttpResponse response=null;
	        String line = "";
	        dados = new ArrayList<Dados>();
	        ArrayList<String> Mes = new ArrayList<String>();
	        
	        String myCustom_JSONResponse="";
	        StringBuffer result = new StringBuffer();
	        
	        HttpClient client = HttpClientBuilder.create().build();
	        response = client.execute(httpGet);
	        
	        System.out.println("Response Code : " +response.getStatusLine().getStatusCode());
	        
	        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	       
	        while ((line = reader.readLine()) != null){
	        	
	        	      	result.append(line); 
	        	}
	        
	       	        
	        myCustom_JSONResponse="{\"master\":"+result.toString()+"}";
	        
	        JSONObject json = new JSONObject(myCustom_JSONResponse);
	        
	    	        
	        JSONArray jsonArray = json.getJSONArray("master");
	        
	        for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj2 = jsonArray.getJSONObject(i);
                
                Dados item = new Dados(
                		obj2.getInt("code"), 
                		obj2.getString("measurer"),
                		obj2.getString("device"), 
                		obj2.getString("date"),
                		obj2.getInt("measuring")/1000,
                		obj2.getString("alarm"));
                
                String [] alarmes = item.getAlarm().split(":");
                
                item.setHaVazamento(Integer.parseInt(alarmes[1]));
                item.setHouveVazamento(Integer.parseInt(alarmes[2]));
                item.setHaDesmontagem(Integer.parseInt(alarmes[3]));
                item.setHouveDesmontagem(Integer.parseInt(alarmes[4]));
                item.setMedidorBloqueado(Integer.parseInt(alarmes[7]));
                item.setRetornoAgua(Integer.parseInt(alarmes[8]));
                
                	
                
              //  Boolean teste = obj2.getBoolean("alarm");
                
                
                dados.add(item);
                
                
	        }
	        
	       
	        
	        
	  /*      JSONArray jsonArray2 = json.getJSONArray("alarm");
	        
	        
	        for (int i = 0; i < jsonArray2.length(); i++) {
                JSONObject obj3 = jsonArray2.getJSONObject(i);
                
                	Boolean alarm1 = obj3.getBoolean(key)
                
                
	        }
	        */
	        
	        System.out.println(dados);
	      
	        return dados;
	        
	 }
	 
	

}