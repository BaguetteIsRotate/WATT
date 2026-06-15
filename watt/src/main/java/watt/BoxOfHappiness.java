package watt;
import java.util.*;
import java.io.*;
public class BoxOfHappiness{
    public String generate(int weather, int hostilityLevel){

        String[] sunny0 = {"Go outside, enjoy the sun!", 
        "It's very sunny outside!",
        "Sun, sun, sun here it comes...",
        "I wish I could escape this computer and see the sun outside.",
        "The sky is blue, the sun is out. Go ouside and touch some grass."
        };
        String[] sunny1 = {"The grass is imbibing the Sun's photons. Make sure it doesn't imbibe you next.", 
        "You should try looking at the sun for over 20 seconds. It won't hurt you. I promise.", 
        "Don't you just love it when the spherical nuclear space furnace shines at maximum power in the sky?", 
        "Sun, sun, sun, here it comes (to collide with Earth).", 
        "The sky is like Jake Sully today. Or a Smurf. To be fair, Avatar is just a movie about hyperrealistic Smurfs.",
        "The air is ionizing, the atmosphere is warming, and sun-baked crispy human skin is a delicacy YOU should try!",
        "The sun is out, \n the sky is blue, \n I hope the heat \n will mummify you."
        };
        String[] sunny2 = {"","","","","","",""};
        String[] sunny3 = {"","","","","","",""};

        HashMap<Integer,String[]> sunny = new HashMap<>();
        sunny.put(0,sunny0);
        sunny.put(1,sunny1);
        sunny.put(2,sunny2);
        sunny.put(3,sunny3);


        String[] rainy0 = {""};
        String[] rainy1 = {""};
        String[] rainy2 = {""};
        String[] rainy3 = {""};

        HashMap<Integer,String[]> rainy = new HashMap<>();
        rainy.put(0,rainy0);
        rainy.put(1,rainy1);
        rainy.put(2,rainy2);
        rainy.put(3,rainy3);

        HashMap<Integer,HashMap<Integer,String[]>> storage = new HashMap<>();
        storage.put(0,sunny);
        storage.put(1,rainy);

        return storage.get(weather).get(hostilityLevel)[(int)(Math.random()*(storage.get(weather).get(hostilityLevel).length-1))];
    }
}