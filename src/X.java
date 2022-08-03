public class X implements Pieces
{
    public static int total_X_Used = 0;
    char forX = 'X';
    public X(){}

    @Override
    public char getChar() {
        return forX;
    }
}
