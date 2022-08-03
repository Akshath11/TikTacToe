import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {
    private Deque<Player> players ;
    Board BoardGame ;
    void Game() {
        StartInitialization();
    }


    public void StartInitialization()
    {
        Scanner sc = new Scanner(System.in);
        int NoOfPlayers = sc.nextInt();
        BoardGame = new Board(NoOfPlayers);
        System.out.println("BOARD FOR " + NoOfPlayers + " Initialized.");
        players = new LinkedList<>();
        while(NoOfPlayers --> 0)
        {
            System.out.println("Please enter name of Player " + NoOfPlayers);
            String Name = sc.next();
            String Key = sc.next();
            Pieces piece = ourPiece(Key);
            players.add(new Player(piece , Name));

        }
        System.out.println(BoardGame.BoardSize());
        System.out.println("All looks good , please click PLAY GAME to start the game");
    }
    void PlayGame()
    {
        Scanner sc = new Scanner(System.in);
        boolean Winner = false;
        int total_spaces_in_board = 0;
        while(Winner != true)
        {

            Player playerChance = players.pop();
            System.out.println("Please place the Piece " + playerChance.Name);

            int x = sc.nextInt();
            int y = sc.nextInt();

            boolean ifWeCanPut = BoardGame.putPieces(x,y,playerChance);
            while(ifWeCanPut == false)
            {
                System.out.println("Place is already Occupied , Please try again");
                 x = sc.nextInt();
                 y = sc.nextInt();
                ifWeCanPut = BoardGame.putPieces(x,y,playerChance);

            }
            if(ifWeCanPut)
            {
                total_spaces_in_board++;
                System.out.println("Piece Placed");
            }

            boolean isAnyWinner = BoardGame.checkWinner(x , y , playerChance.piece);
            if(isAnyWinner)
            {
                Winner = true;
                System.out.println("We have a winner , Congratulations " + playerChance.Name );
                continue;
            }
            if(total_spaces_in_board >= BoardGame.BoardSize())
            {
                System.out.println("It is a tie");
                break;
            }

            players.add(playerChance);
        }

    }

    private static Pieces ourPiece(String Key)
    {
        Pieces p ;
        if(Key.equals("X"))
        {
            p = new X();
            return p;
        }
        else
        {
            p = new O();
            return p;
        }
    }
}
