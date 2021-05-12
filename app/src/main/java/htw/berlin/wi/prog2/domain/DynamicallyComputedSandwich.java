package htw.berlin.wi.prog2.domain;

import htw.berlin.wi.prog2.service.IllegalSandwichException;

import java.util.ArrayList;
import java.util.List;

public class DynamicallyComputedSandwich implements Sandwich{

    private List<Ingredient> ingredientArrayList = new ArrayList<>();

    public DynamicallyComputedSandwich(List<Ingredient> newList) {
        if (newList.size() <= 1) {
            throw new IllegalSandwichException
                    ("Die Anzahl der Zutaten reichen nicht aus. Bitte übergebe mindestens zwei Zutaten.");

        } else
            this.ingredientArrayList = newList;

    }


    @Override
    public double calculatePrice() {
        double verkaufspreis;
        verkaufspreis = 0;
        // nur ein lesender zugriff auf for each möglichd
// die for each schleife ist eine spezialisierte for Schleife um alle Elemente eines Arrays sequenziell zu durchlaufen
        for (Ingredient zutat: ingredientArrayList) {   // while schleife weiß man wie oft es durchlaufen soll  / Do While Schleife weiß man das nicht
            verkaufspreis += zutat.getPrice();  // Anweisung
        }

        return verkaufspreis;
    }

    @Override
    public int calculateCalories() {
        int kalorien = 0;

        for (Ingredient zutat: ingredientArrayList) {
            kalorien += zutat.getCalories();
        }

        return kalorien;
    }

    @Override
    public List<String> getIngredientNames() {
        List<String> zutatenNamen = new ArrayList<>();

        for (Ingredient zutat : ingredientArrayList) {
            zutatenNamen.add(zutat.getName());
        }
        return zutatenNamen;
    }
}