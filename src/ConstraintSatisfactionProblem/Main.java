package ConstraintSatisfactionProblem;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    /**
     * The problem we are solving.
     */
    public Sudoku sudoku;

    /**
     * The initial assignment state.
     */
    public Assignment initial = Assignment.blank();

    /**
     * Setup from an input file.
     */
    public Main(String filename)
    {
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            int boardSize = new Integer(in.readLine());
            sudoku = new Sudoku(boardSize);

            List<Variable> vars = sudoku.variables();
            int numInputs = new Integer(in.readLine());

            Pattern p = Pattern.compile("^(\\d+)\\s+(\\d+)\\s+(\\d+)$");

            // Assign all the values
            for(int i = 0; i < numInputs; i++)
            {
                String input = in.readLine();
                Matcher m = p.matcher(input);
                if(m.matches())
                {
                    int row = new Integer(m.group(1));
                    int col = new Integer(m.group(2));
                    Integer val = new Integer(m.group(3));

                    // Assign the variable and trigger any inference that is required.
                    Variable var = vars.get(row * boardSize + col);
                    initial = initial.assign(var, val);
                    initial = sudoku.inference(initial, var);

                }
                else
                {
                    System.out.println("Bad input on line " + (i + 3) + ". Ignoring.");
                }
            }

            // Done
            in.close();

        }
        catch(IOException e)
        {
            System.out.println("Failed to load input file. Using defaults.");
            initial = Assignment.blank();
            sudoku = new Sudoku(9);
        }
    }

    public static void main(String[] args)
    {
        Main m = new Main(System.getProperty("user.dir") + "/resources/sodoku1.txt"); // D:\Unibraw\Materi Kuliah\NetBeansProjects\KB\src\ConstraintSatisfactionProblem\sodoku1.txt

        System.out.println("Initial:");
        m.represent(m.sudoku.variables(), m.initial);

        Assignment solution = m.solve();

        if(solution == null)
        {
            System.out.println("Failed to find a solution!");
            System.exit(1);
        }
        System.out.println("Solution:");
        m.represent(m.sudoku.variables(), solution);

    }

    public Assignment solve()
    {
        Backtrack solve = new Backtrack(sudoku, initial);
        return solve.solve();
    }

    public void represent(@NotNull List<Variable> vars, @NotNull Assignment assignment)
    {
        int s4 = (int) Math.round(Math.pow(vars.size(), 1f / 4f));
        int idx = -1;
        for(int i = -1, is = s4, js = s4, ks = s4, ls = s4; ++i < is; )
        {
            for(int j = -1; ++j < js; )
            {
                for(int k = -1; ++k < ks; )
                {
                    System.out.printf("%c", ' ');

                    for(int l = -1; ++l < ls; )
                    {
                        int val = -1;
                        try
                        {
                            val = ((Integer) assignment.getValue(vars.get(++idx)));
                        }
                        catch(NullPointerException ignored)
                        {
                        }
                        if(val == -1)
                        {
                            System.out.printf("%2s ", "..");
                        }
                        else
                        {
                            System.out.printf("%2d ", val);
                        }
                    }
                    if((k + 1) != ks)
                    {
                        System.out.printf("%c", '│');
                    }
                }
                System.out.println();
            }
            if((i + 1) != is)
            {
                for(int k = -1; ++k < ks; )
                {
                    System.out.printf("%c", '─');
                    for(int l = -1; ++l < ls; )
                    {
                        System.out.printf("%s", "───");
                    }
                    if((k + 1) != ks)
                    {
                        System.out.printf("%c", '┼');
                    }
                }
                System.out.println();
            }
        }
    }
}
