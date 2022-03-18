public class Pattern {
    Container<Component> components =  new Container<>();
    Pattern(String strPatr) {
        for (int i = 0; i < strPatr.length(); i++) {
            char c = strPatr.charAt(i);
            Component component = new Component();
            if (c == '?') {
                component.tipo = Component.TComponent.qMark;
                component.character = c;
                components.addElement(component);
            } else if (c == '%') {
                component.tipo = Component.TComponent.boL;
                component.character = c;
                components.addElement(component);
            } else if (c == '$') {
                component.tipo = Component.TComponent.eoL;
                component.character = c;
                components.addElement(component);
            } else if (c == '*' || c == '+') {
                component.tipo = Component.TComponent.closure;
                component.character = c;
                components.addElement(component);
            }else if (c == '['){
                component.tipo = Component.TComponent.charClass;
            }else{
                component.tipo = Component.TComponent.nChar;
                component.character = c;
                components.addElement(component);
            }
        }

    }
}
