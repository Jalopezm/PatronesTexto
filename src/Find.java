public class Find {
    private String text;

    public Find(String texto) {
        this.text = texto;
    }

    public boolean match(String stringPat) {
        Pattern pattern = new Pattern(stringPat);
        if (stringPat.length() == 0) {
            return false;
        }
        int accountant = 0;
        for (int i = 0; i < this.text.length(); i++) {
            char c = this.text.charAt(i);
            if (matchText(pattern.components.get(accountant), c)) {
                accountant++;
            }else{
                if (stringPat.charAt(0) == '%' && !matchText(pattern.components.get(accountant), c)){
                    return false;
                }
                if (stringPat.charAt(stringPat.length()-1) == '$' && accountant == pattern.components.size()-1){
                    return true;
                }
                i -= accountant;
                accountant = 0;
            }
            if (accountant == pattern.components.size()) {
                if(stringPat.charAt(stringPat.length()-1) == '$' && i != this.text.length()-1){
                   return false;
                }
                return true;
            }
        }
        return false;
    }

    private boolean matchText(Component component, char c) {
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
                for (int i = 0; i < component.range.length; i++) {
                    if (c == component.range[i]){
                        return true;
                    }
                }
                return false;
            }
            case closure -> {

            }
        }
        return false;
    }


    public String capture(String stringPat) {
        return "";
    }
}