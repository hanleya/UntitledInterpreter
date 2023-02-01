/* Generated By:JJTree&JavaCC: Do not edit this line. ParserConstants.java */
package AST;


/** 
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int NUMBER_LITERAL = 6;
  /** RegularExpression Id. */
  int DIGIT = 7;
  /** RegularExpression Id. */
  int PLUS = 8;
  /** RegularExpression Id. */
  int MINUS = 9;
  /** RegularExpression Id. */
  int MUL = 10;
  /** RegularExpression Id. */
  int DIV = 11;
  /** RegularExpression Id. */
  int MOD = 12;
  /** RegularExpression Id. */
  int POWER = 13;
  /** RegularExpression Id. */
  int AND = 14;
  /** RegularExpression Id. */
  int OR = 15;
  /** RegularExpression Id. */
  int NOT = 16;
  /** RegularExpression Id. */
  int EQ = 17;
  /** RegularExpression Id. */
  int NEQ = 18;
  /** RegularExpression Id. */
  int LT = 19;
  /** RegularExpression Id. */
  int LEQ = 20;
  /** RegularExpression Id. */
  int GT = 21;
  /** RegularExpression Id. */
  int GEQ = 22;
  /** RegularExpression Id. */
  int LPAREN = 23;
  /** RegularExpression Id. */
  int RPAREN = 24;
  /** RegularExpression Id. */
  int LBRACE = 25;
  /** RegularExpression Id. */
  int RBRACE = 26;
  /** RegularExpression Id. */
  int LBRACKET = 27;
  /** RegularExpression Id. */
  int RBRACKET = 28;
  /** RegularExpression Id. */
  int ASSIGN = 29;
  /** RegularExpression Id. */
  int ASADD = 30;
  /** RegularExpression Id. */
  int ASSUB = 31;
  /** RegularExpression Id. */
  int ASMUL = 32;
  /** RegularExpression Id. */
  int ASDIV = 33;
  /** RegularExpression Id. */
  int ASMOD = 34;
  /** RegularExpression Id. */
  int INC = 35;
  /** RegularExpression Id. */
  int DEC = 36;
  /** RegularExpression Id. */
  int COMMA = 37;
  /** RegularExpression Id. */
  int DOT = 38;
  /** RegularExpression Id. */
  int COLON = 39;
  /** RegularExpression Id. */
  int SCOLON = 40;
  /** RegularExpression Id. */
  int ARROW = 41;
  /** RegularExpression Id. */
  int BREAK = 42;
  /** RegularExpression Id. */
  int CLASS = 43;
  /** RegularExpression Id. */
  int FALSE = 44;
  /** RegularExpression Id. */
  int FUNC = 45;
  /** RegularExpression Id. */
  int IF = 46;
  /** RegularExpression Id. */
  int LET = 47;
  /** RegularExpression Id. */
  int RETURN = 48;
  /** RegularExpression Id. */
  int TRUE = 49;
  /** RegularExpression Id. */
  int VOID = 50;
  /** RegularExpression Id. */
  int WHILE = 51;
  /** RegularExpression Id. */
  int IDENTIFIER = 52;
  /** RegularExpression Id. */
  int LETTER = 53;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\n\"",
    "\"\\r\"",
    "\"\\f\"",
    "<NUMBER_LITERAL>",
    "<DIGIT>",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"%\"",
    "\"**\"",
    "\"&&\"",
    "\"||\"",
    "\"!\"",
    "\"==\"",
    "<NEQ>",
    "\"<\"",
    "<LEQ>",
    "\">\"",
    "<GEQ>",
    "\"(\"",
    "\")\"",
    "\"[\"",
    "\"]\"",
    "\"{\"",
    "\"}\"",
    "\"=\"",
    "<ASADD>",
    "<ASSUB>",
    "<ASMUL>",
    "<ASDIV>",
    "<ASMOD>",
    "\"++\"",
    "\"--\"",
    "\",\"",
    "\".\"",
    "\":\"",
    "\";\"",
    "\"->\"",
    "\"break\"",
    "\"class\"",
    "\"false\"",
    "\"func\"",
    "\"if\"",
    "\"let\"",
    "\"return\"",
    "\"true\"",
    "\"void\"",
    "\"while\"",
    "<IDENTIFIER>",
    "<LETTER>",
  };

}
