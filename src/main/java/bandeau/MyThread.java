/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandeau;

import java.util.List;

/**
 *
 * @author mathi
 */
public class MyThread extends Thread {
    
    Bandeau bandeau;
    List<ScenarioElement> myElements;
    
    public MyThread(Bandeau bandeau, List<ScenarioElement> myElements ){
        this.bandeau = bandeau;
        this.myElements = myElements;
    }
    
    
    public void run(){
        synchronized(bandeau){
            System.out.println("Je suis lancé sur le bandeau");
            for (ScenarioElement element : myElements) {
                for (int repeats = 0; repeats < element.repeats; repeats++) {
                    element.effect.playOn(bandeau);
                }
            }
        }
    }
    
}
