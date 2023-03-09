package com.example.playstay.deck;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {
    private List<Card> deck;
    int index;

    /**
     * デッキを作成。このメソッドを使った場合シャッフルされる。
     */
    public Deck() {
        this(true);
    }

    /**
     * デッキを作成。シャッフルするかは引数で来まる
     * @param shuffle シャッフルする場合はtrue,そうでなければfalse
     */
    public Deck(boolean shuffle) {
        createDeck(shuffle);
    }

    /**
     * {@linkplain resetDeck}のエイリアス
     */
    private void createDeck(boolean shuffle) {
        resetDeck();
        if (shuffle) {
            Collections.shuffle(deck);
        } else {
            Collections.sort(deck);
        }
    }

    /**
     * 
     */
    private void resetDeck() {
        if (deck == null) {
            deck = Arrays.stream(Suit.values())
                    .flatMap(s -> IntStream.range(1, 14).mapToObj(i -> new Card(s, i)))
                    .collect(Collectors.toList());
        }
        index = 0;
    }

    /**
     * 先頭のカードを引きます。引く箇所を指定することはできません。
     * 
     * @return 先頭のカード
     */
    public Card draw() {
        Card card = deck.get(index);
        index++;

        // TODO: 引き切った後にシャッフルする必要があるか?
        return card;
    }
}
