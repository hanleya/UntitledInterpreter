/* Generated By:JJTree&JavaCC: Do not edit this line. Parser.java */
package AST;

import java.util.ArrayList;

public class Parser/*@bgen(jjtree)*/implements ParserTreeConstants, ParserConstants {/*@bgen(jjtree)*/
  protected static JJTParserState jjtree = new JJTParserState();
    /** Main entry point. */
    public static ASTStart parse(java.io.InputStream stream) {
        System.out.println("Reading from standard input...");
        Parser t = new Parser(stream);
        ASTStart n = null;
        try {
            n = t.Start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return n;
    }

/** Main production. */
  static final public ASTStart Start() throws ParseException {
                           /*@bgen(jjtree) Start */
  ASTStart jjtn000 = new ASTStart(JJTSTART);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case FUNC:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        Function();
      }
      jjtree.closeNodeScope(jjtn000, true);
      jjtc000 = false;
      {if (true) return jjtn000;}
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
    throw new Error("Missing return statement in function");
  }

/* FUNCTION DECLARATION */
  static final public void Function() throws ParseException {
                             /*@bgen(jjtree) Function */
  ASTFunction jjtn000 = new ASTFunction(JJTFUNCTION);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      FunctionHead();
      Block();
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void FunctionHead() throws ParseException {
    jj_consume_token(FUNC);
             ASTIdentifier jjtn001 = new ASTIdentifier(JJTIDENTIFIER);
             boolean jjtc001 = true;
             jjtree.openNodeScope(jjtn001);
    try {
      jj_consume_token(IDENTIFIER);
    } finally {
             if (jjtc001) {
               jjtree.closeNodeScope(jjtn001, true);
             }
    }
    jj_consume_token(LPAREN);
    DefParamList();
    jj_consume_token(RPAREN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ARROW:
      jj_consume_token(ARROW);
      Type();
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
  }

  static final public void DefParamList() throws ParseException {
                                   /*@bgen(jjtree) FuncParams */
  ASTFuncParams jjtn000 = new ASTFuncParams(JJTFUNCPARAMS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDENTIFIER:
        DefParam();
        label_2:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case COMMA:
            ;
            break;
          default:
            jj_la1[2] = jj_gen;
            break label_2;
          }
          jj_consume_token(COMMA);
          DefParam();
        }
        break;
      default:
        jj_la1[3] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void DefParam() throws ParseException {
                                 /*@bgen(jjtree) #FuncParam( 2) */
  ASTFuncParam jjtn000 = new ASTFuncParam(JJTFUNCPARAM);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
       ASTIdentifier jjtn001 = new ASTIdentifier(JJTIDENTIFIER);
       boolean jjtc001 = true;
       jjtree.openNodeScope(jjtn001);
      try {
        jj_consume_token(IDENTIFIER);
      } finally {
       if (jjtc001) {
         jjtree.closeNodeScope(jjtn001, true);
       }
      }
      jj_consume_token(COLON);
      Type();
    } catch (Throwable jjte000) {
       if (jjtc000) {
         jjtree.clearNodeScope(jjtn000);
         jjtc000 = false;
       } else {
         jjtree.popNode();
       }
       if (jjte000 instanceof RuntimeException) {
         {if (true) throw (RuntimeException)jjte000;}
       }
       if (jjte000 instanceof ParseException) {
         {if (true) throw (ParseException)jjte000;}
       }
       {if (true) throw (Error)jjte000;}
    } finally {
       if (jjtc000) {
         jjtree.closeNodeScope(jjtn000,  2);
       }
    }
  }

/* CONTROL FLOW & STATEMENTS */
  static final public void Block() throws ParseException {
                       /*@bgen(jjtree) Block */
  ASTBlock jjtn000 = new ASTBlock(JJTBLOCK);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(LBRACKET);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case NUMBER_LITERAL:
        case NOT:
        case LPAREN:
        case INC:
        case DEC:
        case LET:
        case IDENTIFIER:
          ;
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_3;
        }
        Statement();
      }
      jj_consume_token(RBRACKET);
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

  static final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LET:
      VarDecl();
      jj_consume_token(SCOLON);
      break;
    case NUMBER_LITERAL:
    case NOT:
    case LPAREN:
    case INC:
    case DEC:
    case IDENTIFIER:
      Expression();
      jj_consume_token(SCOLON);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void VarDecl() throws ParseException {
                              /*@bgen(jjtree) #VarDecl( 3) */
  ASTVarDecl jjtn000 = new ASTVarDecl(JJTVARDECL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(LET);
            ASTIdentifier jjtn001 = new ASTIdentifier(JJTIDENTIFIER);
            boolean jjtc001 = true;
            jjtree.openNodeScope(jjtn001);
      try {
        jj_consume_token(IDENTIFIER);
      } finally {
            if (jjtc001) {
              jjtree.closeNodeScope(jjtn001, true);
            }
      }
      jj_consume_token(COLON);
      Type();
      jj_consume_token(ASSIGN);
      Expression();
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000,  3);
      }
    }
  }

/* DATA CONSTRUCTS? */
  static final public void Type() throws ParseException {
                     /*@bgen(jjtree) Type */
  ASTType jjtn000 = new ASTType(JJTTYPE);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(IDENTIFIER);
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, true);
      }
    }
  }

/* EXPRESSIONS */
  static final public void Expression() throws ParseException {
    AssignmentExp();
  }

  static final public void AssignmentExp() throws ParseException {
                                           /*@bgen(jjtree) #AssignmentExp(> 1) */
  ASTAssignmentExp jjtn000 = new ASTAssignmentExp(JJTASSIGNMENTEXP);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      OrExp();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ASSIGN:
      case ASADD:
      case ASSUB:
      case ASMUL:
      case ASDIV:
      case ASMOD:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ASSIGN:
          jj_consume_token(ASSIGN);
                            jjtn000.type = ASTAssignmentExp.EXP_TYPE.ASSIGN;
          break;
        case ASADD:
          jj_consume_token(ASADD);
                            jjtn000.type = ASTAssignmentExp.EXP_TYPE.APLUS;
          break;
        case ASSUB:
          jj_consume_token(ASSUB);
                            jjtn000.type = ASTAssignmentExp.EXP_TYPE.AMINUS;
          break;
        case ASMUL:
          jj_consume_token(ASMUL);
                            jjtn000.type = ASTAssignmentExp.EXP_TYPE.AMUL;
          break;
        case ASDIV:
          jj_consume_token(ASDIV);
                            jjtn000.type = ASTAssignmentExp.EXP_TYPE.ADIV;
          break;
        case ASMOD:
          jj_consume_token(ASMOD);
                            jjtn000.type = ASTAssignmentExp.EXP_TYPE.AMOD;
          break;
        default:
          jj_la1[6] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        AssignmentExp();
        break;
      default:
        jj_la1[7] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void OrExp() throws ParseException {
                           /*@bgen(jjtree) #OrExp(> 1) */
  ASTOrExp jjtn000 = new ASTOrExp(JJTOREXP);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      AndExp();
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case OR:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_4;
        }
        jj_consume_token(OR);
        AndExp();
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void AndExp() throws ParseException {
                             /*@bgen(jjtree) #AndExp(> 1) */
  ASTAndExp jjtn000 = new ASTAndExp(JJTANDEXP);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      BoolExp();
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case AND:
          ;
          break;
        default:
          jj_la1[9] = jj_gen;
          break label_5;
        }
        jj_consume_token(AND);
        BoolExp();
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void BoolExp() throws ParseException {
                               /*@bgen(jjtree) #BoolExp(> 1) */
  ASTBoolExp jjtn000 = new ASTBoolExp(JJTBOOLEXP);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      AddExp();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EQ:
      case NEQ:
      case LT:
      case LEQ:
      case GT:
      case GEQ:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case EQ:
          jj_consume_token(EQ);
                          jjtn000.type = ASTBoolExp.EXP_TYPE.EQ;
          break;
        case NEQ:
          jj_consume_token(NEQ);
                          jjtn000.type = ASTBoolExp.EXP_TYPE.NEQ;
          break;
        case LT:
          jj_consume_token(LT);
                          jjtn000.type = ASTBoolExp.EXP_TYPE.LT;
          break;
        case LEQ:
          jj_consume_token(LEQ);
                          jjtn000.type = ASTBoolExp.EXP_TYPE.LEQ;
          break;
        case GT:
          jj_consume_token(GT);
                          jjtn000.type = ASTBoolExp.EXP_TYPE.GT;
          break;
        case GEQ:
          jj_consume_token(GEQ);
                          jjtn000.type = ASTBoolExp.EXP_TYPE.GEQ;
          break;
        default:
          jj_la1[10] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        AddExp();
        break;
      default:
        jj_la1[11] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void AddExp() throws ParseException {
                             /*@bgen(jjtree) #AddExp(> 1) */
                              ASTAddExp jjtn000 = new ASTAddExp(JJTADDEXP);
                              boolean jjtc000 = true;
                              jjtree.openNodeScope(jjtn000);ArrayList<ASTAddExp.OP> arr = jjtn000.op;
    try {
      MulExp();
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PLUS:
        case MINUS:
          ;
          break;
        default:
          jj_la1[12] = jj_gen;
          break label_6;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PLUS:
          jj_consume_token(PLUS);
                            arr.add(ASTAddExp.OP.PLUS);
          break;
        case MINUS:
          jj_consume_token(MINUS);
                            arr.add(ASTAddExp.OP.MINUS);
          break;
        default:
          jj_la1[13] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        MulExp();
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void MulExp() throws ParseException {
                             /*@bgen(jjtree) #MulExp(> 1) */
                              ASTMulExp jjtn000 = new ASTMulExp(JJTMULEXP);
                              boolean jjtc000 = true;
                              jjtree.openNodeScope(jjtn000);ArrayList<ASTMulExp.OP> arr = jjtn000.op;
    try {
      ExpoExp();
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MUL:
        case DIV:
        case MOD:
          ;
          break;
        default:
          jj_la1[14] = jj_gen;
          break label_7;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case MUL:
          jj_consume_token(MUL);
                          arr.add(ASTMulExp.OP.MUL);
          break;
        case DIV:
          jj_consume_token(DIV);
                          arr.add(ASTMulExp.OP.DIV);
          break;
        case MOD:
          jj_consume_token(MOD);
                          arr.add(ASTMulExp.OP.MOD);
          break;
        default:
          jj_la1[15] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        ExpoExp();
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void ExpoExp() throws ParseException {
                               /*@bgen(jjtree) #ExpoExp(> 1) */
  ASTExpoExp jjtn000 = new ASTExpoExp(JJTEXPOEXP);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      PrefixExp();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case POWER:
        jj_consume_token(POWER);
        ExpoExp();
        break;
      default:
        jj_la1[16] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void PrefixExp() throws ParseException {
                     boolean prefix = false;
      ASTPrefixExp jjtn001 = new ASTPrefixExp(JJTPREFIXEXP);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NOT:
      case INC:
      case DEC:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INC:
          jj_consume_token(INC);
                          jjtn001.op = ASTPrefixExp.OP.INC;
          break;
        case DEC:
          jj_consume_token(DEC);
                          jjtn001.op = ASTPrefixExp.OP.DEC;
          break;
        case NOT:
          jj_consume_token(NOT);
                          jjtn001.op = ASTPrefixExp.OP.NOT;
          break;
        default:
          jj_la1[17] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
              prefix = true;
        break;
      default:
        jj_la1[18] = jj_gen;
        ;
      }
      SuffixExp();
    } catch (Throwable jjte001) {
      if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
      if (jjtc001) {
        jjtree.closeNodeScope(jjtn001,  prefix);
      }
    }
  }

  static final public void SuffixExp() throws ParseException {
                     boolean suffix = false;
      ASTSuffixExp jjtn001 = new ASTSuffixExp(JJTSUFFIXEXP);
      boolean jjtc001 = true;
      jjtree.openNodeScope(jjtn001);
    try {
      AccessExp();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INC:
      case DEC:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INC:
          jj_consume_token(INC);
                          jjtn001.op = ASTSuffixExp.OP.INC;
          break;
        case DEC:
          jj_consume_token(DEC);
                          jjtn001.op = ASTSuffixExp.OP.DEC;
          break;
        default:
          jj_la1[19] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
              suffix = true;
        break;
      default:
        jj_la1[20] = jj_gen;
        ;
      }
    } catch (Throwable jjte001) {
      if (jjtc001) {
        jjtree.clearNodeScope(jjtn001);
        jjtc001 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte001 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte001;}
      }
      if (jjte001 instanceof ParseException) {
        {if (true) throw (ParseException)jjte001;}
      }
      {if (true) throw (Error)jjte001;}
    } finally {
      if (jjtc001) {
        jjtree.closeNodeScope(jjtn001,  suffix);
      }
    }
  }

  static final public void AccessExp() throws ParseException {
                                   /*@bgen(jjtree) #AccessExp(> 1) */
  ASTAccessExp jjtn000 = new ASTAccessExp(JJTACCESSEXP);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      Subscript();
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DOT:
          ;
          break;
        default:
          jj_la1[21] = jj_gen;
          break label_8;
        }
        jj_consume_token(DOT);
        Subscript();
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void Subscript() throws ParseException {
                                   /*@bgen(jjtree) #Subscript(> 1) */
  ASTSubscript jjtn000 = new ASTSubscript(JJTSUBSCRIPT);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      FunctionCall();
      label_9:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACE:
          ;
          break;
        default:
          jj_la1[22] = jj_gen;
          break label_9;
        }
        jj_consume_token(LBRACE);
        Expression();
        jj_consume_token(RBRACE);
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void FunctionCall() throws ParseException {
                                         /*@bgen(jjtree) #FunctionCall(> 1) */
  ASTFunctionCall jjtn000 = new ASTFunctionCall(JJTFUNCTIONCALL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      ParenExp();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LPAREN:
        jj_consume_token(LPAREN);
        Expression();
        label_10:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case COMMA:
            ;
            break;
          default:
            jj_la1[23] = jj_gen;
            break label_10;
          }
          jj_consume_token(COMMA);
          Expression();
        }
        jj_consume_token(RPAREN);
        break;
      default:
        jj_la1[24] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
      if (jjtc000) {
        jjtree.clearNodeScope(jjtn000);
        jjtc000 = false;
      } else {
        jjtree.popNode();
      }
      if (jjte000 instanceof RuntimeException) {
        {if (true) throw (RuntimeException)jjte000;}
      }
      if (jjte000 instanceof ParseException) {
        {if (true) throw (ParseException)jjte000;}
      }
      {if (true) throw (Error)jjte000;}
    } finally {
      if (jjtc000) {
        jjtree.closeNodeScope(jjtn000, jjtree.nodeArity() > 1);
      }
    }
  }

  static final public void ParenExp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LPAREN:
      jj_consume_token(LPAREN);
      Expression();
      jj_consume_token(RPAREN);
      break;
    case NUMBER_LITERAL:
                                           ASTNumberLiteral jjtn001 = new ASTNumberLiteral(JJTNUMBERLITERAL);
                                           boolean jjtc001 = true;
                                           jjtree.openNodeScope(jjtn001);
      try {
        jj_consume_token(NUMBER_LITERAL);
      } finally {
                                           if (jjtc001) {
                                             jjtree.closeNodeScope(jjtn001,  0);
                                           }
      }
      break;
    case IDENTIFIER:
                                                                                ASTIdentifier jjtn002 = new ASTIdentifier(JJTIDENTIFIER);
                                                                                boolean jjtc002 = true;
                                                                                jjtree.openNodeScope(jjtn002);
      try {
        jj_consume_token(IDENTIFIER);
      } finally {
                                                                                if (jjtc002) {
                                                                                  jjtree.closeNodeScope(jjtn002,  0);
                                                                                }
      }
      break;
    default:
      jj_la1[25] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[26];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x0,0x0,0x810040,0x810040,0xe0000000,0xe0000000,0x8000,0x4000,0x7e0000,0x7e0000,0x300,0x300,0x1c00,0x1c00,0x2000,0x10000,0x10000,0x0,0x0,0x0,0x2000000,0x0,0x800000,0x800040,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x1000,0x200,0x20,0x80000,0x84018,0x84018,0x7,0x7,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x18,0x18,0x18,0x18,0x40,0x0,0x20,0x0,0x80000,};
   }

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 26; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List jj_expentries = new java.util.ArrayList();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[53];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 26; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 53; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}