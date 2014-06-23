import java.util.Scanner;
import java.io.File;

public class Mario
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int height = getHeight();

        while (height < 0 || height > 23)
        {
            System.out.print("\nThat's not between 0 and 23.  Try again: ");
            height = getHeight();
        }

        int consoleOrFile = getOutputType();

        while (consoleOrFile < 0 || consoleOrFile > 1)
        {
            System.out.print("\nThat's not a valid choice.  Try again: ");
            consoleOrFile = getOutputType();
        }

        drawPyramid(height);
        System.out.println(consoleOrFile);
    }

    public static int getHeight()
    {
        System.out.print("\nPlease enter the height of your pyramid, a whole number between 0 and 23: ");
        while (!sc.hasNextInt())
        {
            sc.nextLine();  // eats any invalid input to clear stream
            System.out.print("\nThat's not a valid entry! Try again: ");
        }

        return sc.nextInt();
    }

    public static int getOutputType()
    {
        System.out.print("\nDo you want to print the pyramid to the console or a text file? "
                + "Enter 1 for console or 2 for file: ");

        int consoleOrFile = 2;

        while (!sc.hasNextInt())
        {
            sc.nextLine();
            System.out.print("\nThat's not a valid entry! Try again: ");
        }

        return consoleOrFile;
    }

    public static void drawPyramid(int height)
    {
        int spaces;
        int hashes;

        for (int row = 0; row < height; row++)
        {
            for (spaces = 0; spaces < (height - row - 1); spaces++)
            {
                System.out.print(" ");
            }

            for (hashes = 0; ((hashes + spaces) <= height); hashes++)
            {
                if ((hashes + spaces) < height)
                    System.out.print("#");

                else
                    System.out.print("#\n");
            }

        }
    }
}
