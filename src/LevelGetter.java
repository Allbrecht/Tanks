import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LevelGetter {
    public int WIDTH;
    public int HEIGHT;

    public int[][] getLevel(int level_number){
        String str_level_number = String.valueOf(level_number);

        int height = 0;
        int width;
        try {
            Scanner scanner = new Scanner(new File("Levels/"+str_level_number+".txt")); //fixed poziom
            String tmp = scanner.nextLine();
            tmp = tmp.replace(" ","");
            width = tmp.length();

            while (scanner.hasNextLine()){
                height++;
                scanner.nextLine();
            }
            scanner.close();


            int[][] level = new int[height][width];

            scanner = new Scanner(new File("Levels/"+str_level_number+".txt"));
            for(int w = 0;w<height;w++){
                for(int d = 0;d<width;d++){
                    level[w][d] =scanner.nextInt();
                }}
            scanner.close();

            HEIGHT = height;
            WIDTH = width;
            System.out.println(height + " " + width);
            for (int h =0; h<height;h++){
                for (int w=0; w<width;w++){
                    System.out.print(level[h][w]);
                }
                System.out.println();
            }
            return level;
        }
        catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku z poziomem");
            e.printStackTrace();
            return null;
        }
    }
}

