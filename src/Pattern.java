//La clase pattern será la clase que nos permitirá saber de qué tipo son cada caràcter

public class Pattern {

    //Inicializamos un contenedor

    Container<Component> components = new Container<>();

    Pattern(String strPatr) {
        boolean arrobaFound = false;

        //Entramos en un bucle que mirara caràcter a caràcter el Patron introducido
        //y le asignara un tipo e introducirá dentro del array de componentes

        for (int i = 0; i < strPatr.length(); i++) {
            char c = strPatr.charAt(i);
            if (arrobaFound) {
                Component component = new Component();
                component.type = Component.TComponent.nChar;
                component.character = c;
                components.addElement(component);
                arrobaFound = false;
                continue;
            }
            if (c == '?') {
                Component component = new Component();
                component.type = Component.TComponent.qMark;
                component.character = c;
                components.addElement(component);
            } else if (c == '%' && i == 0) {
                Component component = new Component();
                component.type = Component.TComponent.boL;
            } else if (c == '$' && i == strPatr.length() - 1) {
                Component component = new Component();
                component.type = Component.TComponent.eoL;
            } else if (c == '*' || c == '+') {
                Component component = new Component();
                component.type = Component.TComponent.closure;
                component.character = c;
                components.addElement(component);
            } else if (c == '[') {
                Component component = new Component();
                component.type = Component.TComponent.charClass;
                String characters = "";

                //Bucle para meter los caracteres del patron desde el primer corchete
                //hasta que encuentre el corchete de cierre

                for (int j = i; c != ']'; j++) {
                    c = strPatr.charAt(j);
                    characters += c;
                    i = j;
                }

                //Entramos en la funcion cleanString

                characters = cleanString(characters);
                component.range = characters.toCharArray();
                components.addElement(component);

            } else if (c == '@') {
                arrobaFound = true;
            } else {
                Component component = new Component();
                component.type = Component.TComponent.nChar;
                component.character = c;
                components.addElement(component);
            }
        }

    }

    //La funcion cleanString servira para quitar los corchetes
    //y añadir en un string todas las letras que esten en el rango
    //pej : [a-g] -> abcdefg

    private String cleanString(String characters) {
        String range = "";

        for (int i = 0; i < characters.length(); i++) {
            char c = characters.charAt(i);
            if (c == '[' || c == ']') {
                continue;
            }
            if (i != characters.length() - 1) {
                char asciiValor1 = characters.charAt(i);
                if (characters.charAt(i + 1) == '-') {
                    char asciiValor2 = characters.charAt(i + 2);
                    for (int j = 0; j < (asciiValor2 - asciiValor1); j++) {
                        range += c++;
                    }
                    continue;
                }
                range += c;
            }
        }
        return range;
    }
}
