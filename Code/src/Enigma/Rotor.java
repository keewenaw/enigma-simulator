package Enigma;

/**
 *The Rotor class represents the rotor component(s) of the Enigma machine.
 *The Rotor class will contain three (default) or four rotors. The rotors .....
 * 
 * <ul>
 * <li>Type int: rotor1, rotor2, rotor4, rotor4  - Values for which 'rotors' (arrays) 
 *                                                 to use Rotor 1 - rotor closest to 
 *                                                 plugboard (fastest rotating)
 * <li>Type int: pos1, pos2, pos4, pos4          - Values to hold the current index 
 *                                                 on each array pos1 - position 
 *                                                 on the first rotor, etc
 * <li>Type int: ring1, ring2, ring3, ring4      - Values to hold the current index 
 *                                                 of the rotor ring
 * <li>Type char: rc11, rc21, m_outputChar       - Letters that the rotors are supposed to rotate on
 *                                                 Two for each rotor 
 *                                                 Ex) rc11 - rotateCharRotor1 (char 1),
 *                                                     rc12 - rotateCharRotor1 (char 2), etc
 *                                               - m_outputChar represents the character that
 *                                                 is sent out of the rotors
 * <li>Type char: rc11, rc21, m_outputChar       - Multidimensional (10x26) array that holds 
 *                                                 the hardcoded sequence of chars on each rotor
 * <li>Type char array: rotorDisplayVals         - hold the character values of index position; to be displayed
 *                                                 by the GUI
 * <li>Type char array: rotorWiringChars         - holds the values of character as it travels
 *                                                 along the path
 * <li>Type char int: rotorSettingVals           - holds integer values of the rotor settings 
 * </ul>
 * </p>
 *  
                    
 *@version     1.0
 *  
 */
public class Rotor {
  private int rotor1, rotor2, rotor3, rotor4; 
  private int pos1, pos2, pos3, pos4; 
  private int ring1, ring2, ring3, ring4;
  private char rc11,rc12,rc21,rc22,rc31,rc32,m_outputChar; 
  private char[][] mapping = new char[][] { 
    {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}, // Baseline
    {'E', 'K', 'M', 'F', 'L', 'G', 'D', 'Q', 'V', 'Z', 'N', 'T', 'O', 'W', 'Y', 'H', 'X', 'U', 'S', 'P', 'A', 'I', 'B', 'R', 'C', 'J'}, // Rotor I
    {'A', 'J', 'D', 'K', 'S', 'I', 'R', 'U', 'X', 'B', 'L', 'H', 'W', 'T', 'M', 'C', 'Q', 'G', 'Z', 'N', 'P', 'Y', 'F', 'V', 'O', 'E'}, // Rotor II
    {'B', 'D', 'F', 'H', 'J', 'L', 'C', 'P', 'R', 'T', 'X', 'V', 'Z', 'N', 'Y', 'E', 'I', 'W', 'G', 'A', 'K', 'M', 'U', 'S', 'Q', 'O'}, // Rotor III
    {'E', 'S', 'O', 'V', 'P', 'Z', 'J', 'A', 'Y', 'Q', 'U', 'I', 'R', 'H', 'X', 'L', 'N', 'F', 'T', 'G', 'K', 'D', 'C', 'M', 'W', 'B'}, // Rotor IV
    {'V', 'Z', 'B', 'R', 'G', 'I', 'T', 'Y', 'U', 'P', 'S', 'D', 'N', 'H', 'L', 'X', 'A', 'W', 'M', 'J', 'Q', 'O', 'F', 'E', 'C', 'K'}, // Rotor V
    {'J', 'P', 'G', 'V', 'O', 'U', 'M', 'F', 'Y', 'Q', 'B', 'E', 'N', 'H', 'Z', 'R', 'D', 'K', 'A', 'S', 'X', 'L', 'I', 'C', 'T', 'W'}, // Rotor VI
    {'N', 'Z', 'J', 'H', 'G', 'R', 'C', 'X', 'M', 'Y', 'S', 'W', 'B', 'O', 'U', 'F', 'A', 'I', 'V', 'L', 'P', 'E', 'K', 'Q', 'D', 'T'}, // Rotor VII
    {'F', 'K', 'Q', 'H', 'T', 'L', 'X', 'O', 'C', 'B', 'J', 'S', 'P', 'D', 'Z', 'R', 'A', 'M', 'E', 'W', 'N', 'I', 'U', 'Y', 'G', 'V'}, // Rotor VIII
    {'L', 'E', 'Y', 'J', 'V', 'C', 'N', 'I', 'X', 'W', 'P', 'B', 'Q', 'M', 'D', 'R', 'T', 'A', 'K', 'Z', 'G', 'F', 'U', 'H', 'O', 'S'}, // Beta Rotor
    {'F', 'S', 'O', 'K', 'A', 'N', 'U', 'E', 'R', 'H', 'M', 'B', 'T', 'I', 'Y', 'C', 'W', 'L', 'Q', 'P', 'Z', 'X', 'V', 'G', 'J', 'D'}  // Gamma Rotor
  }; 

  private char[] rotorDisplayVals = new char[4];
  private int[] rotorSettingVals = new int[12];
  private char[] rotorWiringChars = new char[12];
 /********************CONSTRUCTOR METHODS********************/ 
 /*
  * Creates a Rotor object (default constructor)
  */
  public Rotor() {
    setInitialValuesDefault(); // Set initial variables
    setCharsToRotateOn(); // Set notch rotation values for each rotor
  } 
 /*
  * Creates a Rotor object (preferred constructor)
  */
  /**
   * 
   * @param values array of integers to set the rotor values
   */
  public Rotor(int[] values) {
    setInitialValues(values); // Set initial variables
    setCharsToRotateOn(); // Set notch rotation values for each rotor
  }
 /*
  * Sets the Intial state of the rotors
  */ 
  private void setInitialValuesDefault() {
    rotor1 = 1; // Which rotor number is for the fastest rotor?
    rotor2 = 2; // Which rotor number is for the medium rotor?
    rotor3 = 3; // Which rotor number is for the slow rotor?
    rotor4 = 0; // Which rotor number is for the slowest rotor, if it exists?
    pos1 = 0;   // Starting position of rotor 1
    pos2 = 0;   // Starting position of rotor 2
    pos3 = 0;   // Starting position of rotor 3
    pos4 = 0;   // Starting position of rotor 4
    ring1 = 0;  // Starting position of ring 1
    ring2 = 0;  // Starting position of ring 2
    ring3 = 0;  // Starting position of ring 3
    ring4 = 0;  // Starting position of ring 4
    m_outputChar='\0';
  } 
 /* 
  * Sets initial values for class
  * @param int[] values - array that holds the necessary settings for the class
  *   If value in an index is -1, the rotor/position is not used
  */
  private void setInitialValues(int[] values) {
    rotor1 = values[0]; // Which rotor number is for the fastest rotor?
    rotor2 = values[1]; // Which rotor number is for the medium rotor?
    rotor3 = values[2]; // Which rotor number is for the slow rotor?
    rotor4 = values[3]; // Which rotor number is for the slowest rotor, if it exists?
    pos1 = values[4];   // Starting position of rotor 1
    pos2 = values[5];   // Starting position of rotor 2
    pos3 = values[6];   // Starting position of rotor 3
    pos4 = values[7];   // Starting position of rotor 4
    ring1 = values[8];  // Starting position of ring 1
    ring2 = values[9];  // Starting position of ring 2
    ring3 = values[10]; // Starting position of ring 3
    ring4 = values[11]; // Starting position of ring 4
    m_outputChar='\0';
  }
 /*
  * Set the chars that, when hit, are supposed to rotate the rotors
  *   Defined according to constants
  *   Rotor 1 rotates on q->r shift
  *   Rotor 2 rotates on e->f shift
  *   Rotor 3 rotates on v->w shift
  *   Rotor 4 rotates on j->k shift
  *   Rotor 5 rotates on z->a shift
  *   Rotors 6, 7, 8 rotate on z->a and m->n shift
  */
  private void setCharsToRotateOn() {
    switch(rotor1) {
        case 1: rc11 = 'Q'; rc12 = 'Q'; break; // Rotor = Rotor I, so when rotor hits 'r', move the next fastest rotor
        case 2: rc11 = 'E'; rc12 = 'E'; break; // Rotor = Rotor II, so when rotor hits 'f', move the next fastest rotor
        case 3: rc11 = 'V'; rc12 = 'V'; break; // Rotor = Rotor III, so when rotor hits 'w', move the next fastest rotor
        case 4: rc11 = 'J'; rc12 = 'J'; break; // Rotor = Rotor IV, so when rotor hits 'k', move the next fastest rotor
        case 5: rc11 = 'Z'; rc12 = 'Z'; break; // Rotor = Rotor V, so when rotor hits 'a', move the next fastest rotor
        case 6: rc11 = 'Z'; rc12 = 'Z'; break; // Rotor = Rotor VI, so when rotor hits 'a' or 'n', move the next fastest rotor
        case 7: rc11 = 'Z'; rc12 = 'Z'; break; // Rotor = Rotor VII, so when rotor hits 'a' or 'n', move the next fastest rotor
        case 8: rc11 = 'Z'; rc12 = 'Z'; break; // Rotor = Rotor VIII, so when rotor hits 'a' or 'n', move the next fastest rotor
        default: break; // No rotor selected, so do nothing
    }
    switch(rotor2) {
        case 1: rc21 = 'Q'; rc22 = 'Q'; break; // Rotor = Rotor I, so when rotor hits 'r', move the next fastest rotor
        case 2: rc21 = 'E'; rc22 = 'E'; break; // Rotor = Rotor II, so when rotor hits 'f', move the next fastest rotor
        case 3: rc21 = 'V'; rc22 = 'V'; break; // Rotor = Rotor III, so when rotor hits 'w', move the next fastest rotor
        case 4: rc21 = 'J'; rc22 = 'J'; break; // Rotor = Rotor IV, so when rotor hits 'k', move the next fastest rotor
        case 5: rc21 = 'Z'; rc22 = 'Z'; break; // Rotor = Rotor V, so when rotor hits 'a', move the next fastest rotor
        case 6: rc21 = 'Z'; rc22 = 'Z'; break; // Rotor = Rotor VI, so when rotor hits 'a' or 'n', move the next fastest rotor
        case 7: rc21 = 'Z'; rc22 = 'Z'; break; // Rotor = Rotor VII, so when rotor hits 'a' or 'n', move the next fastest rotor
        case 8: rc21 = 'Z'; rc22 = 'Z'; break; // Rotor = Rotor VIII, so when rotor hits 'a' or 'n', move the next fastest rotor
        default: break; // No rotor selected, so do nothing
    }
    switch(rotor3) {
        case 1: rc31 = 'Q'; rc32 = 'Q'; break; // Rotor = Rotor I, so when rotor hits 'r', move the next fastest rotor
        case 2: rc31 = 'E'; rc32 = 'E'; break; // Rotor = Rotor II, so when rotor hits 'f', move the next fastest rotor
        case 3: rc31 = 'V'; rc32 = 'V'; break; // Rotor = Rotor III, so when rotor hits 'w', move the next fastest rotor
        case 4: rc31 = 'J'; rc32 = 'J'; break; // Rotor = Rotor IV, so when rotor hits 'k', move the next fastest rotor
        case 5: rc31 = 'Z'; rc32 = 'Z'; break; // Rotor = Rotor V, so when rotor hits 'a', move the next fastest rotor
        case 6: rc31 = 'Z'; rc32 = 'Z'; break; // Rotor = Rotor VI, so when rotor hits 'a' or 'n', move the next fastest rotor
        case 7: rc31 = 'Z'; rc32 = 'Z'; break; // Rotor = Rotor VII, so when rotor hits 'a' or 'n', move the next fastest rotor
        case 8: rc31 = 'Z'; rc32 = 'Z'; break; // Rotor = Rotor VIII, so when rotor hits 'a' or 'n', move the next fastest rotor
        default: break; // No rotor selected, so do nothing
    }
  }
  /********************PASS 1 (PLUGBOARD->ROTORS->REFLECTOR) METHODS*******************
 /*
  * Processes a character from Plugboard class and outputs a new one based on the current rotor settings
  * @param newValues - array of integers that holds new values, if any
  * @param inputChar - character set as input
  */
  public void cryptPass1(int[] newValues, char inputChar) {
    validateChar(inputChar);
    updateSettings(newValues); // If there are settings to update, do so    
    updateRotors(); // Rotate rotors
    populateRotorSettingsArray();
    setOutputChar(crypt1(inputChar));
  } 

 /*
  * Processes a char and returns a new one, as determined by 'mapping'
  * Adds the character to the wire array as it changes
  * @param char charToCrypt - the char to process
  * @return the processed char
  */
  private char crypt1(char charToCrypt) {
    int wrkNdx = -1;
    
    /*****First Rotor*****/
    wrkNdx=validateCharNdx(getCharNdx(charToCrypt)+pos1-ring1);
    //Add Char to Wire Array
    rotorWiringChars[0] = mapping[0][(wrkNdx)];
    //Convert
    charToCrypt = mapping[rotor1][(wrkNdx)];
    wrkNdx=validateCharNdx(getCharNdx(charToCrypt));
    //Add Char to Wire Array
    rotorWiringChars[1] = mapping[0][(wrkNdx)];
    
    /*****Second Rotor*****/
    wrkNdx=validateCharNdx(getCharNdx(charToCrypt)-pos1+pos2-ring2+ring1);
    //Add Char to Wire Array
    rotorWiringChars[2] = mapping[0][(wrkNdx)];
    //Convert
    charToCrypt = mapping[rotor2][(wrkNdx)];
    wrkNdx=validateCharNdx(getCharNdx(charToCrypt));
    //Add Char to Wire Array
    rotorWiringChars[3] = mapping[0][(wrkNdx)];
    
    /*****Third Rotor*****/
    wrkNdx=validateCharNdx(getCharNdx(charToCrypt)-pos2+pos3-ring3+ring2);
    //Add Char to Wire Array
    rotorWiringChars[4] = mapping[0][(wrkNdx)];
    //Convert
    charToCrypt = mapping[rotor3][(wrkNdx)];
    wrkNdx=validateCharNdx(getCharNdx(charToCrypt));
    //Add Char to Wire Array
    rotorWiringChars[5] = mapping[0][(wrkNdx)];

  return mapping[0][(validateCharNdx(getCharNdx(charToCrypt)-pos3+ring3))];  // Return the final crypted char
  }

  /********************PASS 2 (REFLECTOR->ROTORS->PLUGBOARD) METHODS*******************
 /*
  * Processes a character from Reflector class and outputs a new one based on the current rotor settings
  * @param newValues - integer array that holds new values, if any
  * @param inputChar - the char to process
  */
  public void cryptPass2(int[] newValues, char inputChar) {
    setOutputChar(crypt2(inputChar));
  }

 /*
  * Processes a char and returns a new one, as determined by 'mapping'
  * Adds the character to the wire array as it changes
  * @param char charToCrypt - the char to process
  * @return the processed char
  */
  private char crypt2(char charToCrypt) {  
    int wrkNdx = -1;
    /*****Third Rotor*****/
    //Get the index of the character with adjusted value of rotor 3   
    wrkNdx=validateCharNdx(getCharNdx(charToCrypt)+pos3-ring3);    
    //Add Char to Wire Array
    rotorWiringChars[6] = mapping[0][(wrkNdx)];
    //Convert    
    wrkNdx=getCharNdxFromMapping(wrkNdx, rotor3);    
    charToCrypt=mapping[0][(wrkNdx)];
    //Add Char to Wire Array
    rotorWiringChars[7] =charToCrypt;
    
    /*****Second Rotor*****/
    //Get the index of the character with adjusted value of rotor 2
    
    wrkNdx=validateCharNdx(getCharNdx(charToCrypt)-pos3+pos2-ring2+ring3);    
    //Add Char to Wire Array
    rotorWiringChars[8] = mapping[0][(wrkNdx)];
    //Convert
    wrkNdx=getCharNdxFromMapping(wrkNdx, rotor2);
    charToCrypt=mapping[0][(wrkNdx)];
    //Add Char to Wire Array
    rotorWiringChars[9] =charToCrypt;
    
    /*****First Rotor*****/
    //Get the index of the character with adjusted value of rotor 1    
    wrkNdx=validateCharNdx(getCharNdx(charToCrypt)-pos2+pos1-ring1+ring2); 
    //Add Char to Wire Array
    rotorWiringChars[10] = mapping[0][(wrkNdx)];
    //Convert
    wrkNdx=getCharNdxFromMapping(wrkNdx, rotor1);
    charToCrypt=mapping[0][(wrkNdx)];
    //Add Char to Wire Array
    rotorWiringChars[11] =charToCrypt;

  return mapping[0][validateCharNdx(wrkNdx-pos1+ring1)];  // Return the final crypted char
  }
 /********************UTILITY METHODS********************/ 
 /*
  * Update the settings, if it needs to be
  *   If the new value is in the range 0-25, update the proper variable
  *   Else, do nothing
  * @param int[] newValues - array of integers with updated values
  */
  private void updateSettings(int[] newValues) {
    if (newValues[0]  >= 0 && newValues[0]  <= 25) rotor1 = newValues[0]; 
    if (newValues[1]  >= 0 && newValues[1]  <= 25) rotor2 = newValues[1];
    if (newValues[2]  >= 0 && newValues[2]  <= 25) rotor3 = newValues[2];
    if (newValues[3]  >= 0 && newValues[3]  <= 25) rotor4 = newValues[3];
    if (newValues[4]  >= 0 && newValues[4]  <= 25) pos1   = newValues[4];
    if (newValues[5]  >= 0 && newValues[5]  <= 25) pos2   = newValues[5];
    if (newValues[6]  >= 0 && newValues[6]  <= 25) pos3   = newValues[6];
    if (newValues[7]  >= 0 && newValues[7]  <= 25) pos4   = newValues[7];
    if (newValues[8]  >= 0 && newValues[8]  <= 25) ring1  = newValues[8]; 
    if (newValues[9]  >= 0 && newValues[9]  <= 25) ring2  = newValues[9]; 
    if (newValues[10] >= 0 && newValues[10] <= 25) ring3  = newValues[10]; 
    if (newValues[11] >= 0 && newValues[11] <= 25) ring4  = newValues[11]; 
  } 
 /*
  * Updates the rotor settings as done in the real Enigma machine
  *   Rotor 1 rotates on q->r shift
  *   Rotor 2 rotates on e->f shift
  *   Rotor 3 rotates on v->w shift
  *   Rotor 4 rotates on j->k shift
  *   Rotor 5 rotates on z->a shift
  *   Rotors 6, 7, 8 rotate on z->a and m->n shift
  */
  private void updateRotors() {
    if ((mapping[0][pos1] == rc11)&&(mapping[0][pos2] != rc21)) {
        pos1++; // Move the rotor
        pos2++; // Move the rotor
        if (pos1 >= 26) pos1 = 0;// Make sure value is in acceptable range (0-25)
        if (pos2 >= 26) pos2 = 0;// Make sure value is in acceptable range (0-25)
    }
    else if ((mapping[0][pos1] == rc11)&&(mapping[0][pos2] == rc21)) {
        pos1++; // Move the rotor
        pos2++; // Move the rotor
        pos3++; // Move the rotor
        if (pos1 >= 26) pos1 = 0;// Make sure value is in acceptable range (0-25)
        if (pos2 >= 26) pos2 = 0;// Make sure value is in acceptable range (0-25)
        if (pos3 >= 26) pos3 = 0; // Make sure value is in acceptable range (0-25)
    }
    else {
        pos1++; // Move the rotor
        if (pos1 >= 26) pos1 = 0;// Make sure value is in acceptable range (0-25)
    }    
  }
  /**
   * 
   * Returns the output character
   * 
   * @return output character m_outputChar
   */
  public char getOutputChar(){
    return m_outputChar;
  }
  /*
  * Sets the output character
  */
  private void setOutputChar(char c) {
    m_outputChar=c; 
  }
  /*
  * Returns an integer index value of a character
  * 
  * @return wrkNdx index of character
  */
  private int getCharNdx(char c) {
    int wrkNdx=0;
    
    for (int i = 0; i < 26; i++)
        if (mapping[0][i] == c)
            wrkNdx = i;        
  return wrkNdx;
  }
  /*
  * Returns an integer index value of a character from the rotor mapping array
  * 
  * @param  wNdx   int value of index of charcacter currently being worked
  * @param  rtrNum int value the rotro number being refernced
  * @return wNdx   int index of character based on rotor mapping array
  */
  private int getCharNdxFromMapping(int wNdx, int rtrNum) {
      for (int i=0; i<26; i++) {
        if (mapping[rtrNum][(i)]==mapping[0][wNdx]) {
            wNdx=i;
            break;
        }
    }
      return wNdx;
  }
  /**
   *Populates array with the rotor values to be displayed in GUI.
   * The array is populated after the rotors have been updated.
   */
  public void populateRotorSettingsArray() {
    rotorSettingVals[0]=rotor1;
    rotorSettingVals[1]=rotor2;
    rotorSettingVals[2]=rotor3;
    rotorSettingVals[3]=rotor4;
    rotorSettingVals[4]=pos1;
    rotorSettingVals[5]=pos2;
    rotorSettingVals[6]=pos3;
    rotorSettingVals[7]=pos4;
    rotorSettingVals[8]=ring1;
    rotorSettingVals[9]=ring2;
    rotorSettingVals[10]=ring3;
    rotorSettingVals[11]=ring3;
    
    rotorDisplayVals[0]= mapping[0][pos1];
    rotorDisplayVals[1]= mapping[0][pos2];
    rotorDisplayVals[2]= mapping[0][pos3];
    rotorDisplayVals[3]= mapping[0][pos4];
  }
  /**
   * 
   * Returns an array of characters that are to be displayed in the GUI
   * 
   * @return character array rotorDisplayVals
   */
  public char[] getRotorDisplayVals() {
     return rotorDisplayVals;
  }
  /**
   * 
   * Returns an array of integers that are to be used in the Settings
   * 
   * @return integer array of rotorSettingVals
   */
  public int[] getRotorSettingVals() {
     return rotorSettingVals;
  }
  /**
   * Returns an array of characters that will be displayed in the GUI Wire Display
   * 
   * @return character array of rotorWiringChars
   */
  public char[] getRotorWiringChars() {
      return rotorWiringChars;
  }
  /*
  * Makes sure the character index that is currently worked is acceptable
  * If the integer value is less than 0 or greater than 25; adjust accordingly
  * 
  * @param charNdx valid index of character
  * @return exception if not valid
  */
  private int validateCharNdx(int charNdx) {
    if (charNdx > 25) charNdx -= 26;
    if (charNdx < 0) charNdx += 26;
  return charNdx;
  }
 /*
  * Makes sure the input char is acceptable
  * @param char inputChar - char to check
  * @return exception if not valid
  */
  private void validateChar(char inputChar) {
    if ((inputChar < 'A') || (inputChar > 'Z'))
        throw new IllegalArgumentException("The input is not an acceptable char; char must be in range \'A\'-\'Z\'");
  } 
}
