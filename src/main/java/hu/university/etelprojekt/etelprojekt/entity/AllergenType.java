package hu.university.etelprojekt.etelprojekt.entity;

public enum AllergenType {
    GLUTEN("Glutén"),
    DAIRY("Tejtermék"),
    NUTS("Diófélék"),
    EGG("Tojás"),
    PEANUTS("Mogyoró"),
    SHELLFISH("Héjas állatok"),
    SOYA("Szója"),
    SESAME("Szezámmag"),
    FISH("Hal"),
    CRUSTACEANS("Rákfélék"),
    CELERY("Zeller"),
    MUSTARD("Mustár"),
    LUPIN("Csillagfürt"),
    MOLLUSCS("Puhatestűek");

    private final String allergenNameHungarian;

    AllergenType(String allergenNameHungarian) {
        this.allergenNameHungarian = allergenNameHungarian;
    }

    public String getAllergenNameHungarian() {
        return allergenNameHungarian;
    }
}
