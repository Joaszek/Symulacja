public class Ring {
    private double n;

    public void Power(Postac someone){
        System.out.println("atak przed: " + someone.get_attack());
        someone.set_attack(n* someone.get_attack());        //zwieksza atak (lub zmiejsza pog!)
        System.out.println("atak po: " + someone.get_attack());
    }
    public Ring(double multi){
        n = multi;
    }
}
