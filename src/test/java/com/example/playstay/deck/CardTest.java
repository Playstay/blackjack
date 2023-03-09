package com.example.playstay.deck;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class CardTest {
    @Test
    public void スートがnullなら例外が発生すること() {
        assertThrows(IllegalArgumentException.class, ()->new Card(null,1));
    }
    
    @Test
    public void 数字が範囲外なら例外が発生すること() {
        assertThrows(IllegalArgumentException.class, ()->new Card(Suit.CLUB,0));
    }
    
    @Test
    public void 生成して値が同じであること() {
        int number = 1;
        Card card  = new Card(Suit.CLUB, number);
        assertEquals(number, card.getNumber());
        assertEquals(Suit.CLUB, card.getSuit());
    }
    
    @Test
    public void スートの比較が優先されること(){
        Card card = new Card(Suit.CLUB, 6 );
        Card otherCard = new Card(Suit.DIAMOND, 1 );
        assertEquals(Suit.CLUB.compareTo(Suit.DIAMOND), card.compareTo(otherCard));
    }
    
    @Test
    public void スートが同じなら数字で比較されること(){
        Card card = new Card(Suit.CLUB, 6 );
        Card otherCard = new Card(Suit.CLUB, 1 );
        assertEquals(Integer.compare(card.getNumber(), otherCard.getNumber()), card.compareTo(otherCard));
    }
    
    @Test
    public void Cardクラス以外と比較してもfalseであること(){
        Card card = new Card(Suit.CLUB, 2);
        // そのまま文字列を引数に渡すとコンパイル時にinfoが出てくるので一旦Objectに代入
        Object obj  = "hogehoge";
        assertFalse(()->card.equals(obj));
        assertFalse(()->card.equals(null));
    }
}
