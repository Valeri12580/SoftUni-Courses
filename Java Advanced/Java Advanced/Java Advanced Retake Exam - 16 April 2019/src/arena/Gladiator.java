package arena;

public class Gladiator {
    private String name;
    private Stat stat;
    private Weapon weapon;

    public Gladiator(String name, Stat stat, Weapon weapon) {
        this.name = name;
        this.stat = stat;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getStatPower(){
        int sum=0;
        sum+=this.stat.getAgility()+this.stat.getFlexibility()+
                this.stat.getIntelligence()
                +this.stat.getSkills()+this.stat.getStrength();
        return sum;
    }
    public int getWeaponPower(){
            int sum=this.weapon.getSharpness()+this.weapon.getSize()+this.weapon.getSolidity();

            return sum;

    }


    public int getTotalPower(){
        int sum=0;
        sum+=this.stat.getAgility()+this.stat.getFlexibility()+
                this.stat.getIntelligence()
                +this.stat.getSkills()+this.stat.getStrength()+this.weapon.getSharpness()+this.weapon.getSize()+this.weapon.getSolidity();
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();

        sb.append(String.format("%s - %d%n",this.getName(),this.getTotalPower()));
        sb.append(String.format(" Weapon power: %d%n Stat power: %d",getWeaponPower(),getStatPower()));
        return sb.toString();
    }
}
