/* Generated By:JavaCC: Do not edit this line. Simple1.java */
import java.io.* ;
import java.util.* ;

class Automate {
  public Etat first;
  public Etat last;
  public Automate(){
    this.first = new Etat();
    this.last = new Etat();
  }
}

class Etat {
  public int id;
  static int nb = 1;
  public Etat(){
    this.id = nb++;
  }
}

class Manager {
  public static int[][] tab = new int[70][8];
  public static HashMap<String, String> Comps = new HashMap<String, String>();

  public void add(int i,int j,String e){
    this.tab[i][7] = 1 ;
    this.tab[j][7] = 1 ;
    switch (e) {
      case "Click":
        this.tab[i][0] = j ;
        break;
      case "Dbclick":
        this.tab[i][1] = j ;
        break;
      case "ChrKeyPress":
        this.tab[i][2] = j ;
        break;
      case "NumKeyPress":
        this.tab[i][3] = j ;
        break;
      case "EntrerKeyPress":
        this.tab[i][4] = j ;
        break;
      case "Drag":
        this.tab[i][5] = j ;
        break;
      case "Drop":
        this.tab[i][6] = j ;
        break;

      default:
        break;
    }
  }

  public void update(int k,int j){

    // copy
    for (int i = 0; i < 7; i++) {
      if (this.tab[j][i]==0 && this.tab[k][i]!=0) {
        this.tab[j][i] = this.tab[k][i];
      }
    }
    // update
    for (int i = 0; i < 70; i++) {
      for (int m = 0; m < 7; m++) {
        if (this.tab[i][m] == k) {
          this.tab[i][m] = j ;
        }
      }
    }

    this.tab[k][7] = 0 ;
  }
}


class Simple1 implements Simple1Constants {


  public static void main(String args[]) throws ParseException, FileNotFoundException {

    try {
      Simple1 parser = new Simple1(new FileInputStream("Prog.ihm"));
      parser.Input();
    } catch(FileNotFoundException ex){ }

    try
    {
        PrintWriter pr = new PrintWriter("Automate.aef");

        for (int i = 1; i < 70; i++) {
          if (Manager.tab[i][7] == 1) {
            pr.println("Etat("+i+") : Click("+Manager.tab[i][0]+"), Dbclick("+Manager.tab[i][1]+"), Drag("+Manager.tab[i][5]+")");
          }
        }

        pr.close();
    }
    catch (Exception e)
    {
        e.printStackTrace();
        System.out.println("No such file exists.");
    }

    try
    {
        PrintWriter pr = new PrintWriter("Composants.gui");

        for (String name: Manager.Comps.keySet()){
          String key =name.toString();
          String value = Manager.Comps.get(name).toString();
          pr.println(key + ": " + value);
        }

        pr.close();
    }
    catch (Exception e)
    {
        e.printStackTrace();
        System.out.println("No such file exists.");
    }
  }

  static final public void Input() throws ParseException {
  Token id, type, p, t ;
  String[] Types = new String[5];
  int i = 0;
  String prop = "";
    jj_consume_token(KWDEBUT);
    jj_consume_token(KWINTER);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case KWCOMP:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
     prop = "[ ";
      jj_consume_token(KWCOMP);
      id = jj_consume_token(ID);
      jj_consume_token(KWTWOP);
      type = jj_consume_token(TYPE);
      jj_consume_token(KWPV);
      jj_consume_token(KWPROP);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ID:
          ;
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_2;
        }
        p = jj_consume_token(ID);
        jj_consume_token(KWTWOP);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PROPTYPE:
          t = jj_consume_token(PROPTYPE);
          break;
        case 20:
          jj_consume_token(20);
          t = jj_consume_token(ID);
          label_3:
          while (true) {
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case 21:
              ;
              break;
            default:
              jj_la1[2] = jj_gen;
              break label_3;
            }
            jj_consume_token(21);
            jj_consume_token(ID);
          }
          jj_consume_token(22);
          break;
        default:
          jj_la1[3] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        jj_consume_token(KWPV);
         prop += p.image + ": "+ t.image +" ; ";
      }
      jj_consume_token(KWEVT);
     prop += "]";
     Manager.Comps.put(id.image+" ("+type.image+")", prop);
    }
    jj_consume_token(KWACT);
    A();
    jj_consume_token(0);
  }

/** Actions section. */
  static final public Automate A() throws ParseException {
  Automate a;
  Token id;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 20:
      jj_consume_token(20);
      a = A();
      jj_consume_token(22);
      Y(a);
                      {if (true) return a;}
      break;
    case ID:
      a = Event();
               {if (true) return a;}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Automate Event() throws ParseException {
  Automate a1;
  Token id;
  Manager m = new Manager();
   a1=new Automate();
    id = jj_consume_token(ID);
    jj_consume_token(23);
    jj_consume_token(ID);
    jj_consume_token(24);
   m.add(a1.first.id , a1.last.id , id.image);
    Y(a1);
   {if (true) return a1;}
    throw new Error("Missing return statement in function");
  }

  static final public void Y(Automate ag) throws ParseException {
  Automate ad, tmp;
  Manager m = new Manager();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case KWPV:
      jj_consume_token(KWPV);
      ad = A();
    m.update(ad.first.id , ag.last.id);

    ag.last = ad.last;

    tmp=new Automate();
    tmp.first=ag.first;
    tmp.last=ad.last;
      Y(tmp);
      break;
    case CHOIX:
      jj_consume_token(CHOIX);
      ad = A();
    m.update(ad.first.id,ag.first.id);
    m.update(ad.last.id,ag.last.id);


    tmp=new Automate();
    tmp.first=ag.first;
    tmp.last=ad.last;
      Y(tmp);
      break;
    case ALTERNATIVE:
      jj_consume_token(ALTERNATIVE);
      ad = A();
    m.update(ad.first.id,ag.first.id);

    tmp=new Automate();
    tmp.first=ag.first;
      Y(tmp);
      break;
    default:
      jj_la1[6] = jj_gen;
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 25:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_4;
        }
        jj_consume_token(25);
      }
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public Simple1TokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[7];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x80,0x80000,0x200000,0x140000,0x180000,0x2000000,0x1a000,};
   }

  /** Constructor with InputStream. */
  public Simple1(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Simple1(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new Simple1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
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
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Simple1(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new Simple1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Simple1(Simple1TokenManager tm) {
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
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(Simple1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
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

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[26];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 7; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 26; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
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