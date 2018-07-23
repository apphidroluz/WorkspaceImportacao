package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import entity.Clientes_Concentrador;
import persistence.Clientes_ConcentradorDao;

public class Resgata_Token {

	private static final long serialVersionUID = 1L;
	public final static String path = "http://mizar.net.br:8080/mizar-services/auth/requestToken";
	public final static String user = "hidroluz";
	public final static String senha = "h1dr0l@mzr-srvc";
	public String token;

	public String retorna_token(String Login, String Senha) throws Exception {

		String restUrl = path;
		
		

		JSONObject acesso = new JSONObject();
		acesso.put("user", Login);
		acesso.put("password", Senha);
		String jsonData = acesso.toString();

		Resgata_Token httpPostReq = new Resgata_Token();

		HttpPost httpPost = httpPostReq.createConnectivity(restUrl);

		token = httpPostReq.executeReq(jsonData, httpPost);

		return token;
	}

	HttpPost createConnectivity(String restUrl) {
		HttpPost post = new HttpPost(restUrl);

		post.setHeader("Content-Type", "application/json");
		post.setHeader("Accept", "application/json");
		post.setHeader("X-Stream", "true");
		return post;
	}

	String executeReq(String jsonData, HttpPost httpPost) {

		String tk = null;
		try {
			tk = executeHttpRequest(jsonData, httpPost);
		} catch (UnsupportedEncodingException e) {
			System.out.println("error while encoding api url : " + e);
		} catch (IOException e) {
			System.out.println("ioException occured while sending http request : " + e);
		} catch (Exception e) {
			System.out.println("exception occured while sending http request : " + e);
		} finally {
			httpPost.releaseConnection();
		}
		return tk;
	}

	String executeHttpRequest(String jsonData, HttpPost httpPost)
			throws UnsupportedEncodingException, IOException, JSONException {
		HttpResponse response = null;

		String line = "";
		StringBuilder result = new StringBuilder();
		httpPost.setEntity(new StringEntity(jsonData));

		HttpClient client = HttpClientBuilder.create().build();
		response = client.execute(httpPost);

		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		while ((line = reader.readLine()) != null) {
			result.append(line);
		}

		JSONObject json = new JSONObject(result.toString());

		return json.getString("token");

	}

}
