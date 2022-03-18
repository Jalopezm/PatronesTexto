public class Find {
    private String texto;

    public Find(String texto) {
        this.texto = texto;
    }

    public boolean match(String stringPat) {
        Pattern pattern = new Pattern(stringPat);
        int isMatching = 0;
        String stringAux = "";
        for (int i = 0; i < this.texto.length(); i++) {
            for (int j = 0; j < stringPat.length(); j++) {
                if (i > this.texto.length() - 1) {
                    return false;
                }
                if (stringPat.charAt(j) == '@') {
                    isMatching += 1;
                    j++;
                }
                if (stringPat.charAt(j) == '?') {
                    stringAux = stringPat;
                    stringPat = stringPat.replace(stringPat.charAt(j), this.texto.charAt(i));
                    stringPat = stringPat.substring(0, j + 1) + stringAux.substring(j + 1, stringPat.length());
                }
                while (stringPat.charAt(j) == this.texto.charAt(i)) {
                    isMatching += 1;
                    break;
                }
                if (stringPat.charAt(j) != this.texto.charAt(i)) {
                    isMatching = 0;
                    if (stringAux != ""){
                        if (stringAux.charAt(j) == '?') {
                            stringPat = stringAux;
                            i--;
                            j--;
                        }
                    }
                    break;
                }
                if (isMatching == stringPat.length()) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public String capture(String stringPat) {
        return "";
    }
}