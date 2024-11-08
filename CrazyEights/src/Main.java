 import java.util.ArrayList;
import java.util.Scanner;
class Main 
{
  static ArrayList <Card> player1 = new ArrayList <Card> ();
  static ArrayList <Card> player2 = new ArrayList <Card> ();
  static ArrayList <Card> discardPile = new ArrayList <Card> ();
  static int menuNumber = 1;
  static boolean gameIsGoing = true;
  static int cardChoice =0;

  //It doesn't change the suit when the other player doesn't have the card
  public static void main(String[] args) 
  {
    Deck.fillDeck();
    Deck.shuffle();
    dealCards();
    printPlayer1();
    while (gameIsGoing)
      {
    player1PlayCard();
   
    endGame();
    player2PlayCard();
    endGame();
    printPlayer1();
      }
  }
  
  public static void dealCards()
  {
    
    for (int l = 0; l < 5; l++)
    {
   player1.add(Deck.deck.get(0));
   Deck.deck.remove(0);
   

   player2.add(Deck.deck.get(0));
   Deck.deck.remove(0);

    }
    
    discardPile.add(Deck.deck.get(0));
    System.out.println("The starting card is "+ discardPile.get(0).getRank() +" of "+ discardPile.get(0).getSuit());
    System.out.println("Your cards are: ");
  }

  public static void printPlayer1()
  {
    menuNumber = 1;
    for (int l=0; l < player1.size(); l++)
      {
      System.out.println(menuNumber +". "+ player1.get(l).getRank() +" of "+ player1.get(l).getSuit());
        menuNumber++;

      }
  }

  public static void player1PlayCard()
  {
    Scanner userIntInput = new Scanner (System.in);
    
    cardChoice = userIntInput.nextInt()-1;
 
    if (player1.get(cardChoice).getRank().equals (discardPile.get(0).getRank()) && player1.get(cardChoice).getRank().equals("eight"))
    {
      
      System.out.println("You played an eight!");
      crazyEight();
      endGame();
    }

       else if (player1.get(cardChoice).getRank().equals (discardPile.get(0).getRank()))
      {
        System.out.println("Good choice");
        discardPile.add(0, player1.get(cardChoice));
        player1.remove(cardChoice);
      }

       else if (player1.get(cardChoice).getSuit().equals (discardPile.get(0).getSuit()) && player1.get(cardChoice).getRank().equals("eight"))
        {

          System.out.println("You played an eight!");
          crazyEight();

          // discardPile.add(0, player1.get(cardChoice));
          // player1.remove(cardChoice); 

        }

    else if (player1.get(cardChoice).getSuit().equals (discardPile.get(0).getSuit()))
    {
      System.out.println("Good choice");
      discardPile.add(0, player1.get(cardChoice));
      player1.remove(cardChoice);
    }

    else
    {
      System.out.println("Gain an extra card :( ");
      player1.add(Deck.deck.get(0));
      Deck.deck.remove(0);
    }

  }

  public static void crazyEight()
  {
          //System.out.println("size =" + player1.size());
        discardPile.add(0, player1.get(cardChoice));
        player1.remove(cardChoice); 
          System.out.println();
          System.out.println("Choose what suit to continue in.");

          String [] suits = {"clubs", "hearts", "spades", "diamonds"};

         menuNumber = 1;
         for (int l=0; l < 4; l++)
           {
           System.out.println(menuNumber +". "+ suits[l]);
           menuNumber++;

           }
    Scanner userIntInput = new Scanner (System.in);
         int suitChoice = userIntInput.nextInt()-1;   

    //pasted part

    int playerSize = player2.size();
      int index = -1;
      for (int f = 0; f < playerSize; f++)
        {

      if (player2.get(f).getSuit().equals(suits[suitChoice]))
      {
        index = f;
      }

    // else if (player2.get(f).getRank().equals (discardPile.get(0).getRank()))
    //   {
    //     index = f;
    //   }

       }

      if (index >= 0 )
      {
        discardPile.add(0, player2.get(index));
        player2.remove(index);
      }


      if (playerSize == player2.size())
      {
          player2.add(Deck.deck.get(0));
          Deck.deck.remove(0);
          System.out.println("Your opponent drew a card.");
      }

      System.out.println();
      System.out.println("The next card is "+ discardPile.get(0).getRank() +" of "+ discardPile.get(0).getSuit());
      System.out.println("Play your next card!");
    menuNumber = 1;
    for (int l=0; l < player1.size(); l++)
      {
      System.out.println(menuNumber +". "+ player1.get(l).getRank() +" of "+ player1.get(l).getSuit());
        menuNumber++;

      }

      player1PlayCard();
  }
  
  public static void player2PlayCard()
  {
   
    int playerSize = player2.size();
    int index = -1;
    for (int f = 0; f < playerSize; f++)
      {
        
    if (player2.get(f).getSuit().equals (discardPile.get(0).getSuit()) && player2.get(f).getRank().equals ("eight"))
    {
      crazyEightPlayer2();
      endGame();
    }

   else if (player2.get(f).getSuit().equals (discardPile.get(0).getSuit()))
    {
      index = f;
    }

     else if(player2.get(f).getRank().equals (discardPile.get(0).getRank()) && player2.get(f).getRank().equals ("eight"))
     {
       crazyEightPlayer2();
       endGame();
     }
       
  else if (player2.get(f).getRank().equals (discardPile.get(0).getRank()))
    {
      index = f;
    }
       
     }

    if (index >= 0 )
    {
      discardPile.add(0, player2.get(index));
      player2.remove(index);
    }
  
    
    if (playerSize == player2.size())
    {
        player2.add(Deck.deck.get(0));
        Deck.deck.remove(0);
        System.out.println("Your opponent drew a card.");
    }

    System.out.println();
    System.out.println("The next card is "+ discardPile.get(0).getRank() +" of "+ discardPile.get(0).getSuit());
    System.out.println("Play your next card!");

  }

  public static void crazyEightPlayer2()
  {
    String [] suits = {"clubs", "hearts", "spades", "diamonds"};

    System.out.println("Your opponent played an eight and changed the suit!");

    String computerSuit = "clubs"; 
    for (int i = 0; i < 1; i++)
      {
        if (player2.get(i).getSuit().equals("clubs"))
        {
          computerSuit = "clubs";
        }

        else if (player2.get(i).getSuit().equals("hearts"))
        {
          computerSuit = "hearts";
        }

        else if (player2.get(i).getSuit().equals("spades"))
        {
          computerSuit = "spades";
        }

        else if (player2.get(i).getSuit().equals("diamonds"))
        {
          computerSuit = "diamonds";
        }
      }
    System.out.println();
    System.out.println("The suit is now " + computerSuit);
    System.out.println();
    //pasted
    printPlayer1();
    
    Scanner userIntInput = new Scanner (System.in);

    cardChoice = userIntInput.nextInt()-1;

    if (player1.get(cardChoice).getRank().equals (discardPile.get(0).getRank()) && player1.get(cardChoice).getRank().equals("eight"))
    {

      System.out.println("You played an eight!");
      crazyEight();
      endGame();

    }

       else if (player1.get(cardChoice).getRank().equals (discardPile.get(0).getRank()))
      {
        System.out.println("Good choice");
        discardPile.add(0, player1.get(cardChoice));
        player1.remove(cardChoice);
         //player2PlayCard();
      }

       else if (player1.get(cardChoice).getSuit().equals (computerSuit) && player1.get(cardChoice).getRank().equals("eight"))
        {

          System.out.println("You played an eight!");
          crazyEight();
          endGame();

          // discardPile.add(0, player1.get(cardChoice));
          // player1.remove(cardChoice); 

        }

    else if (player1.get(cardChoice).getSuit().equals (computerSuit))
    {
      System.out.println("Good choice");
      discardPile.add(0, player1.get(cardChoice));
      player1.remove(cardChoice);
       //player2PlayCard();
    }

    else
    {
      System.out.println("Gain an extra card :( ");
      player1.add(Deck.deck.get(0));
      Deck.deck.remove(0);

      //pasted for player 2
      int playerSize = player2.size();
        int index = -1;
        for (int f = 0; f < playerSize; f++)
          {

        if (player2.get(f).getSuit().equals(computerSuit))
        {
          index = f;
        }

      else if (player2.get(f).getRank().equals (discardPile.get(0).getRank()))
        {
          index = f;
        }

         }

        if (index >= 0 )
        {
          discardPile.add(0, player2.get(index));
          player2.remove(index);
        }


        if (playerSize == player2.size())
        {
            player2.add(Deck.deck.get(0));
            Deck.deck.remove(0);
            System.out.println("Your opponent drew a card.");
        }

        System.out.println();
        System.out.println("The next card is "+ discardPile.get(0).getRank() +" of "+ discardPile.get(0).getSuit());
        System.out.println("Play your next card!");
      menuNumber = 1;
      for (int l=0; l < player1.size(); l++)
        {
        System.out.println(menuNumber +". "+ player1.get(l).getRank() +" of "+ player1.get(l).getSuit());
          menuNumber++;

        }

        player1PlayCard();
       //player2PlayCard();
      //end of pasted for player 2
    }

    //end of pasted
    
  }
  
  public static void endGame()
  {
    if (player1.size() == 0)
    {
      System.out.println("Game over! You won!");
      gameIsGoing = false;

    }
    else if (player2.size() == 0)
    {
      System.out.println("Game over! The computer won!");
      gameIsGoing = false;

    }
  }


  
}