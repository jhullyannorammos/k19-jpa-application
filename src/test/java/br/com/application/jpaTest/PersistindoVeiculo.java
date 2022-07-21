package br.com.application.jpaTest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.com.application.model.motors.Endereco;
import br.com.application.model.enumerator.TipoCombustivel;
import br.com.application.model.motors.Acessorio;
import br.com.application.model.motors.Automovel;
import br.com.application.model.motors.AutomovelId;
import br.com.application.model.motors.Proprietario;
import br.com.application.persistence.util.JpaUtil;

public class PersistindoVeiculo {

	public void ExcluindoVeiculo() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Automovel veiculo = manager.find(Automovel.class, 1L);
		manager.remove(veiculo);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

	public void AtualizandoVeiculo() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		Automovel veiculo = manager.find(Automovel.class, 1L);
		System.out.println("Valor atual: " + veiculo.getValor());
		veiculo.setValor(veiculo.getValor().add(new BigDecimal(500)));
		System.out.println("Novo valor: " + veiculo.getValor());
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

	public void listandoVeiculos(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Query query = manager.createQuery("from Veiculo");
		List<Automovel> veiculos = query.getResultList();
		for (Automovel veiculo : veiculos) {
			System.out.println(veiculo.getId() + " - " + veiculo.getFabricante() + " " + veiculo.getModelo() + ", ano "
					+ veiculo.getAnoFabricacao() + "/" + veiculo.getAnoModelo() + " por " + "R$" + veiculo.getValor());

		}
		manager.close();
		JpaUtil.close();
	}

	public void buscando() {
		EntityManager manager = JpaUtil.getEntityManager();
		Automovel veiculo = manager.find(Automovel.class, 1L);
		System.out.println("Veículo de código " + veiculo.getId() + " é um " + veiculo.getModelo());
		manager.close();
		JpaUtil.close();
	}

	public void reference() {
		EntityManager manager = JpaUtil.getEntityManager();
		Automovel veiculo = manager.getReference(Automovel.class, 1L);
		System.out.println("Veículo de código " + veiculo.getId() + " é um " + veiculo.getModelo());
		manager.close();
		JpaUtil.close();
	}
	
	public void ExibindoImagem() throws IOException {
		EntityManager manager = JpaUtil.getEntityManager();
		Automovel veiculo = manager.find(Automovel.class, 16L);
		
		if (veiculo.getFoto() != null) {
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(veiculo.getFoto()));
			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
		}else {
			System.out.println("Veículo não possui foto.");
		}
		
		manager.close();
		JpaUtil.close();
	}

	public void PersistindoVeiculo() throws IOException {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Automovel veiculo = new Automovel();
		
		Proprietario proprietario = new Proprietario();
		proprietario.setNome("João das Couves");
		proprietario.getTelefones().add("(34) 1234-5678");
		proprietario.getTelefones().add("(11) 9876-5432");
		proprietario.getEnderecos().add(new Endereco("ttttt yyyyy qqqqq", "999", "85410235"));
		proprietario.getEnderecos().add(new Endereco("ttttt yyyyy uuuuu", "888", "85410255"));
		
		Path path = FileSystems.getDefault().getPath("C:/veiculos/ford_mustang.jpg");
		byte[] foto = Files.readAllBytes(path);
		
		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");
		
		
		// instancia acessórios
		Acessorio alarme = new Acessorio();
		alarme.setDescricao("Alarme");
		Acessorio arCondicionado = new Acessorio();
		arCondicionado.setDescricao("Ar condicionado");
		Acessorio bancosDeCouro = new Acessorio();
		bancosDeCouro.setDescricao("Bancos de couro");
		Acessorio direcaoHidraulica = new Acessorio();
		direcaoHidraulica.setDescricao("Direção hidráulica");
		
		manager.persist(alarme);
		manager.persist(arCondicionado);
		manager.persist(bancosDeCouro);
		manager.persist(direcaoHidraulica);
		
		veiculo.getAcessorios().add(arCondicionado);
		veiculo.getAcessorios().add(alarme);
		veiculo.getAcessorios().add(bancosDeCouro);
		veiculo.getAcessorios().add(direcaoHidraulica);
		
		veiculo.setEspecificacoes(especificacoes.toString());
		veiculo.setProprietario(proprietario);
		veiculo.setFabricante("Honda");
		veiculo.setAutomovelId(new AutomovelId("ABC-1234", "Uberlândia"));
		veiculo.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		// veiculo.setModelo("Civic");
		veiculo.setAnoFabricacao(2012);
		veiculo.setAnoModelo(2013);
		veiculo.setValor(new BigDecimal(71300));
		veiculo.setDataCadastro(new Date());
		veiculo.setFoto(foto);
		
		manager.persist(veiculo);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
