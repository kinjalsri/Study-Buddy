package main;

import main.models.Timer;
import main.services.TimerService;
import main.services.MusicService;
import main.services.ToDoService;
import main.services.FocusModeService;
import main.services.ThemesService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimerService timerService = new TimerService();
        MusicService musicService = new MusicService();
        ToDoService toDoService = new ToDoService();
        FocusModeService focusModeService = new FocusModeService();
        ThemesService themeService = new ThemesService();

        while (true) {
            System.out.println("\n📚 VIRTUAL STUDY ROOM MENU");
            System.out.println("1️⃣ Start Study Timer");
            System.out.println("2️⃣ Stop Study Timer");
            System.out.println("3️⃣ Play Lo-Fi Music");
            System.out.println("4️⃣ Play YouTube Music");
            System.out.println("5️⃣ Stop Music");
            System.out.println("6️⃣ Skip Lo-Fi Song");
            System.out.println("7️⃣ Add Task");
            System.out.println("8️⃣ Mark Task as Complete");
            System.out.println("9️⃣ View All Tasks");
            System.out.println("🔟 Enable Focus Mode");
            System.out.println("1️⃣1️⃣ Disable Focus Mode");
            System.out.println("1️⃣2️⃣ Change Theme");
            System.out.println("0️⃣ Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter timer duration (minutes) (5,10,20,25,30,50): ");
                    int duration = scanner.nextInt();
                    timerService.startTimer(new Timer(duration));
                    break;
                case 2:
                    timerService.stopTimer();
                    break;
                case 3:
                    musicService.playLoFi();
                    break;
                case 4:
                    System.out.print("Enter YouTube playlist link: ");
                    String link = scanner.nextLine();
                    musicService.playLoFi();
                    break;
                case 5:
                    musicService.stopMusic();
                    break;
                case 6:
                    musicService.skipSong();
                    break;
                case 7:
                    System.out.print("Enter task name: ");
                    String task = scanner.nextLine();
                    toDoService.addTask(task);
                    break;
                case 8:
                    System.out.print("Enter task name to mark complete: ");
                    String taskName = scanner.nextLine();
                    toDoService.completeTask(taskName);
                    break;
                case 9:
                    toDoService.showTasks();
                    break;
                case 10:
                    focusModeService.enableFocusMode();
                    break;
                case 11:
                    focusModeService.disableFocusMode();
                    break;
                case 12:
                    System.out.print("Choose Theme (Chill, Dark Academia, Beach): ");
                    String theme = scanner.nextLine();
                    themeService.setTheme(theme);
                    themeService.showCurrentTheme();
                    break;
                case 0:
                    System.out.println("🚪 Exiting Virtual Study Room...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }
}
