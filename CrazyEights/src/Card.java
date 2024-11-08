class Card 
  {
    private String rank;
    private String suit;
    private int value;

    public Card (String r, String s, int v)
    {
      rank = r;
      suit = s;
      value = v;
    }

    public String getRank()
    {
      return rank;
    }

    public void setRank(String r)
    {
      rank = r;
    }

    public String getSuit()
    {
      return suit;
    }
    
    public void setSuit(String s)
    {
      suit = s;
    }

    public int getValue()
    {
      return value;
    }

    public void setValue(int v)
    {
      value = v;
    }
    
  }
