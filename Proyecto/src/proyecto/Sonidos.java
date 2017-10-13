/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.applet.AudioClip;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.net.*;
/**
 *
 * @author COMPAQ
 */
public class Sonidos implements Runnable {
/*InputStream Sonido;
AudioStream audio;
public Sonidos(String archivo){
    try {
        Sonido=new FileInputStream(archivo);
        audio=new AudioStream(this.Sonido);
    } catch (FileNotFoundException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        Logger.getLogger(Sonidos.class.getName()).log(Level.SEVERE, null, ex);
    }
        

}    */
    private AudioClip sonido1;
public Sonidos(String archivo){
        try {
            URL url=new URL("song.wav");
            this.sonido1=getAudioClip(url);
        } catch (MalformedURLException ex) {
            
        }




}

@Override
    public void run() {
     // AudioPlayer.player.start(audio);
    this.sonido1.play();
    }

  
   
}
