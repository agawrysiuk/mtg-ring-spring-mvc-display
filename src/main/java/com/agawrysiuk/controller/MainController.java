package com.agawrysiuk.controller;

import com.agawrysiuk.model.Card;
import com.agawrysiuk.model.Deck;
import com.agawrysiuk.service.RingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    private RingService service;

    @Autowired
    public MainController(RingService service) {
        this.service = service;
    }

    @ModelAttribute("decks")
    public List<Deck> decks(){
        return service.getDecks();
    }

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("deck")
    public String deck(@RequestParam String deckName, Model model) {
        Deck deck = service.getDeck(deckName);
        model.addAttribute("deckMain",deck.getCardsInDeck());
        model.addAttribute("deckSide",deck.getCardsInSideboard());
        model.addAttribute("deckName",deckName);
        return "deck_view";
    }

    @GetMapping("card")
    public String card(@RequestParam String cardName,Model model) {
        Card card = service.getCard(cardName);
        model.addAttribute("card",card);
        return "card_view";
    }
}
