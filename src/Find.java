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
            if (matchText(pattern.components.get(contador), c)) {
                contador++;
            }else{
                if (stringPat.charAt(0) == '%' && !matchText(pattern.components.get(contador), c)){
                    return false;
                }
                if (stringPat.charAt(stringPat.length()-1) == '$' && contador == pattern.components.size()-1){
                    return true;
                }
                i -= contador;
                contador = 0;
            }
            if (contador == pattern.components.size()) {
                if(stringPat.charAt(stringPat.length()-1) == '$'&& i != this.texto.length()-1){
                   return false;
                }
                return true;
            }
        }
        return false;
    }

    private boolean matchText(Component component, char c) {
        switch (component.tipo) {
            case nChar -> {
                return component.character == c;
            }
            case qMark -> {
                return true;
            }
            case boL, eoL -> {
               return c == component.character;
            }
            //            case closure -> {}
        }
        return false;
    }


    public String capture(String stringPat) {
        return "";
    }
}