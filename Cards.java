import java.util.*;

public class Cards {


    public boolean gameInProgress = true;

    public void shuffleCards() {

        Scanner userInput = new Scanner(System.in);
        List cardList = new LinkedList();
        List matchedCards = new LinkedList();

        //this is the list of cards available to pick from
        String[]cards =  {"a","b","c","d","f","e","a","b","c","d","e","f"} ;

        //this shuffles the cards each game
        Collections.shuffle(Arrays.asList(cards));

        //this moves the cards array into a LinkedList
        Collections.addAll(cardList, cards);

        //main game loop. stops when all cards are matched
        while (gameInProgress) {

            //Stores the users card picks in variables card1 and card2
            System.out.println("pick a card (0-11)\n");
           
            int card1 = userInput.nextInt();

            System.out.println("First card picked is the letter " + cardList.get(card1));

            System.out.println("pick a second card.\n");

             int card2 = userInput.nextInt();

      while(card1==card2){
            System.out.println("You cannot pick the same card twice. Pick a different card.");
            card2 = userInput.nextInt();
        }

            System.out.println("second card picked is the letter " + cardList.get(card2));


            //checks if a card has been picked already
            while(matchedCards.contains(cardList.get(card1))) {
                System.out.println("First card already picked. Pick again: ");
                card1 = userInput.nextInt();
            }

            while(matchedCards.contains(cardList.get(card2))){
                System.out.println("Second card already picked. Pick again: ");
                card2 = userInput.nextInt();
            }

                //copies the matched cards to a new linked list
                if (cardList.get(card1) == cardList.get(card2)) {
                    System.out.println("You got a match!\n");

                    matchedCards.add(cardList.get(card1));
                    matchedCards.add(cardList.get(card2));

                    System.out.println("You have collected " + matchedCards.size() + "/12 cards");

                    System.out.println(matchedCards + " are in the matched pile\n");

                    //stops the game once all cards have been matched
                    if (matchedCards.size() == 12) {
                        System.out.println("You Win!!!");
                        gameInProgress = false;
                    }
                }
                else {
                    System.out.println("Not a match\n");

                }
        }
    }
    }


