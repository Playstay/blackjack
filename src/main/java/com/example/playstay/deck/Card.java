package com.example.playstay.deck;

public class Card implements Comparable<Card> {
    private Suit suit;
    private int number;

    public Card(Suit suit, int number) {
        if (suit == null) {
            throw new IllegalArgumentException("suit must not null.");
        }
        if (number < 1 || 13 < number) {
            throw new IllegalArgumentException("number only allowed between 1 and 13.");
        }

        this.suit = suit;
        this.number = number;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int hashCode() {
        return suit.hashCode() + number;
    }

    /**
     * カードが等しいとは、スートとカードの数字が両方とも同じであることを意味します。
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Card)) {
            return false;
        }

        Card card = (Card) obj;
        return (getSuit() == card.getSuit()) && (getNumber() == card.getNumber());
    }

    /**
     * まずスートを比較し、スートが違う場合はスートの順序に準拠します。 スートが同じであるなら数字を比較します。
     * 
     * @param card
     * @return 指定されたオブジェクトとスートが違えばスートの順序、スートが同じならば指定されたオブジェクトより大きければ正の数、小さければ負の数、等しければ0を返します。
     */
    @Override
    public int compareTo(Card card) {
        int suitOrder = getSuit().compareTo(card.getSuit());
        if (suitOrder != 0) {
            return suitOrder;
        } else {
            return Integer.compare(getNumber(), card.getNumber());
        }
    }
}
