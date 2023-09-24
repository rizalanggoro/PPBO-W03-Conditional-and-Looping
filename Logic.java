import java.util.ArrayList;

public class Logic {
  private final ArrayList<Fruit> arrayListFruit = new ArrayList<>();
  private final ArrayList<Vegetable> arrayListVegetable = new ArrayList<>();

  public CheckResult checkInput(String input) {
    if (input.toLowerCase().contains("buah")) {
      if (input.toLowerCase().indexOf("buah") == 0)
        return CheckResult.VALID_FRUIT;
    } else if (input.toLowerCase().contains("sayur")) {
      if (input.toLowerCase().indexOf("sayur") == 0)
        return CheckResult.VALID_VEGETABLE;
    }

    return CheckResult.INVALID;
  }

  public String addFruit(String input) throws Exception {
    String name = getFruitOrVegetableName(input);
    if (name == null)
      throw new Exception("Nama buah tidak boleh kosong!");

    this.arrayListFruit.add(new Fruit(name));
    return name;
  }

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

  private String getFruitOrVegetableName(String input) {
    int firstSpaceIndex = input.indexOf(" ");
    if (firstSpaceIndex == -1) return null;

    String name = input.substring(firstSpaceIndex + 1);
    if (name.trim().isEmpty()) return null;

    return name;
  }
}
