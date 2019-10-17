package com.agawrysiuk.service;

import com.agawrysiuk.model.Card;
import com.agawrysiuk.model.Database;
import com.agawrysiuk.model.Deck;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RingServiceImpl implements RingService {

    @Getter
    private final Database database = Database.getInstance();

    @Override
    public List<Deck> getDecks() {
        List<Deck> decks = new ArrayList<>();
        for(Map.Entry<String,Deck> deck : database.getDecks().entrySet()) {
            decks.add(deck.getValue());
        }
        return decks;
    }

    @PostConstruct
    public void loadDatabase() {
        database.loadDatabase();
    }

    @Override
    public List<Card> getCards() {
        return database.getDatabaseCards();
    }

    @Override
    public Deck getDeck(String deckName) {
        return database.getDecks().getOrDefault(deckName, null);
    }

    @Override
    public Card getCard(String cardName) {
        return database.getCard(cardName);
    }
}
