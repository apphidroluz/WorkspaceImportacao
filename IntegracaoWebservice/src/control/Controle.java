package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.json.JSONException;

import entity.Clientes;
import entity.Dados;
import entity.Facturation;
import entity.Hidrometro;
import persistence.FacturationDao;
import persistence.HidrometroDao;

@WebServlet("/Controle")
public class Controle extends HttpServlet {

	private String filename;
	private String path;

	private File file;

	SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		String cmd = request.getParameter("cmd");
		if(cmd.equalsIgnoreCase("exportar")) {
			exportar(request, response);
		}
		
	}
	
	private void exportar(HttpServletRequest request, HttpServletResponse response) {
		try { 
		 String nome = file.getName();
		 response.setContentType("text/html");
		 response.setHeader("Content-Disposition", "attachment; filename='"+ nome + "'");
		 OutputStream output = response.getOutputStream();
		 Files.copy(file.toPath(), output);
		}catch(Exception e){
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		if (cmd.equalsIgnoreCase("logar")) {
			try {
				logar(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	protected String logar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {

		String login = new String(request.getParameter("login"));
		String senha = new String(request.getParameter("senha"));

		Consumo c = new Consumo();

		try {
			List<Dados> dados = c.retorna_token(login, senha);

			System.out.println(dados);

			Collections.sort(dados);

			List<Dados> dd_atualizados = new ArrayList<>();

			for (int i = 0; i < dados.size(); i++) {

				if (dd_atualizados.isEmpty()) {

					dd_atualizados.add(dados.get(i));

				} else {

					int count = 0;

					for (Dados d : dd_atualizados) {

						if (dados.get(i).getMeasure().equalsIgnoreCase(d.getMeasure())) {

							count++;
						}

					}

					if (count == 0) {

						dd_atualizados.add(dados.get(i));
					}

				}

			}

			for (int i = 0; i < dd_atualizados.size(); i++) {

				try {
					List<Hidrometro> h = new HidrometroDao().findHidro(dd_atualizados.get(i).getMeasure());

					dd_atualizados.get(i).setLocalizacao(h.get(0).getLocal());
					dd_atualizados.get(i).setCodigo(h.get(i).getCliente().getCodigo());

				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			
			for (int i = 0; i < dd_atualizados.size(); i++) {

				try {
					List<Facturation> f = new FacturationDao().findFact(dd_atualizados.get(i).getMeasure());

				
					
					SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
					 
					String result = out.format(in.parse(f.get(i).getData_levant().toString()));
					
					
					
					dd_atualizados.get(i).setData_hist(result);
					dd_atualizados.get(i).setIndice_antigo(f.get(i).getIndice());
					dd_atualizados.get(i).setConsumo((double) (dd_atualizados.get(i).getMeasuring() - f.get(i).getIndice()));

				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			 ServletContext context = request.getServletContext();
				path = context.getRealPath("/");
				
				System.out.println(path);
				
				file = new File(path + dados.get(0).getCode() + ".txt");
				
				FileWriter writer = new FileWriter(file);
				
				
				writer.write(Parametros.cabecalho);
				writer.write(System.getProperty("line.separator"));
				
				for(int i = 0; i < dd_atualizados.size() ;i++) {
					
					String dt = dd_atualizados.get(i).getDate().substring(0, 10);
					System.out.println("data : " + dt);
					

					SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
					 
					String result = out.format(in.parse(dt));
					
			
					
					
					
					
					writer.write(dd_atualizados.get(i).getLocalizacao() + "\t" + 
								 dd_atualizados.get(i).getMeasuring() + "\t" + 
								 dd_atualizados.get(i).getIndice_antigo() + "\t" + 
								 dd_atualizados.get(i).getConsumo() + "\t" + 
								 dd_atualizados.get(i).getHaDesmontagem() + "\t" +
								 dd_atualizados.get(i).getHaVazamento() + "\t" +
								 dd_atualizados.get(i).getHouveVazamento() + "\t" + 
								 dd_atualizados.get(i).getMedidorBloqueado() + "\t" +
								 dd_atualizados.get(i).getCodigo() + "\t" +
								 dd_atualizados.get(i).getMeasure() + "\t" +
								 result + "\t" +
								 dd_atualizados.get(i).getData_hist() + "\t" +
								 8 + "\t" +
								 0 + "\t" +
								 dd_atualizados.get(i).getHouveDesmontagem() + "\t" + 
								 dd_atualizados.get(i).getRetornoAgua());		
					writer.write(System.getProperty("line.separator"));
				
				 }
				 writer.close();

			cadastra_fac(dd_atualizados);
			
			System.out.println(dd_atualizados);

			request.setAttribute("dados", dd_atualizados);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

		request.getRequestDispatcher("medicao.jsp").forward(request, response);

		return "";
	}

	private void cadastra_fac(List<Dados> dados)
			throws ServletException, IOException {

		try {

			for (int i = 0; i < dados.size(); i++) {

				Clientes c = new Clientes();
				c.setCodigo(dados.get(i).getCodigo());
				
				String Data2 =dados.get(i).getDate().substring(0, 10); 
				
				SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");
				
				
				
								
				Date dt = in.parse(Data2);
				
				System.out.println(dt);
				Date dt_hist = SDF.parse(dados.get(i).getData_hist());
				Facturation f = new Facturation();

				f.setIndice(dados.get(i).getMeasuring());
				f.setCliente(c);
				f.setLocaligacao(dados.get(i).getLocalizacao());
				f.setData_levant(dt);
				f.setNum_medidor(dados.get(i).getMeasure());
				f.setDesmontagem(dados.get(i).getHaDesmontagem());
				f.setTeve_desmontagem(dados.get(i).getHouveDesmontagem());
				f.setVazamento(dados.get(i).getHaVazamento());
				f.setTeve_vazamento(dados.get(i).getHouveVazamento());
				f.setMedidor_bloqueado(dados.get(i).getMedidorBloqueado());
				f.setRetorno_agua(dados.get(i).getRetornoAgua());
				f.setData_hist(dt_hist);
				f.setIndice_antigo(dados.get(i).getIndice_antigo());
				f.setConsumo(dados.get(i).getConsumo());

				new FacturationDao().gravar(f);

			}

			
		} catch (Exception ex) {
			
			ex.printStackTrace();

		}

	}

}