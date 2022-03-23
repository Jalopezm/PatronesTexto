public class Pattern {
    Container<Component> components = new Container<>();

    Pattern(String strPatr) {
        boolean arrobaFound = false;

        for (int i = 0; i < strPatr.length(); i++) {
            char c = strPatr.charAt(i);
            if (arrobaFound) {
                Component component = new Component();
                component.tipo = Component.TComponent.nChar;
                component.character = c;
                components.addElement(component);
                arrobaFound = false;
                continue;
            }
            if (c == '?') {
                Component component = new Component();
                component.tipo = Component.TComponent.qMark;
                component.character = c;
                components.addElement(component);
            } else if (c == '%' && i == 0) {
                Component component = new Component();
                component.tipo = Component.TComponent.boL;
            } else if (c == '$' && i == strPatr.length() - 1) {
                Component component = new Component();
                component.tipo = Component.TComponent.eoL;
            } else if (c == '*' || c == '+') {
                Component component = new Component();
                component.tipo = Component.TComponent.closure;
                component.character = c;
                components.addElement(component);
            } else if (c == '[') {
                Component component = new Component();
                component.tipo = Component.TComponent.charClass;
                String caracteres = "";
                for (int j = i; c != ']'; j++) {
                    c = strPatr.charAt(j);
                    caracteres+=c;
                    i=j;
                }
                caracteres = cleanString(caracteres);
                System.out.println(caracteres);
                component.rango = caracteres.toCharArray();
                components.addElement(component);

            } else if (c == '@') {
                arrobaFound = true;
            } else {
                Component component = new Component();
                component.tipo = Component.TComponent.nChar;
                component.character = c;
                components.addElement(component);
            }
        }

    }

    private String cleanString(String caracteres) {
        String range = "";

        for (int i = 0; i < caracteres.length(); i++) {
            char c = caracteres.charAt(i);
            if (c == '[' || c == ']'){
                continue;
            }
            if (i != caracteres.length()-1) {
                char asciiValor1 = caracteres.charAt(i);
                if (caracteres.charAt(i + 1) == '-') {
                    char asciiValor2 = caracteres.charAt(i+2);
                    for (int j = 0; j < (asciiValor2-asciiValor1); j++) {
                        range+=c++;
                    }
                    continue;
                }
                range+=c;
            }
        }
        return range;
    }
}
