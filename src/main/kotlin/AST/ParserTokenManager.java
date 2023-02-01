/* Generated By:JJTree&JavaCC: Do not edit this line. ParserTokenManager.java */
package AST;
import java.util.ArrayList;

/** Token Manager. */
public class ParserTokenManager implements ParserConstants
{

  /** Debug output. */
  public static  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public static  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private static final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x10000L) != 0L)
            return 3;
         if ((active0 & 0x1000L) != 0L)
            return 17;
         if ((active0 & 0x20020000L) != 0L)
            return 22;
         if ((active0 & 0x800L) != 0L)
            return 15;
         if ((active0 & 0x800000100L) != 0L)
            return 9;
         if ((active0 & 0x2400L) != 0L)
            return 13;
         if ((active0 & 0x200000L) != 0L)
            return 7;
         if ((active0 & 0xffc0000000000L) != 0L)
         {
            jjmatchedKind = 52;
            return 20;
         }
         if ((active0 & 0x21000000200L) != 0L)
            return 11;
         if ((active0 & 0x80000L) != 0L)
            return 5;
         return -1;
      case 1:
         if ((active0 & 0x400000000000L) != 0L)
            return 20;
         if ((active0 & 0xfbc0000000000L) != 0L)
         {
            jjmatchedKind = 52;
            jjmatchedPos = 1;
            return 20;
         }
         return -1;
      case 2:
         if ((active0 & 0xf3c0000000000L) != 0L)
         {
            jjmatchedKind = 52;
            jjmatchedPos = 2;
            return 20;
         }
         if ((active0 & 0x800000000000L) != 0L)
            return 20;
         return -1;
      case 3:
         if ((active0 & 0x91c0000000000L) != 0L)
         {
            jjmatchedKind = 52;
            jjmatchedPos = 3;
            return 20;
         }
         if ((active0 & 0x6200000000000L) != 0L)
            return 20;
         return -1;
      case 4:
         if ((active0 & 0x1000000000000L) != 0L)
         {
            jjmatchedKind = 52;
            jjmatchedPos = 4;
            return 20;
         }
         if ((active0 & 0x81c0000000000L) != 0L)
            return 20;
         return -1;
      default :
         return -1;
   }
}
private static final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
static private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
static private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         return jjStartNfaWithStates_0(0, 16, 3);
      case 37:
         return jjStartNfaWithStates_0(0, 12, 17);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 40:
         return jjStopAtPos(0, 23);
      case 41:
         return jjStopAtPos(0, 24);
      case 42:
         jjmatchedKind = 10;
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 43:
         jjmatchedKind = 8;
         return jjMoveStringLiteralDfa1_0(0x800000000L);
      case 44:
         return jjStopAtPos(0, 37);
      case 45:
         jjmatchedKind = 9;
         return jjMoveStringLiteralDfa1_0(0x21000000000L);
      case 46:
         return jjStopAtPos(0, 38);
      case 47:
         return jjStartNfaWithStates_0(0, 11, 15);
      case 58:
         return jjStopAtPos(0, 39);
      case 59:
         return jjStopAtPos(0, 40);
      case 60:
         return jjStartNfaWithStates_0(0, 19, 5);
      case 61:
         jjmatchedKind = 29;
         return jjMoveStringLiteralDfa1_0(0x20000L);
      case 62:
         return jjStartNfaWithStates_0(0, 21, 7);
      case 91:
         return jjStopAtPos(0, 25);
      case 93:
         return jjStopAtPos(0, 26);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x40000000000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x80000000000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x300000000000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x400000000000L);
      case 108:
         return jjMoveStringLiteralDfa1_0(0x800000000000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x1000000000000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x2000000000000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x4000000000000L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x8000000000000L);
      case 123:
         return jjStopAtPos(0, 27);
      case 124:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 125:
         return jjStopAtPos(0, 28);
      default :
         return jjMoveNfa_0(4, 0);
   }
}
static private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x4000L) != 0L)
            return jjStopAtPos(1, 14);
         break;
      case 42:
         if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(1, 13);
         break;
      case 43:
         if ((active0 & 0x800000000L) != 0L)
            return jjStopAtPos(1, 35);
         break;
      case 45:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStopAtPos(1, 36);
         break;
      case 61:
         if ((active0 & 0x20000L) != 0L)
            return jjStopAtPos(1, 17);
         break;
      case 62:
         if ((active0 & 0x20000000000L) != 0L)
            return jjStopAtPos(1, 41);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000000000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x1800000000000L);
      case 102:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 46, 20);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000000000L);
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x80000000000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000000000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x2040000000000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x200000000000L);
      case 124:
         if ((active0 & 0x8000L) != 0L)
            return jjStopAtPos(1, 15);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
static private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x80000000000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000000000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0xc000000000000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x100000000000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x200000000000L);
      case 116:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 47, 20);
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000000000L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
static private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000000000L);
      case 99:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 45, 20);
         break;
      case 100:
         if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 50, 20);
         break;
      case 101:
         if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 49, 20);
         break;
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000000000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x180000000000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
static private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 44, 20);
         else if ((active0 & 0x8000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 51, 20);
         break;
      case 107:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 42, 20);
         break;
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000000000000L);
      case 115:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 43, 20);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
static private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 110:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 48, 20);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
static private int jjMoveNfa_0(int startState, int curPos)
{
   //int[] nextStates; // not used
   int startsAt = 0;
   jjnewStateCnt = 30;
   int i = 1;
   jjstateSet[0] = startState;
   //int j; // not used
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 22:
                  if (curChar == 37)
                  {
                     if (kind > 34)
                        kind = 34;
                  }
                  else if (curChar == 47)
                  {
                     if (kind > 33)
                        kind = 33;
                  }
                  else if (curChar == 42)
                  {
                     if (kind > 32)
                        kind = 32;
                  }
                  else if (curChar == 45)
                  {
                     if (kind > 31)
                        kind = 31;
                  }
                  else if (curChar == 43)
                  {
                     if (kind > 30)
                        kind = 30;
                  }
                  else if (curChar == 62)
                  {
                     if (kind > 22)
                        kind = 22;
                  }
                  else if (curChar == 60)
                  {
                     if (kind > 20)
                        kind = 20;
                  }
                  else if (curChar == 49)
                  {
                     if (kind > 18)
                        kind = 18;
                  }
                  break;
               case 4:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 6)
                        kind = 6;
                     jjCheckNAddTwoStates(0, 1);
                  }
                  else if (curChar == 61)
                     jjAddStates(0, 7);
                  else if (curChar == 37)
                     jjstateSet[jjnewStateCnt++] = 17;
                  else if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 15;
                  else if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 13;
                  else if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 11;
                  else if (curChar == 43)
                     jjstateSet[jjnewStateCnt++] = 9;
                  else if (curChar == 62)
                     jjstateSet[jjnewStateCnt++] = 7;
                  else if (curChar == 60)
                     jjstateSet[jjnewStateCnt++] = 5;
                  else if (curChar == 33)
                     jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjCheckNAddTwoStates(0, 1);
                  break;
               case 1:
                  if (curChar == 46)
                     jjCheckNAdd(2);
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjCheckNAdd(2);
                  break;
               case 3:
                  if (curChar == 61 && kind > 18)
                     kind = 18;
                  break;
               case 5:
                  if (curChar == 61 && kind > 20)
                     kind = 20;
                  break;
               case 6:
                  if (curChar == 60)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 7:
                  if (curChar == 61 && kind > 22)
                     kind = 22;
                  break;
               case 8:
                  if (curChar == 62)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 9:
                  if (curChar == 61 && kind > 30)
                     kind = 30;
                  break;
               case 10:
                  if (curChar == 43)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 11:
                  if (curChar == 61 && kind > 31)
                     kind = 31;
                  break;
               case 12:
                  if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 13:
                  if (curChar == 61 && kind > 32)
                     kind = 32;
                  break;
               case 14:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 13;
                  break;
               case 15:
                  if (curChar == 61 && kind > 33)
                     kind = 33;
                  break;
               case 16:
                  if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 17:
                  if (curChar == 61 && kind > 34)
                     kind = 34;
                  break;
               case 18:
                  if (curChar == 37)
                     jjstateSet[jjnewStateCnt++] = 17;
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 52)
                     kind = 52;
                  jjstateSet[jjnewStateCnt++] = 20;
                  break;
               case 21:
                  if (curChar == 61)
                     jjAddStates(0, 7);
                  break;
               case 23:
                  if (curChar == 60 && kind > 20)
                     kind = 20;
                  break;
               case 24:
                  if (curChar == 62 && kind > 22)
                     kind = 22;
                  break;
               case 25:
                  if (curChar == 43 && kind > 30)
                     kind = 30;
                  break;
               case 26:
                  if (curChar == 45 && kind > 31)
                     kind = 31;
                  break;
               case 27:
                  if (curChar == 42 && kind > 32)
                     kind = 32;
                  break;
               case 28:
                  if (curChar == 47 && kind > 33)
                     kind = 33;
                  break;
               case 29:
                  if (curChar == 37 && kind > 34)
                     kind = 34;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 4:
               case 20:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 52)
                     kind = 52;
                  jjCheckNAdd(20);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 30 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   22, 23, 24, 25, 26, 27, 28, 29, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, "\53", "\55", "\52", "\57", 
"\45", "\52\52", "\46\46", "\174\174", "\41", "\75\75", null, "\74", null, "\76", 
null, "\50", "\51", "\133", "\135", "\173", "\175", "\75", null, null, null, null, 
null, "\53\53", "\55\55", "\54", "\56", "\72", "\73", "\55\76", 
"\142\162\145\141\153", "\143\154\141\163\163", "\146\141\154\163\145", "\146\165\156\143", 
"\151\146", "\154\145\164", "\162\145\164\165\162\156", "\164\162\165\145", 
"\166\157\151\144", "\167\150\151\154\145", null, null, };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT", 
};
static final long[] jjtoToken = {
   0x1fffffffffff41L, 
};
static final long[] jjtoSkip = {
   0x3eL, 
};
static protected SimpleCharStream input_stream;
static private final int[] jjrounds = new int[30];
static private final int[] jjstateSet = new int[60];
static protected char curChar;
/** Constructor. */
public ParserTokenManager(SimpleCharStream stream){
   if (input_stream != null)
      throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", TokenMgrError.STATIC_LEXER_ERROR);
   input_stream = stream;
}

/** Constructor. */
public ParserTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
static private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 30; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
static public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
static public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

static protected Token jjFillToken()
{
   final Token t;
   final String tokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   tokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, tokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

static int curLexState = 0;
static int defaultLexState = 0;
static int jjnewStateCnt;
static int jjround;
static int jjmatchedPos;
static int jjmatchedKind;

/** Get the next Token. */
public static Token getNextToken() 
{
  //int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100003600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

static private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
static private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
static private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

static private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
