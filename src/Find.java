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
                if (matchText(pattern.components.get(contador),c,i)){
                    contador++;
                }else{
                    i-=contador;
                    contador=0;
                }
                if (stringPat.contains("@") && contador == stringPat.length()-1){
                    contador++;
                }
                if (contador == stringPat.length()){
                    return true;
                }
        }
        return false;
    }

    private boolean matchText(Component component, char c, int i) {
            switch (component.tipo) {
                case nChar -> {return component.character == c;}
                case qMark -> {return true;}
//            case boL -> {if (i == 0 && component.tipo == Component.TComponent.boL){}}
//            case eoL -> {if (i == this.texto.length()-1 && component.tipo == Component.TComponent.eoL){}}
//            case closure -> {}
            }
        return false;
    }


    public String capture(String stringPat) {
        return "";
    }
}