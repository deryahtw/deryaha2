package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.*;

import java.util.ArrayList;
import java.util.List;

public class SandwichBuilder {

    private List<Ingredient> zutaten = new ArrayList<>();

    public SandwichBuilder add(Ingredient zutatIngredient) {
        // TODO hier die Annahme von Zutaten implementieren

        zutaten.add(zutatIngredient);

        return this; // die Rückgabe von this sollte beibehalten bleiben (siehe Benutzung im SandwichBuilderTest)
    }

    public Sandwich buildPrecomputed() { // Sandwichobjekt zu erstellen von unterschiedlichen klassen
        // TODO hier stattdessen die neue Klasse PrecomputedSandwich verwenden
        List<Ingredient> ingredientArrayList = new ArrayList<>();
        ingredientArrayList.addAll(zutaten);
        zutaten.removeAll(zutaten);
        return new PreComputedSandwich(ingredientArrayList);
    }

    public Sandwich buildDynamicallyComputed() {
        // TODO hier stattdessen die neue Klasse DynamicallyComputedSandwich verwenden
        List<Ingredient> ingredientArrayList = new ArrayList<>();
        ingredientArrayList.addAll(zutaten);
        zutaten.removeAll(zutaten);
        return new DynamicallyComputedSandwich(ingredientArrayList);
    }

}