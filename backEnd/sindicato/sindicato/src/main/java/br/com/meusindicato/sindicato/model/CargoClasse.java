package br.com.meusindicato.sindicato.model;

public enum CargoClasse {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E");

    private String classe;

    CargoClasse(String classe){
        this.classe = classe;
    }

    public String getClasse() {
        return classe;
    }

    public static CargoClasse fromString(String texto){
        for (CargoClasse classe:CargoClasse.values()){
            if (classe.classe.equalsIgnoreCase(texto)){
                return classe;
            }
        }
        throw new IllegalArgumentException("Classe não diponível");
    }
}
