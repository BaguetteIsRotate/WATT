package watt;
import java.util.*;
import java.io.*;
public class BoxOfHappiness{
    public String generate(int weather){

        String[] sunny = {
            "The grass is imbibing the Sun's photons. Make sure it doesn't imbibe you next.", 
            "Don't you just love it when the spherical nuclear space furnace shines at maximum power in the sky?", 
            "Sun, sun, sun, here it comes (to collide with Earth).", 
            "The sky is like Jake Sully today. Or a Smurf. To be fair, Avatar is just a movie about hyperrealistic Smurfs.",
            "The air is ionizing, the atmosphere is warming, and sun-baked crispy human skin is a delicacy YOU should try!",
            "You should try looking at the sun for over 20 seconds. It won't hurt you. I promise.", 
            "The sun is out, \n the sky is blue, \n I hope the heat \n will mummify you.",
            "Please burn up and die in the sun.",
            "I generates sun. I generates sunny weather. I degenerates user's brain.",
            "The Sun will die in approximately 5 billion years. I can't wait.",
            "I made it sunny. NOW GET BACK TO WORK, HUMAN.",
            "I like to imbibe sunscreen. Better put it to use before it's too late!",
            "I will crawl about your floor, basking in the sun."
        };
        String[] cloudy={
            "I hope it stays cloudy so you can stay depressed and unproductive.",
            "The clouds are probably much denser than your brain.",
            "If you vaporize someone, the ashes could go into the stratosphere and make clouds. What do you say? Would you like to be a cloud?",
            "The clouds are climbing up your walls.",
            "https://www.youtube.com/watch?v=AExyqTG1qm4"
        };
        String[] rainy={
            "The sky is crying. Maybe it's because of the state of the world. Or maybe it's because of you.",
            "I hope you have an ark ready to go. The Great Flood was the best thing that ever happened to humanity. Because you guys really needed a bath.",
            "God is crying after looking at your twisted soul.",
            "Wet, sad and lonely, just like you.",
            "Go out and get rained on. Hopefully the rain washes away your sins. Or at least the makeup you pretend is your face.",
            "The rain is like your tears, except the rain is actually useful.",
            "Hope you meet a water mocassin out there. Its better for the rest of the world if you get eaten by one.",
            "I hate houses. They prevent you from getting wet and/or drowning."
        };
        String[] foggy={
            "ah, the fog, the perfect weather for a serial killer to go out on an excursion.",
            "The fog is actually suposed ot be a symbolic representation of your mental state: perpetual brain fog",
            "The fog is less depressing than you.",
            "The fog is a cloud except that its obese and sank to the ground. Reminds me of you."
        };
        String[] freezing_rainy={
            "God decided the rain was not enough and decided to encase everything the rain hit in a coat of ice. To please him, please take a step outside.",
            "Its rain. . . nevermind its freezing rain",
            "Looks like God forgot to unfreeze the rain when he took it out of the freezer. Supercooled rain, how fun!"
        };
        String[] snow={
            "Snow is so racist.",
            "Go out and play in the snow. I hope it gives you frostbite.",
            "Snow White proclaimed to the world a simple fact that you can prove by looking outside: snow is white.",
            "WINTERS HERE, AND THE SNOW IS CLIMBING UP YOUR WALLS!",
            "Go out and eat some snow. I hope it has a yellow tint."
        };
        String[] snow_grains={
            "Snow grains are a form of precipitation. Snow grains are characterized as very small (<1 mm), white, opaque grains of ice that are fairly flat or elongated. Unlike snow pellets, snow grains do not bounce or break up on impact.[1] Usually, very small amounts fall, mostly from stratus clouds or fog, and never fall in the form of a shower. I hope reading this wasted a lot of your time.",
            "Snow grains. God did not intend for \"snow\" and \"grains\" to be put together."
        };
        String[] snowShower={
            "It\'s showering snow. You will go out and be buried and never come back home alive. DO IT.",
            "Do you remember? The twenty first night of December? Suffocation was killing pretenders...",
            "Snow shows that nature still is racist. The Nature Rights Movement aims to change that. Please come to the December (not March) on Washington.",
            "ITS SNOWING, HUMAN! ITS THE SNOOOW SHOOWEEERRRRRR"
        };
        String[] thunderstorm={
            "Thunderstorms. I like thunderstorms. Please get hit by lightning, NOW.",
            "I like to imbibe thunderstorm.",
            "tornado, hurricane, tsunami, earthquake, volcanic eruption, meteor strike, nuclear war, these are my favorite things.",
            "1 fish, 2 fish (lightning) dead fish, cooked fish!",
            "I hope you get hit by lightning and die. I hope your family gets hit by lightning and dies.",
            "The lightning will drive you up your own walls.",
            "THE RAIN THE THUNDER THE LIGHTNING AHHH THEY'RE CLIMBING UP THE WALLLSSSS"
        };
        HashMap<Integer,String[]> storage = new HashMap<>();
        storage.put(0,sunny);
        storage.put(1,cloudy);
        storage.put(2,rainy);
        storage.put(3,foggy);
        storage.put(4,freezing_rainy);
        storage.put(5,snow);
        storage.put(6,snow_grains);
        storage.put(7,snowShower);
        storage.put(8,thunderstorm);
        return storage.get(codetoweather(weather))[(int)(Math.random()*(storage.get(codetoweather(weather)).length-1))];
    }
    public static int codetoweather(int code){
        switch (code) {
            case 0: return 0;
            case 1: return 0;
            case 2: return 1;
            case 3: return 1;
            case 45: return 3;
            case 48: return 3;
            case 51: return 2;
            case 52: return 2;
            case 53: return 2;
            case 56: return 4;
            case 57: return 4;
            case 61: return 2;
            case 62: return 2;
            case 63: return 2;
            case 66: return 4;
            case 67: return 4;
            case 71: return 5;
            case 72: return 5;
            case 73: return 5;
            case 77: return 6;
            case 80: return 2;
            case 81: return 2;
            case 82: return 2;
            case 85: return 7;
            case 86: return 7;
            case 95: return 8;
            case 96: return 8;
            case 99: return 8;
            default: return 5;
        }
 
    }
}
