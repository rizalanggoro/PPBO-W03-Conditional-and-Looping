/*
  file business logic dari program Pencatatan Buah dan Sayur.
 */

import java.util.ArrayList;

public class Logic {
  // dua buah array kosong sebagai tempat menyimpan catatan
  // buah dan sayur
  private final ArrayList<Fruit> arrayListFruit = new ArrayList<>();
  private final ArrayList<Vegetable> arrayListVegetable = new ArrayList<>();

  /*
    method atau logika untuk mengecek input yang dimasukkan oleh user.
    method ini dapat mengembalikan 1 diantara 3 state:
    - valid_fruit (valid untuk input buah)
    - valid_vegetable (valid untuk input sayur)
    - invalid (tidak valid untuk keduanya)
   */
  public CheckResult checkInput(String input) {
    // mengecek apakah input mengandung keyword "buah"
    if (input.toLowerCase().contains("buah")) {
      /*
        memastikan bahwa keyword "buah" terdapat di awal input
        contoh: - buah mangga (valid)
                - mangga buah (tidak valid)
       */
      if (input.toLowerCase().indexOf("buah") == 0)
        return CheckResult.VALID_FRUIT;

      // mengecek apakah input mengandung keyword "sayur"
    } else if (input.toLowerCase().contains("sayur")) {
      // memastikan bahwa keyword "sayur" terdapat di awal input
      if (input.toLowerCase().indexOf("sayur") == 0)
        return CheckResult.VALID_VEGETABLE;
    }

    return CheckResult.INVALID;
  }

  /*
    method untuk menambahkan buah ke dalam array list buah.
    method ini akan melempar sebuah exception ketika nama buah
    yang dimasukkan tidak empty/blank.
   */
  public String addFruit(String input) throws Exception {
    String name = getFruitOrVegetableName(input);
    if (name == null)
      throw new Exception("Nama buah tidak boleh kosong!");

    this.arrayListFruit.add(new Fruit(name));
    return name;
  }

  /*
    method untuk menambahkan sayur ke dalam array list sayur.
    method ini akan melempar sebuah exception ketika nama sayur
    yang dimasukkan tidak empty/blank.
   */
  public String addVegetable(String input) throws Exception {
    String name = getFruitOrVegetableName(input);
    if (name == null)
      throw new Exception("Nama sayur tidak boleh kosong!");

    this.arrayListVegetable.add(new Vegetable(name));
    return name;
  }

  public ArrayList<Fruit> getArrayListFruit() {
    return this.arrayListFruit;
  }

  public ArrayList<Vegetable> getArrayListVegetable() {
    return this.arrayListVegetable;
  }

  /*
    method untuk mengecek, apakah nama buah/sayur tidak empty/blank.
    - ketika nama buah/sayur empty/blank, method ini akan mengembalikan null.
    - ketika nama buah/sayur tidak empty/blank, method akan mengembalikan nama
      buah/sayur tersebut tanpa kata kunci "buah"/"sayur".
   */
  private String getFruitOrVegetableName(String input) {
    int firstSpaceIndex = input.indexOf(" ");
    if (firstSpaceIndex == -1) return null;

    String name = input.substring(firstSpaceIndex + 1);
    if (name.trim().isEmpty()) return null;

    return name;
  }
}
