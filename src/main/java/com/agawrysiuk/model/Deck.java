package com.agawrysiuk.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class Deck implements Comparable<Deck> {

    private String deckName;
    private String deckInfo;
    private String deckType;
    private Map<Card,Integer> cardsInDeck;
    private Map<Card,Integer> cardsInSideboard;
    private LocalDateTime creationDate;
    private String previewImage = "";

    public Deck(String deckName, String deckInfo, LocalDateTime creationDate,
                String previewImage, String deckType) { //for loading
        this.deckName = deckName;
        this.cardsInDeck = new HashMap<>();
        this.cardsInSideboard = new HashMap<>();
        this.creationDate = creationDate;
        this.deckInfo = deckInfo;
        this.previewImage = previewImage;
        this.deckType = deckType;
    }

    @Override
    public int compareTo(Deck o) {
        return this.creationDate.compareTo(o.getCreationDate());
    }

    public void addCard(Card card, boolean main) {
        Map<Card,Integer> list = main? cardsInDeck : cardsInSideboard;
        if(list.containsKey(card)) {
            int number = list.get(card);
            number++;
            list.put(card,number);
        } else {
            list.put(card,1);
        }
    }
}
