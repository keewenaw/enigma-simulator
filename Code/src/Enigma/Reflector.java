package Enigma;

/**
 *The Reflector class represents the reflector component of Enigma machine.
 * The class should assign a valid character variable from the Controller Class,
 * change the character based on settings, and signal the Controller Class when
 * permutation of character is complete.  When called, the Reflector Class 
 * returns a valid character to the Controller Class.
 * <p>
The class data members:
 * <ul>
 * <li>Type char: m_outputChar - character to be returned to Controller Class
 * <li>Type char: m_ReflectorType - character that represents the type of reflector
 * </ul>
 * </p>
 *
 *  
                    
@version     1.0
 *  
 */
public class Reflector {
    //Class data members
    private char m_outputChar;
    private char m_ReflectorType;
    /** 
    * Class constructor. The default constructor assigns a value to the data 
    * members. By default, the data member m_outputChar is set to '/0', and 
    * m_ReflectorType is set to 'B'
    */
    public Reflector()
    {
        m_outputChar = '\0';
        setReflectorType('B');
    }
    /** 
    * Class constructor with reflector type argument. The constructor assigns a 
    * value to the data members. The data member m_outputChar is set to '/0', 
    * and m_ReflectorType is set to the value of the passed argument
    * @param rType character that represents the character type
    */
    public Reflector(char rType)
    {
        m_outputChar = '\0';
        setReflectorType(rType);
    }
    
   /**
   *Accepts a character variable that is passed as an argument from the 
   *Controller Class
   * Assuming the parameter is valid, the reflect() method is called
   * and the character is passed as an argument
   * 
   * @param  c the character passed from the controller class, and to the 
   *           reflect() method
   */
    public void setInputChar(char c)
    {
        if (Character.isLetter(c))          //Verify Character is type char
            if (Character.isUpperCase(c))   //Verify Character is uppercase
                  reflect(c); 
            else         
                throw new IllegalArgumentException("Reflector: Character is not uppercase");                 //Return Not Uppercase Error
        else 
            throw new IllegalArgumentException("Reflector: Character is not a letter");                     //Return Not a Character Error   
    }
    
  /**
   *  
   *Accepts a character variable that is passed as an argument from the 
   *setInputChar() method, reassigns the value of the character (based on reflector
   * type setting), and assigns the output character value by calling setOutputChar() 
   * method.  The m_outputChar data member is assigned a the new value, and awaits
   * the Controller Class to retrieve the value.  The value is returned to the
   * setInputChar() method for error checking.
   * <p>The return values are:
   * <ul>
   * <li> m_outputChar - the converted output character
   * </ul>
   * <p>
   * @param  c the character passed from the reflect() method, and passed as an
   *           argument of the setOutputChar() method
   */
    private void reflect(char c)
    {
        if (getReflectorType()=='B')
        {
            switch (c) {
                case 'A': setOutputChar('Y');
                    break;
                case 'B': setOutputChar('R');
                    break;
                case 'C': setOutputChar('U');
                    break;
                case 'D': setOutputChar('H');
                    break;
                case 'E': setOutputChar('Q');
                    break;
                case 'F': setOutputChar('S');
                    break;
                case 'G': setOutputChar('L');
                    break;
                case 'H': setOutputChar('D');
                    break;
                case 'I': setOutputChar('P');
                    break;
                case 'J': setOutputChar('X');
                    break;
                case 'K': setOutputChar('N');
                    break;
                case 'L': setOutputChar('G');
                    break;
                case 'M': setOutputChar('O');
                    break;
                case 'N': setOutputChar('K');
                    break;
                case 'O': setOutputChar('M');
                    break;
                case 'P': setOutputChar('I');
                    break;
                case 'Q': setOutputChar('E');
                    break;
                case 'R': setOutputChar('B');
                    break;
                case 'S': setOutputChar('F');
                    break;
                case 'T': setOutputChar('Z');
                    break;
                case 'U': setOutputChar('C');
                    break;
                case 'V': setOutputChar('W');
                    break;
                case 'W': setOutputChar('V');
                    break;
                case 'X': setOutputChar('J');
                    break;
                case 'Y': setOutputChar('A');
                    break;
                case 'Z': setOutputChar('T');
                    break;
                default:  setOutputChar('\0');
                    break;
            }
        }
        else if (getReflectorType()=='C')
        {
            switch (c) {
                case 'A': setOutputChar('F');
                    break;
                case 'B': setOutputChar('V');
                    break;
                case 'C': setOutputChar('P');
                    break;
                case 'D': setOutputChar('J');
                    break;
                case 'E': setOutputChar('I');
                    break;
                case 'F': setOutputChar('A');
                    break;
                case 'G': setOutputChar('O');
                    break;
                case 'H': setOutputChar('Y');
                    break;
                case 'I': setOutputChar('E');
                    break;
                case 'J': setOutputChar('D');
                    break;
                case 'K': setOutputChar('R');
                    break;
                case 'L': setOutputChar('Z');
                    break;
                case 'M': setOutputChar('X');
                    break;
                case 'N': setOutputChar('W');
                    break;
                case 'O': setOutputChar('G');
                    break;
                case 'P': setOutputChar('C');
                    break;
                case 'Q': setOutputChar('T');
                    break;
                case 'R': setOutputChar('K');
                    break;
                case 'S': setOutputChar('U');
                    break;
                case 'T': setOutputChar('Q');
                    break;
                case 'U': setOutputChar('S');
                    break;
                case 'V': setOutputChar('B');
                    break;
                case 'W': setOutputChar('N');
                    break;
                case 'X': setOutputChar('M');
                    break;
                case 'Y': setOutputChar('H');
                    break;
                case 'Z': setOutputChar('L');
                    break;
                default:  setOutputChar('\0');
                    break;
            }
        } 
        else                    //Reflector type not set
            throw new IllegalArgumentException("Reflector: Character is not vaild");
    }
    
  /**
   *  
   *changes the type of reflector that is being used
   */
    public void changeReflectorType()
    {
        if (getReflectorType()=='C')
            setReflectorType('B');
        else
            setReflectorType('C');
    }
   /**
   *  
   *returns the character value of m_outputChar
   * @return character m_outputChar
   */
    public char getOutputChar()
    {
        return m_outputChar;
    }
   /**
   *  
   *assigns the character value of m_outputChar
   * @param  c the character passed as an argument, and assigned to m_outputChar
   */
    private void setOutputChar(char c)
    {
        m_outputChar = c;
    }
   /**
   *  
   *assigns the character value of m_ReflectorType
   * @param  c the character passed as an argument, and assigned to m_ReflectorType
   */  
    private void setReflectorType(char rType)
    {
        m_ReflectorType = rType;   
    }
   /**
   *  
   *returns the character value of m_ReflectorType
   * @return character m_ReflectorType
   */
    public char getReflectorType()
    {
        return m_ReflectorType;
    }

}
