import java.util.ArrayList;
import java.util.Arrays;

public abstract class StandUser implements Contract{
    public String name;
    public static int power = 5;
    public static int speed = 5;
    public static int energy = 5;
    public static int potential = 5;
    public int forward;
    public int back;
    public int left;
    public int right;
    public boolean canFly;
    public String itemType;
    public ArrayList<String> directionalcmd =new ArrayList<String>(Arrays.asList("forward", "back", "left", "right"));
    public ArrayList<String> uselessitems = new ArrayList<String>(Arrays.asList("Pizza with bones", "Expired debit card", "Used napkin", "Riceless sushi"));
    public int minSize = 1;
    public ArrayList<String> curseditems = new ArrayList<String>(Arrays.asList("Stone Mask","Emily's diary", "A broken piece of arrow", "Steel ball"));
    public ArrayList<String> effects = new ArrayList<String>(Arrays.asList("increases ripple energy by 5 and decreases power by 3", "increases power by 4 and decreases speed by 7", "increases potential by 5 and increases power by 3", "increases speed by 5 and decreases power by 5"));
    public int midSize = 5;
    public ArrayList<String> correspondingAbility = new ArrayList<String>(Arrays.asList("energy", "power", "potential", "speed"));
    public ArrayList<String> inventory =  new ArrayList<String>();
    public int maxSize = 20;
    /**
     * grabs item
     * @param item stuff you put in your inventory 
     */
    public void grab(String item){
        if (uselessitems.contains(item) || curseditems.contains(item)){
            if (minSize< maxSize || midSize< maxSize){
                inventory.add(item);
                if (uselessitems.contains(item)){
                maxSize-=minSize;
                }if (curseditems.contains(item)){
                    maxSize-=midSize;
                }else{         
                throw new RuntimeException("You don't have enough space for this item.");
                }
            }else{         
            throw new RuntimeException("There does not exist such item.");
            }
        }
    }
    /**
     * drops item
     * @param item stuff you drop from your inventory 
     */
    public String drop(String item){
        if (inventory.contains(item)){
            inventory.remove(item);
            System.out.println( item + " has been removed from " + this.name + "'s inventory");
        }
        else{ 
            throw new RuntimeException("Item does not exist in inventory");
            
        }

        return item; 
    } 
    /** 
     * to pick up and examine object
     * @param item stuff you find
     */
    public void examine(String item){
        System.out.println(this.name + " picked up and examined " + item);
        String itemname = " ";
        String ability = " ";
        String printedString = "it is a " + itemname + " that would increase your "+ ability + " by 2!";
        if (item == uselessitems.get(0)){
            itemname = uselessitems.get(0);
            ability = correspondingAbility.get(10);
            System.out.println(printedString);
        }else if (item == uselessitems.get(1)){
            itemname = uselessitems.get(1);
            ability = correspondingAbility.get(1);
            System.out.println(printedString);
        }else if (item == uselessitems.get(2)){
            itemname = uselessitems.get(2);
            ability = correspondingAbility.get(2);
            System.out.println(printedString);
        }else if (item == uselessitems.get(3)){
            itemname = uselessitems.get(3);
            ability = correspondingAbility.get(3);
            System.out.println(printedString);
        }else if (item == curseditems.get(0)){
            System.out.println(curseditems.get(0) + " " + effects.get(0));
        }else if (item == uselessitems.get(1)){
            System.out.println(curseditems.get(1) + " " + effects.get(1));
            System.out.println(printedString);
        }else if (item == uselessitems.get(2)){
            System.out.println(curseditems.get(2) + " " + effects.get(2));
            System.out.println(printedString);
        }else if (item == uselessitems.get(3)){
            System.out.println(curseditems.get(3) + " " + effects.get(3));
        }
    }
    /** 
     * to use stuff from inventory 
     * @param item stuff you  use from your inventory 
     */
    public void use(String item){
        System.out.println(this.name + " used " + item);
        String ability = " ";
        String ability2 = " ";
        int number = 0;
        int number2 = 0;
        if (inventory.contains(item) && uselessitems.contains(item)){
            if (item == uselessitems.get(0)){
                ability = correspondingAbility.get(0);
                // System.out.println(printedString);
                this.energy+= 1;
            }else if (item == uselessitems.get(1)){
                ability = correspondingAbility.get(1);
                this.power+= 1;
                // System.out.println(printedString);
            }else if (item == uselessitems.get(2)){
                ability = correspondingAbility.get(2);
                // System.out.println(printedString);
                this.potential+= 1;
            }else if (item == uselessitems.get(3)){
                ability = correspondingAbility.get(3);
                // System.out.println(printedString);
                this.speed+= 1;
            }String printedString = ability + " increases by 1.";
            System.out.println(printedString);
        }
        if (inventory.contains(item) && curseditems.contains(item)){
            if (item == curseditems.get(0)){
                ability = "energy";
                ability2 = "power";
                number = 5;
                number2 = 3;
                this.energy+= 5;
                this.power -= 3;
                // System.out.println(printedString2);
            }else if (item == uselessitems.get(1)){
                ability = "power";
                ability2 = "speed";
                number = 5;
                number2 = 7;
                this.power+= 5;
                this.speed -= 7;
                // System.out.println(printedString2);
            }else if (item == uselessitems.get(2)){
                ability = "potential";
                ability2 = "power";
                number = 5;
                number2 = 3;
                this.potential+= 5;
                this.power-=3;
                // System.out.println(printedString2);
            }else if (item == uselessitems.get(3)){
                ability = "speed";
                ability2 = "power";
                number = 5;
                number2 = 5;
                this.speed+= 5;
                this.power-= 5;
                // System.out.println(printedString2);
            }String s = Integer.toString(number);
            String s2 = Integer.toString(number2);
            String printedString2 = ability + " increases by " + s + " and " + ability2 + " decreases by " + s2;
            System.out.println(printedString2);
        }      
    }
    /** 
     * to move to different directions
     * @param direction the direction that you want to walk in in North, East, South, West 
     */
    public boolean walk(String direction){
        this.forward = 0;
        this.left = 0;
        this.back = 0;
        this.right = 0;
        if (this.speed > 0){
            if (direction ==directionalcmd.get(0)){
                this.forward += 1;    
            }else if (direction ==directionalcmd.get(1)){
                this.back += 1;
            }else if (direction ==directionalcmd.get(2)){
                this.left += 1;
            }else if (direction ==directionalcmd.get(3)){
            this.right += 1;
            }else{
            throw new RuntimeException("WHERE");
            }
            return true;
        }else{
            System.out.println("Too slow, not enough speed!!");
            return false;
        }
    }
    /** 
     * to move quickly across multiple steps
     * @param direction the direction in terms of x and y direction
     */
    public boolean fly(int x, int y){
        if (this.speed > 20){
            this.canFly = true;
            this.speed -= 20;
            if (y > 0){
                this.forward += y;
            }if(y < 0){
                this.back += y;
            }if(x > 0){
                this.left += x;
            }if(x < 0){
                this.right += x;
            }if(x == 0 && y ==0){
                throw new RuntimeException("Don't just stand there!");
            }
            return true;
        } else{
            System.out.println("Oop, too heavy to fly. You need to hit the gym");
            return false;
        }

     }
     /** 
     * decrease energy points to increase power points
     */
    public Number shrink(){
        energy -= 1;
        power += 1;
        return energy;
     }
    /** 
     * decrease power points to increase energy points
     */
    public Number grow(){
        power -= 1;
        energy += 1;
        return energy;
    }
    /** 
     * decrease power points to increase energy points
     */
    public void rest(){
        if (this.speed == 0 && this.speed < 20){
            speed += 1;
        }else{
            throw new RuntimeException("No time to rest!");
        }
    }
    /** 
     * No, you can't undo 
     */
    public void undo(){
        throw new RuntimeException("You can't reverse time");
    } 

  }
