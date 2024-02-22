package br.edu.senaisp.view;
 
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
 
import br.edu.senaisp.model.Funcionario;
 
	
	public class FuncionarioDetView extends JDialog {
 
		JLabel lblId = new JLabel("Id:");
		JTextField txtId = new JTextField(null, 20);
		JLabel lblNome = new JLabel("Nome:");
		JTextField txtNome = new JTextField(null, 20);
		JLabel lblCpf = new JLabel("Cpf:");
		JTextField txtCpf = new JTextField(null, 20);
		JButton btnGravar = new JButton("Gravar");
		JButton btnFechar = new JButton("Fechar");
		private Funcionario funcionarios = new Funcionario();
 
		public FuncionarioDetView() {
			this.setLayout(new FlowLayout()); 
			this.getContentPane().add(lblId);
			this.getContentPane().add(txtId);
 
			this.getContentPane().add(lblNome);
			this.getContentPane().add(txtNome);
 
			this.getContentPane().add(lblCpf);
			this.getContentPane().add(txtCpf);
 
			this.getContentPane().add(btnGravar); 
			this.getContentPane().add(btnFechar);
 
			btnGravar.addActionListener(new ActionListener() {
 
				@Override
				public void actionPerformed(ActionEvent e) {
 
					
					funcionarios.setId(Long.parseLong(txtId.getText()));
					funcionarios.setNome(txtNome.getText());
					funcionarios.setCpf(txtCpf.getText());
 
					//JOptionPane.showMessageDialog(rootPane, aluno.toString());
					hide();
 
				}
			});
			this.setModal(true);
			this.setSize(600, 480); 

		}
 
		public Funcionario getFuncionario() {
			return funcionarios;
		}
 
		public void setAluno(Funcionario funcionarios) {
			this.funcionarios = funcionarios;
		}
 
	}
 
