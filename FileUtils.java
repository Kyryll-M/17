import java.io.*;
import java.util.Scanner;

public class FileUtils {
    public static String[] loadConfig(String filename) {
        try {
            File f = new File(filename);
            if (!f.exists()) return null;
            Scanner s = new Scanner(f);
            String[] data = new String[3];
            data[0] = s.nextLine();
            data[1] = s.nextLine();
            data[2] = s.nextLine();
            s.close();
            return data;
        } catch (Exception e) {
            System.out.println("Помилка при завантаженні конфігурації.");
            return null;
        }
    }

    public static void saveWinStat(String filename, char symbol, int size, String winner) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write("Переможець: " + winner + ", Символ: " + symbol + ", Розмір: " + size + ", Час: " + java.time.LocalDateTime.now() + "\n");
        } catch (IOException e) {
            System.out.println("Не вдалося зберегти статистику.");
        }
    }

    public static void saveDrawStat(String filename, int size) {
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write("Результат: Нічия, Розмір: " + size + ", Час: " + java.time.LocalDateTime.now() + "\n");
        } catch (IOException e) {
            System.out.println("Не вдалося зберегти статистику.");
        }
    }

    public static void displayStats(String filename) {
        try {
            File f = new File(filename);
            if (!f.exists()) {
                System.out.println("Статистика відсутня.");
                return;
            }
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) System.out.println(s.nextLine());
            s.close();
        } catch (IOException e) {
            System.out.println("Помилка при читанні статистики.");
        }
    }

    public static void saveConfig(String filename, int boardSize, String player1, String player2) {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(boardSize + "\n");
            fw.write(player1 + "\n");
            fw.write(player2 + "\n");
        } catch (IOException e) {
            System.out.println("Не вдалося зберегти конфігурацію.");
        }
    }
}