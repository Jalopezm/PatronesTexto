public class Find {
    private String texto;

    public Find(String texto) {
        this.texto = texto;
    }

    public boolean match(String stringPat) {
        Pattern pattern = new Pattern(stringPat);
        if (stringPat.length() == 0) {
            return false;
        }
        int contador = 0;
        for (int i = 0; i < this.texto.length(); i++) {
            char c = this.texto.charAt(i);
            if (matchText(pattern.components.get(contador), c, i, stringPat.length())) {
                contador++;
            } else {
                i -= contador;
                contador = 0;
            }
            if (contador == pattern.components.size()) {
                return true;
            }
        }
        return false;
    }

    private boolean matchText(Component component, char c, int i, int size) {
        switch (component.tipo) {
            case nChar -> {
                return component.character == c;
            }
            case qMark, boL, eoL -> {
                return true;
            }
            //            case closure -> {}
        }
        return false;
    }


    public String capture(String stringPat) {
        return "";
    }
}