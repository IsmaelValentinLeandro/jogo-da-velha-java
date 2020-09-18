package JogoDaVelha;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class Principal extends JFrame {

	private JPanel contentPane;
	private TicTacToe jogo = new TicTacToe();
	int tipoJogoEscolhido = jogo.COMPUTADORxHUMANO;
	private JButton bt01;
	private JButton bt02;
	private JButton bt03;
	private JButton bt04;
	private JButton bt05;
	private JButton bt06;
	private JButton bt07;
	private JButton bt08;
	private JButton bt09;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setType(Type.UTILITY);
		setTitle("Jogo da Velha\r\n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bt01 = new JButton("");
		bt01.setFont(new Font("Dialog", Font.BOLD, 23));
		bt01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ret[];
				if (jogo.position[0][0] == jogo.EMPTY) {
                	jogo.setMovimentoJogador(0, 0);
                	bt01.setText("X");
                	verificaGanho();
                    ret = jogo.movimentoCompudador();
                    jogaComputador(ret);
                    verificaGanho();
                }
			}
		});
		bt01.setBackground(Color.LIGHT_GRAY);
		bt01.setForeground(Color.GRAY);
		bt01.setBounds(10, 42, 68, 61);
		contentPane.add(bt01);
		
		bt02 = new JButton("");
		bt02.setFont(new Font("Dialog", Font.BOLD, 23));
		bt02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret[];
				if (jogo.position[0][1] == jogo.EMPTY) {
                	jogo.setMovimentoJogador(0, 1);
                	bt02.setText("X");
                	verificaGanho();
                    ret = jogo.movimentoCompudador();
                    jogaComputador(ret);
                    verificaGanho();
                }
			}
		});
		bt02.setBackground(Color.LIGHT_GRAY);
		bt02.setForeground(Color.GRAY);
		bt02.setBounds(88, 42, 68, 61);
		contentPane.add(bt02);
		
		bt03 = new JButton("");
		bt03.setFont(new Font("Dialog", Font.BOLD, 23));
		bt03.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret[];
				if (jogo.position[0][2] == jogo.EMPTY) {
                	jogo.setMovimentoJogador(0, 2);
                	bt03.setText("X");
                	verificaGanho();
                    ret = jogo.movimentoCompudador();
                    jogaComputador(ret);
                    verificaGanho();
                }
			}
		});
		bt03.setBackground(Color.LIGHT_GRAY);
		bt03.setForeground(Color.GRAY);
		bt03.setBounds(166, 42, 68, 61);
		contentPane.add(bt03);
		
		bt04 = new JButton("");
		bt04.setFont(new Font("Dialog", Font.BOLD, 23));
		bt04.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret[];
				if (jogo.position[1][0] == jogo.EMPTY) {
                	jogo.setMovimentoJogador(1, 0);
                	bt04.setText("X");
                	verificaGanho();
                    ret = jogo.movimentoCompudador();
                    jogaComputador(ret);
                    verificaGanho();
                }
			}
		});
		bt04.setBackground(Color.LIGHT_GRAY);
		bt04.setForeground(Color.GRAY);
		bt04.setBounds(10, 114, 68, 61);
		contentPane.add(bt04);
		
		bt05 = new JButton("");
		bt05.setFont(new Font("Dialog", Font.BOLD, 23));
		bt05.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret[];
				if (jogo.position[1][1] == jogo.EMPTY) {
                	jogo.setMovimentoJogador(1, 1);
                	bt05.setText("X");
                	verificaGanho();
                    ret = jogo.movimentoCompudador();
                    jogaComputador(ret);
                    verificaGanho();
                }
			}
		});
		bt05.setBackground(Color.LIGHT_GRAY);
		bt05.setForeground(Color.GRAY);
		bt05.setBounds(89, 114, 68, 61);
		contentPane.add(bt05);
		
		bt06 = new JButton("");
		bt06.setFont(new Font("Dialog", Font.BOLD, 23));
		bt06.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret[];
				if (jogo.position[1][2] == jogo.EMPTY) {
                	jogo.setMovimentoJogador(1, 2);
                	bt06.setText("X");
                	verificaGanho();
                    ret = jogo.movimentoCompudador();
                    jogaComputador(ret);
                    verificaGanho();
                }
			}
		});
		bt06.setBackground(Color.LIGHT_GRAY);
		bt06.setForeground(Color.GRAY);
		bt06.setBounds(166, 114, 68, 61);
		contentPane.add(bt06);
		
		bt07 = new JButton("");
		bt07.setFont(new Font("Dialog", Font.BOLD, 23));
		bt07.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret[];
				if (jogo.position[2][0] == jogo.EMPTY) {
                	jogo.setMovimentoJogador(2, 0);
                	bt07.setText("X");
                	verificaGanho();
                    ret = jogo.movimentoCompudador();
                    jogaComputador(ret);
                    verificaGanho();
                }
			}
		});
		bt07.setBackground(Color.LIGHT_GRAY);
		bt07.setForeground(Color.GRAY);
		bt07.setBounds(10, 186, 68, 61);
		contentPane.add(bt07);
		
		bt08 = new JButton("");
		bt08.setFont(new Font("Dialog", Font.BOLD, 23));
		bt08.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret[];
				if (jogo.position[2][1] == jogo.EMPTY) {
                	jogo.setMovimentoJogador(2, 1);
                	bt08.setText("X");
                	verificaGanho();
                    ret = jogo.movimentoCompudador();
                    jogaComputador(ret);
                    verificaGanho();
                }
			}
		});
		bt08.setBackground(Color.LIGHT_GRAY);
		bt08.setForeground(Color.GRAY);
		bt08.setBounds(88, 186, 68, 61);
		contentPane.add(bt08);
		
		bt09 = new JButton("");
		bt09.setFont(new Font("Dialog", Font.BOLD, 23));
		bt09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret[];
				if (jogo.position[2][2] == jogo.EMPTY) {
                	jogo.setMovimentoJogador(2, 2);
                	bt09.setText("X");
                	verificaGanho();
                    ret = jogo.movimentoCompudador();
                    jogaComputador(ret);
                    verificaGanho();
                }
			}
		});
		bt09.setBackground(Color.LIGHT_GRAY);
		bt09.setForeground(Color.GRAY);
		bt09.setBounds(166, 186, 68, 61);
		contentPane.add(bt09);
		
		JLabel lblNewLabel = new JLabel("Grupo: Ismael Valentin");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 22, 224, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIntelignciaArtificial = new JLabel("Intelig\u00EAncia artificial");
		lblIntelignciaArtificial.setForeground(Color.DARK_GRAY);
		lblIntelignciaArtificial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblIntelignciaArtificial.setBounds(10, 11, 224, 14);
		contentPane.add(lblIntelignciaArtificial);
		
		
		jogo.init_game(tipoJogoEscolhido);
		
	}
	
	public void reiniciaJogo(){
		jogo = new TicTacToe();
		jogo.init_game(tipoJogoEscolhido);
		bt01.setText("");
		bt02.setText("");
		bt03.setText("");
		bt04.setText("");
		bt05.setText("");
		bt06.setText("");
		bt07.setText("");
		bt08.setText("");
		bt09.setText("");
	}
	
	public void verificaGanho(){
		if (jogo.GAMEOVER == jogo.YES) {
			if (jogo.playerWin == jogo.HUMAN) {
			    JOptionPane.showMessageDialog(this, "Você ganhou", "Jogo da Velha", JOptionPane.INFORMATION_MESSAGE);
			} else if (jogo.playerWin == jogo.COMPUTER) {
			    JOptionPane.showMessageDialog(this, "Você perdeu!", "Jogo da Velha", JOptionPane.INFORMATION_MESSAGE);
			} else {
			    JOptionPane.showMessageDialog(this, "Empatou!", "Jogo da Velha", JOptionPane.INFORMATION_MESSAGE);
			}
			reiniciaJogo();
		}
	}
	
	public void jogaComputador(int[] ret) {
		int linha=ret[0];
		int coluna=ret[1];
		if(linha==0 &&coluna==0) bt01.setText("O"); 
		if(linha==0 &&coluna==1) bt02.setText("O"); 
		if(linha==0 &&coluna==2) bt03.setText("O"); 
		if(linha==1 &&coluna==0) bt04.setText("O"); 
		if(linha==1 &&coluna==1) bt05.setText("O");
		if(linha==1 &&coluna==2) bt06.setText("O");
		if(linha==2 &&coluna==0) bt07.setText("O");
		if(linha==2 &&coluna==1) bt08.setText("O");
		if(linha==2 &&coluna==2) bt09.setText("O");		
	}
}
