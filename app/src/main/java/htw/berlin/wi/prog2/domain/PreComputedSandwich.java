package htw.berlin.wi.prog2.domain;

import htw.berlin.wi.prog2.service.IllegalSandwichException;

import java.util.ArrayList;
import java.util.List;


import htw.berlin.wi.prog2.service.IllegalSandwichException;

import java.util.ArrayList;
import java.util.List;

public class PreComputedSandwich implements Sandwich {

    private double verkaufspreis;
    private int kalorien;
    private List<String> zutatenNamen;

    public PreComputedSandwich(List<Ingredient> ingredientArrayList) {

        verkaufspreis = 0;
        kalorien = 0;
        zutatenNamen = new ArrayList<String>();

        if (ingredientArrayList.size() <= 1) {

            throw new IllegalSandwichException
                    ("Die Anzahl der Zutaten reichen nicht aus. Bitte übergebe mindestens zwei Zutaten.");
        }

        for (Ingredient zutat : ingredientArrayList) {

            verkaufspreis = verkaufspreis + zutat.getPrice();
            kalorien = kalorien + zutat.getCalories();
            zutatenNamen.add(zutat.getName());
        }
    }

    @Override
    public double calculatePrice() {
        return verkaufspreis;
    }

    @Override
    public int calculateCalories() {
        return kalorien;
    }

    @Override
    public List<String> getIngredientNames() {
        return zutatenNamen; }
}

