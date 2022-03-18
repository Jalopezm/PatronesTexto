public class Component {
    char[] rango;
    char character;
    enum TComponent{
        nChar,    //Caracter Normal
        qMark,    //Interrogante
        boL,      //Principio de Linea
        eoL,      //Final de Linea
        charClass, //Conjunto de Caracteres '[ ' ']'
        closure,  //Modificadores + o *
    };
    TComponent tipo;

    Component component;
}

