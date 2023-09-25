/*
  Nama : Rizal Dwi Anggoro
  NIM  : L0122142
 */

/*
  file utama berupa:
  - ui/menu dari aplikasi Pencatatan Buah dan Sayur.
 */

import java.util.Scanner;

public class PPBO_03_L0122142 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Logic logic = new Logic();

    while (true) {
      int option = printMainMenu(scanner);

      if (option == 1) addFruitOrVegetable(scanner, logic);
      else if (option == 2) {
        showAllFruit(logic);
        enterToContinue(scanner);
      } else if (option == 3) {
        showAllVegetable(logic);
        enterToContinue(scanner);
      } else {
        System.out.println("\nKeluar program...");
        break;
      }
    }

    scanner.close();
  }

  /*
    method untuk menampilkan daftar sayur ke console
    menggunakan perulangan.
   */
  private static void showAllVegetable(Logic logic) {
    if (logic.getArrayListVegetable().isEmpty()) {
      System.out.println("\n[Belum ada data sayur]");
      return;
    }

    System.out.println("\nDaftar Sayur\n");
    System.out.printf("%-4s %s\n", "No", "Nama");

    int num = 1;
    for (Vegetable vegetable : logic.getArrayListVegetable()) {
      System.out.printf("%3d. %s\n", num, vegetable.getName());
      num++;
    }
  }

  /*
    method untuk menampilkan daftar buah ke console
    menggunakan perulangan.
   */
  private static void showAllFruit(Logic logic) {
    if (logic.getArrayListFruit().isEmpty()) {
      System.out.println("\n[Belum ada data buah]");
      return;
    }

    System.out.println("\nDaftar Buah\n");
    System.out.printf("%-4s %s\n", "No", "Nama");

    int num = 1;
    for (Fruit fruit : logic.getArrayListFruit()) {
      System.out.printf("%3d. %s\n", num, fruit.getName());
      num++;
    }
  }

  /*
    method: mengatur ui/menu untuk memasukkan input user.
   */
  private static void addFruitOrVegetable(
      Scanner scanner,
      Logic logic
  ) {
    System.out.println("\nTambah Buah atau Sayur\n");

    System.out.println("Petunjuk:");
    System.out.println("- Masukkan nama buah atau sayur diawali dengan");
    System.out.println("  kata kunci \"buah\" atau \"sayur\".");
    System.out.println("- Gunakan kata kunci \"exit\" untuk keluar dari");
    System.out.println("  perulangan.\n");

    boolean isFinished = false;

    // perulangan untuk meminta masukan dari user
    // sekaligus melakukan pengecekan masukan dari user
    while (!isFinished) {
      System.out.print(">> ");
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("exit"))
        isFinished = true;
      else {
        try {
          // memanggil logic untuk melakukan validasi input dari user
          final CheckResult result = logic.checkInput(input);
          if (result == CheckResult.VALID_FRUIT) {
            String name = logic.addFruit(input);
            System.out.printf("   Berhasil menambahkan buah \"%s\"\n", name);
          } else if (result == CheckResult.VALID_VEGETABLE) {
            String name = logic.addVegetable(input);
            System.out.printf("   Berhasil menambahkan sayur \"%s\"\n", name);
          } else
            throw new Exception("Masukan yang Anda berikan tidak valid!");
        } catch (Exception e) {
          // menangani error input yang mungkin terjadi
          System.out.printf("   Error: %s\n", e.getMessage());
        }
      }
    }
  }

  private static int printMainMenu(Scanner scanner) {
    System.out.println("\nPencatatan Buah dan Sayur\n");
    System.out.println("1. Tambah buah/sayur");
    System.out.println("2. Lihat daftar buah");
    System.out.println("3. Lihat daftar sayur");
    System.out.println("4. Keluar program");

    System.out.print(">> ");
    int option = scanner.nextInt();
    scanner.nextLine();

    return option;
  }

  private static void enterToContinue(Scanner scanner) {
    System.out.println("\nTekan <enter> untuk melanjutkan...");
    String a = scanner.nextLine();
  }
}
