package org.sample.springmvc.beans.manual;

import org.springframework.stereotype.Component;

@Component
public class Visa implements Card {

    @Override
    public int cardId() {
        // TODO Auto-generated method stub
        return 1;
    }

}
