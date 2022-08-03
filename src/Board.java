public class Board {
    public int NoOfPeoplePlaying;
    private Pieces[][] B;

    public Board(int NoOfPeoplePlaying) {
        if (B == null) {
            B = new Pieces[NoOfPeoplePlaying + 1][NoOfPeoplePlaying + 1];
        }
    }
    public int BoardSize()
    {
        return B.length * B.length;
    }


    public boolean putPieces(int x, int y, Player P) {
        if (B[x][y] != null) {
            return false;
        } else {
            B[x][y] = P.piece;
            return true;
        }
    }

    public boolean checkWinner(int x , int y , Pieces ofThatPlayer)
    {
//        if(ofThatPlayer.getChar() == B[0][0].getChar())
//        {
//            System.out.println("TRUE");
//        }
        boolean Diagonal = true;
        boolean Horizontal = true;
        boolean Vertical = true;
        boolean AntiDiagonal = true;
       // int count = 0;


            for (int i = 0; i < B.length; i++)
            {
                if (B[i][y] == null || B[i][y].getChar() != ofThatPlayer.getChar()) {
                    Vertical = false;
                }

            }




            for (int j = 0; j < B.length; j++) {
                if (B[x][j] == null || B[x][j].getChar() != ofThatPlayer.getChar()) {
                    Horizontal = false;
                }
            }



        for (int i = 0, j = 0; i < B.length; i++, j++) // Diagonal
        {
            if (B[i][j] == null  || B[i][j].getChar() != ofThatPlayer.getChar()) {
                Diagonal = false;
            }
        }

        for (int i = 0, j = B.length - 1; j >= 0; j--, i++) //Anti Diagonal
        {
            if (B[i][j] == null  || B[i][j].getChar() != ofThatPlayer.getChar()){
                AntiDiagonal = false;
            }
        }

        return (Diagonal || Vertical || AntiDiagonal || Horizontal);

    }
}
