import java.util.*;

public class NQueens
{
    private int[][] board;
    private int size;

    public NQueens (int n)
    {
        try
        {
            if (n > 0)
            {
                size = n;
                board = new int[size][size];
                for(int row = 0; row < size; row++)
                {
                    for(int col = 0; col < size; col++)
                    {
                        board[row][col] = 0;
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.print("The size of the board should at least be 1...");
        }
    }

    private int row = 0;
    private int col = 0;

    private boolean Qcheck_H(/*int row, int col*/)
    {
        for(int col = 0; col < size; col++)
        {
            if(board[row][col] == 1)
            {
                return false;
            }
        }
        return true;

//        if(board[row][col] == 1)
//        {
//            return false;
//        }
//        else if(col == size - 1)
//        {
//            return true;
//        }
//        else
//        {
//            return Qcheck_H(row, col++);
//        }
    }

    private boolean Qcheck_V(/*int row, int col*/)
    {
        for(int row = 0; row < size; row++)
        {
            if(board[row][col] == 1)
            {
                return false;
            }
        }
        return true;

//        if(board[row][col] == 1)
//        {
//            return false;
//        }
//        else if(row == size - 1)
//        {
//            return true;
//        }
//        else
//        {
//            return Qcheck_V(row++, col);
//        }
    }

    private boolean Qcheck_RDU(int row, int col)
    {
        for(int i = 0; i < size - col; i++)
        {
            if(board[row - i][col + i] == 1)
            {
                return false;
            }
        }
        return true;

//        if(board[row][col] == 1)
//        {
//            return false;
//        }
//        else if(col == size - 1)
//        {
//            return true;
//        }
//        else
//        {
//            return Qcheck_RDU(row--, col++);
//        }
    }

    private boolean Qcheck_RDD(int row, int col)
    {
        for(int i = 0; i < size - col; i++)
        {
            if(board[row + i][col - i] == 1)
            {
                return false;
            }
        }
        return true;

//        if(board[row][col] == 1)
//        {
//            return false;
//        }
//        else if(col == 0)
//        {
//            return true;
//        }
//        else
//        {
//            return Qcheck_RDD(row++, col--);
//        }
    }

    private boolean Qcheck_LDU(int row, int col)
    {
        for(int i = 0; i < col; i++)
        {
            if(board[row - i][col + i] == 1)
            {
                return false;
            }
        }
        return true;

//        if(board[row][col] == 1)
//        {
//            return false;
//        }
//        else if(col == 0)
//        {
//            return true;
//        }
//        else
//        {
//            return Qcheck_LDU(row--, col--);
//        }
    }

    private boolean Qcheck_LDD(int row, int col)
    {
        for(int i = 0; i < col; i++)
        {
            if(board[row + i][col - i] == 1)
            {
                return false;
            }
        }
        return true;

//        if(board[row][col] == 1)
//        {
//            return false;
//        }
//        else if(col == size - 1)
//        {
//            return true;
//        }
//        else
//        {
//            return Qcheck_LDD(row++, col++);
//        }
    }

    private boolean Qcheck_D(int row, int col)
    {
        return Qcheck_LDD(row, col) && Qcheck_LDU(row, col) &&
                Qcheck_RDD(row, col) && Qcheck_RDU(row, col);
    }

    private boolean Qcheck(int row, int col)
    {
        return Qcheck_H(/*row, 0*/) && Qcheck_V(/*0, col*/) && Qcheck_D(row, col);
    }

    private boolean boardFill()
    {
        int count = 0;
        for(int row = 0; row < size; row++)
        {
            for(int col = 0; col < size; col++)
            {
                if(board[row][col] == 1)
                {
                    count++;
                }
            }
        }

        if(count == size)
        {
            return true;
        }

        return false;
    }

    private boolean placeNQueens(int row, int col)
    {
        if(boardFill())
        {
            return true;
        }
        else if(row != size - 1)
        {
            if (Qcheck(row, col))
            {
                board[row][col] = 1;
                row++;
                return placeNQueens(row, col);
            }
            else
            {
                if(col == size - 1)
                {
                    return false;
                }
                else
                {
                    row--;
                    for (int i = 0; i < size; i++)
                    {
                        if (board[row][i] == 1)
                        {
                            board[row][i] = 0;
                        }
                    }
                    col++;
                    return placeNQueens(row, col);
                }
            }
        }

        return false;
    }

    public boolean placeNQueens()
    {
        printToConsole();
        return placeNQueens(row, col);
    }

    public void printToConsole()
    {
        String consoleBoard = "";

        for(int row = 0; row < size; row++)
        {
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

            consoleBoard += "\n";
        }

        System.out.println(consoleBoard);
    }
}
