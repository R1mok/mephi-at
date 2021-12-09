
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

import java_cup.runtime.*;
import javafx.util.Pair;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\026\000\002\002\004\000\002\002\004\000\002\002" +
    "\003\000\002\002\004\000\002\002\003\000\002\005\005" +
    "\000\002\005\004\000\002\004\007\000\002\004\003\000" +
    "\002\011\005\000\002\013\002\000\002\003\005\000\002" +
    "\006\007\000\002\006\007\000\002\006\003\000\002\007" +
    "\005\000\002\007\005\000\002\007\003\000\002\010\005" +
    "\000\002\010\003\000\002\010\003\000\002\010\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\050\000\014\011\016\016\006\017\012\020\011\021" +
    "\020\001\002\000\004\004\051\001\002\000\014\004\ufff0" +
    "\007\ufff0\010\ufff0\012\ufff0\013\ufff0\001\002\000\014\004" +
    "\uffee\007\uffee\010\uffee\012\uffee\013\uffee\001\002\000\016" +
    "\002\047\011\016\016\006\017\012\020\011\021\020\001" +
    "\002\000\016\002\uffff\011\uffff\016\uffff\017\uffff\020\uffff" +
    "\021\uffff\001\002\000\004\013\044\001\002\000\014\004" +
    "\uffed\007\uffed\010\uffed\012\uffed\013\uffed\001\002\000\014" +
    "\004\ufff3\007\033\010\032\012\ufff3\013\ufff3\001\002\000" +
    "\006\004\ufff7\013\025\001\002\000\016\002\ufffd\011\ufffd" +
    "\016\ufffd\017\ufffd\020\ufffd\021\ufffd\001\002\000\012\011" +
    "\016\016\006\017\012\021\020\001\002\000\006\004\ufff9" +
    "\013\021\001\002\000\014\004\uffec\007\uffec\010\uffec\012" +
    "\uffec\013\uffec\001\002\000\004\014\022\001\002\000\004" +
    "\013\023\001\002\000\012\011\016\016\006\017\012\021" +
    "\020\001\002\000\006\004\ufffa\013\025\001\002\000\006" +
    "\005\026\006\027\001\002\000\004\013\036\001\002\000" +
    "\004\013\030\001\002\000\012\011\016\016\006\017\012" +
    "\021\020\001\002\000\014\004\ufff4\007\033\010\032\012" +
    "\ufff4\013\ufff4\001\002\000\012\011\016\016\006\017\012" +
    "\021\020\001\002\000\012\011\016\016\006\017\012\021" +
    "\020\001\002\000\014\004\ufff2\007\ufff2\010\ufff2\012\ufff2" +
    "\013\ufff2\001\002\000\014\004\ufff1\007\ufff1\010\ufff1\012" +
    "\ufff1\013\ufff1\001\002\000\012\011\016\016\006\017\012" +
    "\021\020\001\002\000\014\004\ufff5\007\033\010\032\012" +
    "\ufff5\013\ufff5\001\002\000\006\012\041\013\025\001\002" +
    "\000\014\004\uffef\007\uffef\010\uffef\012\uffef\013\uffef\001" +
    "\002\000\004\004\043\001\002\000\016\002\ufff6\011\ufff6" +
    "\016\ufff6\017\ufff6\020\ufff6\021\ufff6\001\002\000\004\021" +
    "\045\001\002\000\006\004\ufff8\013\ufff8\001\002\000\016" +
    "\002\001\011\001\016\001\017\001\020\001\021\001\001" +
    "\002\000\004\002\000\001\002\000\016\002\ufffe\011\ufffe" +
    "\016\ufffe\017\ufffe\020\ufffe\021\ufffe\001\002\000\020\002" +
    "\ufffb\011\ufffb\015\052\016\ufffb\017\ufffb\020\ufffb\021\ufffb" +
    "\001\002\000\016\002\ufffc\011\ufffc\016\ufffc\017\ufffc\020" +
    "\ufffc\021\ufffc\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\050\000\022\002\006\003\014\004\003\005\007\006" +
    "\013\007\012\010\004\011\016\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\020\003\047\004" +
    "\003\005\045\006\013\007\012\010\004\011\016\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\013\041\001\001\000\002\001\001" +
    "\000\010\006\037\007\012\010\004\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\010\006\023\007\012\010\004\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\007\030\010\004\001\001\000\002\001\001\000" +
    "\004\010\034\001\001\000\004\010\033\001\001\000\002" +
    "\001\001\000\002\001\001\000\006\007\036\010\004\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    Set<Pair<String, Integer>> varArray = new HashSet();
    /* Change the method report_error so it will display the line and
       column of where the error occurred in the input as well as the
       reason for the error which is passed into the method in the
       String 'message'. */
    public void report_error(String message, Object info) {
   
        /* Create a StringBuilder called 'm' with the string 'Error' in it. */
        StringBuilder m = new StringBuilder("Error");
   
        /* Check if the information passed to the method is the same
           type as the type java_cup.runtime.Symbol. */
        if (info instanceof java_cup.runtime.Symbol) {
            /* Declare a java_cup.runtime.Symbol object 's' with the
               information in the object info that is being typecasted
               as a java_cup.runtime.Symbol object. */
            java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);
   
            /* Check if the line number in the input is greater or
               equal to zero. */
            if (s.left >= 0) {                
                /* Add to the end of the StringBuilder error message
                   the line number of the error in the input. */
                m.append(" in line "+(s.left+1));   
                /* Check if the column number in the input is greater
                   or equal to zero. */
                if (s.right >= 0)                    
                    /* Add to the end of the StringBuilder error message
                       the column number of the error in the input. */
                    m.append(", column "+(s.right+1));
            }
        }
   
        /* Add to the end of the StringBuilder error message created in
           this method the message that was passed into this method. */
        m.append(" : "+message);
   
        /* Print the contents of the StringBuilder 'm', which contains
           an error message, out on a line. */
        System.err.println(m);
    }
   
    /* Change the method report_fatal_error so when it reports a fatal
       error it will display the line and column number of where the
       fatal error occurred in the input as well as the reason for the
       fatal error which is passed into the method in the object
       'message' and then exit.*/
    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        System.exit(1);
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // expr_list ::= expr_list initialize 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= expr_list EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // expr_list ::= initialize 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // expr_list ::= expr_list expr_part 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // expr_list ::= expr_part 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr_list",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // initialize ::= initialize_part SEMI LT 
            {
              Object RESULT =null;
		 System.out.print(";\n");
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("initialize",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // initialize ::= initialize_part SEMI 
            {
              Object RESULT =null;
		 System.out.print(";");
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("initialize",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // initialize_part ::= defenition SPACE EQUALS SPACE expr 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer n = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                     System.out.print(" = " + n);
                     for (Pair<String, Integer> el : varArray) {
                         if (Objects.equals(el.getKey(), e)){
                              Pair<String, Integer> elem;
                              elem = new Pair<>(e, n);
                              varArray.remove(el);
                              varArray.add(elem);
                              break;
                         }
                     }
                     
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("initialize_part",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // initialize_part ::= defenition 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String e = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("initialize_part",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // defenition ::= VALUE SPACE WORD 
            {
              String RESULT =null;
		int vleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		String v = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int wleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int wright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String w = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 Pair<String, Integer> p = new Pair(w, 0);
                     varArray.add(p);
                     System.out.print(v + " " + w);
                     RESULT = w;
                     
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("defenition",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // NT$0 ::= 
            {
              Object RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
 System.out.println(" = " + e); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("NT$0",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // expr_part ::= expr NT$0 SEMI 
            {
              Object RESULT =null;
              // propagate RESULT from NT$0
                RESULT = (Object) ((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr_part",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // expr ::= expr SPACE PLUS SPACE factor 
            {
              Integer RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer f = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Integer(e.intValue() + f.intValue()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // expr ::= expr SPACE MINUS SPACE factor 
            {
              Integer RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-4)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer f = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Integer(e.intValue() - f.intValue()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // expr ::= factor 
            {
              Integer RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer f = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Integer(f.intValue()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // factor ::= factor TIMES term 
            {
              Integer RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Integer f = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer t = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Integer(f.intValue() * t.intValue()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // factor ::= factor DIVIDE term 
            {
              Integer RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int fright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Integer f = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer t = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Integer(f.intValue() / t.intValue()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // factor ::= term 
            {
              Integer RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer t = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = new Integer(t.intValue()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // term ::= LPAREN expr RPAREN 
            {
              Integer RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Integer e = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 RESULT = e; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // term ::= NUMBER 
            {
              Integer RESULT =null;
		int nleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int nright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer n = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = n; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // term ::= ID 
            {
              Integer RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Integer i = (Integer)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = i; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // term ::= WORD 
            {
              Integer RESULT =null;
		int wleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int wright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String w = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		
                 for (Pair<String, Integer> el : varArray) {
                    if (Objects.equals(el.getKey(), w)){
                    RESULT = el.getValue();
                    break;
                    }
                 }
                 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}