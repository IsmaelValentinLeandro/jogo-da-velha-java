package JogoDaVelha;

public class Controle {
	
	public int tabuleiro[][] = new int[3][3];
	
	public Controle(int[][] tabuleiro)
	{
		this.tabuleiro = tabuleiro;
	}
	
	public int getPosicao(int i, int j)
	{
		return (tabuleiro[i][j]);
	}
	
	public void setPosicao(int i, int j, int valor)
	{
		tabuleiro[i][j] = valor;
	}
	
}
