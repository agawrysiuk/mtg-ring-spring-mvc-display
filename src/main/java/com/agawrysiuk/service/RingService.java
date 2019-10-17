package com.agawrysiuk.service;

import com.agawrysiuk.model.Card;
import com.agawrysiuk.model.Deck;

import java.util.List;

public interface RingService {
    List<Deck> getDecks();
    List<Card> getCards();
    Deck getDeck(String deckName);
    Card getCard(String cardName);
}
