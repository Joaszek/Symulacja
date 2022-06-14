import java.util.Random;

public class Item {



    private int damage;
    private int magic;
    private int magic_resist;
    private int armor;
    public Random rand = new Random();
    public Item()
    {
        this.rand=new Random();
        this.damage = rand.nextInt(40)+40;
        this.magic = rand.nextInt(80)+40;
        this.magic_resist= rand.nextInt(50)+10;
        this.armor=rand.nextInt(50)+10;
    }
    public int getItemDamage()
    {
        return this.damage;
    }
    public int getMagic() {
        return this.magic;
    }
    public int getMagic_resist()
    {
        return this.magic_resist;
    }
}
