public class Pattern {
    Container<Component> components = new Container<>();

    Pattern(String strPatr) {
        boolean arrobaFound = false;
        boolean rangeFound = false;

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
            if (rangeFound){
                if (c==']'){
                    rangeFound=false;
                }
                if (c=='-'){
                    while(c!=']'){

                    }
                }

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
                rangeFound= true;
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
}
