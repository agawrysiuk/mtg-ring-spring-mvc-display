package com.agawrysiuk.model;

import lombok.Data;
import org.json.JSONObject;

@Data
public class Card implements Comparable<Card> {
    private final String title;
    private String cardPath;
    private String cardPathTransform;
    private boolean hasTransform;
    private String json;

    public Card(String title, String json) { //for loading from deck
        this.title = title;
        this.json = json;
        JSONObject downloadedCard = new JSONObject(json);
        String cardType = downloadedCard.getString("type_line");
        if(cardType.contains("Legendary")) {
            cardType = cardType.replace("Legendary ","");
        }
        if(cardType.contains("Artifact Creature")) {
            cardType = "Creature";
        } else {
            cardType = cardType.split(" ",2)[0];
            if(cardType.equals("Basic")) {
                cardType = "Land";
            }
        }

        String cardPathNormalTransform = "";
        String fileName;
        String fileNameTransform = "";

        if(downloadedCard.getString("layout").equals("transform")) { //checking if the card is a transform card
            /*  getJSONArray("card_faces") downloading arraylist containing two objects, each has "image_uris"
                getJSONObject(0) chooses object, 0 is front card, 1 is back card for mtg
                getJSONObject("image_uris") chooses object of "image_uris"
                getString("border_crop") gets the url of card image */
            cardPathNormalTransform = downloadedCard.getJSONArray("card_faces").getJSONObject(1).getJSONObject("image_uris").getString("border_crop");
        }

        fileName = downloadedCard.getString("scryfall_uri"); //getting url name from scryfall
        fileName = fileName.replace("?utm_source=api",""); //deleting the final part about source
        String[] toSave = fileName.split("/"); //splitting
        fileName = toSave[toSave.length-1];

        if(!cardPathNormalTransform.equals("")) { //saving back of the card
            fileNameTransform = fileName+"-transform";
        }

        this.cardPath = fileName;
        this.cardPathTransform = fileNameTransform;
        if(!cardPathTransform.equals("")) {
            this.hasTransform = true;
        }
    }

    public boolean isTransform() {
        return hasTransform;
    }

    @Override
    public int compareTo(Card card) {
        return this.title.compareToIgnoreCase(card.getTitle());
    }

    @Override
    public String toString() {
        return title;
    }
}
