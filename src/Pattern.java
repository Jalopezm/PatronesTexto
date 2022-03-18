public class Pattern {
    Container<Component> components =  new Container<>();
    Pattern(String strPatr) {
        for (int i = 0; i < strPatr.length(); i++) {
            char c = strPatr.charAt(i);
            if (c == '?') {
                Component component = new Component();
                component.tipo = Component.TComponent.qMark;
                component.character = c;
                components.addElement(component);
            } else if (c == '%') {
                Component component = new Component();
                component.tipo = Component.TComponent.boL;
                component.character = c;
                components.addElement(component);
            } else if (c == '$') {
                Component component = new Component();
                component.tipo = Component.TComponent.eoL;
                component.character = c;
                components.addElement(component);
            } else if (c == '*' || c == '+') {
                Component component = new Component();
                component.tipo = Component.TComponent.closure;
                component.character = c;
                components.addElement(component);
            }else if (c == '['){
                Component component = new Component();
                component.tipo = Component.TComponent.charClass;
            }else{
                if (c == '@'){
                    i++;
                    c = strPatr.charAt(i);
                }
                Component component = new Component();
                component.tipo = Component.TComponent.nChar;
                component.character = c;
                components.addElement(component);
            }
        }

    }
}
