
package gameoflife;


public class Pattern {

  private String   name;
  private String[] pattern;


  public String getName() {
    return name;
  }

  void setName(String abcd) {
    this.name = abcd;
  }

  public String[] getPattern() {
    return pattern;
  }

  public void setPattern(String[] xyz) {
    this.pattern = xyz;
  }

  public Pattern(String abc, String[] xyz) {
    this.name = abc;
    this.pattern = xyz;
  }

  public String toString() {
    return name;
  }

  public static Pattern[] setPattern() {
    Pattern[] pattern = new Pattern[4];
    pattern[0] = new Pattern("Worm", new String[]{"0#0", "0##", "#0#"});
    pattern[1] = new Pattern("Block", new String[]{"0##", "0##", "000"});
    pattern[2] = new Pattern("SpaceShip", new String[]{"0##00", "####0", "##0##","00##0"});
    pattern[3] = new Pattern("Blinker", new String[]{"###"});
    return pattern;
  }
}