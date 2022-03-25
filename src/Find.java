public class Find {
    private String text;

    //Construimos el Find con valor Texto a this.text

    public Find(String texto) {
        this.text = texto;
    }

    //La funcion match es la funcion que retornara si
    //el patron y el texto coinciden o no.

    public boolean match(String stringPat) {
        Pattern pattern = new Pattern(stringPat);

        //Si no hay patron no puede coincidir
        // por lo cual es false

        if (stringPat.length() == 0) {
            return false;
        }

        int MatchAccountant = 0;

        //Bucle para comprobar caracter a caracter si hace match
        //el patron y el texto incrementando el contador "MatchAccountant"

        for (int i = 0; i < this.text.length(); i++) {

            char c = this.text.charAt(i);

            //Si el componente del patron indocado por el contador
            //coincide con el caracter comparado hacemos match
            //e incrementados el contador

            if (matchText(pattern.components.get(MatchAccountant), c)) {
                MatchAccountant++;

                //En caso de no hacer match comprobaremos los principios y final de linea
                //o reseteamos el contador y dejamos la i enla posicion de i - MatchAccount

            } else {

                //En el caso de que en la primera posicion haya un '%'
                // y en al que hagamos comparacion no haya match retornamos false

                if (stringPat.charAt(0) == '%' && !matchText(pattern.components.get(MatchAccountant), c)) {
                    return false;
                }

                //Si en la ultima posicion hay un '$' y
                //el contador esta al final retornamos true

                if (stringPat.charAt(stringPat.length() - 1) == '$' && MatchAccountant == pattern.components.size() - 1) {
                    return true;
                }
                i -= MatchAccountant;
                MatchAccountant = 0;
            }

            //Si el contador es igual que la longitud del patron
            //quiere decir que todo ha hecho match y retornamos true

            if (MatchAccountant == pattern.components.size()) {

                //Si el ultimo caracter es '$' y no estamos al final
                //retornamos false

                if (stringPat.charAt(stringPat.length() - 1) == '$' && i != this.text.length() - 1) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }


    private boolean matchText(Component component, char c) {

        //Esta funcion hara las comparaciones
        //pertinentes para retornar true o false y que
        //la funcion match sume uno al contador y pueda devolver el resultado final

        switch (component.type) {
            case nChar -> {
                return component.character == c;
            }
            case qMark -> {
                return true;
            }
            case boL, eoL -> {
                return c == component.character;
            }
            case charClass -> {

                //Bucle para comprovar si  el caracter coincide con alguno
                //del array de chars.

                for (int i = 0; i < component.range.length; i++) {
                    if (c == component.range[i]) {
                        return true;
                    }
                }
                return false;
            }

        }
        return false;
    }

    public String capture(String stringPat) {
        return "";
    }
}