package br.edu.senaisp.view;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.edu.senaisp.dao.FuncionarioDao;
import br.edu.senaisp.model.Funcionario;


public class FuncionarioView extends JFrame{
 
		private JButton btNovo = new JButton("Novo");
		JLabel lblista = new JLabel("Lista de Funcionarios: ");
		JTextArea txtLista = new JTextArea();	
		private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		public FuncionarioView() {
			inicializar();
			acoes();
 
			FuncionarioDao dao = new FuncionarioDao();
			funcionarios = dao.lerFuncionarios();
			preencherFuncionario();
		}
		private void inicializar() {
 
			this.setLayout(null);
			this.btNovo.setBounds(50, 30, 150, 20);
			this.lblista.setBounds(50, 70, 300, 20);
			this.txtLista.setBounds(50, 90, 500, 160);
 
			this.getContentPane().add(btNovo);
			this.getContentPane().add(lblista);
			this.getContentPane().add(txtLista);
 
			this.setSize(800, 600);
			this.setVisible(true);
 
		}
		private void acoes() {
			btNovo.addActionListener(new ActionListener() {
 
				@Override
				public void actionPerformed(ActionEvent e) {
 
					FuncionarioDetView frm = new FuncionarioDetView();
					frm.show();
 
					Funcionario tmp = frm.getFuncionario();
					if (tmp != null) {
						funcionarios.add(tmp);
						FuncionarioDao dao = new FuncionarioDao();
						try {
							dao.gravarFuncionario(funcionarios);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(frm, e2.getMessage());
						}
 
					}
 
					preencherFuncionario();
				}
			});
		}
 
		private void preencherFuncionario() {
			txtLista.setText("");
			for (Funcionario funcionario : funcionarios) {
				txtLista.append(funcionario.getNome() + "[" + funcionario.getCpf() + "]");
				txtLista.append("\n");
			}
		}
 
 
	
	}


