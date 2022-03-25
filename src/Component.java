//La clase Component es la clase de paso a la cual guardara que tipo de componente tenemos

public class Component {
    char[] range;
    char character;

    enum TComponent {
        nChar,    //Carácter Normal
        qMark,    //Interrogante
        boL,      //Principio de Linea
        eoL,      //Final de Linea
        charClass, //Conjunto de Caracteres '[ ' ']'
        closure,  //Modificadores + o *
    };
    TComponent type;
}