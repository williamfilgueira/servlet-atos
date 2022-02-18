package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Cliente;
import model.Endereco;
import model.Fornecedor;

public class ConnectionJDBC {

//	parametros da conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/projetoc?user=root?useTimezone=true&serverTimezone=UTC";

	private String user = "root";
	private String password = "123321";

//	metodo de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Estou funfando");
			return con;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Estou morto");
			return null;
		}
	}
//	teste de conexão

	public void testeConexão() {
		try {
			Connection con = conectar();
			System.out.println("Bom dia!");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	método create cliente
	public void newClient(Cliente cliente, Endereco endereco) {
		String createAdress = "insert into endereco(cep,rua, numero, complemento) values (?,?,?,?)";
		String createClient = "insert into cliente(nome, id_endereco,cpf, fone, email) values (?,?,?,?,?)";
//		String innerAdressAndClient = "SELECT `cliente`.* FROM `cliente`"
//				+ "  INNER JOIN `endereco` ON `cliente`.`id_endereco` = `endereco`.`id`"
//				+ "  ORDER BY `cliente`.`nome`;";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(createAdress);
			pst.setInt(1, endereco.getCep());
			pst.setString(2, endereco.getRua());
			pst.setInt(3, endereco.getNumero());
			pst.setString(4, endereco.getComplemento());

			pst.executeUpdate();

			PreparedStatement pst2 = con.prepareStatement(createClient);
			pst2.setString(1, cliente.getNome());
			pst2.setInt(2, endereco.getId());
			pst2.setString(3, cliente.getCpf());
			pst2.setString(4, cliente.getFone());
			pst2.setString(5, cliente.getEmail());
			pst2.executeUpdate();

//			PreparedStatement pst3 = con.prepareStatement(innerAdressAndClient);
//			pst3.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	crud read cliente

	public ArrayList<Cliente> listarClientes() {
		ArrayList<Cliente> cliente = new ArrayList<>();

		String read = "select id,nome,cpf,fone,email from cliente order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String fone = rs.getString(4);
				String email = rs.getString(5);

				cliente.add(new Cliente(id, nome, cpf, fone, email));
			}
			con.close();
			return cliente;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void selecionarCliente(Cliente cliente) {
		String read2 = "select * from cliente where id=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, cliente.getId());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				cliente.setId(rs.getString(1));
				cliente.setNome(rs.getString(2));
				cliente.setCpf(rs.getString(3));
				cliente.setFone(rs.getString(4));
				cliente.setEmail(rs.getString(5));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void editarCliente(Cliente cliente) {
		String create = "update cliente set nome=?, cpf=?, fone=?, email? where id=?";
		try {

		} catch (Exception e) {

		}
	}

//	fornecedor 

	public ArrayList<Fornecedor> listarFornecedores() {
		ArrayList<Fornecedor> fornecedor = new ArrayList<>();

		String read = "select id,nome,cnpj,fone,email from fornecedor order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String cnpj = rs.getString(3);
				String fone = rs.getString(4);
				String email = rs.getString(5);

				fornecedor.add(new Fornecedor(id, nome, cnpj, fone, email));
			}
			con.close();
			return fornecedor;
//272202181032930
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void novoFornecedor(Fornecedor fornecedor, Endereco endereco) {
		String createAdress = "insert into endereco(cep,rua, numero, complemento) values (?,?,?,?)";
		String createFornecedor = "insert into fornecedor(nome, id_endereco,cnpj, fone, email) values (?,?,?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(createAdress);
			pst.setInt(1, endereco.getCep());
			pst.setString(2, endereco.getRua());
			pst.setInt(3, endereco.getNumero());
			pst.setString(4, endereco.getComplemento());

			pst.executeUpdate();

			PreparedStatement pst2 = con.prepareStatement(createFornecedor);
			pst2.setString(1, fornecedor.getNome());
			pst2.setInt(2, endereco.getId());
			pst2.setString(3, fornecedor.getCnpj());
			pst2.setString(4, fornecedor.getFone());
			pst2.setString(5, fornecedor.getEmail());
			pst2.executeUpdate();

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
