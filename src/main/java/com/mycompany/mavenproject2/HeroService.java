package com.mycompany.mavenproject2;

import javax.inject.Singleton;

@Singleton
public class HeroService {

    public boolean isValid(Hero pHero){
        byte percent = 0;
        for(Hibryd hibryd: pHero.getHibryds())
            percent+=hibryd.getPercent();
        return percent == 100;
    }
    
}
