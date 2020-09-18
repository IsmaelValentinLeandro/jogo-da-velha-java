package JogoDaVelha;



import java.util.Random;

class TicTacToe {
    public int DIRWIN;

    public int GAMEOVER;

    int bestr[] = new int[1];

    int bestc[] = new int[1];

    public static final int UNCLEAR = 0;

    public static final int HUMAN_WIN = 1;

    public static final int DRAW = 2;

    public static final int COMPUTER_WIN = 3;

    public final int HUMAN = 4;

    public final int HUMAN2 = 6;

    public final int COMPUTER = 5;

    public final int EMPTY = -1;

    public final int NO = -7;

    public final int YES = 7;

    public final int COMPUTADORxHUMANO = 8;

    public final int HUMANOxHUMANO = 9;

    public int tipoJogo, playerWin;

    Random r;

    int TURN;

    int MOVES;

    int[][] position;
    
    int count=0;


    TicTacToe() {
        

    }

    public void init_game(int tipoJogo) {
        /***********************************************************************
         * Inicializa as principais variaveis usadas no jogo.
         **********************************************************************/
        MOVES = 0;
        GAMEOVER = NO;
        DIRWIN = 8; //winning directions 0-7, 8 is not a winning direction
        r = new Random();
        this.tipoJogo = tipoJogo;
        if (tipoJogo == COMPUTADORxHUMANO) {
            TURN = HUMAN;
        }
        position = new int[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                position[i][j] = EMPTY;
    }

    public void win() {
        /***********************************************************************
         * Detecta se existe algum ganhador em qualquer umas das direcoes.
         **********************************************************************/
        for (int player = HUMAN2; player >= HUMAN; player--) {
            if (position[0][0] == player && position[0][1] == player
                    && position[0][2] == player) {
                DIRWIN = 0;
                playerWin = player;
            }
            if (position[1][0] == player && position[1][1] == player
                    && position[1][2] == player) {
                DIRWIN = 1;
                playerWin = player;
            }
            if (position[2][0] == player && position[2][1] == player
                    && position[2][2] == player){
                DIRWIN = 2;
                playerWin = player;
            }
            if (position[0][0] == player && position[1][0] == player
                    && position[2][0] == player) {
                DIRWIN = 3;
                playerWin = player;
            }
            if (position[0][1] == player && position[1][1] == player
                    && position[2][1] == player) {
                DIRWIN = 4;
                playerWin = player;
            }
            if (position[0][2] == player && position[1][2] == player
                    && position[2][2] == player) {
                DIRWIN = 5;
                playerWin = player;
            }
            if (position[0][0] == player && position[1][1] == player
                    && position[2][2] == player) {
                DIRWIN = 6;
                playerWin = player;
            }
            if (position[0][2] == player && position[1][1] == player
                    && position[2][0] == player) {
                DIRWIN = 7;
                playerWin = player;
            }
        } //final laco for
        if (DIRWIN != 8)
            GAMEOVER = YES;
        //Verifica se houve empate
        MOVES++;
        if (MOVES == 9)
            GAMEOVER = YES;      
    }

    public int[] movimentoCompudador() {
        /***********************************************************************
         * Chama o metodo miniMax para decidir o melhor movimento e armazena-lo
         * no array<ret>.
         **********************************************************************/
        Controle gs = new Controle(position);
        miniMax(gs, COMPUTER, HUMAN_WIN, COMPUTER_WIN, bestc, bestr);
        int ret[] = new int[2];
        position[bestr[0]][bestc[0]] = COMPUTER;
        win();
        TURN = COMPUTER;
        ret[0] = bestr[0];
        ret[1] = bestc[0];
        return ret;
    }

    public void setMovimentoJogador(int x, int y) {
        /***********************************************************************
         * Stores human move in array. Precondition: Call from plotMove in
         * applet. Postcondition: Human move stored and flag set for computer to
         * make move.
         **********************************************************************/
        if (position[x][y] == EMPTY) {
            if (tipoJogo == COMPUTADORxHUMANO) {
                position[x][y] = HUMAN;
                win();
                TURN = COMPUTER;
            } else {
                if (TURN == HUMAN) {
                    position[x][y] = HUMAN;
                    win();
                    TURN = HUMAN2;
                } else {
                    position[x][y] = HUMAN2;
                    win();
                    TURN = HUMAN;
                }
            }
        }
    }

    public int evaluate(Controle gs) {
        /***********************************************************************
         * Retorna o valor de um possivel movimento.
         * Chamado pelo metodo miniMax.
         * Retorna um valor que indica um dos possiveis movimentos:
         * humano ganha, computador ganha, jogo deu velha ou jogo ainda nao acabou
         **********************************************************************/
        int i, j;
        playerWin = UNCLEAR;
        for (i = 0; i < 3; i++) {
            if (temGanhador(gs.getPosicao(i, 0), gs
                    .getPosicao(i, 1), gs.getPosicao(i, 2))) {//vertical
                                                                          // win
                playerWin = retornaGanhador(gs.getPosicao(i, 0));
            } else if (temGanhador(gs.getPosicao(0, i), gs
                    .getPosicao(1, i), gs.getPosicao(2, i))) {//horizontal
                                                                          // win
                playerWin = retornaGanhador(gs.getPosicao(0, i));
            } else if (temGanhador(gs.getPosicao(0, 0), gs
                    .getPosicao(1, 1), gs.getPosicao(2, 2))) {//diagonal
                                                                          // win
                playerWin = retornaGanhador(gs.getPosicao(0, 0));
            } else if (temGanhador(gs.getPosicao(0, 2), gs
                    .getPosicao(1, 1), gs.getPosicao(2, 0))) {//diagonal
                                                                          // win
                playerWin = retornaGanhador(gs.getPosicao(0, 2));
            }
        }
        if (playerWin == UNCLEAR) {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    if (gs.getPosicao(i, j) == EMPTY) {
                        //Nao ha Ganhador, mas ha jogadas possiveis
                        return UNCLEAR;
                    }
                }
            }
            return DRAW; //Nao ha ganhador, deu Velha
        }
        return playerWin;
    }

    public int retornaGanhador(int playerWin) {
        int retPlayerWin = 0;

        if (playerWin == COMPUTER) {
            retPlayerWin = COMPUTER_WIN;
        } else if (playerWin == HUMAN) {
            retPlayerWin = HUMAN_WIN;
        } else if (playerWin == HUMAN2) {
            retPlayerWin = HUMAN_WIN;
        }
        return retPlayerWin;
    }

    public boolean temGanhador(int posValue1, int posValue2, int posValue3) {
        return ((posValue1 == posValue2) && (posValue2 == posValue3) && (posValue1 != EMPTY));
    }

    public int miniMax(Controle gs, int side, int alpha, int beta,
            int bestc[], int bestr[]) {
        /***********************************************************************
         * Procura o melhor movimento para o computador.
         * Chamado pelo metodo movimentoComputador.
         * Armazena os melhores movimentos em bestc e bestr
         **********************************************************************/
        int opp = 0;
        int reply = 0;
        int value = 0;
        int[] dc = new int[1];

        if (evaluate(gs) != UNCLEAR)
            return evaluate(gs); //base case

        if (side == COMPUTER) {
            opp = HUMAN;
            value = alpha;
        } else {
            opp = COMPUTER;
            value = beta;
        }

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (gs.getPosicao(row, col) == EMPTY) {
                	
                	
                    gs.setPosicao(row, col, side); //Tenta um movimento
                                                         // experimental
                    reply = miniMax(gs, opp, alpha, beta, dc, dc); //Chamada
                                                                   // Recursiva
                    gs.setPosicao(row, col, EMPTY); //Desfaz movimento
                                                          // experimental
                    
                    if (((side == COMPUTER) && (reply > value)) || //MAX
                            ((side == HUMAN) && (reply < value))) { //MIN
                        if (side == COMPUTER) { //Armazena melhor movimento do
                                                // computador
                            alpha = reply;
                            value = reply;
                        } else { //Armazena melhor movimento do jogador
                            beta = reply;
                            value = reply;
                        }                        
                        bestr[0] = row;
                        bestc[0] = col;
                        if (alpha >= beta)
                            return value;
                        
                        
                    } //if
                } //if
            } //for
        } //for
        return value;
    }
}
