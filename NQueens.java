import java.util.*;

public class NQueens
{
    private int[][] board;
    private int size;

    public NQueens (int n)
    {
        if (n >= 0)
        {
            size = n;
            board = new int[size][size];
        }
    }

    private boolean Qcheck(int row, int col)
    {
        //Horizontal check
        for(int c = 0; c < size; c++)
        {
            if(board[row][c] == 1)
            {
                return false;
            }
        }

        //Vertical check
        for(int r = 0; r < size; r++)
        {
            if(board[r][col] == 1)
            {
                return false;
            }
        }

        //Diagonal check
        for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 1){
                return false;
            }
        }
        for (int r = row, c = col; r >= 0 && c < size; r--, c++) {
            if (board[r][c] == 1) {
                return false;
            }
        }

        return true;
    }

    private boolean placeNQueens(int row)
    {
        if(row == size)
        {
            printToConsole();
            return true;
        }

        for(int i = 0; i < size; i++)
        {
            if(Qcheck(row, i))
            {
                board[row][i] = 1;

                if(placeNQueens(row + 1))
                {
                    return true;
                }
                else
                {
                    board[row][i] = 0;
                }
            }
        }

        return false;
    }

    public boolean placeNQueens() throws Exception
    {
        if(size <= 0)
        {
            throw new Exception();
        }

        return placeNQueens(0);
    }

    public void printToConsole()
    {
        String consoleBoard = " ";
        for(int i = 0; i < size; i++)
        {
            consoleBoard += "=";
            if(i > 0)
            {
                consoleBoard += "==";
            }
        }

        consoleBoard += "\n";

        for(int row = 0; row < size; row++)
        {
            consoleBoard += "|";
            for(int col = 0; col < size; col++)
            {
                if(board[row][col] == 1)
                {
                    consoleBoard += "Q";
                }
                else
                {
                    consoleBoard += "-";
                }

                if(col < size - 1)
                {
                    consoleBoard += "  ";
                }
            }

            consoleBoard += "|\n";
        }

        consoleBoard += " ";

        for(int i = 0; i < size; i++)
        {
            consoleBoard += "=";
            if(i > 0)
            {
                consoleBoard += "==";
            }
        }


        System.out.println(consoleBoard);
    }
}
