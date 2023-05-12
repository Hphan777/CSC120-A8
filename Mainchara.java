public class Mainchara extends StandUser{

        public Mainchara(String name,int speed,boolean canFly, int power, int energy, int potential){
            this.name = name;
            this.speed = speed; 
            this.canFly = canFly;
            this.power = power;
            this.energy = energy;
            this.potential = potential;
        }
        public static void main(String[] args) {
            StandUser Player = new Mainchara("Dio",speed, false, power, energy, potential);
            Player.grab("Stone Mask");
            Player.examine("Stone Mask");
            Player.use("Stone Mask");
            Player.drop("Stone Mask");
            Player.fly(20,10);
        }
    
    }

  


